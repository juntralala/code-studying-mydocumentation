package muhammad.junaidi.test.testBerulang;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public class RepeatedTestTest {

    @DisplayName(" ini RepeatedTest")
    @RepeatedTest(value = 5, name = "{displayName}, {currentRepetition} dari {totalRepetitions}")
    public void repeatedTest() {}

    @DisplayName(" ini RepeatedInfoTest")
    @RepeatedTest(value = 5, name = "{displayName}, {currentRepetition} dari {totalRepetitions}")
    public void repeatedInfoTest(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + ", " + repetitionInfo.getCurrentRepetition() + " dari " + repetitionInfo.getTotalRepetitions() );
    }
}
