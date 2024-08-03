<?php

namespace App\Http\Requests\User;

use App\Models\User;
use Illuminate\Contracts\Validation\Validator;
use Illuminate\Foundation\Http\FormRequest;
use Illuminate\Http\Exceptions\HttpResponseException;
use Illuminate\Support\Facades\Hash;
use Illuminate\Validation\Rule;

class UserLoginRequest extends FormRequest
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
            'username' => ['required', 'min:4', 'max:100', Rule::exists('users', 'username')],
            'password' => [
                'required',
                function ($attribute, $value, $fail) {
                    $user = User::select('password')->where('username', $this->input('username'))->first();
                    if (!is_null($user) && !Hash::check($value, $user->password)) {
                        $fail('Wrong username or :attribute.');
                    }
                }
            ]
        ];
    }

    public function messages()
    {
        return [
            'username.exists' => 'Wrong :attribute or password.',
        ];
    }

    public function failedValidation(Validator $validator)
    {
        $errors = $validator->errors();
        $errorsArray = $errors->toArray(); // default error response content
        $status = 400; // default http status code

        if ($errors->hasAny(['username.exists', 'password']) &&
            !$errors->has('password.required')) {
            $status = 401;
            $errorsArray = [
                'message' => $errors->get('username.exists') ?: $errors->get('password')
            ];
        }

        throw new HttpResponseException(response([
            'errors' => $errorsArray
        ], $status));
    }
}
