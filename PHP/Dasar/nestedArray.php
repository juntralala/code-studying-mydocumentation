<?php

$ujun = array(
    "id" => "1001",
    "name" => "Muhammad Junaidi",
    "age" => 18,
    "address" => array(
        "country" => "Indonesia",
        "city" => "Rantau City",
    )
);

echo $ujun["id"], "\n";
echo $ujun["name"], "\n";
echo $ujun["age"], "\n";
echo $ujun["address"]["country"], "\n";
echo $ujun["address"]["city"], "\n";

$dawi = [
    "id"   => "1002",
    "nama" => "Ahmad Badawi",
    "usia" => 21,
    "address" => [
        "country" => "Indonesia",
        "city" => "Rantau City",
    ]
];