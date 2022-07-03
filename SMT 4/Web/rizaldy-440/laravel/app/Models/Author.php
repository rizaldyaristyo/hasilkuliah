<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Author extends Model
{
    use HasFactory;
    protected $table = 'author_';
    protected $guarded = [];
    public function artikel()
    {
        return $this->hasMany(Artikel::class);
    }
    public function identity()
    {
        return $this->hasOne(Identity::class);
    }
    public function category()
    {
        return $this->hasMany(Category::class);
    }
}
