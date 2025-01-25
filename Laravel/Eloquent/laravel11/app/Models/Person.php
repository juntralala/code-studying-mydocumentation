<?php

namespace App\Models;

use App\Casts\AsAddress;
use Illuminate\Database\Eloquent\Casts\Attribute;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Person extends Model
{
    protected $table = 'people';
    protected $primaryKey = 'id';
    protected $keyType = 'int';
    public $incrementing = true;
    public $timestamps = true;

    public $casts = [ 
        'address' => AsAddress::class,
        'created_at' => 'string', // defaultnya datetime dengan class Carbon::class
        'updated_at' => 'string'
    ];

    protected function fullName(): Attribute
    {
        return Attribute::make(
            get: fn() => $this->full_name,
            set: fn($value)=> ['full_name' => $value]
        );
    }

    // function ini akan dipanggil ketika menge set atau get property first_name dan last_name
    protected function firstName(): Attribute
    {
        return Attribute::make(
            get: fn($value, $attributes) => mb_strtoupper($value),
            set: fn($value, $attributes) => ['first_name' => mb_strtoupper($value)]
        );
    }
}
