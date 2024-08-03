<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Casts\Attribute;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;
use Illuminate\Support\Str;

/**
 * @property integer $id
 * @property string $street
 * @property string $city
 * @property string $province
 * @property string $country
 * @property string $postalCode
 * @property integer $contactId
 * @property Contact $contact
 */
class Address extends Model
{
    protected $table = 'addresses';
    protected $primaryKey = 'id';
    protected $keyType = 'int';
    public $incrementing = true;
    public $timestamps = true;
    public $fillable = [
        'street',
        'city',
        'province',
        'country',
        'postalCode',
        'contactId'
    ];

    public function contact(): BelongsTo
    {
        return $this->belongsTo(Contact::class, 'contact_id', 'id');
    }

    public function postalCode(): Attribute
    {
        return Attribute::make(
            get: fn($value, $attributes) => $attributes['postal_code'],
            set: fn($value, $attributes) => ['postal_code' => $value],
        );
    }

    public function contactId(): Attribute
    {
        return Attribute::make(
            get: fn($value, $attributes) => $attributes['contact_id'],
            set: fn($value, $attributes) => ['contact_id' => $value],
        );
    }
}
