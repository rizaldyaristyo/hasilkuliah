<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use App\Models\Category;

class CategorySeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        $a = Category::create([
            'id'=>1,
            'categories'=>'Kategori 1',
            'created_at'=>'2020-06-20 11:55:31',
            'updated_at'=>'2020-06-20 11:55:31',
            'author_id'=>1
        ]);
    }
}
