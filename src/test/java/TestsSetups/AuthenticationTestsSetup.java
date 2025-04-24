package TestsSetups;

import homework.TestBot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Timeout;
import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;
import java.util.stream.Stream;

public class AuthenticationTestsSetup{
    private static final String basicUrl = "https://ok.ru/";
    private static final TestBot testBot = new TestBot("technopol62", "technopolisPassword");
    private static final TestBot testBot1 = new TestBot("technopol70", "technopolisPassword");
    private static final TestBot testBot2 = new TestBot("technopol71", "technopolisPassword");
    @BeforeEach
    @Timeout(10)
    public void before() {
        open(basicUrl);
    }

    @AfterEach
    public void after() {
        closeWindow();
    }


    private static Stream<Object> testsBots() {
        return Stream.of(
                testBot,
                testBot1,
                testBot2
        );
    }
}
