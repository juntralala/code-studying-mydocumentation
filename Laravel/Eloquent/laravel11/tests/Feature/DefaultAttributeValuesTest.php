<?php

namespace Tests\Feature;

use App\Models\Comment;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use PHPUnit\Framework\Attributes\TestDox;
use Tests\TestCase;

class DefaultAttributeValuesTest extends TestCase
{
    public function setUp(): void
    {
        parent::setUp();
        Comment::query()->delete();
    }

    #[TestDox('contoh kode untuk Default Attribute Value dengan cara mengoverride $attributes pada model yg kita buat')]
    public function testDefaultAttributeValues(): void
    {
        $comment = new Comment();
        $comment->email = "ujun@ujun.com";
        $comment->save();

        $this->assertEquals('default title', $comment->title);
        $this->assertNotNull('default comment', $comment->comment);
    }
}
