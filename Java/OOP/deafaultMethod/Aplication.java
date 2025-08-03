package deafaultMethod;

public class Aplication {
    public static void main(String[] args) {
        Car mobil = new Avanza();

        mobil.drive();
        System.out.println(mobil.getTire());
        System.out.println(mobil.isBig());

    }
}
