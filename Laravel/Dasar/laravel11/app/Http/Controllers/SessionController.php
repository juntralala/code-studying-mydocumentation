<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Http\Response;

class SessionController extends Controller
{
    public function createSession(Request $request): string {
        $session = $request->session();
        $session->put("User-Id", "UJUN");
        $session->put("Is-Member", true);
        return "SESSION";
    }

    public function getSession(Request $request): string {
        $session = $request->session();
        $userId = $session->get('User-Id', "guest");
        $isMember = $session->get('Is-Member', false);
        return "User Id : {$userId}, Is Member : {$isMember}";
    }
}
