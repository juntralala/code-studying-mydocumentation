<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Http\Response;

class FormController extends Controller
{
    public function form(): Response {
        return response()->view("form");
    }

    public function submitForm(Request $request): Response {
        $name = $request->input("username");

        return response()->view("hello", data: [
            'name' => $name
        ]);
    } 
}
