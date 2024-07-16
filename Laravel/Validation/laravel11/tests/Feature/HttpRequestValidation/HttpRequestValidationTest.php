<?php

namespace Tests\Frature\HttpRequestValidation;

use App\Http\Controllers\FormController;
use Illuminate\Support\Facades\Route;
use Tests\TestCase;

/** Rule Classses
 * Laravel Validator sudah terintegrasi dengan baik dengan HTTP Request di Laravel
 * Class Request memiliki method validate() untuk melakukan validasi data request yang dikirim oleh User, misal dari Form atau Query Parameter
 * https://laravel.com/api/10.x/Illuminate/Http/Request.html#method_validate 
 */

class HttpRequestValidationTest extends TestCase
{
    public function testLoginFailed()
    {
        $this->post('/login', [
            'username' => '',
            'password' => ''
        ])->assertStatus(400);
    }

    public function testLoginSuccess(): void
    {
        $this->post('/login', [
            'username' => 'valid', 
            'password' => 'valid'
        ])->assertStatus(200)
            ->assertSeeText("OK");
    }
}