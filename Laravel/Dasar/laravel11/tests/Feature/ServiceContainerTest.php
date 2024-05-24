<?php

namespace Tests\Feature;

use App\Data\Bar;
use App\Data\Foo;
use App\Data\Orang;
use App\Services\HelloService;
use App\Services\HelloServiceIndonesia;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class ServiceContainerTest extends TestCase
{
    // public function testDependency(): void {
    //     $foo1 = $this->app->make(Foo::class);
    //     $foo2 = $this->app->make(Foo::class);

    //     self::assertEquals("Foo", $foo1->foo());
    //     self::assertEquals("Foo", $foo2->foo());
    //     self::assertNotSame($foo1, $foo2);
    // }

    public function testBind(): void {
        $this->app->bind(Orang::class, function() {
            return new Orang("Muhammad", "Junaidi");
        });

        $orang1 = $this->app->make(Orang::class); // closure() // return new Orang("Muhammad", "Junaidi")
        $orang2 = $this->app->make(Orang::class); // closure() // return new Orang("Muhammad", "Junaidi")

        self::assertEquals('Muhammad', $orang1->firstName);
        self::assertEquals('Muhammad', $orang2->firstName);
        self::assertNotSame($orang1, $orang2);
    }

    public function testSingleton(): void {
        $this->app->singleton(Orang::class, function() {
            return new Orang("Muhammad", "Junaidi");
        });

        $orang1 = $this->app->make(Orang::class); // return new Orang("Muhammad", "Junaidi"); if not exists
        $orang2 = $this->app->make(Orang::class); // return existing

        self::assertEquals('Muhammad', $orang1->firstName);
        self::assertEquals('Muhammad', $orang2->firstName);
        self::assertSame($orang1, $orang2);
    }

    public function testInstance(): void {
        $orang = new Orang("Muhammad", "Junaidi");
        $this->app->instance(Orang::class, $orang);

        $orang1 = $this->app->make(Orang::class); // return new Orang("Muhammad", "Junaidi"); if not exists
        $orang2 = $this->app->make(Orang::class); // return existing

        self::assertEquals('Muhammad', $orang1->firstName);
        self::assertEquals('Muhammad', $orang2->firstName);
        self::assertSame($orang, $orang1);
        self::assertSame($orang1, $orang2);
    }
    
    // public function testDependencyInjection(): void {
    //     $foo = $this->app->make(Foo::class);
    //     $bar = $this->app->make(Bar::class);

    //     self::assertNotSame($foo, $bar->foo);
    // }

    public function testDependencyInjectionSingleton(): void {
        $this->app->singleton(Foo::class, function() {
            return new Foo();
        });
        
        $foo = $this->app->make(Foo::class);
        $bar = $this->app->make(Bar::class);

        self::assertSame($foo, $bar->foo);
    }

    // penjelasan ada di : ./../Service Container/Dependency Injection Di Closure.txt 
    public function testDependencyInjectionDiClosure(): void {
        $this->app->singleton(Foo::class, function() {
            return new Foo();
        });
        $this->app->singleton(Bar::class, function($app){
            return $app->make(Foo::class);
        });
        
        $bar1 = $this->app->make(Bar::class);
        $bar2 = $this->app->make(Bar::class);

        self::assertSame($bar1, $bar2);
    } 

    public function testBindInterfaceToClass(): void {
        // $this->app->bind(HelloService::class, HelloServiceIndonesia::class);
        $this->app->bind(HelloService::class, function(){
            return new HelloServiceIndonesia();
        });

        $helloService = $this->app->make(HelloService::class);

        self::assertEquals("Halo ujun", $helloService->hello("ujun"));
    }

    
}
