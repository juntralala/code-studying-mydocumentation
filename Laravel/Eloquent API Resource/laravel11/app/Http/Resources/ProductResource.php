<?php

namespace App\Http\Resources;

use Illuminate\Http\Request;
use Illuminate\Http\Resources\Json\JsonResource;

class ProductResource extends JsonResource
{

    public static $wrap = 'value';

    /**
     * Transform the resource into an array.
     *
     * @return array<string, mixed>
     */
    public function toArray(Request $request): array
    {
        return [
            'value' => [
                'id' => $this->id,
                'name' => $this->name,
                'category' => new CategorySimpleResource($this->whenLoaded('category')),
                'price' => $this->price,
                'is_expensive' => $this->when($this->price > 1000, true, false), // <- atribute ini akan hilang, jika kondisi false kalau nilai default tidak di tentukan, 
                'created_at' => $this->created_at,
                'updated_at' => $this->updated_at,
            ]
        ];
    }
}
