<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Support\Facades\Storage;
use Tests\TestCase;

class FileStorageTest extends TestCase
{
    
    public function testStorage(): void
    {
        $filesystem = Storage::disk('local');

        $filesystem->put('file.txt', "Muhammad Junaidi");

        $content = $filesystem->get('file.txt');

        self::assertEquals('Muhammad Junaidi', $content);
    }

    public function testPublic(): void
    {
        $filesystem = Storage::disk('public');

        $filesystem->put('file.txt', "Muhammad Junaidi");

        $content = $filesystem->get('file.txt');

        self::assertEquals('Muhammad Junaidi', $content);
    }
    
}
