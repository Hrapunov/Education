package homework;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public class AuthenticationPage {
    private static final TestBot testBot = new TestBot("technopol62", "technopolisPassword");
    private static final String basicUrl = "https://ok.ru/";
    private static final SelenideElement registrationButton = $(By.xpath("//a[@class='button-pro __sec mb-3x __wide']"));
    private static final SelenideElement usernameField = $("#field_email");
    private static final SelenideElement passwordField = $("#field_password");
    private static final SelenideElement loginButton = $(By.xpath("//input[@class='button-pro __wide']"));
    private static final SelenideElement enterWithQR = $(By.xpath("//span[@class='qr-button-label']"));
    private static final SelenideElement QrButton = $(By.xpath("//a[@class='filter_i js-login-nav js-login-qrCode']"));


    public static void authOpen() {
        open(basicUrl);
    }

    public static MainPage login() {
        usernameField.setValue(testBot.getLogin());
        passwordField.setValue(testBot.getPassword());
        loginButton.click();
        return new MainPage();
    }

    public static SelenideElement getRegistrationButton() {
        return registrationButton;
    }

    public static SelenideElement getEnterWithQR() {
        return enterWithQR;
    }

    public static SelenideElement getQrButton() {
        return QrButton;
    }
}

