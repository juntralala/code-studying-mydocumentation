<?php

namespace Tests\Feature;

use App\Data\Orang;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Support\Collection;
use PHPUnit\Framework\Attributes\Depends;
use PHPUnit\Framework\Attributes\DoesNotPerformAssertions;
use PHPUnit\Framework\Attributes\Group;
use PHPUnit\Framework\Attributes\TestDox;
use Tests\TestCase;

class CollectionTest extends TestCase {
    public function testCreateCollection(): void {
        $collection = collect([1, 2, 3]);

        $this->assertEqualsCanonicalizing([1, 2, 3], $collection->all()); // all() untuk mengkonversikan collection ke array
    } // assertEquals() memeriksa index/key dan value sama atau tidak, sedangkan assertEqualsCanonicalizing() hanya memeriksa kesamaan valuenya saja

    public function testForeach(): void {
        $collection = collect([1, 2, 3, 4, 5]);
        foreach($collection as $key => $value){
            self::assertEquals($key + 1, $value);
        }
    }

    public function testCollectionManimpulation(): void {
        $collection = collect();
        $collection->push(1, 2, 3);
        self::assertEqualsCanonicalizing([1, 2 ,3], $collection->all());
        
        $value = $collection->pop();
        self::assertEquals(3, $value);
        self::assertEqualsCanonicalizing([1, 2], $collection->all()); 
    }

    #[Group('Mapping')]
    public function testMap(): void {
        $collection = collect([1, 2, 3, 4]);
        $mapped = $collection->map(fn($value) => $value * 2);
        
        self::assertEqualsCanonicalizing([2, 4, 6, 8], $mapped->all());
        }
        
    #[Group('Mapping')]
    public function testMapInto(): void {
        $collection = collect(['ujun', 'ozon', 'taichou']);
        $mapped = $collection->mapInto(Orang::class);
        
        $orangs = [
            new Orang('ujun'),
            new Orang('ozon'),
            new Orang('taichou')
            ];
            
            self::assertEquals($orangs, $mapped->all());
            }
            
        #[Group('Mapping')]
        public function testMapSpread(): void {
            $collection = collect([['Muhammad', 'Junaidi'], ['Abd', 'Wahid'], ['Ahmad', 'Syairoji']]);
        $mapped = $collection->mapSpread(fn($firstName, $lastName) => "$firstName $lastName");

        self::assertEquals(['Muhammad Junaidi', 'Abd Wahid', 'Ahmad Syairoji'], $mapped->all());
        }
        
    #[Group('Mapping')]
    public function testMapToGroups(): void {
        $collection = collect([
            [
                'name' => "ujun",
                'departement' => "IT"
            ],
            [
                'name' => "junaidi",
                'departement' => "IT"
            ],
            [
                'name' => "ozon",
                'departement' => "HR"
            ]
        ]);

        $mapped = $collection->mapToGroups(function($person) {
            return [$person['departement'] => $person['name']];
        });

        self::assertEquals([
            'IT' => collect(['ujun', 'junaidi']),
            'HR' => collect(['ozon'])
        ], $mapped->all());
    }

    #[Group('Zipping')]
    public function testZip(): void {
        $collection1 = collect([1, 2, 3]);
        $collection2 = collect([4, 5, 6]);
        $zipped = $collection1->zip($collection2);
        
        self::assertEquals([
            collect([1,4]),
            collect([2,5]),
            collect([3,6])
        ], $zipped->all());
    }
            
    #[Group('Zipping')]
    public function testConcat(): void {   
        $collection1 = collect([1, 2, 3]);
        $collection2 = collect([4, 5, 6]);
        $concated = $collection1->concat($collection2);
        
        self::assertEquals([1, 2, 3, 4, 5, 6], $concated->all());
    }
                
    #[Group('Zipping')]
    public function testCombine(): void {   
        $collection1 = collect(['name', 'country']);
        $collection2 = collect(['ujun', 'Indonesia']);
        $combined = $collection1->combine($collection2);

        self::assertEquals(['name' => 'ujun', 'country' => 'Indonesia'], $combined->all());
    }

    #[Group('Flatting')]
    public function testCollapse(): void {
        $collection = collect([
            [1, 2, 3],
            [4, 5, 6],
            [7, 8, 9]
        ]);
        $collapsed = $collection->collapse();

        self::assertEquals([1,2,3,4,5,6,7,8,9], $collapsed->all());
    }

