<?php

namespace App\Models;

use Database\Seeders\TagSeeder;
use Illuminate\Contracts\Database\Query\Builder;
use Illuminate\Database\Eloquent\Concerns\HasUuids;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\MorphMany;
use Illuminate\Database\Eloquent\Relations\MorphToMany;
use Illuminate\Database\Eloquent\SoftDeletes;

class Voucher extends Model
{
    use HasFactory;
    use HasUuids; // <- dengan ini secara otomatis uuid nya akan di generate secara otomatis
    use SoftDeletes;

    protected $table = "vouchers";
    protected $primaryKey = "id";
    protected $keyType = 'string';
    public $incrementing = false; // karna primarykey nya tidak lagi auto_increment
    public $timestamps = false;  // <- karna kita tidak membuat 2 kolom : created_at dan updated_at

    public function uniqueIds(): array
    {
        return [$this->primaryKey, 'voucher_code'];
    }

    public function scopeIsActive(Builder $builder): void {
        $builder->where('is_active', '=', '1');
    }

    public function scopeIsNonActive(Builder $builder): void {
        $builder->where('is_active', '=', 'false');
    }

    public function comments(): MorphMany
    {                         //relatedModel  , namaRelasi
        return $this->morphMany(Comment::class, 'commentable');
    }

    public function tags(): MorphToMany
    {
        return $this->morphToMany(Tag::class, 'taggable'); 
    }
}
