<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;
use Illuminate\Validation\Rules\Password;

class LoginRequest extends FormRequest
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
            'username' => ['required', 'email', 'max:100'],
            'password' => ['required', Password::min(6)->max(20)->letters()->numbers()->symbols()]
        ];
    }

    public function prepareForValidation(): void 
    {
        $this->merge([
            'username' => str($this->input('username'))->lower()
        ]);
    }

    public function passedValidation(): void 
    {
        $this->merge([
            'password' => bcrypt($this->input('password'))
        ]);
    }
}
