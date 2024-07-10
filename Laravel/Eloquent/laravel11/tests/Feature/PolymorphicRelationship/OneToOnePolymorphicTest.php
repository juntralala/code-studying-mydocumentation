<?php

namespace Tests\Feature\PolymorphicRelationship;

use App\Models\Customer;
use App\Models\Image;
use App\Models\Product;
use Database\Seeders\CategorySeeder;
use Database\Seeders\CustomerSeeder;
use Database\Seeders\ImageSeeder;
use Database\Seeders\ProductSeeder;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use PHPUnit\Framework\Attributes\TestDox;
use Tests\TestCase;

class OneToOnePolymorphicTest extends TestCase
{
    #[TestDox('make one to one polymorphic relation from images to customers')]
    public function testOneToOnePolymorphicCustomer(): void
    {
        $this->seed([
            CustomerSeeder::class,
            ImageSeeder::class
        ]);
        
        $customer = Customer::find('UJUN');
        self::assertNotNull($customer);
        
        $image = $customer->image;
        self::assertNotNull($image);
        self::assertEquals('https://www.ujun.com/images/gambar1.jpg' ,$image->url);
    }
    
    #[TestDox('make one to one polymorphic relation from images to products')]
    public function testOneToOnePolymorphicProduct(): void
    {
        $this->seed([
            CategorySeeder::class,
            ProductSeeder::class,
            ImageSeeder::class
        ]);
        
        $product = Product::find('1');
        self::assertNotNull($product);

        $image = $product->image;
        self::assertNotNull($image);
        self::assertEquals('https://www.ujun.com/images/gambar2.jpg' ,$image->url);
    }

    public function testOneToOnePolymorphicImage(){
        $this->seed([
            CustomerSeeder::class,
            CategorySeeder::class,
            ProductSeeder::class,
            ImageSeeder::class
        ]);

        $imageCustomer = Image::where('imageable_id', 'UJUN')->first();
        self::assertNotNull($imageCustomer);
        $customer = $imageCustomer->imageable; // <<---
        self::assertNotNull($customer);
        self::assertEquals("Ujun", $customer->name);
        
        $imageProduct = Image::where('imageable_id', '1')->first();
        self::assertNotNull($imageProduct);
        $product = $imageProduct->imageable; // <<---
        self::assertNotNull($product);
        self::assertEquals("Product 1", $product->name);
    }
}
