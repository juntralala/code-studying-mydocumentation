<?php

function showTodoList() {
    global $todoList;

    echo "<===== Show To Do List =====>" . PHP_EOL;
    foreach($todoList as $number => $todo) {
        echo "$number. $todo" . PHP_EOL;
    }
}
