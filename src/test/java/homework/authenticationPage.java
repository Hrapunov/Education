package homework;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class authenticationPage {
    public static SelenideElement registrationButton = $(".button-pro.__sec.mb-3x.__wide");
    public static SelenideElement usernameField = $("#field_email");
    public static SelenideElement passwordField = $("#field_password");
    public static SelenideElement loginButton = $(By.xpath("//input[@value='Войти в Одноклассники']"));

    public void authOpen(){
        open("https://ok.ru/");
    }

    public static void login(String username, String password) {
        usernameField.setValue(username);
        passwordField.setValue(password);
        loginButton.click();
    }
    public static void getRegistrationButton(String text){
        registrationButton.shouldBe(visible).shouldHave(text(text));
    }
}
