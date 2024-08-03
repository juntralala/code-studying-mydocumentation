<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Casts\Attribute;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;
use Illuminate\Database\Eloquent\Relations\HasMany;


/**
 * @property integer $id
 * @property string $fullName
 * @property string $firstName
 * @property string $lastName
 * @property string $email
 * @property string $phone
 * @property integer $userId
 * @property User $user
 * @property \Illuminate\Database\Eloquent\Collection<integer, Address> $addresses
 */
class Contact extends Model
{
    protected $table = 'contacts';
    protected $primaryKey = 'id';
    protected $keyType = 'int';
    public $incrementing = true;
    public $timestamps = true;
    protected $hidden = [
        'first_name',
        'last_name',
        'user_id'
    ];
    protected $appends = [
        'firstName',
        'lastName'
    ];
    public $fillable = [
        'firstName',
        'lastName',
        'email',
        'phone'
    ];

    public function user(): BelongsTo
    {
        return $this->belongsTo(User::class, 'user_id', 'id');
    }

    public function addresses(): HasMany
    {
        return $this->hasMany(Address::class, 'contact_id', 'id');
    }

    public function firstName(): Attribute
    {
        return Attribute::make(
            get: fn($value, $attributes) => $attributes['first_name'],
            set: fn($firstName) => ['first_name' => $firstName]
        );
    }

    public function lastName(): Attribute
    {
        return Attribute::make(
            get: fn($value, $attributes) => $attributes['last_name'],
            set: fn($lastName) => ['last_name' => $lastName]
        );
    }

    public function userId(): Attribute
    {
        return Attribute::make(
            get: fn($user_id, $attributes) => $user_id,
            set: fn($userId) => ['user_id' => $userId]
        );
    }

    public function fullName(): Attribute
    {
        return Attribute::make(
            get: fn($value, $attributes) => $attributes['first_name'] . ' ' . $attributes['last_name'],
            set: function ($fullName) {
                [$firstName, $lastName] = mb_split(' ', $fullName, 2);
                return ['first_name' => $firstName, 'last_name' => $lastName];
            }
        )->shouldCache();
    }
}
