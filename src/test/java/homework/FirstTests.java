package homework;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class FirstTests {
    private final String username = "technopol62";
    private final String password = "technopolisPassword";

    @AfterEach
    public void after() {
        closeWindow();
    }

    @BeforeEach
    @Timeout(10)
    public void before() {
        new AuthenticationPage().authOpen();
    }

        @Nested
        class AuthenticationPageTests {
            @Test
            @Tag("authenticationPage")
            @DisplayName("Заход на главную страницу")
            public void loginToMain() {
                AuthenticationPage.login(username, password);
                assertTrue(
                        new MainPage().getNewsTape().shouldBe(visible.because("Кнопка ленты не отображается")).innerText().matches("Лента")
                );
            }

            @Test
            @Tag("authenticationPage")
            public void registrationButtonOnPage() {
                AuthenticationPage.getRegistrationButton().shouldBe(visible.because("Кнопка регистрации не отображается"));
            }

            @Test
            @Tag("authenticationPage")
            public void lookingQR() {
                assertAll(
                        () -> AuthenticationPage.getQrButton().shouldBe(visible.because("Кнопка QR-код не отображается")),
                        () -> AuthenticationPage.getEnterWithQR().shouldBe(visible.because("Кнопка Войти по QR-коду не отображается"))
                );
            }
        }

        @Nested
        class MainPageTests {

            @BeforeEach
            public void beforeMainPage(){
                AuthenticationPage.login(username, password);
            }

            @Test
            @Tag("mainPage")
            public void postTest() {
                assertTrue(
                        new MainPage().getPost().shouldBe(visible.because("Кнопка Опубликовать не отображается")).innerText().matches("Опубликовать")
                );
            }

            @Test
            @Tag("mainPage")
            public void lookingOnSite() {
                new MainPage().setSearchField("Something");
                MainPage.getBestMatches().shouldBe(visible.because("Остров с подходящими результатами не отображается"));
            }

            @ParameterizedTest
            @ValueSource(strings = {"1", "111111111111111111111111111111111111"})
            @Tag("mainPage")
            public void searchLengthTest(String length) {
                new MainPage().setSearchField(length);
                assertTrue(
                MainPage.getFindCount().shouldBe(visible.because("Остров с подходящими результатами не отображается")).innerText().startsWith("Найдено")
                );
            }
        }
    @Disabled
    @Test
    void skippedTrue() {
        assertTrue(true);
    }
}