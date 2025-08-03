<?php
/*
- php memiliki fitur varianle variable, yaitu membuat variable dari
  string value variable lain
- walaupun fitur ini ada tidak disarankan untuk menggunkan fitur ini, karena
  akan membingungkan jika digunakan secara luas.
- untuk membuat variable variables digunakan $$ diikuti dengannama variablenya 
*/

$name = "UJUN";
$$name = "Pintar";

echo "Name : ", $name, "\n";

echo "variable variables : ",$$name, "\n";
echo "variable variables : ",$UJUN, "\n";
