<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class FilterRequestInputController extends Controller
{
    public function filterOnly(Request $request): string {
        $name = $request->only(['name.first', 'name.last']);

        return json_encode($name);
    }

    public function filterExcept(Request $request): string {
        $user = $request->except(['admin']);

        return json_encode($user);
    }

    public function mergeInput(Request $request): string {
        $request->merge(['admin' => false]);
        $user = $request->input();
        return json_encode($user);
    }
}
