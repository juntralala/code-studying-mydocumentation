package muhammad.junaidi.test.conditionTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class EnabledOnOs_DisabledOnOs {

    @Test
    @EnabledOnOs({OS.WINDOWS})
    public void enabaledOnOsWindows() {
    }

    @Test
    @DisabledOnOs({OS.WINDOWS})
    public void disabaledOnOsWindows() {
    }


}
