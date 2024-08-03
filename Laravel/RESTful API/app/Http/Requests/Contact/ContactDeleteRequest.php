<?php

namespace App\Http\Requests\Contact;

use Illuminate\Foundation\Http\FormRequest;
use Illuminate\Http\Exceptions\HttpResponseException;
use Illuminate\Support\Facades\Auth;
use Illuminate\Validation\Rule;

class ContactDeleteRequest extends FormRequest
{
    /**
     * Determine if the user is authorized to make this request.
     */
    public function authorize(): bool
    {
        return Auth::check();
    }

    
    /**
     * @return array<string, \Illuminate\Contracts\Validation\ValidationRule|array<mixed>|string>
     */
    public function rules(): array
    {
        return [
            'contactId' => [Rule::exists('contacts', 'id')->where('user_id', Auth::user()->id)]
        ];
    }

    public function validationData()
    {
        return array_merge($this->route()->parameters(), $this->all());
    }

    public function failedValidation($validator)
    {
        throw new HttpResponseException(response()->json([
            'errors' => $validator->errors()
        ], 404));
    }
}
