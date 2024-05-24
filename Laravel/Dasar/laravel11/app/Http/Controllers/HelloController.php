<?php

namespace App\Http\Controllers;

use App\Services\HelloService;
use Illuminate\Http\Request;

class HelloController extends Controller{

    public HelloService $helloService;

    public function __construct(HelloService $helloService){
        $this->helloService = $helloService;
    } 
    
    public function hello(Request $request, string $name): string {
        return "Hello $name";
    }

    public function request(Request $request): string {
        return "<ul>".
            "<li>". $request->path() ."</li>".
            "<li>". $request->url() ."</li>".
            "<li>". $request->fullUrl() ."</li>".
            "<li>". $request->method() ."</li>".
            "<li>". $request->header("Accept") ."</li>".
        "</ul>";
    }

    public function helloArray(Request $request): string {
        $names = $request->input("products.*.name");
        return json_encode($names);
    }

}
