<?php

namespace App\Http\Controllers;

use Illuminate\Http\RedirectResponse;
use Illuminate\Http\Request;
use Illuminate\Http\Response;

class RedirectController extends Controller
{
    public function redirectFrom(): RedirectResponse {
        return response()
            ->redirectTo("/redirect/to");
    }

    public function redirectTo(): Response {
        return response("Ini Redirect To");
    }

    public function redirectName(): RedirectResponse {
        return redirect()->route("redirect-hello", ['name' => "UJUN"]);
        // return response()
        //     ->redirectToRoute("redirect-hello", ["name" => "UJUN"]);
    }
    
    public function redirectHello($name): Response {
        return response("Hello $name");
    }

    public function redirectAction(): RedirectResponse {
        return redirect()->action([RedirectController::class, 'redirectHello'], ['name' => "UJUN"]);
        // return response()
        //     ->redirectToAction([RedirectController::class, 'redirectHello'], ["name" => "UJUN"]);
    }

    public function redirectAway(): RedirectResponse {
        return redirect()->away("https://www.youtube.com");
    }
}
