package Interface;

/**
 * ketika kita membuat class emplements dari interface, maka kita harus mengoverride semua method
 */

public class Avanza implements Car {

    public void drive() {
        System.out.println("Avanza drive");
    }

    public int getTire() {
        return 4;
    }

}
