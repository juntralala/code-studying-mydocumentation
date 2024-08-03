<?php

namespace Tests\Feature;

use App\Models\Address;
use App\Models\Contact;
use App\Models\User;
use Database\Seeders\UserSeeder;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Hash;
use Tests\TestCase;

class UserTest extends TestCase
{
    public function setUp(): void
    {
        parent::setUp();
        Address::query()->delete();
        Contact::query()->delete();
        User::query()->delete();
    }
    public function testRegisterSuccess(): void
    {
        $this->post('/api/users', [
            'username' => 'juntralala',
            'password' => 'rahasia1234',
            'name' => 'Ujun'
        ])->assertStatus(201)
            ->assertJson([
                'data' => [
                    'username' => 'juntralala',
                    'name' => 'Ujun'
                ]
            ]);
    }

    public function testRegisterFailed(): void
    {
        $this->post('/api/users', [
            'username' => '',
            'password' => '',
            'name' => ''
        ])->assertStatus(400)
            ->assertJson([
                'errors' => [
                    'username' => ['The username field is required.'],
                    'password' => ['The password field is required.'],
                    'name' => ['The name field is required.']
                ]
            ]);
    }

    public function testRegisterUsernameAlreadyExists(): void
    {
        $this->post('/api/users', [
            'username' => 'juntralala',
            'password' => 'rahasia1234',
            'name' => 'Ujun'
        ]);

        $this->post('/api/users', [
            'username' => 'juntralala',
            'password' => 'rahasia1234',
            'name' => 'Ujun'
        ])->assertStatus(400)
            ->assertJson([
                'errors' => [
                    'username' => ['The username already taken.']
                ]
            ]);
    }

    public function testLoginSuccess(): void
    {
        $this->seed(UserSeeder::class);
        $this->post('/api/users/login', [
            'username' => 'juntralala',
            'password' => 'Admin#1234'
        ])->assertJson([
                    'data' => [
                        'username' => 'juntralala',
                        'name' => 'ujun',
                    ]
                ]);

        $user = User::where('username', 'juntralala')->first();
        self::assertNotNull($user->token);
    }

    public function testLoginFailed(): void
    {
        $this->seed(UserSeeder::class);

        $this->post('/api/users/login', [
            'username' => 'juntralala',
            'password' => 'salah'
        ])->assertStatus(401)
            ->assertJson([
                'errors' => [
                    'message' => ['Wrong username or password.']
                ]
            ]);

        $user = User::where('username', 'juntralala')->first();
        self::assertNotNull($user->token);
    }

    public function testGetSuccess(): void
    {
        $this->seed(UserSeeder::class);
        $this->get('/api/users/current', headers: [
            'Authorization' => 'test'
        ])->assertStatus(200)
            ->assertJson([
                'data' => [
                    'username' => 'juntralala',
                    'name' => 'ujun',
                ]
            ]);
    }

    public function testGetUnauthorized(): void
    {
        $this->seed(UserSeeder::class);
        $this->get('/api/users/current', headers: [])
            ->assertStatus(401)
            ->assertJson([
                'errors' => [
                    'message' => ['unauthorized']
                ]
            ]);
    }
    public function testGetInvalidToken(): void
    {
        $this->seed(UserSeeder::class);
        $this->get('/api/users/current', headers: [
            'Authorization' => 'salah'
        ])
            ->assertStatus(401)
            ->assertJson([
                'errors' => [
                    'message' => ['unauthorized']
                ]
            ]);
    }

    public function testUpdateNameSuccess()
    {
        $this->seed(UserSeeder::class);
        $this->patch(
            '/api/users/current',
            [
                'name' => 'ozon'
            ],
            [
                'Authorization' => 'test'
            ]
        )->assertStatus(200)
            ->assertJson([
                'data' => [
                    'username' => 'juntralala',
                    'name' => 'ozon'
                ]
            ]);
    }

    public function testUpdatePasswordSuccess()
    {
        $this->seed(UserSeeder::class);
        $oldUser = User::where('username', 'juntralala')->first();
        $response = $this->patch(
            '/api/users/current',
            [
                'password' => 'berubah'
            ],
            [
                'Authorization' => 'test'
            ]
        )->assertStatus(200)
            ->assertJson([
                'data' => [
                    'username' => 'juntralala',
                    'name' => 'ujun'
                ]
            ]);


        $newUser = User::where('username', 'juntralala')->first();
        self::assertTrue(Hash::check('berubah', $newUser->password));
    }

    public function testUpdateFailed()
    {
        $this->seed(UserSeeder::class);
        $oldUser = User::where('username', 'juntralala')->first();
        $this->patch(
            '/api/users/current',
            [
                'name' => 'p'
            ],
            [
                'Authorization' => 'test'
            ]
        )->assertStatus(400)
            ->assertJson([
                'errors' => [
                    'name' => ['The name field must be at least 4 characters.']
                ]
            ]);
    }

    public function testLogoutSuccess(): void
    {
        $this->seed(UserSeeder::class);
        $this->delete('/api/users/logout', headers:[
            'Authorization' => 'test'
        ])
            ->assertStatus(200)
            ->assertJson([
                'data' => true
            ]);

        $user = User::where('username', 'juntralala')->first();
        self::assertNull($user->token);
    }

    public function testLogoutFailed(): void
    {
        $this->seed(UserSeeder::class);
        $this->delete('/api/users/logout', headers:[
            'Authorization' => 'salah'
        ])->assertStatus(401)
            ->assertJson([
                'errors' => ['message' => ['unauthorized']]
            ]);
    }
}
