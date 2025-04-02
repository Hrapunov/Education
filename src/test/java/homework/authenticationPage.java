package homework;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class authenticationPage {
    public static SelenideElement registrationButton = $(By.xpath("//a[@class='button-pro __sec mb-3x __wide']"));
    public static SelenideElement usernameField = $("#field_email");
    public static SelenideElement passwordField = $("#field_password");
    public static SelenideElement loginButton = $(By.xpath("//input[@value='Войти в Одноклассники']"));
    public static SelenideElement enterWithQR = $(By.xpath("//a[@class='button-pro __wide qr-code-button mt-2x js-login-nav js-login-qrCode']"));
    public static SelenideElement QrButton = $(By.xpath("//a[@class='filter_i js-login-nav js-login-qrCode']"));

    public void authOpen() {
        open("https://ok.ru/");
    }

    public static void login(String username, String password) {
        usernameField.setValue(username);
        passwordField.setValue(password);
        loginButton.click();
    }

    public static void getRegistrationButton(String text) {
        registrationButton.shouldBe(visible).shouldHave(text(text));
    }
}
