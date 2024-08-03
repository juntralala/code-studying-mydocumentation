<?php

namespace Database\Seeders;

use App\Models\Contact;
use App\Models\User;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class ContactSeeder extends Seeder
{
    public function run(): void
    {
        $user = User::where('username', 'juntralala')->first();
        for ($i = 0; $i < 10; $i++) {
            Contact::create([
                'firstName' => 'dummy',
                'lastName' => (string) $i,
                'email' => "dummy$i@email.com",
                'phone' => "087654321$i",
                'userId' => $user->id 
            ]);
        }
        for ($i = 0; $i < 10; $i++) {
            Contact::create([
                'firstName' => 'anonym',
                'lastName' => (string) $i,
                'email' => "anonym$i@email.com",
                'phone' => "097654321$i",
                'userId' => $user->id 
            ]);
        }
    }


}
