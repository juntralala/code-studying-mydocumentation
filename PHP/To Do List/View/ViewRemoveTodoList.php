<?php

require_once __DIR__."/../Model/toDoList.php";
require_once __DIR__."/../BusinessLogic/RemoveTodoList.php";
require_once __DIR__."/../Helper/Input.php";

function viewRemoveTodoList() {
    echo "<===== Menghapus Todo =====>" . PHP_EOL;
    $pilihan = input("Pilih (x untuk batal)");
    
    if($pilihan != "x"){
        $success = removeTodoList((int)$pilihan);
        if($success) {
            echo "Sukses Mengapus todo No. $pilihan" . PHP_EOL;
        } else {
            echo "Sukses Mengapus todo No. $pilihan" . PHP_EOL;
        }
    }else{
        echo "Batal menghapus Todo" . PHP_EOL;
    }
}