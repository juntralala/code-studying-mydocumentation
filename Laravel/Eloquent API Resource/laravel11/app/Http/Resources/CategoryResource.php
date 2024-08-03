<?php

namespace App\Http\Resources;

use Illuminate\Http\Request;
use Illuminate\Http\Resources\Json\JsonResource;

class CategoryResource extends JsonResource
{
    /**
     * wrap json with
     * @var string
     */
    public static $wrap = 'category';
    // public static $collectionWrap = 'categories'; // baca fungsi yg dikomentari di class sini

    /**
     * Transform the resource into an array.
     *
     * @return array<string, mixed>
     */
    public function toArray(Request $request): array
    {
        return [
             'id' => $this->id,
             'name' => $this->name,
             'created_at' => $this->created_at,
             'updated_at' => $this->updated_at,
        ];
    }

    // cara mengganti wrap dari hasil CategoryCollection::collection()
    // public static function collection($collection)
    // {
    //     $collection = parent::collection($collection);
    //     $collection::wrap(self::$collectionWrap);
    //     return $collection;
    // }
}
