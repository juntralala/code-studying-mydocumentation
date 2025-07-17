/** Live vs Static NodeList
 * NodeList memiliki 2 tipe, yaitu Live dan Static
 * Live artinya perubahan yang terjadi pada NodeList nya, akan merubah semua NodeList yang sama
 * Sattic artinya perubahan yang terjadi pada NodeList nya, tidak akan merubah semua NodeList yang sama
 * Saat kita menggunakan element.childNodes, NodeList tersebut bersifat Live
 * Saat kita menggunakan document.querySelectorAll(), NodeList tersebut bersifat Static
*/