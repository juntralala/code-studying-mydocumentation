<?php
/** Melihat daftar test
 * Di PHPUnit kita bisa melihat daftar test yg ada dengan perintah terminal :
   - phpunit --list-tests
   - phpunit --list-tests _namaFile_
 */

echo `vendor\bin\phpunit --list-tests`; // mem print hasil perintah ke terminal 