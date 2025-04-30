package TestsSetups;

import Pages.AuthenticationPage;
import Pages.MainPage;
import homework.TestBot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Timeout;
import static com.codeborne.selenide.Selenide.*;

public class MainTestsSetup {
    private static final String BASIC_URL = "https://ok.ru/";
    private static final TestBot TEST_BOT = new TestBot("technopol62", "technopolisPassword");
    protected MainPage mainPage;
    @BeforeEach
    @Timeout(15)
    public void before() {
        open(BASIC_URL);
        mainPage = new AuthenticationPage().login(TEST_BOT.getLogin(), TEST_BOT.getPassword());
    }

    @AfterEach
    public void after() {
        closeWindow();
    }
}

