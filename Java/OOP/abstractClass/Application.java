package abstractClass;

public class Application {
    public static void main(String[] args) {

//      Location lokasi = new Location(); // ini error karena abstract class
        City mtp = new City();
        mtp.name = "Martapura";

        System.out.println(mtp.name);

    }
}