    #[Group('Flatting')]
    public function testFlatMap(): void {
        $collection = collect([
            [
                'name' => 'ujun', 
                'hobbies' => ['Coding', 'Gaming']
            ],
            [
                'name' => 'ozon', 
                'hobbies' => ['Makan', 'Rebahan']
            ]
        ]);
        $flatMap = $collection->flatMap(fn($datas)=> $datas['hobbies']); 

        self::assertEqualsCanonicalizing(['Coding', 'Gaming', 'Makan', 'Rebahan'], $flatMap->all());
    }

    #[TestDox('String Representation')]
    public function testJoin(): void { // penjelannya di 'String Representation.txt' 
        $collection = collect(['ujun', 'Muhammad', 'Junaidi']);

        self::assertEquals('ujun-Muhammad-Junaidi', $collection->join('-'));
        self::assertEquals('ujun-Muhammad_Junaidi', $collection->join('-', '_'));
        self::assertEquals('ujun Muhammad and Junaidi', $collection->join(' ', ' and '));
    }

    #[Group('Filtering')]
    public function testFilter(): void {
        $collection = collect([
            'ujun' => 100,
            'ucup' => 90,
            'udin' => 80,
        ]);
        $filtered = $collection->filter(fn($val, $key) => $val>=90);

        self::assertEquals([
            'ujun' => 100, 
            'ucup' => 90
        ], $filtered->all());
    }
    
    #[Group('Filtering')]
    public function testFilterWithIndex(){
        $collection = collect([1,2,3,4,5,6,7,8,9,10]);
        $filtered = $collection->filter(fn($value, $key)=> $value%2 === 0);

        self::assertEqualsCanonicalizing([2,4,6,8,10], $filtered->all());
    }

    public function testPartition(): void {
        $collection = collect([
            'ujun' => 100,
            'ucup' => 90,
            'udin' => 80,
        ]);
        [$result1, $result2] = $collection->partition(fn($val, $key) => $val>=90);

        self::assertEquals(['ujun' => 100, 'ucup' => 90], $result1->all());
        self::assertEquals(['udin' => 80], $result2->all());
    }

    public function testTesting() { // testing atau checking
        $collection = collect(["ujun", "Muhammad", "Junaidi"]);
        $this->assertTrue($collection->contains("Muhammad"));
        $this->assertTrue($collection->contains(fn($value, $key)=> $value === "Junaidi"));
    }

    #[Group('Grouping')]
    public function testGroupby() {
        $collection = collect([
            [
                'name' => "ujun",
                'departement' => "IT"
            ],
            [
                'name' => "Junaidi",
                'departement' => "IT"
            ],
            [
                'name' => "Ozon",
                'departement' => "HR"
            ],
        ]);
        $grouped = $collection->groupBy('departement');

        $expected =[
            'IT' => collect([
                [
                    'name' => "ujun",
                    'departement' => "IT"
                ],
                [
                    'name' => "Junaidi",
                    'departement' => "IT"
                ]
            ]),
            'HR' => collect([
                [
                'name' => "Ozon",
                'departement' => "HR"
                ]
            ])
        ];

        self::assertEquals($expected, $grouped->all());;

        return $collection;
    }

    #[Group('Grouping')]
    #[Depends('testGroupby')]
    public function testGroupbyFunctionParam(Collection $collection): void {
        $grouped = $collection->groupBy(function($value, $key) {
            return $value['departement'];
        });

        $expected =[
            'IT' => collect([
                [
                    'name' => "ujun",
                    'departement' => "IT"
                ],
                [
                    'name' => "Junaidi",
                    'departement' => "IT"
                ]
            ]),
            'HR' => collect([
                [
                'name' => "Ozon",
                'departement' => "HR"
                ]
            ])
        ];

        self::assertEquals($expected, $grouped->all());
    }

    #[TestDox('Slicing')]
    public function testSlice(): void {
        $collection = collect()->range(1, 10);
        $sliced = $collection->slice(4);
        self::assertEqualsCanonicalizing([5,6,7,8,9,10], $sliced->all()); 
        
        $sliced2 = $collection->slice(4, 2);
        self::assertEqualsCanonicalizing([5,6], $sliced2->all()); 
    }

    #[TestDox('Take & Skip')]
    public function testTake(): void {
        $collection = Collection::range(1, 10);
        $taked1 = $collection->take(3);
        self::assertEqualsCanonicalizing([1,2,3], $taked1->all());

        $taked1 = $collection->take(-3);
        self::assertEqualsCanonicalizing([8,9,10], $taked1->all());
        
        $taked2 = $collection->takeUntil(fn($value, $key)=> $value == 3);
        self::assertEqualsCanonicalizing([1,2], $taked2->all());
        
        $taked3 = $collection->takeWhile(fn($value, $key)=> $value < 3);
        self::assertEqualsCanonicalizing([1,2], $taked3->all());
    }

