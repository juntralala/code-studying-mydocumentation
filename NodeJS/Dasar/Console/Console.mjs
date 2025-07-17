/*
 * Console adalah standard library yg sering kita gunakan
 * Secara default object console bisa digunakan tanpa perlu melakukan import module, dan console melakukan print
   text ke stdout
 * kita juga bisa membuat instance object console sendiri jika kita mau
 * https://nodejs.org/dist/latest-v16.x/docs/api/console.html
*/
import {Console} from 'console'
import fs from 'fs'

let file = fs.createWriteStream('app.log')

let log = new Console({
    stdout: file,
    stderr: file
})

log.info("Hallo guys")