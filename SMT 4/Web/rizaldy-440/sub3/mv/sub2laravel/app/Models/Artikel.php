<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Artikel extends Model
{
    use HasFactory;
    protected $guarded = [];
    public function author()
    {
        return $this->belongsToMany(Author::class);
    }
    public function category()
    {
        return $this->belongsToMany(Category::class);
    }
}
