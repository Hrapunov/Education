package TestsSetups;

import homework.TestBot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Timeout;
import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;
import java.util.stream.Stream;

public class AuthenticationTestsSetup{
    private static final String BASIC_URL = "https://ok.ru/";
    private static final TestBot TEST_BOT = new TestBot("technopol62", "technopolisPassword");
    private static final TestBot TEST_BOT1 = new TestBot("technopol70", "technopolisPassword");
    private static final TestBot TEST_BOT2 = new TestBot("technopol71", "technopolisPassword");
    @BeforeEach
    @Timeout(15)
    public void before() {
        open(BASIC_URL);
    }

    @AfterEach
    public void after() {
        closeWindow();
    }


    private static Stream<Object> testsBotsStream() {
        return Stream.of(
                TEST_BOT,
                TEST_BOT1,
                TEST_BOT2
        );
    }
}
