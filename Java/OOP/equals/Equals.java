package equals;

/**
 * hal yang membingungkan di java adalah cara membandingkan object
 *
 * di bahasa pemrograman lain untuk mengecek apakah sebuah object sama, biasanya menggunkan operator ==,
 * di java operator == hanya mengecek data prmitif
 *
 * untuk data non primitif penegcekan menggunakan method equals
 *
 * dan secara default, method equals akan membeandingkan object secaa kesamaan posisi object di memori,
 * artinya jika kita membuat dua object yang isi field nya sama, maka akan tetap di anggap berbeda oleh method equals
 *
 * olehkarena itu, ada baiknya kita meng-override method equals milik class object tersebut
 */

public class Equals {
    public static void main(String[] args) {

        Cat kucing1 = new Cat("Tom", 3);
        Cat kucing2 = new Cat("Tom", 3);

        System.out.println(kucing1 == kucing2);
        System.out.println(kucing1.equals(kucing2));
    }
}
