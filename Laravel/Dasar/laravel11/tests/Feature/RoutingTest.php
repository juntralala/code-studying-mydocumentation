<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class RoutingTest extends TestCase
{
    public function testRoutingTest(): void {
        $this->get('/ujun')
            ->assertStatus(200)
            ->assertSeeText('Hello UJUN-Al-Rantaui');
    }

    public function testRedirect(): void {
        $this->get('/youtube')
            ->assertRedirect('/ujun');
    }

    public function testFallback(): void {
        $this->get('/NotFoundPath')
            ->assertSeeText("404 by UJUN-Al-Rantaui");
    }

    public function testRouteParameter(): void {
        $this->get("/products/12244")
                ->assertSeeText("Product : 12244");

        $this->get("/products/12244/items/A001")
                ->assertSeeText("Product : 12244 , Item : A001");
    }

    public function testRouteParameterRegex(): void {
        $this->get("/categories/221023")
                ->assertSeeText("Category : 221023");

        $this->get("/categories/ujun")
                ->assertSeeText("404 by UJUN-Al-Rantaui");

        $this->get("/categories/122445/status/active")
                ->assertSeeText("Category : 122445 , Status : active");
    }

    public function testRoutingOptionalParameter(): void {
        $this->get("/users/ujun")
                ->assertSeeText("User : ujun");
                
        $this->get("/users")
                ->assertSeeText("User : 404");
    }

    public function testRouteConflict(): void {
        $this->get("/conflict/ozon")
                ->assertSeeText("Conflict : ozon");

        $this->get("/conflict/ujun")
                ->assertSeeText("Conflict : ujun"); // seharusnya outputnya "Conflict : Muhammad Junaidi" kalau tidak ada Route Conflict
    }

    public function testNamedRoute(): void {
        $this->get("/produk/12345678")
                ->assertSeeText("Link http://localhost/products/12345678");
        
        $this->get("/produk-redirect/12345678")
                ->assertRedirect("/products/12345678");
    }
}
