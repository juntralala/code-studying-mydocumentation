package muhammad.junaidi.test.conditionTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

public class EnabledIfEnvironmentVariable_DisabledIfEnvironmentVariable {

    @Test
    @EnabledIfEnvironmentVariable(named = "PROFILE", matches= "DEV")
    public void testEnabledOnProfileDev() {}

    @Test
    @DisabledIfEnvironmentVariable(named = "PROFILE", matches= "DEV")
    public void testDisabledOnProfileDev() {}

}
