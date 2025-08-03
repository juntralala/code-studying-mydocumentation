import java.util.HexFormat;

public class App {
    public static void main(String[] args) {

        int binner = 0b101;
        int oktal  = 0123;
        int hex    = 0xac;

        print("Binner : ", binner);
        print("Oktal  : ", oktal);
        print("Hexade : ", hex);

    }

    private static void print(Object ...args){
        for(Object data : args){
            System.out.print(data);
        }

        System.out.println();
    }
}
