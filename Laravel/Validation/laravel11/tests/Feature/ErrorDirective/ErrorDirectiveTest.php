<?php

namespace Tests\Frature\ErrorDirective;

use PHPUnit\Framework\Attributes\TestDox;
use Tests\TestCase;

/** Error Directive
 * Selain menggunakan variable $errors, untuk mendapatkan error by key, kita pernah bahas di kelas Laravel Blade
   Template
 * Kita bisa menggunakan directive @error(key)
*/

// contoh penggunaan @error ada di resources/Login/form.blade.php

class ErrorDirectiveTest extends TestCase {

    #[TestDox('nothing testing scenario here')]
    public function testErrorDirective()
    {
        self::assertTrue(true);
    }
}