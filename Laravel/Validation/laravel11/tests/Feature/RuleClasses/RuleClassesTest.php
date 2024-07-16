<?php

namespace Tests\Feature\RuleClasses;

use Illuminate\Validation\Rule;
use Illuminate\Validation\Rules\In;
use Illuminate\Validation\Rules\Password;
use Tests\TestCase;

/** Rule Classses
 * Selain Rule-Rule yang kita lihat di halaman dokumentasi Laravel
 * Laravel juga menyediakan beberapa class Rule yang bisa kita gunakan ketika membuat Validator
 * Kita bisa lihat daftar class-class Rule yang tersedia di package Rules
 * https://laravel.com/api/10.x/Illuminate/Validation/Rules.html 
 * https://laravel.com/api/11.x/Illuminate/Validation/Rules.html 
*/

/** Daftar class yg tersedia
 * ArrayRule            -> memastikan bahwa input adalah array
 * Can                  -> validasi otorisasi
 * DatabaseRule         -> validasi yg berinteraksi dengan database, tidak digunakan secara langsung tetapi lewat kelas turunannya seperti Exists dan Unique
 * Dimensions
 * Enum
 * ExcludeIf
 * Exists
 * File
 * ImageFile
 * In                   -> validasi input ada di dalam array
 * NotIn
 * Password             -> validasi password dengan kreteria tertentu
 * ProhibitedIf
 * RequiredIf
 * Unique
 */

class RuleClassesTest extends TestCase {
    public function testRuleClasses()
    {
        $data = [
            'username' => 'ujun@email.com',
            'password' => 'ujun@email.com'
        ];
        $rules = [
            'username' => ['required', new In(["UJUN", "OZON", "Junaidi"])],
            'password' => ['required', 'min:6', 'max:20', Password::min(6)->max(20)->letters()->numbers()->symbols()]
        ];
        $validator = validator($data, $rules);

        self::assertTrue($validator->fails());
        self::assertStringContainsString(<<<MS
        {
            "username": [
                "The selected username is invalid."
            ],
            "password": [
                "The password field must contain at least one number."
            ]
        }
        MS, $validator->errors()->toJson(JSON_PRETTY_PRINT));
    }
}
