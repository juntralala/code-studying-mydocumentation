package muhammad.junaidi.test.siklusHidupTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LifeCycleTest {

    int counter = 0;

    @BeforeAll
    public void setUp() {
        System.out.println("Before All : " + counter);
    }

    @AfterAll
    public void tearDown() {
        System.out.println("After All : " + counter);
    }

    @Test
    public void test1() {
        System.out.println( ++counter );
    }

    @Test
    public void test2() {
        System.out.println( ++counter );
    }

    @Test
    public void test3() {
       System.out.println( ++counter );
    }

}
