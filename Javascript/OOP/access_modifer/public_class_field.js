/** Public Class Field
 * Dalam proposal tersebut juga disebutkan bahwa EcmaScript akan mendukung access modifier public dan private
 * Public artinya bisa diakses dari luar class, dan private hanya bisa diakses dari dalam class
 * private class field akan kita bahas chapter selanjutnya
 * Untuk public class field akan kita bahas di chapter selanjutnya
 * Untuk membuat public class field, kita bisa langsung buat nama field dengan value nya selevel dengan
   method
 * Jika kita tidak memasukkan value ke dalam field tersebut, artinya field tersebut memiliki value undefined
*/
log = console.log

class Hero{
    name
    hp
    attack
}

let layla = new Hero()
log(layla)
