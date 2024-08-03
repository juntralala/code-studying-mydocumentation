<?php

namespace App\Http\Resources;

use Illuminate\Http\Request;
use Illuminate\Http\Resources\Json\JsonResource;

class ProductDebugResource extends JsonResource
{
    public $additional = [
        'author' => 'juntralala'
    ];
    /**
     * Transform the resource into an array.
     *
     * @return array<string, mixed>
     */
    public function toArray(Request $request): array
    {
        return [
            'app' => 'Belajar Eloquent API Resource',
            'server_time' => now()->toDateTimeString(),
            'data' => [
                'id' => $this->id,
                'name' => $this->name,
                'price' => $this->price,
            ]
        ];
    }
}
