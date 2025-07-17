package muhammad.junaidi.test.generator;

import org.junit.jupiter.api.DisplayNameGenerator;
import java.lang.reflect.Method;

public class SimpleDisplayNameGenerator implements DisplayNameGenerator {
    @Override
    public String generateDisplayNameForClass(Class<?> testClass) {
        return "Test" + testClass.getSimpleName();
    }

    @Override
    public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod){
        return "Test " + testClass.getSimpleName() + "." + testMethod.getName();
    }

    @Override
    public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
        return "Test" + nestedClass.getSimpleName();
    }
}
