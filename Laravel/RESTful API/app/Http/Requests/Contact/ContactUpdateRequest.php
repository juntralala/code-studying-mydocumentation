<?php

namespace App\Http\Requests\Contact;

use Illuminate\Contracts\Validation\Validator;
use Illuminate\Foundation\Http\FormRequest;
use Illuminate\Http\Exceptions\HttpResponseException;
use Illuminate\Support\Facades\Auth;
use Illuminate\Validation\Rule;

class ContactUpdateRequest extends FormRequest
{
    public function authorize(): bool
    {
        return Auth::check();
    }

    /**
     * @return array<string, \Illuminate\Contracts\Validation\ValidationRule|array<mixed>|string>
     */
    public function rules(): array
    {
        $user = Auth::user();
        return [
            'contactId' => [Rule::exists('contacts', 'id')->where('user_id', $user->id)],
            'firstName' => ['min:1', 'max:50'],
            'lastName' => ['nullable', 'max:50'],
            'email' => ['nullable', 'max:255', 'email'],
            'phone' => ['nullable', 'max:20', 'regex:/^[0-9]{10,20}$/']
        ];
    }

    public function validationData()
    {
        return array_merge($this->route()->parameters(), $this->all());
    }

    public function failedValidation(Validator $validator)
    {
        $errors = $validator->errors();
        $status = 400;
        
        if($errors->has('contactId')){
            $status = 404;
        }

        throw new HttpResponseException(response([
            'errors' => $errors->toArray()
        ], $status));
    }

    /**
     * @param array|int|string|null $key
     */
    public function validated($key = null, $default = null): array
    {
        return array_diff_key(parent::validated(), ['contactId' => '']); // agar contactId tidak di return ketika pemanggilan method validated()
    }
}
