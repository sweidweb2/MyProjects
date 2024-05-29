<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Category extends Model
{
    use HasFactory;
    protected $fillable=[
        'name',
        'store_id'
    ];


    public function getStore(){
        return $this->belongsTo(Store::class,'store_id','id');

    }
    public function getProducts(){
        return $this->hasMany(Product::class);
    }
}
