package random;

import java.util.Random;

/**
 * Random class adalah class yang bisa kita gunakan untuk men-generate random number
 */

public class RandomApp {
    public static void main(String[] args) {

        Random rand = new Random();

        for (int i=1 ; i<100 ; i++) {
            var value = rand.nextInt(100);
            System.out.println(value);
        }

    }
}
