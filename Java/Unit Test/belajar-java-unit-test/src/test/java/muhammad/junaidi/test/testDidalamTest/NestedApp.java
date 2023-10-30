package muhammad.junaidi.test.testDidalamTest;

import org.junit.jupiter.api.*;

import java.util.LinkedList;
import java.util.Queue;

public class NestedApp {

    Queue<String> queue;

    @Nested
    public class queueTest {

        @BeforeEach
        public void setUp() {
            queue = new LinkedList<>();
        }

        @Test
        @DisplayName("when offer, size must be 1")
        public void offerNewData() {
            queue.offer("Ujun");
            Assertions.assertEquals(1, queue.size());
        }

        @Test
        @DisplayName("when offer 2 data, size must be 2")
        public void offerMoreData() {
            queue.offer("Ujun");
            queue.offer("Maidi");
            Assertions.assertEquals(2, queue.size());
        }

    }

}
