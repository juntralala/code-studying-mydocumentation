<?php

namespace Tests\Frature\AdditionalValidation;

use Illuminate\Support\Facades\Validator;
use Tests\TestCase;

/** Additional Validation
 * Saat kita selesai melakukan validasi, kadang kita ingin melakukan validasi tambahan
 * Pada kasus seperti ini, kita bisa menggunakan method after(callback), dimana kita bisa menambahkan function
   callback sebagai parameter
 * Function callback nya terdapat satu parameter yaitu Validator, sehingga kita bisa menambah error tambahan jika
   dibutuhkan
*/

class AdditionalValidationTest extends TestCase {
    public function testAddtionalTest()
    {
        $datas = [ // sebenarnya datas nya berdasarkan rules telah valid, tapi tidak dengan terhadp addtional validation yg kita tambahlam
            'username' => 'ujun@gmail.com',
            'password' => 'ujun@gmail.com'
        ];
        $rules = [
            'username' => 'required|email',
            'password' => 'required|min:6|max:20'
        ];
        $validator = Validator::make($datas, $rules);

        $validator->after(function(\Illuminate\Validation\Validator $validator){ // menambahkan additional validation
            $datas = $validator->getData();
            if($datas['username'] == $datas['password']){
                $validator->errors()->add('password', 'Password tidak boleh sama dengan username');
            }
        });

        self::assertStringContainsString(<<<MS
        {
            "password": [
                "Password tidak boleh sama dengan username"
            ]
        }
        MS, $validator->messages()->toJson(JSON_PRETTY_PRINT));
    }
}