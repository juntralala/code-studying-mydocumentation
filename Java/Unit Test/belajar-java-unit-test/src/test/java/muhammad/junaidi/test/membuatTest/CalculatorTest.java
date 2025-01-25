package muhammad.junaidi.test.membuatTest;

import muhammad.junaidi.test.generator.SimpleDisplayNameGenerator;
import org.opentest4j.TestAbortedException;
import org.junit.jupiter.api.*;

import static  org.junit.jupiter.api.Assertions.*;
import static  org.junit.jupiter.api.Assumptions.*;

//@DisplayNameGeneration(value = SimpleDisplayNameGenerator.class)
//@DisplayName("Test untuk calculator class")
public class CalculatorTest {

    Calculator calculator = new Calculator();

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before All");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After All");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Before Each");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("After Each");
    }

    @Test
    public void testSumSuccess() {
        var result = calculator.sum(10, 10);
        assertEquals(20, result);

        // CONTOH Assertion manual
//        if (result != 20) {
//            throw new RuntimeException("Test Gagal!");
//        }
    }

    @Test
    public void testDivideSuccess() {
        var result = calculator.divide(100, 10);
        assertEquals(10, result);
    }

    @Test
    @DisplayName("Test skenario gagal method divide(Integer, Integer)")
    public void testDivideFiled() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0 );
        });
    }

    @Test
    @Disabled
    public void testDisabled() {}

    @Test
    public void testAborted() {
        var profile = System.getenv("PROFILE");
        if (!"DEV".equals(profile)) {
            throw new TestAbortedException("Test Di Hentikan : TestAbortedException");
        }
    }

    @Test
    public void testAssumtions() {
//        System
        assumeTrue("DEV".equals(System.getenv("PROFILE")));
    }

}
