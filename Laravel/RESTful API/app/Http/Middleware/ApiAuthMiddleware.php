<?php

namespace App\Http\Middleware;

use App\Models\User;
use Closure;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Symfony\Component\HttpFoundation\Response;

class ApiAuthMiddleware
{
    /**
     * Handle an incoming request.
     *
     * @param  \Closure(\Illuminate\Http\Request): (\Symfony\Component\HttpFoundation\Response)  $next
     */
    public function handle(Request $request, Closure $next): Response
    {
        $token = $request->header('Authorization');
        $authenticate = true;

        if (blank($token)) {
            $authenticate = false;
        }

        $user = User::where('token', $token)->first();
        if (blank($user)) {
            $authenticate = false;
        }

        if (!is_null($user))
            Auth::login($user);

        if ($authenticate) {
            return $next($request);
        } else {
            return \Illuminate\Support\Facades\Response::json([
                'errors' => [
                    'message' => ['unauthorized']
                ]
            ], 401);
        }
    }
}
