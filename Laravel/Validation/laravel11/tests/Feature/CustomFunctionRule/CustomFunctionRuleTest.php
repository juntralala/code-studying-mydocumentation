<?php

namespace Tests\Frature\CustomFunctionRule;

use App\Rules\RegistrationRule;
use Closure;
use Illuminate\Support\Str;
use Tests\TestCase;

/** Custome Function Rule
 * Pada kasus kita perlu membuat Custom Rule, namun jika membuat Class Rule terlalu berlebihan, kita bisa menggunakan Custom Function Rule ketika membuat Rule
 * Cukup gunakan Function dimana terdapat 3 parameter, $attribute, $value dan $fail 
*/

class CustomFunctionRuleTest extends TestCase {
    public function testCustomFunctionRule()
    {
        $data = [
            'username' => 'ujun@email.com',
            'password' => 'ujun@email.com'
        ];
        $rules = [
            'username' => ['required', 'email', 'max:100', function(string $attribute, mixed $value, Closure $fail){
                if($value != Str::upper($value)){
                    $fail("$attribute harus UPPERCASE.");           
                }
            }],
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