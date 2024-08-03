<?php

namespace App\Http\Requests\User;

use GuzzleHttp\Exception\BadResponseException;
use Illuminate\Contracts\Validation\Validator;
use Illuminate\Foundation\Http\FormRequest;
use Illuminate\Http\Exceptions\HttpResponseException;

class UserUpdateRequest extends FormRequest
{
    public function authorize(): bool
    {
        return $this->user() != null;
    }

    public function rules(): array
    {
        return [
            'name' => ['nullable', 'min:4', 'max:100'],
            'password' => ['nullable', 'min:4', 'max:100']
        ];
    }

    public function failedValidation(Validator $validator)
    {
        throw new HttpResponseException(response([
            'errors' => $validator->errors()->toArray()
        ], 400));
    }
}
