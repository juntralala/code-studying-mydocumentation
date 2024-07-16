<?php

namespace Tests\Frature\NestedArrayValidation;

use Tests\TestCase;

/** Indexed Array Validation
 * Pada beberapa kasus, misal nested array nya adalah indexed, artinya bisa lebih dari satu
 * Pada kasus ini, kita bisa menggunakan * (bintang)
*/

class NestedIndexedArrayValidationTest extends TestCase {
    public function testNestedIndexedArrayValidation()
    {
        $datas = [
            'username' => [
                'first' => 'Muhammad',
                'last' => 'Junaidi'
            ],
            'address' => [
                [
                    'planet' => 'Earth',
                    'country' => 'Indonesia',
                    'city' => 'Martapura'
                ],
                [
                    'planet' => 'Earth',
                    'country' => 'Indonesia',
                    'city' => 'Martapura'
                ]
            ]
        ];
        $rules = [
            'name.first' => ['required', 'max:100'],
            'name.last' => ['required', 'max:100'],
            'address.*.planet' => ['required', 'max:100'],
            'address.*.country' => ['required', 'max:100'],
            'address.*.city' => ['required', 'max:100'],
        ];
        $validator = validator($datas, $rules);

        $validator = validator($datas);
        self::assertTrue($validator->passes());
    }
}