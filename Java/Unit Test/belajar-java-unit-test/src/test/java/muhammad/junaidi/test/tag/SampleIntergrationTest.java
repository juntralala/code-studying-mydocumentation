package muhammad.junaidi.test.tag;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tags({ @Tag("sample-integration-test") })
public class SampleIntergrationTest {

    @Test
    public void test1() {}

    @Test
    public void test2() {}

    @Test
    public void test3() {}

}
