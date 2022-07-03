<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use App\Models\Identity;

class IdentitySeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        $a = Identity::create([
            'id'=>1,
            'tel'=>'08123456789',
            'city'=>'Jakarta',
            'province'=>'DKI Jakarta',
            'created_at'=>'2020-06-20 11:55:31',
            'updated_at'=>'2020-06-20 11:55:31',
            'author_id'=>1
        ]);
    }
}
