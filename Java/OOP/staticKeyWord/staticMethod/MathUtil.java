package staticKeyWord.staticMethod;

public class MathUtil {
    // static method
    public static int sum(int... values) {
        int total = 0;
        for (int i = 0; i < values.length ; i++) {
            total += values[i];
        }
        return total;
    }
}
