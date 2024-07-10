<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Relations\BelongsTo;
use Illuminate\Database\Eloquent\Relations\Pivot;

class Like extends Pivot
{
    protected $table = 'customers_likes_products';
    protected $foreignKey = 'customer_id';
    protected $relatedKey = 'product_id';
    public $timestamps = false; // <- ini tidak berfungsi meski telah kita atur menjadi false, karena jika ngedetek ada kolom created_at maka otomatis $timestamps = true 

    protected static $ignoreTimestampsOn = [Like::class]; // <- untuk menonaktifkan $timestamps
    // public function usesTimestamps(): bool
    // {
    //     return false;
    // }

    public function customer(): BelongsTo
    {
        return $this->belongsTo(Customer::class, 'customer_id', 'id');
    }

    public function product(): BelongsTo
    {
        return $this->belongsTo(Product::class, 'product_id', 'id');
    }
}
