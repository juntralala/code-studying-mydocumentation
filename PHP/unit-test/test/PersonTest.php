<?php

use UjunAlRantaui\UnitTest\Person;

class PersonTest extends PHPUnit\Framework\TestCase {
    private Person $person;

    protected function setUp():void{
        $this->person = new Person("Ujun");
    }
    
    /** 
     * @before 
     */
    public function before(){
    }

    protected function tearDown(): void{
        unset($person);
    }

    /** 
     * @after 
     */
    public function after(){
    }
    
    public function testSuccess(){
        $this->assertEquals("Hello Maidi, my name is Ujun", $this->person->sayHello("Maidi"));
    }
    
    public function testException(){
        self::expectException(Exception::class);
        $this->person->sayHello(null);
    }
    
    public function testExpectOutputString(){
        self::expectOutputString("Good bye ajid" . PHP_EOL);
        $this->person->sayGoodbye("ajid");
    }
}