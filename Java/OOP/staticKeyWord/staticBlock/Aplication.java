package staticKeyWord.staticBlock;

public class Aplication {

    public static int PROCESSORS = 0;

    static {

        System.out.println("Mengakses static block");
        PROCESSORS = Runtime.getRuntime().availableProcessors();

    }

}
