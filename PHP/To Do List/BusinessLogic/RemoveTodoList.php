<?php

function removeTodoList(int $number) {
    global $todoList;

    if(empty($todoList[$number])) return false;

    for($i=$number; $i<sizeof($todoList) ;$i++) {
        $todoList[$i] = $todoList[$i + 1];
    }
    array_pop($todoList);

    return true;
}