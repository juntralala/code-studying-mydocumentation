<?php

namespace Tests\Feature\Validator;

use Illuminate\Support\Facades\Validator;
use Tests\TestCase;

/** Menjalankan Validasi
 * Setelah kita membuat Validator, selanjutnya yang biasa kita lakukan adalah mengecek apakah validasi sukses atau gagal
 * Untuk melakukan itu, kita bisa menggunakan dua method yang mengembalikan nilai boolean
 * fails(), akan mengembalikan true jika gagal, false jika sukses
 * passes(), akan mengembalikan true jika sukses, false jika gagal
 */

class MenjalankanValidasiTest extends TestCase
{

    public function testMenjalankanValidasi(): void
    {
        $datas = [
            'username' => 'admin',
            'password' => 'admin1234'
        ];
        $rules = [
            'username' => 'required',
            'password' => 'required'
        ];

        $validator = Validator::make($datas, $rules);

        self::assertTrue($validator->passes());
        self::assertFalse($validator->fails());
    }

}