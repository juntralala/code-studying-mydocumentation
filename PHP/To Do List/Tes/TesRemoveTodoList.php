<?php

require_once __DIR__."/../Model/toDoList.php";
require_once __DIR__."/../BusinessLogic/ShowTodoList.php";
require_once __DIR__."/../BusinessLogic/AddTodoList.php";
require_once __DIR__."/../BusinessLogic/RemoveTodoList.php";

$todoList[1] = "Makan Pagi";
$todoList[2] = "Makan Siang";
$todoList[3] = "Makan Malam";

removeTodoList(2);

showTodoList();

echo "\n\ntes menghapus yang tidak ada\n"; 
$successful = removeTodoList(10);
var_dump($successful); // ini false

