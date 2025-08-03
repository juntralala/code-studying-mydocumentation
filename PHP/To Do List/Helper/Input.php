<?php

function input(string $info):string {
    echo "$info : ";
    $todo = fgets(STDIN);
    return trim($todo);
}