<?php

namespace Tests\Frature\ValidationRules;

use Illuminate\Support\Facades\Validator;
use Tests\TestCase;

/** Validation Rules
 * Salah satu keuntungan menggunakan Laravel Validator, yaitu sudah disediakan aturan-aturan yang bisa kita gunakan
   untuk melakukan validasi
 * Kita bisa lihat di halaman dokumentasi untuk melihat detail dari aturan-aturan yang sudah disediakan di Laravel
    untuk validasi
 * https://laravel.com/docs/10.x/validation#available-validation-rules 
 * Bagaimana jika aturan yang kita butuhkan tidak ada? Kita juga bisa membuat aturan sendiri, yang akan dibahas di
   materi terpisah
*/

class ValidationRulesTest extends TestCase {

    public function testValidationRules(): void 
    {
        $datas = [
            'username' => 'admin',
            'password' => 'rahasia'
        ]; 
        $rules = [
            'username' => 'required|email|max:100',
            'password' => ['required', 'min:6', 'max:100'],
        ];
        $validator = Validator::make($datas, $rules);

        self::assertTrue($validator->fails());
        $this->logger->info($validator->getMessageBag()->toJson(JSON_PRETTY_PRINT));
        }

}