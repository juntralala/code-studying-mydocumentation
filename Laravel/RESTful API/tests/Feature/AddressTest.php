<?php

namespace Tests\Feature;

use App\Models\Address;
use App\Models\Contact;
use App\Models\User;
use Database\Seeders\AddressSeeder;
use Database\Seeders\ContactSeeder;
use Database\Seeders\UserSeeder;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class AddressTest extends TestCase
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
        $this->seed([UserSeeder::class, ContactSeeder::class]);
        $contact = Contact::where('first_name', 'dummy')->first();
        $response = $this->post(
            "/api/contacts/$contact->id/addresses",
            [
                'street' => 'Jl. Batu Hijau',
                'city' => 'Amas',
                'province' => 'Tanah Makmur',
                'country' => 'Indonesia',
                'postalCode' => '080810'
            ],
            [
                'Authorization' => 'test'
            ]
        )
            ->assertStatus(201)
            ->assertJson([
                'data' => [
                    'street' => 'Jl. Batu Hijau',
                    'city' => 'Amas',
                    'province' => 'Tanah Makmur',
                    'country' => 'Indonesia',
                    'postalCode' => '080810'
                ]
            ]);
        self::assertNotNull($response->json('data.id'));
    }

    public function testCreateFailed(): void
    {

        $this->seed([UserSeeder::class, ContactSeeder::class]);
        $contact = Contact::where('first_name', 'dummy')->first();
        $response = $this->post(
            "/api/contacts/$contact->id/addresses",
            [
                'street' => 'Jl. Batu Hijau',
                'city' => 'Amas',
                'province' => 'Tanah Makmur',
                'country' => '',
                'postalCode' => '080810'
            ],
            [
                'Authorization' => 'test'
            ]
        )
            ->assertStatus(400)
            ->assertJson([
                'errors' => [
                    'country' => [
                        'The country field is required.'
                    ]
                ]
            ]);
    }

    public function testCreateWithContactNotFound(): void
    {
        $this->seed([UserSeeder::class, ContactSeeder::class]);
        $contact = Contact::where('first_name', 'dummy')->first();
        $response = $this->post(
            "/api/contacts/" . ($contact->id + 100) . "/addresses",
            [
                'street' => 'Jl. Batu Hijau',
                'city' => 'Amas',
                'province' => 'Tanah Makmur',
                'country' => 'Indonesia',
                'postalCode' => '080810'
            ],
            [
                'Authorization' => 'test'
            ]
        )
            ->assertStatus(404)
            ->assertJson([
                'errors' => [
                    'message' => ['The contact is not found.']
                ]
            ]);
    }

    public function testUpdateSuccess(): void
    {
        $this->seed([UserSeeder::class, ContactSeeder::class, AddressSeeder::class]);
        $contact = Contact::where('first_name', 'dummy')->first();
        $address = Address::where('street', 'Street 0')->first();
        $response = $this->patch(
            "/api/contacts/$contact->id/addresses/$address->id",
            [
                'street' => 'Street Updated',
                'city' => 'City Updated',
                'province' => 'Province Updated',
                'country' => 'Country Updated',
                'postalCode' => '909090'
            ],
            [
                'Authorization' => 'test'
            ]
        )
            ->assertStatus(200)
            ->assertJson([
                'data' => [
                    'street' => 'Street Updated',
                    'city' => 'City Updated',
                    'province' => 'Province Updated',
                    'country' => 'Country Updated',
                    'postalCode' => '909090'
                ]
            ]);
        self::assertNotNull($response->json('data.id'));
    }

    public function testUpdateFailed(): void
    {
        $this->seed([UserSeeder::class, ContactSeeder::class, AddressSeeder::class]);
        $contact = Contact::where('first_name', 'dummy')->first();
        $address = Address::where('street', 'Street 0')->first();
        $response = $this->patch(
            "/api/contacts/$contact->id/addresses/$address->id",
            [
                'street' => 'Street Updated',
                'city' => 'City Updated',
                'province' => 'Province Updated',
                'country' => 'Country Updated',
                'postalCode' => '12345789012'  // The postalCode too lenght
            ],
            [
                'Authorization' => 'test'
            ]
        )
            ->assertStatus(400)
            ->assertJson([
                'errors' => [
                    'postalCode' => ['The postal code field must not be greater than 10 characters.']
                ]
            ]);
    }
    public function testUpdateNotFound(): void
    {
        $this->seed([UserSeeder::class, ContactSeeder::class, AddressSeeder::class]);
        $contact = Contact::where('first_name', 'dummy')->first();
        $address = Address::where('street', 'Street 0')->first();
        $response = $this->patch(
            "/api/contacts/$contact->id/addresses/" . ($address->id + 100),
            [
                'street' => 'Street Updated',
                'city' => 'City Updated',
                'province' => 'Province Updated',
                'country' => 'Country Updated',
                'postalCode' => '909090'
            ],
            [
                'Authorization' => 'test'
            ]
        )
            ->assertStatus(404)
            ->assertJson([
                'errors' => [
                    'message' => ['The address is not found.']
                ]
            ]);
    }

    public function testGetSuccess(): void
    {
        $this->seed([UserSeeder::class, ContactSeeder::class, AddressSeeder::class]);
        $contact = Contact::where('first_name', 'dummy')->first();
        $address = Address::where('street', 'Street 0')->first();
        $this->get(
            "/api/contacts/$contact->id/addresses/$address->id",
            [
                'Authorization' => 'test'
            ]
        )
            ->assertStatus(200)
            ->assertJson([
                'data' => [
                    'id' => $address->id,
                    'street' => $address->street,
                    'city' => $address->city,
                    'province' => $address->province,
                    'country' => $address->country,
                    'postalCode' => $address->postalCode
                ]
            ]);
    }

    public function testGetNotFound(): void
    {
        $this->seed([UserSeeder::class, ContactSeeder::class, AddressSeeder::class]);
        $contact = Contact::where('first_name', 'dummy')->first();
        $address = Address::where('street', 'Street 0')->first();
        $this->get(
            "/api/contacts/$contact->id/addresses/" . ($address->id + 100),
            [
                'Authorization' => 'test'
            ]
        )
            ->assertStatus(404)
            ->assertJson([
                'errors' => [
                    'message' => [
                        'The address is not found.'
                    ]
                ]
            ]);
    }

    public function testDeleteSuccess(): void
    {
        $this->seed([UserSeeder::class, ContactSeeder::class, AddressSeeder::class]);
        $contact = Contact::where('first_name', 'dummy')->first();
        $address = Address::where('street', 'Street 0')->first();
        $this->delete(
            "/api/contacts/$contact->id/addresses/$address->id",
            headers: [
                'Authorization' => 'test'
            ]
        )
            ->assertStatus(200)
            ->assertJson([
                'data' => true
            ]);
    }

    public function testDeleteNotFound(): void
    {
        $this->seed([UserSeeder::class, ContactSeeder::class, AddressSeeder::class]);
        $contact = Contact::where('first_name', 'dummy')->first();
        $address = Address::where('street', 'Street 0')->first();
        $this->delete(
            "/api/contacts/$contact->id/addresses/" . ($address->id + 100),
            headers: [
                'Authorization' => 'test'
            ]
        )
            ->assertStatus(404)
            ->assertJson([
                'errors' => [
                    'message' => [
                        'The address is not found.'
                    ]
                ]
            ]);
    }

    public function testListSuccess(): void
    {
        $this->seed([UserSeeder::class, ContactSeeder::class, AddressSeeder::class]);
        $contact = Contact::where('first_name', 'dummy')->first();
        $response = $this->get(
            "/api/contacts/$contact->id/addresses",
            [
                'Authorization' => 'test'
            ]
        )->assertStatus(200);

        for($i = 0 ; $i < 5 ; $i++){
            $response->assertJson([
                'data' => [
                    $i => [
                        'street' => "Street $i",
                        'city' => "City $i",
                        'province' => "Province $i",
                        'country' => "Country $i",
                        'postalCode' => "080810$i"
                    ]
                ]
            ]);
            self::assertNotNull($response->json("data.$i.id"));
        }
    }

    public function testListNotFound(): void
    {
        $this->seed([UserSeeder::class, ContactSeeder::class, AddressSeeder::class]);
        $contact = Contact::where('first_name', 'dummy')->first();
        Address::where('contact_id', $contact->id)->delete();
        $this->get(
            "/api/contacts/$contact->id/addresses",
            [
                'Authorization' => 'test'
            ]
        )
            ->assertStatus(404)
            ->assertJson([
                'errors' => [
                    'message' => ['The addresses is not found.'] 
                ]
            ]);
    }
}
