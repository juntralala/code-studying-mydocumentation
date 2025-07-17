package muhammad.junaidi.test.urutanEksekusiTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTest {

    @Test
    @Order(3)
    public void test1() {}

    @Test
    @Order(2)
    public void test2() {}

    @Test
    @Order(1)
    public void test3() {}

}
