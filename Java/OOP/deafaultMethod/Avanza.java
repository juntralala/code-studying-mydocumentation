package deafaultMethod;

/**
 * ketika kita membuat class emplements dari interface, maka kita harus mengoverride semua method
 *
 * emplments bisa lebih dari 1, tidak seperti abstract class
 */

public class Avanza implements Car {

    public void drive() {
        System.out.println("Avanza drive");
    }

    public int getTire() {
        return 4;
    }
}
