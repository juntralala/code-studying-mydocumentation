<?php

require_once __DIR__."/../Model/toDoList.php";
require_once __DIR__."/../BusinessLogic/ShowTodoList.php";
require_once __DIR__."/../View/ViewRemoveTodoList.php";

$todoList[1] = "Makan Pagi";
$todoList[2] = "Makan Siang";
$todoList[3] = "Makan Malam";

showTodoList();
viewRemoveTodoList();
showTodoList();