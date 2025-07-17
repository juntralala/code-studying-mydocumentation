/** Project Type
 * Secara default, saat kita membuat project NodeJS, NodeJS menggunakan commonjs
 * Oleh karena itu, ketika kita ingin menggunakan JavaScript Modules, kita harus mengubah file nya menjadi file mjs
 * Namun, kita juga bisa mengubah default project type dari commonjs menjadi js modules, dengan cara mengubah type
   di package.json
 * Sangat direkomendasikan sekarang menggunakan js modules dibanding commonjs, karena js modules sudah menjadi 
   standard di JavaScript
 */

import os from "os"

console.log(os.cpus().length)