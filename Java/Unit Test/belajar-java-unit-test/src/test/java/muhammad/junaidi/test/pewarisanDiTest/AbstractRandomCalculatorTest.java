package muhammad.junaidi.test.pewarisanDiTest;

import muhammad.junaidi.test.membuatTest.Calculator;
import org.junit.jupiter.api.BeforeEach;

public abstract class AbstractRandomCalculatorTest {

    protected Calculator calculator = new Calculator();

    @BeforeEach
    public void beforeEach() {
        System.out.println("Before Each");
    }

}
