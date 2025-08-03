<?php

require_once __DIR__."/../Model/toDoList.php";
require_once __DIR__."/../BusinessLogic/AddTodoList.php";
require_once __DIR__."/../Helper/Input.php";

function viewAddTodoList() {
    echo "<===== Menambah =====>" . PHP_EOL;
    $todo = input("Todo (x untuk batal): ");

    if($todo == "x") {
        echo "Menambahakan Todo Dibatalkan" . PHP_EOL;
    } else {
        AddTodoList($todo);
        echo "Menambahakan Todo Sukses" . PHP_EOL;
    }
}