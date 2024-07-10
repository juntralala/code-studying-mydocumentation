<?php

namespace Tests\Feature;

use App\Models\Comment;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use PHPUnit\Framework\Attributes\TestDox;
use Tests\TestCase;

class CommentTest extends TestCase
{
    public function setUp(): void
    {
        parent::setUp();
        Comment::query()->delete();
    }

    #[TestDox('contoh kode untuk properti $timstamps yg berasal dari model')]
    public function testCreateComment(): void
    {
        $comment = new Comment();
        $comment->email = "ujun@ujun.com";
        $comment->title = "ujun bermain";
        $comment->comment = "ujun bermain di nebula";
        $comment->save();

        $this->assertNotNull($comment->created_at);
        $this->assertNotNull($comment->updated_at);
    }
}
