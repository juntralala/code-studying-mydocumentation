<?php

namespace App\Rules;

use Closure;
use Illuminate\Contracts\Validation\{DataAwareRule, ValidationRule, ValidatorAwareRule};
use Illuminate\Validation\Validator;

class RegistrationRule implements ValidationRule, DataAwareRule, ValidatorAwareRule
{
    private array $data;
    private Validator $validator;

    public function setData(array $data): RegistrationRule 
    {
        $this->data = $data;
        return $this;
    }

    public function setValidator(Validator $validator): self
    {
        $this->validator = $validator;
        return $this;
    }

    /**
     * Run the validation rule.
     *
     * @param  \Closure(string): \Illuminate\Translation\PotentiallyTranslatedString  $fail
     */
    public function validate(string $attribute, mixed $value, Closure $fail): void
    {
        if($this->data["username"] == $value){
            $fail("$attribute harus berbeda dengan username");
        }
    }
}
