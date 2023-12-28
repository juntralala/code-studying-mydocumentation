<?php

require_once __DIR__."/../Model/toDoList.php";
require_once __DIR__."/../BusinessLogic/AddTodoList.php";
require_once __DIR__."/../BusinessLogic/ShowTodoList.php";

$todoList[1] = "Makan Pagi";
$todoList[2] = "Makan Siang";
$todoList[3] = "Makan Malam";

showTodoList();

