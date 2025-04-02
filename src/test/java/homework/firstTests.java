package homework;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static homework.authenticationPage.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class firstTests {
    authenticationPage loginPage = new authenticationPage();
    mainPage mainPage = new mainPage();
    private final String username = "technopol62";
    private final String password = "technopolisPassword";


    @AfterEach
    public void after() {
        closeWindow();
    }

    @BeforeEach
    @Timeout(10)
    public void before() {
        loginPage.authOpen();
    }

    @Test
    @Tag("authenticationPage")
    @DisplayName("Заход на главную страницу")
    public void loginToMain() {
        authenticationPage.login(username, password);
        mainPage.getNewsTape("лента");
    }

    @Test
    @Tag("authenticationPage")
    public void registrationButtonOnPage() {
        authenticationPage.getRegistrationButton("Зарегистрироваться");
    }

    @Test
    @Tag("authenticationPage")
    public void lookingQR() {
        assertAll(
                () -> QrButton.shouldBe(visible),
                () -> enterWithQR.shouldBe(visible)
        );
    }

    @Test
    @Tag("mainPage")
    public void postTest() {
        authenticationPage.login(username, password);
        mainPage.getPost("Опубликовать");
    }

    @Test
    @Tag("mainPage")
    public void lookingOnSite() {
        authenticationPage.login(username, password);
        mainPage.search("what");
        $(By.xpath("//div[@class='island_cnt__pyx2y island-content__zdst2']"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "111111111111111111111111111111111111"})
    @Tag("mainPage")
    public void searchLengthTest(String length) {
        authenticationPage.login(username, password);
        mainPage.search(length);
    }

    @Disabled
    @Test
    void skippedTrue(){
        assertTrue(true);
    }

}
