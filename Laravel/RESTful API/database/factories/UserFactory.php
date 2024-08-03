<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Str;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\User>
 */
class UserFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'username' => 'anonym',
            'password' => Hash::make('secret'),
            'name'     => 'anonym'
        ];
    }

    public function unlogged(): Factory
    {
        return $this->state([
            'username' => 'juntralala',
            'password' => Hash::make('Admin#1234'),
            'name' => 'ujun'
        ]);
    }

    public function logged(): Factory
    {
        return $this->unlogged()
            ->state(['token' => Str::uuid()]);
    }
}
