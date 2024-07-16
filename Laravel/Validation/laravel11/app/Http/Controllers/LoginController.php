<?php

namespace App\Http\Controllers;

use App\Http\Requests\LoginRequest;
use Illuminate\Http\Request;
use Illuminate\Http\Response;
use Illuminate\Support\Facades\View;
use Illuminate\Validation\ValidationException;
use \Symfony\Component\HttpFoundation\Response as SymfonyResponse;

class LoginController extends Controller
{
    public function login(Request $request): Response
    {
        try {
            $request->validate([
                'username' => 'required',
                'password' => 'required'
            ]);
            // do somthing with data
            return response("OK", SymfonyResponse::HTTP_OK);
        } catch (ValidationException $e){
            return response($e->errors(), SymfonyResponse::HTTP_BAD_REQUEST);
        }
    }

    public function form(): Response
    {
        return response()->view('Login.form');
    }

    public function submitForm(LoginRequest $request): Response
    {
        $request->validated();
        return response("OK", SymfonyResponse::HTTP_OK);
    }
}
