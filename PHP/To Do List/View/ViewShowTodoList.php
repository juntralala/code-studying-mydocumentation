<?php

require_once __DIR__."/../Model/toDoList.php";
require_once __DIR__."/../BusinessLogic/ShowTodoList.php";
require_once __DIR__."/../Helper/Input.php";
require_once __DIR__."/ViewAddTodoList.php";
require_once __DIR__."/ViewRemoveTodoList.php";

function viewShowTodoList() {
    $keluar = false;

    while(true) {
        showTodoList();

        echo "<===== Menu =====>" . PHP_EOL;
        echo "1. Tambah" . PHP_EOL;
        echo "2. Hapus" . PHP_EOL;
        echo "x. Keluar" . PHP_EOL;

        $pilihan = input("Pilihan");

        switch($pilihan) {
            case "1" :
                viewAddTodoList();
                break;
            case "2":
                viewRemoveTodoList();
                break;
            case "x":
                $keluar = true;
                break;
            default:
                echo "pilihan tidak ada yang sesuai dengan menu" . PHP_EOL;
        }

        if($keluar) {
            echo "Terimakasih Telah menggunakan Applikasi Kami" . PHP_EOL;
            break;
        }
    }
}