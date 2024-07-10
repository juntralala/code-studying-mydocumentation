<?php

namespace Tests\Feature;

use App\Models\Employee;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class FactoryTest extends TestCase
{
    public function testFactory(): void
    {
        $employee1 = Employee::factory()->programmer()->create([
            'id' => '1',
            'name' => 'UJUN'
        ]);
        self::assertNotNull($employee1);

        $employee2 = Employee::factory()->seniorProgrammer()->create([
            'id' => '2',
            'name' => 'OZON'
        ]);
        self::assertNotNull($employee2);
    }
}
