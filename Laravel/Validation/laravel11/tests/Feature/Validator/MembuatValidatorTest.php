<?php

namespace Tests\Feature\Validator;

use Illuminate\Support\Facades\Validator;
use Tests\TestCase;

/** Membuat Validator
 * Untuk membuat Validator, kita bisa menggunakan static method di Facade Validator::make()
 * https://laravel.com/api/10.x/Illuminate/Support/Facades/Validator.html
 * Saat membuat Validator, kita harus tentukan data yang akan divalidasi, dan rules (aturan-aturan validasi) 
 */
            
class MembuatValidatorTest extends TestCase
{
    public function testCreateValidator(): void
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
        self::assertNotNull($validator);
    }
}