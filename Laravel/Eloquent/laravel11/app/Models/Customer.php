<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsToMany;
use Illuminate\Database\Eloquent\Relations\HasMany;
use Illuminate\Database\Eloquent\Relations\HasOne;
use Illuminate\Database\Eloquent\Relations\HasOneThrough;
use Illuminate\Database\Eloquent\Relations\MorphOne;
use Illuminate\Support\Facades\Date;

class Customer extends Model
{

    protected $table = 'customers';
    protected $primaryKey = 'id';
    protected $keyType = 'string';
    public $incrementing = false;
    public $timestamps = false;

    protected $with = ['wallet'];

    public function wallet(): HasOne
    {
        return $this->hasOne(Wallet::class, "customer_id", "id");
    }

    public function vitualAcount(): HasOneThrough
    {
        return $this->hasOneThrough(VirtualAcount::class, Wallet::class, 
            'customer_id',  // FK on wallets table
            'wallet_id',  // FK on virtual_acounts table
            'id', // PK on cuctomers
            'id' // PK on wallets
        );
    }

    public function reviews(): HasMany
    {
        return $this->hasMany(Review::class, 'customer_id', 'id');
    }

    public function likeProducts(): BelongsToMany
    {
        // kedua kolom ini dari table customers_likes_products
        // kolom pertama untuk table dari model saat ini
        // kolom kedua untuk table relasi
        return $this->belongsToMany(Product::class, 'customers_likes_products', 'customer_id', 'product_id')
            ->withPivot('created_at')
            ->using(Like::class); 
    }

    public function likeProductsLastWeek(): BelongsToMany
    {
        return $this->belongsToMany(Product::class, 'customers_likes_products', 'customer_id', 'product_id')
            ->withPivot('created_at')
            ->wherePivot('created_at', '>=', Date::now()->addDays(-7))
            ->using(Like::class); // <- setelah kita menggunakan Pivot class nya maka kembliannya bukan lagi array
    }

    public function image(): MorphOne
    {
        return $this->morphOne(Image::class, 'imageable');
    }
}
