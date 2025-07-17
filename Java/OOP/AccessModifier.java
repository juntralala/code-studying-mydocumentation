/**
 * Access modifier adalah kemampuan membuat class, field, method dan constractor dapat diakses darimana saja
 *
 * Access modiefier Level 4 :
 *    Modifire              Class   package Subclass    Wolrd
 * 1. public                Y       Y       Y           Y
 * 2. protected             Y       Y       Y           N
 * 3. no modifier(default)  Y       Y       N           N
 * 4. private               Y       N       N           N
 *
 * tambahan :
 * elemen yang diberi modifier protected tidak dapat diakses oleh kelas-kelas di package yang berbeda,
 * kecuali jika ada hubungan turunan antara kelas-kelas tersebut
 */

class AccessModifier {
}
