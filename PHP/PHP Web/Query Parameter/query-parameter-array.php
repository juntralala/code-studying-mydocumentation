<?php
/** Query Parameter Array
 * Secara default, query parameter berisikan data key=value, artinya 1 key akan berisi 1 value
 * di PHP ada kemampuan untuk mengirim query parameter dengan data lebih dari satu
 * Data tersebut akan secara otomatis dikonversi menjadi array PHP
 * Caranya kita wajib menambahkan tanda[] diakhir nama query parameter nya
 * name[]=Ujun&name[]=Humaidi&name[]=Wahid, maka secara otomatis parameter name akan berisi ["Ujun", "Humaidi", "Wahid"] 
 */
// http://localhost:8080/query-parameter/query-parameter-array.php?numbers[]=5&numbers[]=8&numbers[]=12

$numbers = $_GET['numbers'];
$total = 0;
foreach($numbers as $number){
    $total += $number;
}
?>

<html>
<head>
    <title>Query Parameter Array</title>
</head>
<body>
    <h1>Total : <?= $total ?></h1>
</body>
</html>