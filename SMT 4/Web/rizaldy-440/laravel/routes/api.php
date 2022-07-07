<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\Api\AuthController;
use App\Http\Controllers\Api\ArtikelController;
use App\Http\Controllers\AdminController;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});

Route::prefix('v1')->group(function () {
    Route::prefix('auth')->group(function () {
        Route::post('register', [AuthController::class, 'register']);
        Route::post('login', [AuthController::class, 'login']);
        Route::post('logout', [AuthController::class, 'logout']);
        Route::post('refresh', [AuthController::class                   , 'refresh']);
        Route::get('me', [AuthController::class, 'me']);
    });

    Route::middleware('jwt.verify')->group(function(){
        Route::apiResource('artikels',ArtikelController::class,[
            'as'=>'api'
        ]);
        Route::get('/admin', [AdminController::class, 'indexadmin'])->name('admin');
    });
});

Route::any('{any}', function () {
    return response()->json(['error' => 'Not Found'], 404);
})->where('any', '.*');


