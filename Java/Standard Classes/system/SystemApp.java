package system;

public class SystemApp {
    public static void main(String[] args) {

        System.out.println(System.currentTimeMillis()); // tanggal saat ini dalam bentuk milisecond
        System.out.println(System.nanoTime());

        System.out.println(System.getenv("USERDOMAIN"));

        System.gc();   // cuman untuk menjalankan garbage colection

        System.exit(1);
        System.out.println("hai");

    }
}
