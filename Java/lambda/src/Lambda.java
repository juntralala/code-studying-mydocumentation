import app.SimpAct;
import app.SimpleAct;

/** apa itu LAMBDA?
 * lamda beasal dari lambda calculus, yang mengacu pada anonymous function
 * tapi, di java function/method tidak bisa berdiri sendiri
 * jadi kemungkinan pada praktek nya, lambda di java dan bahasa pemrograman lain akan berbeda
 */

/** Anonymous Class
 * di java kita hanya mengenal anonymous class
 * lmabda di java sebenarnya adalah versi sederhana membuat anonymous class
 */

/** SYARAT LAMBDA
 * Memiliki 1 method abstract
 * ditambahkan anotation @FunctionInterface di interface nya
 * minimal menggunakan java 8
 */

public class Lambda {
    public static void main(String[] args) {
        // anonymous class
        SimpAct simpAct = new SimpAct() {
            public String act() {
                return "ujun";
            }
        };
        System.out.println(simpAct.act());

        // lamda
        // tanpa parameter
        SimpAct simpAct1 = () -> {
            return "Junaidi";
        };
        System.out.println(simpAct1.act());

        // ada parameter
        // cara 1
        SimpleAct simpleAct1 = (String val) -> {
            return "halo "+ val;
        };
        System.out.println(simpleAct1.act("Muhammad Junaidi"));

        // cara 2
        SimpleAct simpleAct2 = (val) -> {
            return "jalo " + val;
        } ;
        System.out.println(simpleAct2.act("Muhammad Junaidi"));

        // cara 3 tanpa blok
        SimpleAct simpleAct3 = (String val) -> "Hallo " + val;
        System.out.println(simpleAct3.act("Muhammad Junaidi"));

        // cara 4 tanpa tipe data
        SimpleAct simpleAct4 = (val) -> "Hallo " + val;
        System.out.println(simpleAct3.act("Muhammad Junaidi"));

        // cara 5 parameter tanpa dalam kurung jika parameternya cuman 1
        SimpleAct simpleAct5 = val -> "Hallo " + val;
        System.out.println(simpleAct3.act("Muhammad Junaidi"));


    }
}
