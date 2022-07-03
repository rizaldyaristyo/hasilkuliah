<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Identity extends Model
{
    use HasFactory;
    protected $table = 'identity';
    protected $guarded = [];
    public function author()
    {
        return $this->belongsTo(Author::class);
    }
}
