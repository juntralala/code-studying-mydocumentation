<?php

function AddTodoList(string $todo) {
    global $todoList;

    $todoList[sizeof($todoList) + 1] = $todo;
}