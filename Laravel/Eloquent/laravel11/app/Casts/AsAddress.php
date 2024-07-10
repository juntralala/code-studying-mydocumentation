<?php

namespace App\Casts;

use App\Data\Address;
use Illuminate\Contracts\Database\Eloquent\CastsAttributes;
use Illuminate\Database\Eloquent\Model;

class AsAddress implements CastsAttributes
{
    /**
     * Cast the given value.
     *
     * @param  array<string, mixed>  $attributes
     */
    public function get(Model $model, string $key, mixed $value, array $attributes): mixed
    {
        if(is_null($value)) return null;
        $addresses = mb_split(', ', $value);
        return new Address($addresses[0], $addresses[1], $addresses[2], $addresses[3]);
    }

    /**
     * Prepare the given value for storage.
     * 
     * @param Address
     * @param array<string, mixed>  $attributes
     */
    public function set(Model $model, string $key, mixed $value, array $attributes): mixed
    {
        if(is_null($value)) return null;
        return "$value->street, $value->city, $value->country, $value->postalCode";
    }
}
