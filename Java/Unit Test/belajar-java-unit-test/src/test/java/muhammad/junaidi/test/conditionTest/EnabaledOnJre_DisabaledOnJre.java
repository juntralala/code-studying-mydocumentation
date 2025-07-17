package muhammad.junaidi.test.conditionTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;

public class EnabaledOnJre_DisabaledOnJre {

    @Test
    @EnabledOnJre(JRE.JAVA_17)
    public void onlyRunOnJava17() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_19)
    public void onlyRunOnJava19() {
    }

    @Test
    @DisabledOnJre(JRE.JAVA_19)
    public void disabledRunOnJava19() {
    }


}
