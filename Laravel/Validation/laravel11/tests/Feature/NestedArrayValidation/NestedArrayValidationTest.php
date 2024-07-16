<?php

namespace Tests\Feature\NestedArrayValidation;

use Tests\TestCase;

/** Nested Array Validation
 * Saat kita melakukan validasi, kadang data yang kita validasi tidak hanya berformat key-value
 * Kadang terdapat nested array, misal terdapat key address, dimana di dalamnya berisi array lagi
 * Pada kasus data jenis nested array, kita bisa membuat Rule menggunakan tanda . (titik), misal address.street,
   address.city, dan lain-lain
 * Jika masih terdapat nested array, kita bisa tambahkan . (titik) lagi
 */

class NestedArrayValidationTest extends TestCase
{
    public function testNestedArrayValidation()
    {
        $datas = [
            'username' => [
                'first' => 'Muhammad',
                'last' => 'Junaidi'
            ],
            'address' => [
                'planet' => 'Earth',
                'country' => 'Indonesia',
                'city' => 'Martapura'
            ]
        ];
        $rules = [
            'name.first' => ['required', 'max:100'],
            'name.last' => ['required', 'max:100'],
            'address.planet' => ['required', 'max:100'],
            'address.country' => ['required', 'max:100'],
            'address.city' => ['required', 'max:100'],
        ];
        $validator = validator($datas, $rules);

        $validator = validator($datas);
        self::assertTrue($validator->passes());
    }
}