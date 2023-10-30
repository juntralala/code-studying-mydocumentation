<?php
/* overflow integer pada php bervariasi pada os yang berbeda
jika os yang digunkan berbasis 32-bit maka batas defaultnya (2147483647)
jika os yang digunkan berbasis 64-bit maka batasnya (92233720368547757)

jika kita membuat number yang melebihi angka tersebut,maka secara otomatis 
tipe number nya berubah menjadi floating point
*/


echo 9223372036854775807;
