package muhammad.junaidi.test.conditionTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariables;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;

public class EnabledIfEnvironmentVariables_DisabledIfEnvironmentVariables {

    @Test
    @EnabledIfEnvironmentVariables({
        @EnabledIfEnvironmentVariable(named = "PROFILE", matches= "DEV")
    })
    public void testEnabledOnProfileDev() {}

    @Test
    @DisabledIfEnvironmentVariables({
    @DisabledIfEnvironmentVariable(named = "PROFILE", matches= "DEV")
    })
    public void testDisabledOnProfileDev() {}

}
