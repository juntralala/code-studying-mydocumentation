<?php

namespace Tests\Feature\ErrorPage;

use Tests\TestCase;

/** Error Page
 * Saat kita membuat Web, dan menerima input data yang tidak valid, kadang kita ingin menampilkan error message 
   di halaman web nya
 * Kita bisa dengan mudah menampilkan error dari MessageBag di Laravel Blade Template
 * Kita cukup menggunakan variable $errors di Blade Template
 * https://laravel.com/api/10.x/Illuminate/Support/MessageBag.html 
*/

// contohnya di App\Http\LoginController::login
//          dan routes/web.php
//          dan resource/Login/form.blade.php

class ErrorPageTest extends TestCase {
    public function testFormLoginError()
    {
        $this->post('/login/form', [
            'username' => '',
            'password' => ''
        ])->assertStatus(302);
    }

    public function testFormLoginSuccess()
    {
        $this->post('/login/form', [
            'username' => 'ujun@email.com',
            'password' => 'Admin#1234'
        ])->assertStatus(200)
            ->assertSeeText('OK');
    }
}