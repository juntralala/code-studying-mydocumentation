<?php

namespace App\Http\Requests\User;

use Illuminate\Contracts\Validation\Validator;
use Illuminate\Foundation\Http\FormRequest;
use Illuminate\Http\Exceptions\HttpResponseException;
use Illuminate\Validation\Rule;

class UserRegisterRequest extends FormRequest
{
    /**
     * Determine if the user is authorized to make this request.
     */
    public function authorize(): bool
    {
        return true;
    }

    /**
     * Get the validation rules that apply to the request.
     *
     * @return array<string, \Illuminate\Contracts\Validation\ValidationRule|array<mixed>|string>
     */
    public function rules(): array
    {
        return [
            'username' => ['required', 'min:4', 'max:100', Rule::unique('users', 'username')],
            'password' => ['required', 'min:6', 'max:100'],
            'name' => ['required', 'min:1', 'max:100']
        ];
    }

    public function messages(): array
    {
        return [
            'username.unique' => 'The :attribute already taken.'
        ];
    }

    public function failedValidation(Validator $validator)
    {
        $errors = $validator->errors();
        $status = 400;
        throw new HttpResponseException(response([
            'errors' => $errors->toArray()
        ], $status));
    }
}
