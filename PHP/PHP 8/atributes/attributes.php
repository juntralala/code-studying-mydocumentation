<?php 
/**
 * Attributes adalah menambahkan metadata terhadap kode program yang kita buat
 * Fitur ini adalah fitur yang sangat baru di PHP, dan bisa memungkinkan fitur ini bakal di adopsi oleh banyak framework-framework di PHP di masa akan datang
 * Fitur ini jika di bahasa pemrograman lain seperti Java bernama Annotion, Attributes di C# ,dan decorator di Python dan Javascript
 * https://www.php.net/manual/en/languange.attributes.php
 * https://wiki.php.net/rfc/attributes_v2
*/

/** Menggunakan Attributes
 * Attributes bisa kita gunakan di berbagai tempat, seperti Class, Function, Method, Property, Class Constant dan Parameter
 * Untuk menggunakan Attrbute, kita cukup gunakan tanda #[NamaAttribute] di target yang kita tentukan 
*/

/** Attribute Target
 * Secara Default, attribute bisa digunakan, pada semua target (class, function, method, property, dll)
 * Jika kita ingin membatasihanya bisa digunakan di tagrt tertentu, kita bisa tambahkan informasinya ketika membuat class attribute  
*/

require_once "attributesClass.php";

// membuat Attribute
#[Attribute(Attribute::TARGET_PROPERTY | Attribute::TARGET_CLASS)] // cuman bisa digunakan untuk property dan class
class NotBlank {
}

class LoginRequest {
    #[Length(min: 4, max:20)]  // menggunakan Atribute yang memiliki property, constructor dengan prameter $min dan $max
    #[NotBlank]
    public ?string $username;
    
    #[Length(min: 4, max:20)]
    #[NotBlank]
    public ?string $password;
}


function validate(object $object) {
    $class = new ReflectionClass($object);
    $properties = $class->getProperties();
    foreach($properties as $property) {
        validateNotBlank($property, $object);
        validateLength($property, $object);
    }
}

function validateNotBlank(ReflectionProperty $property,object $object) {
    $attributes = $property->getAttributes(NotBlank::class);
    if(count($attributes) > 0) {
        if(!$property->isInitialized($object)) {
            throw new Exception("Property $property->name tidak terinisiasi");
        }elseif ($property->getValue($object) == null) {
            throw new Exception("Property $property->name is null");
        }
    }
}

function validateLength(ReflectionProperty $property, object $object){
    if(!$property->isInitialized($object) || $property->getValue($object) == null){
        return; // cancel validasi length
    }

    $value = $property->getValue($object);
    $lengthAttributes = $property->getAttributes(Length::class);
    if($lengthAttributes > 0) {
        foreach($lengthAttributes as $lengthAttribute) {
            $length = $lengthAttribute->newInstance();
            if(strlen($value) < $length->min) {
                throw new Exception("Property $property->name is too short, the minimum length is $length->min");
            }elseif(strlen($value) > $length->max) {
                throw new Exception("Property $property->name is too long, the maximum length is $length->max");
            }
        }
    }
}

// <============== run utama ==============>

$request = new LoginRequest();

$request->username = "ujun";
$request->password = "12111111111111111111111111134";

validate($request);