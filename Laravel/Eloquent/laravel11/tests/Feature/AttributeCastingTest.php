<?php

namespace Tests\Feature;

use App\Data\Address;
use App\Models\Person;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class AttributeCastingTest extends TestCase
{
    public function testCast(): void
    {
        $person = new Person();
        $person->fullName = "jun tralala";
        $person->save();

        self::assertNotNull($person->created_at);
        self::assertNotNull($person->updated_at);

        self::assertIsString($person->created_at);
        self::assertIsString($person->updated_at);
    }

    public function testCustomCast(): void
    {
        $person = new Person();
        $person->fullName = "jun tralala";
        $person->address = new Address('Jalan Tanah Merah', 'Bumi Selamat', 'Indonesia', '12345');
        $person->save();

        $person = Person::find($person->id);
        self::assertNotNull($person->address);
        self::assertInstanceOf(Address::class, $person->address);
        self::assertEquals("Jalan Tanah Merah", $person->address->street);
        self::assertEquals("Bumi Selamat", $person->address->city);
        self::assertEquals("Indonesia", $person->address->country);
        self::assertEquals("12345", $person->address->postalCode);
    }
}
