<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\MorphTo;

class Comment extends Model
{
    use HasFactory;
    protected $table = "comments";
    protected $primaryKey = "id";
    protected $keyType = "int";
    public $incrementing = true;
    public $timestamps = true; 

    protected $attributes = [
        'title' => 'default title',
        'comment' => 'default comment'
    ];

    public function commentable(): MorphTo
    {
        return $this->morphTo();
    } 
}
