package muhammad.junaidi.test.DependencyInjection;

import muhammad.junaidi.test.membuatTest.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.Extensions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;

import java.util.Random;

@Extensions({
        @ExtendWith(RandomParameterResolver.class)
})
public class randomCalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void testRandom(Random random) {
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.sum(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testRandom2(Random random) {
        var a = random.nextInt();
        var b = random.nextInt();

        Assertions.assertEquals(a + b, calculator.sum(a, b));
    }

}
