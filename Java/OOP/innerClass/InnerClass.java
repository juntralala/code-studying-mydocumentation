package innerClass;

/**
 * Di java, kita bisa membuat class di dalam class, atau di sebut dengan inner class
 *
 * Salah satu kasus kita membuat inner class biasany kita butuh membuat class yang saling berhubungan, dimana class
 * tidak bisa dibuat tanpa class lain
 *
 * Misal kita membuat class Employee, di mana membutuhkan class Company, maka kita bisa membuat class Employee
 * sebagai inner class Company
 *
 * Cara membuat inner class, cukup membuatnya didalam blok class outer class nya
 */

/**
 * KEUNTUNGAN kita membuat inner class adalah kemampuan untuk mengakses outer class nya
 *
 * inner class bisa membaca semua private member outer yang ada di class nya
 *
 * untuk mengases object outer classnya, kita menggunakan nama classnya dan diikuti dengan kata kunci this,
 * nisalnya Compony.this
 *
 * Dan untuk mengakses super class outer class nya, kita bisa menggunakan nama class outernya diikuti dengan
 * kata kunci super, misal Company.super
 */

public class InnerClass {
}
