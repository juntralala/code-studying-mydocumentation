<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class InputController extends Controller
{
    
    public function hello(Request $request): string {
        $name = $request->input("name");
        return "Hello $name";
    }

    public function helloFirstLast(Request $request): string {
        $firstName = $request->input('name.first');
        $lastName = $request->input('name.last');
        return "Hello $firstName $lastName";
    }

    public function helloInput(Request $request): string {
        $input = $request->input();

        return json_encode($input);
    }

    public function helloDynamicProperties(Request $request): string {
        $firstName = $request->first_name;
        $lastName = $request->last_name;

        return "Hello $firstName $lastName";
    }

}
