<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Http\Resources\ArtikelResource;
use App\Models\Artikel;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Validator;
use Tymon\JWTAuth\Facades\JWTAuth;

class ArtikelController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $artikel = Artikel::all();
        return response([
            'total'=>$artikel->count(),
            'message'=>'success',
            'data'=>ArtikelResource::collection($artikel)
        ],200);
    }

    /**
     * Store a newly c reated resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        
        if(JWTAuth::parseToken()->authenticate()->id !=1){
            $validator = Validator::make($request->all(), [
                'judul' => 'required|string|max:255',
                'isi_konten' => 'required|string|max:255',
                'author_id' => 'required|integer',
                'category_id' => 'required|integer',
                'image' => 'required|string|max:255',
            ]);
            if ($validator->fails()) {
                return response()->json([
                    'error' => $validator->errors(),
                    'status' => 'Validation Error'
                ], 401);
            }
            $artikel = Artikel::create($request->all());
            return response([
                'data'=>new ArtikelResource($artikel),
                'message'=>'Artikel has been created!'
            ],200);
        }
        return response([
            'message'=>'You are not authorized to add data!'
        ],401);
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        $artikel = Artikel::find($id);
        if ($artikel != null) {
            return response([
                'data'=>new ArtikelResource($artikel),
                'message'=>'Artikel has been found!'
            ],200);
        } else {
            return response([
                'message'=>'Artikel not found!'
            ],404);
        }
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        if(JWTAuth::parseToken()->authenticate()->id !=1){
            $validator = Validator::make($request->all(), [
                'judul' => 'required|string|max:255',
                'isi_konten' => 'required|string|max:255',
                'author_id' => 'required|integer',
                'category_id' => 'required|integer',
                'image' => 'required|string|max:255',
            ]);
            if ($validator->fails()) {
                return response()->json([
                    'error' => $validator->errors(),
                    'status' => 'Validation Error'
                ], 401);
            }
            $artikel = Artikel::find($id);
            if ($artikel != null) {
                $artikel->update($request->all());
                return response([
                    'data'=>new ArtikelResource($artikel),
                    'message'=>'Artikel has been updated!'
                ],200);
            } else {
                return response([
                    'message'=>'Artikel not found!'
                ],404);
            }
        }
        return response([
            'message'=>'You are not authorized to update this data!'
        ],401);
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {

        if(JWTAuth::parseToken()->authenticate()->id !=1){
            $artikel = Artikel::find($id);
            if ($artikel != null) {
                $artikel->delete();
                return response([
                    'message'=>'Artikel '.$id.' has been deleted!'
                ],200);
            } else {
                return response([
                    'message'=>'Artikel '.$id.' not found!'
                ],404);
            }
        }
        return response([
            'message'=>'You are not authorized to destroy this data!'
        ],401);
    }
}
