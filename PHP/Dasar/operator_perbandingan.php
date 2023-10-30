<?php
/*
operator perbandingan :
1. ==                       // check sama dengan setelah mengkonversi data 
2. ===                      // sama dengan dan sama tipe data
3. !=                       // check tidak sama dengan setelah mengkonversi data
4. <>                       // check tidak sama dengan setelah mengkonversi data
5. !==                      // tidak sama dengan dan tidak sama tipe data
6. <
7. <=
8. >
9. >=

type jugling = perubahan tipe data automatis
*/

var_dump( 1 == "1" );
var_dump( 1 === "1");
var_dump( 1 != "1");
var_dump( 1 !== "1");