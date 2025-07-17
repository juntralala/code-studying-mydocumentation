package muhammad.junaidi.test.urutanEksekusiTest;

import org.junit.jupiter.api.Test;

public class LifeCycleTest {

    String temp;

    @Test
    public void testA() {
        temp = "UJUN";
    }

    @Test
    public void testB() {
        System.out.println(temp);
    }

}
