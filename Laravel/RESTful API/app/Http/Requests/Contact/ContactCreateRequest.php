<?php

namespace App\Http\Requests\Contact;

use Illuminate\Contracts\Validation\Validator;
use Illuminate\Foundation\Http\FormRequest;
use Illuminate\Http\Exceptions\HttpResponseException;
use Illuminate\Support\Facades\Auth;

class ContactCreateRequest extends FormRequest
{
    public function authorize(): bool
    {
        return Auth::user() != null;
    }

    /**
     * @return array<string, \Illuminate\Contracts\Validation\ValidationRule|array<mixed>|string>
     */
    public function rules(): array
    {
        return [
            'firstName' => ['required', 'max:50'],
            'lastName' => ['nullable', 'max:50'],
            'email' => ['nullable', 'max:255', 'email'],
            'phone' => ['nullable', 'max:20', 'regex:/^[0-9]{10,20}$/']
        ];
    }

    public function failedValidation(Validator $validator)
    {
        throw new HttpResponseException(response([
            'errors' => $validator->errors()
        ], 400));
    }
}
