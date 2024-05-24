<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class InputTypeController extends Controller
{
    
    public function inputType(Request $request): string {
        $name = $request->input("name");
        $married = $request->boolean("married");
        $birthDate = $request->date('birth_date', 'Y-m-d');

        return json_encode([
            'name' => $name,
            'married' => $married,
            'birth_date' => $birthDate->format('d-m-Y')
        ]);
    } 

}
