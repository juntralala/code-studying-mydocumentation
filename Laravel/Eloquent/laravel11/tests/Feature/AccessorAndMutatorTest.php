<?php

namespace Tests\Feature;

use App\Models\Person;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class AccessorAndMutatorTest extends TestCase
{

    public function testAccessorAndMutator(): void
    {
        $person = new Person();
        $person->first_name = "Muhammad";
        $person->last_name = "Junaidi";
        $person->save();
        
        // untuk tahu kenapa first_name menjadi uppercase di App\Models\Person::firstName()
        self::assertEquals("MUHAMMAD Junaidi", $person->fullName);

        $person->fullName = "jun tralala";
        $person->save();

        self::assertEquals('JUN', $person->first_name);
        self::assertEquals('tralala', $person->last_name);
    }
}
