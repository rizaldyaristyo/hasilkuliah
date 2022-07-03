<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use App\Models\Artikel;

class ArtikelSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        $a = Artikel::create([
            'id'=>1,
            'image'=>'https://picsum.photos/200/300',
            'judul'=>'Judul 1',
            'isi_konten'=>'Isi Konten 1',
            'created_at'=>'2020-06-20 11:55:31',
            'updated_at'=>'2020-06-20 11:55:31',
            'author_id'=>1,
            'category_id'=>1    
        ]);
    }
}
