<?php

namespace Tests\Frature\CustomRule;

use App\Rules\Uppercase;
use Illuminate\Support\Facades\Validator;
use Tests\TestCase;

/** Custom Rule
 * Walaupun Rule di Laravel sudah tersedia banyak
 * Kadang, pada beberapa kasus, kita perlu membuat Custom Rule sendiri
 * Misal untuk mengecek data ke database, dan lain-lain
 * Untuk membuat rule, kita bisa menggunakan perintah : php artisan make:rule NamaRule
*/

// membuat rule
// php artisan make:rule Uppercase

class CustomRuleTest extends TestCase {
    public function testCustomeRule()
    {
        $datas = [
            'username' => 'ujun@gmail.com',
            'password' => 'rahasia'
        ];
        $rules = [
            'username' => ['required', 'email', new Uppercase()],
            'password' => "required|min:6|max:20"
        ];
        $validator = Validator::make($datas, $rules);

        self::assertFalse($validator->passes());  
        self::assertTrue($validator->fails());  
        self::assertStringContainsString(<<<MS
            {
                "username": [
                    "username harus UPPERCASE."
                ]
            }
            MS, $validator->getMessageBag()->toJson(JSON_PRETTY_PRINT));
    }
}