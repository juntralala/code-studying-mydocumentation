<?php

require_once "Food.php";

class Pet {
    function eat(AnimalFood $animalFood):void {
        echo "Animal is eating " .PHP_EOL;
    }
}

class Dog extends Animal {
    function eat(AnimalFood $animalFood):void {
        echo "Cat is eating $animalFood" .PHP_EOL;
    }
}

class Cat extends Animal {
    function __construct(){}
    function eat(Food $food):void { // contravariace
        echo "Cat is eating $food" .PHP_EOL;
    }
}

interface AnimalShelter{
    function adobt():Animal;
}

class DogShelter implements AnimalShelter{
    function adobt(): Dog {
        return new Dog();
    }
}

class CatShelter implements AnimalShelter{
    function adobt():Cat {
        return new Cat();
    }
}