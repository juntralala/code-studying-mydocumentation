<?php

namespace Tests\Feature\ValidData;

use Illuminate\Support\Facades\Validator;
use Illuminate\Validation\ValidationException;
use Tests\TestCase;

/** Valid Data
 * Laravel Validator bisa mengembalikan data yang berisikan hanya attribute yang di validasi
 * Hal ini sangat cocok ketika kita memang tidak ingin menggunakan attribute yang tidak di validasi
 * Untuk mendapatkan data tersebut, kita bisa menggunakan return value validate() atau validated()
*/

/** methods
 * validate(): array
 */

class ValidDataTest extends TestCase {
    public function testUnit()
    {
        $datas = [
            'username' => 'admin@gmail.com',
            'password' => 'rahasia'
        ];
        $rules = [
            'username' => 'required|email|max:100',
            'password' => 'required|min:6|max:20'
        ];

        $validator = Validator::make($datas, $rules);
        self::assertNotNull($validator);

        try{
            $valid = $validator->validate(); // <- POINT utama mengambil data yg divalidasi
            $this->logger->info(json_encode($valid, JSON_PRETTY_PRINT)); 
        } catch (ValidationException $exception){
            self::assertNotNull($exception->validator); // <- kita bisa mendapatkan validator dari exception nya
            $message = $exception->errors();
            $this->logger->info(json_encode($message, JSON_PRETTY_PRINT));
        }
    }
}