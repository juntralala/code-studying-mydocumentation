<?php

namespace Tests\Frature\CustomRule;

use App\Rules\RegistrationRule;
use App\Rules\Uppercase;
use Tests\TestCase;

/** Data Aware dan Validator Aware
 * Saat kita membutuhkan Custom Rule yang membutuhkan bisa melihat seluruh data yang di validasi, kita bisa
   implement interface DataAwareRule
 * Dan jika kita butuh object Validator, kita bisa implement interface ValidatorAwareRule
*/

// penerapannya ada di App\Http\Rules\RegistrationRule

class DataAwareDanValidatorTest extends TestCase {
    public function testDataAwareDanValidatorAware()
    {
        $data = [
            'username' => 'ujun@email.com',
            'password' => 'ujun@email.com'
        ];
        $rules = [
            'username' => ['required', 'email', 'max:100', new Uppercase()],
            'password' => ['required', 'min:6', 'max:20', new RegistrationRule()],
        ];
        $validator = validator($data, $rules);

        self::assertTrue($validator->fails());
        self::assertStringContainsString(<<<MS
        {
            "username": [
                "username harus UPPERCASE."
            ],
            "password": [
                "password harus berbeda dengan username"
            ]
        }
        MS, $validator->errors()->toJson(JSON_PRETTY_PRINT));
    }
}