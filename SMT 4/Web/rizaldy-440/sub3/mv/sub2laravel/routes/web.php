<?php

use Illuminate\Support\Facades\Route;
use \App\Http\Controllers\AdminController;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/



Route::get('/', [AdminController::class, 'index'])->name('index');

Route::get('/admin', [AdminController::class, 'indexadmin'])->name('admin');

Route::get('/profile', function () {
    return view('profile');
});

Route::get('/calc', function () {
    return view('calc');
});

Route::get('/watchlist', function () {
    return view('watchlist');
});

Route::get('/1', function () {
    return view('1');
});

Route::get('/2', function () {
    return view('2');
});
