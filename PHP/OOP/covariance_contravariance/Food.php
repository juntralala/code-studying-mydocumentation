<?php

class Food {
    function __toString(){
        return "Food";
    }
}

class AnimalFood extends Food{
    function __toString(){
        return "Animal Food";
    }
}