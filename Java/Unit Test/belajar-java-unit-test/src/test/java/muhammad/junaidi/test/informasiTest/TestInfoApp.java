package muhammad.junaidi.test.informasiTest;

import org.junit.jupiter.api.*;

@DisplayName("Information Test")
public class TestInfoApp {

    @Test
    @Tags({
            @Tag("one"),
            @Tag("two")
    })
    @DisplayName("this is test1")
    public void test1(TestInfo info) {
        System.out.println( "DisplayName : " + info.getDisplayName() );
        System.out.println( "Tags        : " +  info.getTags() );
        System.out.println( "Test Class  : " + info.getTestClass().orElse(null) );
        System.out.println( "Test Method : " + info.getTestMethod().orElse(null) );
    }

}
