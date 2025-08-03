package muhammad.junaidi.test.membuatTest;

public class Calculator {

    public Integer divide(Integer first, Integer second) {
        if (second == 0) {
            throw new IllegalArgumentException("Can't divide by zero");
        } else {
            return first / second;
        }
    }

    public Integer sum(Integer first, Integer second) {
        return first + second;
    }

}
