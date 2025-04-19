package TestsSetups;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Timeout;
import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

public class AuthenticationTestsSetup {
    private static final String basicUrl = "https://ok.ru/";

    @BeforeEach
    @Timeout(10)
    public void before() {
        open(basicUrl);
    }

    @AfterEach
        public void after() {
            closeWindow();
        }
}
