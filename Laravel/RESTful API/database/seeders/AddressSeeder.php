<?php

namespace Database\Seeders;

use App\Models\Address;
use App\Models\Contact;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class AddressSeeder extends Seeder
{
    public function run(): void
    {
        $contact = Contact::where('first_name', 'dummy')->first();
        for ($i = 0; $i < 5; $i++) {
            Address::create([
                'street' => "Street $i",
                'city' => "City $i",
                'province' => "Province $i",
                'country' => "Country $i",
                'postalCode' => "080810$i",
                'contactId' => $contact->id
            ]);
        }
    }
}
