package muhammad.junaidi.test.conditionTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

public class EnabaledIfSystemProperty_DisabaledIfSystemProperty {

    @Test
    public void testViewProperties() {
        System.getProperties().forEach(
                (key, value) -> System.out.println(key + " : " + value)
        );
    }

    @Test
    @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    public void testEnabledIfSystemProperty() {
    }

    @Test
    @DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    public void testDisabledIfSystemProperty() {
    }

}
