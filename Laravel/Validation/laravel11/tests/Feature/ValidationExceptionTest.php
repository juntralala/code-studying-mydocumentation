<?php

namespace Tests\Frature;

use Illuminate\Support\Facades\Validator;
use Illuminate\Validation\ValidationException;
use Tests\TestCase;

/** Validation Exception
 * Pada beberapa kasus, kadang-kadang kita ingin menggunakan Exception ketika melakukan validasi
 * Jika data tidak valid, maka harapan kita terjadi exception
 * Validator juga menyediakan fitur ini, dengan menggunakan method validate()
 * Saat kita memanggil method validate(), jika data tidak valid, maka akan throw ValidationException
 * Untuk mendapatkan detail informasi validator dan error message, bisa kita ambil dari ValidationException
 * https://laravel.com/api/10.x/Illuminate/Validation/ValidationException.html 
 */

 /** Methods
  * ->validate()
  */

class ValidationExceptionTest extends TestCase
{
    public function testValidationException()
    {
        
        $datas = [
            'username' => 'admin',
            'password' => ''
        ];
        $rules = [
            'username' => 'required',
            'password' => 'required'
        ];

        $validator = Validator::make($datas, $rules);
        self::assertNotNull($validator);

        try{
            $validator->validate();
            self::fail("Validation Exception not thrown");
        } catch (ValidationException $exception){
            self::assertNotNull($exception->validator); // <- kita bisa mendapatkan validator dari exception nya
            $message = $exception->errors();
            $this->logger->info(json_encode($message, JSON_PRETTY_PRINT));
        }
    }
}