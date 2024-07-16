<?php

namespace Tests\Feature\ValidationMessage;

use Illuminate\Support\Facades\Validator;
use Tests\TestCase;

/** Localozation
 * Message di Laravel, mendukung multi bahasa
 * Caranya kita cukup membuat folder dengan kode locale pada folder lang, dan buat file php validation yang berisi
    attribute sama 
 * Kita bisa mengubah nilai message nya, sesuai dengan bahasanya
 * Untuk mengaktifkan bahasa yang ingin kita gunakan, kita bisa gunakan Facade App::setLocale()
 * Jika locale yang kita pilih tidak tersedia, maka secara otomatis akan menggunakan default locale
*/

// telah menambahkan /lang/id/*

class LocalizationTest extends TestCase {
    public function testLocalization()
    {
        $this->app->setLocale("id"); // menggati bahasa
        $datas = [
            'username' => '',
            'password' => ''
        ];
        $rules = [
            'username' => 'required',
            'password' => 'required'
        ];

        $validator = Validator::make($datas, $rules);
        $messages = $validator->messages();
        self::assertStringContainsString(<<<MS
            {
                "username": [
                    "username harus diisi."
                ],
                "password": [
                    "password harus diisi."
                ]
            }
            MS, $messages->toJson(JSON_PRETTY_PRINT)
        );    
    }
}