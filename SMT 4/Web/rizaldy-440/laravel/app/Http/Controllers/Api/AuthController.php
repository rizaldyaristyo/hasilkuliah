<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Validator;
use Illuminate\Support\Facades\Http;
use Illuminate\Support\Facades\DB;

class AuthController extends Controller
{
    public function __construct(){
        $this->middleware('jwt.verify', ['except' => ['login', 'register']]);
    }

    public function login(){
        $credentials = request(['email', 'password']);

        if (!$token = auth()->attempt($credentials)) {
            //return response()->json(['error' => 'Unauthorized'], 401);
            return redirect('/login/login-failed');
        }
        \setcookie('token', $token, time() + (86400 * 30), "/");
        return $this->respondWithToken($token);
        //return redirect('/api/v1/admin');
    }
    

    public function me(){
        return response()->json(auth()->user());
    }

    public function logout(){
        auth()->logout();
        \setcookie('token', "", time() - 3600, "/");
        // return response()->json(['message' => 'Successfully logged out']);
        //return view('index');
        return redirect('/login');
    }

    public function refresh(){
        return $this->respondWithToken(auth()->refresh());
    }

    protected function respondWithToken($token){
        return response()->json([
            'access_token' => $token,
            'token_type' => 'bearer',
            'expires_in' => auth()->factory()->getTTL() * 60
        ]);
    }
    
    public function register(Request $request)
    {
        $validator = Validator::make($request->all(), [
            'name' => 'required|string|max:255',
            'email' => 'required|string|email|max:255|unique:users',
            'password' => 'required|string|min:6|confirmed',
        ]);
        if($validator->fails()){
            //return response()->json(['error' => $validator->errors()], 401);
            return redirect('/login/register-failed');
        }

        $user = User::create([
            'name' => $request->name,
            'email' => $request->email,
            'password' => Hash::make($request->password),
        ]);

        // return response()->json([
        //     'message' => 'Successfully created user!',
        //     'user' => $user
        // ]);
        return redirect('/login/register-success');
    }
}
