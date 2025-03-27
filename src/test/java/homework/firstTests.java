package homework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;



public class firstTests {
    authenticationPage loginPage = new authenticationPage();
    mainPage mainPage = new mainPage();
    private final String username = "d1ng0x@mail.ru";
    private final String password = "d1ng011";
    //fake account

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
        $("//*[@id=\"hook_Block_SearchMRB\"]/portal-search/div[2]/div[1]/div[1]/div/div[1]/button/span/span[1]");
    }
}
