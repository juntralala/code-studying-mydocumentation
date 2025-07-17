package muhammad.junaidi.test.conditionTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledForJreRange;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.JRE;

public class EnabaledForJreRange_DisabaledForJreRange {

    @Test
    @EnabledForJreRange(min= JRE.JAVA_11, max= JRE.JAVA_19)
    public void testEnabaledForJreRange11To19() {}

    @Test
    @DisabledForJreRange(min= JRE.JAVA_11, max= JRE.JAVA_19)
    public void testDisabledForJreRange11To19() {}

}
