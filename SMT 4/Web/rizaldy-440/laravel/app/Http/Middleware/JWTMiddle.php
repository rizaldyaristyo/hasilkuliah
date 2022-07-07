<?php

namespace App\Http\Middleware;

use Closure;
use Illuminate\Http\Request;
use Tymon\JWTAuth\Exceptions\TokenBlacklistedException;
use Tymon\JWTAuth\Exceptions\TokenExpiredException;
use Tymon\JWTAuth\Exceptions\TokenInvalidException;
use Tymon\JWTAuth\Facades\JWTAuth;
use Illuminate\Support\Facades\DB;

class JWTMiddle
{
    /**
     * Handle an incoming request.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \Closure(\Illuminate\Http\Request): (\Illuminate\Http\Response|\Illuminate\Http\RedirectResponse)  $next
     * @return \Illuminate\Http\Response|\Illuminate\Http\RedirectResponse
     */
    public function handle(Request $request, Closure $next)
    {
        if (isset($_COOKIE['token'])) {
            try{
                $user = JWTAuth::parseToken()->authenticate();
            }catch(TokenExpiredException $e){
                return redirect('/login?tokenexpired');
            }catch(TokenInvalidException $e){
                return redirect('/login?tokeninvalid');
            }catch(TokenBlacklistedException $e){
                return redirect('/login?tokenblacklisted');
            }catch(\Exception $e){
                return redirect('/login?unknown');
            }
            return $next($request);
        } else {
            return redirect('/login?notoken');
        }
    }
}
