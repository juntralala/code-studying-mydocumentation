<?php
/*
beberapa fungtion string
1. join() / implode()       <- untuk mengabungkan string
2. explode()                <- Memvha string menjadi array
3. strtolower()             <- mengubah string menjadi lowercase
4. strtoupper()             <- substr
5. trim()                   <- menghaspus space dibelakah dan didepan string
*/

var_dump(join(',', [1,2,3,4,5,6]));
var_dump(explode(' ', "Muhammad Junaidi"));
var_dump(strtoupper("Muhammad Junaidi"));
var_dump(strtolower("Muhammad Junaidi"));
var_dump(trim("           UJUN          "));
var_dump(substr("Muhammad Junaidi", 0, 8));

