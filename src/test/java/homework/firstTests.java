package homework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;



public class firstTests {
    authenticationPage loginPage = new authenticationPage();
    mainPage mainPage = new mainPage();
    private final String username = "technopol62";
    private final String password = "technopolisPassword";

    @AfterEach
    public void after(){
        closeWindow();
    }
    @BeforeEach
    public void before(){
        loginPage.authOpen();
    }

    @Test
    public void loginToMain(){
        authenticationPage.login(username, password);
        mainPage.getNewsTape("лента");
    }
    @Test
    public void registrationButtonOnPage(){
        authenticationPage.getRegistrationButton("Зарегистрироваться");
    }

    @Test
    public void postTest(){
        authenticationPage.login(username, password);
        mainPage.getPost("Опубликовать");
    }
    @Test
    public void lookingOnSite(){
        authenticationPage.login(username, password);
        mainPage.search("what");
        $(By.xpath("//div[@class='island_cnt__pyx2y island-content__zdst2']"));
    }
}
