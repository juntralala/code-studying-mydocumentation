<?php

namespace Tests\Feature;

use App\Data\Bar;
use App\Data\Foo;
use App\Services\HelloService;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class FooBarServiceProviderTest extends TestCase
{
    public function testServiceProvider(): void
    {
        $foo1 = $this->app->make(Foo::class);
        $foo2 = $this->app->make(Foo::class);
        
        self::assertSame($foo1, $foo2);

        $bar1 = $this->app->make(Bar::class);
        $bar2 = $this->app->make(Bar::class);

        self::assertSame($bar1, $bar2);
        self::assertSame($bar1->foo, $foo1);
    }

    public function testPropertySingletons(): void {
        $helloService = $this->app->make(HelloService::class);

        self::assertEquals("Halo ujun", $helloService->hello("ujun"));
    }

    public function testEmpty(): void {
        self::assertTrue(True);
    }
}
