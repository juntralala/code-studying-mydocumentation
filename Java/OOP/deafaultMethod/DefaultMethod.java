package deafaultMethod;

/**
 * sebelumnya kita tahu bahwa di interface, kita tidak bisa membuat method konkrit yang memiliki block method
 *
 * namun semenjak java 8, ada fitur default method di interface
 *
 * fitur ini terjadi karena sulit uuntuk maintain kontreak interface jika sudah terlalu banyak class yang implement
 * interface tersebut
 *
 * ketika kita menambah satu method di interface, secara otomatis semua class yang implements akan rusak, karena harus
 * meng-override method tersebut
 *
 * dengan mengggunakan default method, kita mengkonkrit method tersebut di interface
 */

public class DefaultMethod {
}
