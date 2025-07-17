package muhammad.junaidi.test.parameterizedTest;
import muhammad.junaidi.test.membuatTest.Calculator;
import muhammad.junaidi.test.pewarisanDiTest.AbstractRandomCalculatorTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class ParameterizedCalculatorTest extends AbstractRandomCalculatorTest {

    @DisplayName("Tes Kalkulator")
    @ParameterizedTest(name = "{displayName} dengan parameter {0} {index}")
    @ValueSource(ints = {2, 4, 6, 8})
    public void valueParameterizedTest(int value) {
        Assertions.assertEquals(value + value, calculator.sum(value, value));
    }

    public static List<Integer> iniParameterSource() {
        return List.of(12, 24, 48);
    }

    @DisplayName("Tes Kalkulator MethodSource")
    @ParameterizedTest(name = "{displayName} dengan parameter {0}")
    @MethodSource( {"iniParameterSource"})
    public void methodParameterizedTest(Integer value) {
        Assertions.assertEquals(value + value, calculator.sum(value, value));
    }


}
