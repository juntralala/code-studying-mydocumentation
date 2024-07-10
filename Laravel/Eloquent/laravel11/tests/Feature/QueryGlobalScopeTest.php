<?php

namespace Tests\Feature;

use App\Models\Category;
use App\Models\Scopes\IsActiveScope;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use PHPUnit\Event\Code\TestDox;
use Tests\TestCase;

class QueryGlobalScopeTest extends TestCase
{
    public function testQueryGlobalScope(): void
    {
        $category = new Category();
        $category->id = "FOOD";
        $category->name = "Food";
        $category->description = "Food Category";
        $category->is_active = false;
        $category->save();

        $resultCategory = Category::find("FOOD");
        self::assertNull($resultCategory);
    }

    #[TestDox("Mematikan Global Scope")]
    public function testDisableQueryGlobalScope(): void
    {
        $category = new Category();
        $category->id = "FOOD";
        $category->name = "Food";
        $category->description = "Food Category";
        $category->is_active = false;
        $category->save();

        // mematikan Global Scope
        $resultCategory = Category::withoutGlobalScopes([
            IsActiveScope::class
        ])->find("FOOD");
        self::assertNotNull($resultCategory);
    }
}
