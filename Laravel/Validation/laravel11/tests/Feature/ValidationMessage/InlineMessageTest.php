<?php

namespace Tests\Feature\ValidationMessage;

use Illuminate\Support\Facades\Validator;
use Tests\TestCase;

/** Inline Message
 * Kadang, mengubah message file di folder lang mungkin terlalu ribet
 * Kita bisa menambahkan message pada parameter ketiga saat membuat Validator menggunakan 
   Validator::make(data, rules, messages)
 * Secara otomatis, Validator akan mengambil message yang terdapat parameter messages, dan jika tidak ada, maka
   akan mengambil dari folder lang
*/

// meskinpun ada fitur inline message tetap lebih disarankan mengatur bahasa dan pesan mengguankan folder lang/

class InlineMessageTest extends TestCase {
    public function testInlineMessage()
    {
        $datas = [
            'username' => 'ujun',
            'password' => 'ujun'
        ];
        $rules = [
            'username' => 'required|email',
            'password' => 'required|min:6|max:20'
        ];
        $messages = [
            'required' => ":attribute harus diisi",
            'email' => ":attribute harus berupa email",
            'max' => ":attribute maksimal :max karakter",
            'min' => ":attribute minimal :min karakter"
        ];
        $validator = Validator::make($datas, $rules, $messages);
        $messages = $validator->errors();
        self::assertStringContainsString(<<<MS
            {
                "username": [
                    "username harus berupa email"
                ],
                "password": [
                    "password minimal 6 karakter"
                ]
            }
            MS, $messages->toJson(JSON_PRETTY_PRINT)
        );
    }
}