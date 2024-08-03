<?php

namespace Tests\Feature;

use App\Models\Address;
use App\Models\Contact;
use App\Models\User;
use Database\Seeders\ContactSeeder;
use Database\Seeders\UserSeeder;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use PHPUnit\Framework\Attributes\TestDox;
use Tests\TestCase;

class ContactTest extends TestCase
{
    public function setUp(): void
    {
        parent::setUp();
        Address::query()->delete();
        Contact::query()->delete();
        User::query()->delete();
    }

    public function testCreateSuccess(): void
    {
        $this->seed([UserSeeder::class]);
        $user = User::where('username', 'juntralala')->first();
        $this->post(
            '/api/contacts',
            [
                'firstName' => 'ozon',
                'lastName' => 'mantap',
                'email' => 'ozon@email.com',
                'phone' => '08121122334455'
            ],
            [
                'Authorization' => 'test'
            ]
        )->assertStatus(201)
            ->assertJson([
                'data' => [
                    'firstName' => 'ozon',
                    'lastName' => 'mantap',
                    'email' => 'ozon@email.com',
                    'phone' => '08121122334455'
                ]
            ]);
    }

    public function testCreateFailed(): void
    {
        $this->seed(UserSeeder::class);
        $this->post(
            '/api/contacts',
            data: [
                'firstName' => '',
                'lastName' => 'mantap',
                'email' => 'ozon@email.com',
                'phone' => '08121122334455',
            ],
            headers: [
                'Authorization' => 'test'
            ]
        )
            ->assertStatus(400)
            ->assertJson([
                'errors' => [
                    'firstName' => [
                        'The first name field is required.'
                    ]
                ]
            ]);
    }

    public function testCreateContactUnauthorized(): void
    {
        $this->seed(UserSeeder::class);
        $this->post(
            '/api/contacts',
            data: [
                'firstName' => 'ozon',
                'lastName' => 'mantap',
                'email' => 'ozon@email.com',
                'phone' => '08121122334455',
            ],
            headers: [
                'Authorization' => 'salahToken'
            ]
        )
            ->assertStatus(401)
            ->assertJson([
                'errors' => [
                    'message' => [
                        'unauthorized'
                    ]
                ]
            ]);
    }

    public function testGetSuccess(): void
    {
        $this->seed([UserSeeder::class, ContactSeeder::class]);
        $contact = Contact::where('first_name', 'dummy')->first();
        $this->get("/api/contacts/$contact->id", headers: [
            'Authorization' => 'test'
        ])
            ->assertStatus(200)
            ->assertJson([
                'data' => [
                    'id' => $contact->id,
                    'firstName' => $contact->firstName,
                    'lastName' => $contact->lastName,
                    'email' => $contact->email,
                    'phone' => $contact->phone
                ]
            ]);
    }

    public function testGetNotFound(): void
    {
        $this->seed([UserSeeder::class, ContactSeeder::class]);
        $contact = Contact::where('first_name', 'dummy')->first();
        $this->get("/api/contacts/" . ($contact->id * 10), headers: [
            'Authorization' => 'test'
        ])
            ->assertStatus(404)
            ->assertJson([
                'errors' => [
                    'contactId' => ["The selected contact id is invalid."],
                ]
            ]);
    }

    public function testUpdateSuccess(): void
    {
        $this->seed([UserSeeder::class, ContactSeeder::class]);
        $contact = Contact::where('first_name', 'dummy')->first();
        $this->patch(
            "/api/contacts/$contact->id",
            data: [
                'lastName' => 'Nomer 1',
            ],
            headers: [
                'Authorization' => 'test'
            ]
        )
            ->assertStatus(200)
            ->assertJson([
                'data' => [
                    'id' => $contact->id,
                    'firstName' => 'dummy',
                    'lastName' => 'Nomer 1',
                    'email' => $contact->email,
                    'phone' => $contact->phone
                ]
            ]);
    }

    public function testUpdateValidationException(): void
    {
        $this->seed([UserSeeder::class, ContactSeeder::class]);
        $contact = Contact::where('first_name', 'dummy')->first();
        $this->patch(
            "/api/contacts/$contact->id",
            data: [
                'email' => 'format_email_salah',
            ],
            headers: [
                'Authorization' => 'test'
            ]
        )
            ->assertStatus(400)
            ->assertJson([
                'errors' => [
                    'email' => ['The email field must be a valid email address.']
                ]
            ]);
    }

    #[TestDox('test update not exists contact or contact owned by other user')]
    public function testUpdateNotExists(): void
    {
        $this->seed([UserSeeder::class, ContactSeeder::class]);
        $contact = Contact::where('first_name', 'dummy')->first();
        $this->patch(
            "/api/contacts/" . ($contact->id * 10),
            data: [
                'lastName' => 'Nomer 1',
            ],
            headers: [
                'Authorization' => 'test'
            ]
        )
            ->assertStatus(404)
            ->assertJson([
                'errors' => [
                    'contactId' => ['The selected contact id is invalid.']
                ]
            ]);
    }

    public function testDeleteSuccess()
    {
        $this->seed([UserSeeder::class, ContactSeeder::class]);
        $contact = Contact::where('first_name', 'dummy')->first();
        $this->delete("/api/contacts/$contact->id", headers: [
            'Authorization' => 'test'
        ])
            ->assertStatus(200)
            ->assertJson([
                'data' => true
            ]);
    }

    public function testDeleteNotFound()
    {
        $this->seed([UserSeeder::class, ContactSeeder::class]);
        $contact = Contact::where('first_name', 'dummy')->first();
        $this->delete("/api/contacts/" . ($contact->id * 10), headers: [
            'Authorization' => 'test'
        ])
            ->assertStatus(404)
            ->assertJson([
                'errors' => [
                    'contactId' => ['The selected contact id is invalid.']
                ]
            ]);
    }

    public function testSearchName(): void
    {
        $this->seed([UserSeeder::class, ContactSeeder::class]);
        $response = $this->get(
            '/api/contacts?name=dummy',
            [
                'Authorization' => 'test'
            ]
        )
            ->assertStatus(200);

        $firstNames = $response->json('data.*.firstName');
        self::assertCount(10, $firstNames);
        $total = $response->json('meta.total');
        self::assertEquals(10, $total);
        foreach ($firstNames as $firstName) {
            self::assertEquals('dummy', $firstName);
        }
    }

    public function testSearchEmail(): void
    {
        $this->seed([UserSeeder::class, ContactSeeder::class]);
        $response = $this->get(
            '/api/contacts?email=dummy',
            [
                'Authorization' => 'test'
            ]
        )
            ->assertStatus(200);

        var_dump($response->json());
        $emails = $response->json('data.*.email');
        self::assertCount(10, $emails);
        $total = $response->json('meta.total');
        self::assertEquals(10, $total);
        for ($i = 0; $i < 10; $i++) {
            $email = $emails[$i];
            self::assertEquals("dummy$i@email.com", $email);
        }
    }
    public function testSearchPhone(): void
    {
        $this->seed([UserSeeder::class, ContactSeeder::class]);
        $response = $this->get(
            '/api/contacts?phone=087654321',
            [
                'Authorization' => 'test'
            ]
        )
            ->assertStatus(200);

        $total = $response->json('meta.total');
        self::assertEquals(10, $total);
        $phones = $response->json('data.*.phone');
        self::assertCount(10, $phones);
        for ($i = 0; $i < 10; $i++) {
            $phone = $phones[$i];
            self::assertEquals("087654321$i", $phone);
        }
    }
}
