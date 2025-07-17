<?php
/** Query SQL
 * Setelah kita tahu bagaimana cara mengirim SQL ke MySQL yang tidak dibutuhkan result data, sekarang bagaimana cara
   melakukan query SQL yang membutuhkan result data seperti SQL SELECT?
 * PDO memiliki function bernama query(sql), ini digunakan untuk melakukan query data dari database
 * Return value dari function query(sql) adalah sebuah object PDOStatement    
*/

require_once "database/helper.php";

$connection = Helper\getConnection();
$sql = "SELECT * FROM costumers";
$statement = $connection->query($sql);

$connection = null;