    #[TestDox('Slicing')]
    public function testSkip(): void {
        $collection = Collection::range(1, 10);
        $skipped = $collection->skip(5); // penggunaan angka minus tidak berpengaruh tidak seperti take
        self::assertEqualsCanonicalizing([6,7,8,9,10], $skipped->all());
        
        $skipped = $collection->skipUntil(fn($val,$key)=> $val == 5); 
        self::assertEqualsCanonicalizing([5,6,7,8,9,10], $skipped->all());
        
        $skipped = $collection->skipWhile(fn($val,$key)=> $val < 5); 
        self::assertEqualsCanonicalizing([5,6,7,8,9,10], $skipped->all());
    }

    #[Group('Chunk')]
    public function testChunk(): void {
        $collection = Collection::range(1, 10);
        $chunked = $collection->chunk(3);
        self::assertEqualsCanonicalizing([1,2,3], $chunked->get(0)->all());
        self::assertEqualsCanonicalizing([4,5,6], $chunked->get(1)->all());
        self::assertEqualsCanonicalizing([7,8,9], $chunked->get(2)->all());
        self::assertEqualsCanonicalizing([10], $chunked->get(3)->all());
    }

    #[Group('Chunk')]
    public function testChunkWhile(): void {
        $collection = collect(str_split("AAABBBCCCCD"));
        $chunked = $collection->chunkWhile(fn($val,$key,$chunk)=> $val === $chunk->last());
        self::assertEqualsCanonicalizing(['A','A','A'], $chunked->get(0)->all());
        self::assertEqualsCanonicalizing(['B','B','B'], $chunked->get(1)->all());
        self::assertEqualsCanonicalizing(['C','C','C','C'], $chunked->get(2)->all());
        self::assertEqualsCanonicalizing(['D'], $chunked->get(3)->all());
    }

    public function testFirst(): void {
        $collection = Collection::range(1,10);
        $first = $collection->first();
        self::assertEquals(1, $first);
        
        $first = $collection->first(fn($value, $key)=> $value > 5);
        self::assertEquals(6, $first);

        $first = $collection->first(fn($value, $key)=> $value > 100, default: 0); // pakai default
        self::assertEquals(0, $first);
    }

    public function testLast(): void {
        $collection = Collection::range(1, 10);
        $last = $collection->last();
        self::assertEquals(10, $last);

        $last = $collection->last(fn($value) => $value < 5);
        self::assertEquals(4, $last);
    }

    public function testRandom(): void {
        $collection = Collection::range(1, 10);
        $random = $collection->random();
        self::assertContains($random, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]);
        
        $randoms = $collection->random(5);
        $randoms->each(function($value){
            self::assertContains($value, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]);
        });
    }

    public function testExistance(): void {
        $collection = Collection::range(1,10);
        self::assertNotTrue($collection->isEmpty());
        self::assertTrue($collection->isNotEmpty());
        self::assertTrue($collection->contains(10));
        self::assertNotTrue($collection->contains(100));
        self::assertTrue($collection->contains(fn($value)=> $value == 8));
    }

    #[Group('Ordering')]
    public function testSort(): void {
        $collection = Collection::range(1,10)->shuffle();
        $sorted = $collection->sort();
        self::assertEqualsCanonicalizing([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], $sorted->all());
    }

    #[Group('Ordering')]
    public function testSortDesc(): void {
        $collection = Collection::range(1,10)->shuffle();
        $sorted = $collection->sortDesc();
        self::assertEqualsCanonicalizing([10, 9, 8, 7, 6, 5, 4, 3, 2, 1], $sorted->all());
    }

    #[Group('Agregate')]
    public function testSum(): void {
        $collection = collect()->range(1,10);
        $result = $collection->sum();
        self::assertEquals(55, $result);
        }
        
    #[Group('Agregate')]
    public function testAvg(): void {
        $collection = collect()->range(1,10);
        $result = $collection->avg();
        self::assertEquals(5.5, $result);
    }
        
    #[Group('Agregate')]
    public function testMin(): void {
        $collection = collect()->range(1,10);
        $result = $collection->min();
        self::assertEquals(1, $result);
    }
        
    #[Group('Agregate')]
    public function testMax(): void {
        $collection = collect()->range(1,10);
        $result = $collection->max();
        self::assertEquals(10, $result);
    }
        
    #[Group('Agregate')]
    public function testCount(): void {
        $collection = collect()->range(1,10);
        $result = $collection->count();
        self::assertEquals(10, $result);
    }

    public function testReduce(): void {
        $collection = Collection::range(1, 10);
        $result = $collection->reduce(fn($carry, $item)=> $carry + $item);
        self::assertEquals(55, $result);
    }
}
