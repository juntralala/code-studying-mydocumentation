<?php

namespace App\Rules;

use Closure;
use Illuminate\Contracts\Validation\ValidationRule;
use Illuminate\Support\Str;

class Uppercase implements ValidationRule
{
    /**
     * Run the validation rule.
     *
     * @param  \Closure(string): \Illuminate\Translation\PotentiallyTranslatedString  $fail
     */
    public function validate(string $attribute, mixed $value, Closure $fail): void
    {
        if($value !== Str::upper($value)){
            $fail("validation.ujun.uppercase")->translate([
                'attribute' => $attribute, 
                'value' => $value 
            ]);
        }
    }
}
