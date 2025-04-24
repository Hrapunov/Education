package TestsSetups;

import Pages.AuthenticationPage;
import Pages.MainPage;
import homework.TestBot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Timeout;
import static com.codeborne.selenide.Selenide.*;

public class MainTestsSetup {
    private static final String basicUrl = "https://ok.ru/";
    private static final TestBot testBot = new TestBot("technopol62", "technopolisPassword");
    protected MainPage mainPage;
    @BeforeEach
    @Timeout(10)
    public void before() {
        open(basicUrl);
        AuthenticationPage authenticationPage = new AuthenticationPage();
        mainPage = authenticationPage.login(testBot.getLogin(), testBot.getPassword());
    }

    @AfterEach
    public void after() {
        closeWindow();
    }
}

