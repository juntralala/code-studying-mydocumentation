<?php

namespace App\Http\Controllers;

use Illuminate\Http\JsonResponse;
use Illuminate\Http\Request;
use Illuminate\Http\Response;
use Illuminate\Support\Facades\Storage;
use Symfony\Component\HttpFoundation\BinaryFileResponse;

class ResponseController extends Controller
{
    
    function response(Request $request): Response {
        return response("Hello Response", 200);
    }

    public function hello(Request $request, string $name): Response {
        return response("Hello $name", 200, [
            'Content-Type' => "application/json",
            'Cache-Control' => "public ; no-store"
        ]);
    }

    public function header(Request $request): Response {
        $body = [
                'name' => [
                    'first' => "Muhammad",
                    'last' => "Junaidi"
                ]
            ];
        return response(json_encode($body), 200)
            ->header('Content-Type', "application/json")
            ->withHeaders([
                'Author' => "UJUN-Al-Rantaui",
                'App'    => "Belajar Laravel"
        ]);
    }

    public function responseView(): Response {
        return response()
            ->view('hello', ['name' => "UJUN"]);
    }

    public function responseJson(): JsonResponse {
        $body = [
            'name' => [
                'first' => "Muhammad",
                'last' => "Junaidi"
            ]
        ];

        return response()
            ->json($body); // Content-Type nya otomatis application/json
    }

    public function responseFile(): BinaryFileResponse {
        return response()
            ->file(storage_path('app/public/pictures/ujun.png'));
    }

    public function responseDownload(): BinaryFileResponse {
        $sysfile = Storage::disk('public');
        $toPathFile = $sysfile->path("pictures/ujun.png");

        return response()
            ->download($toPathFile, "ujun.png");
    }
}
