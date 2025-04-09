package homework;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public class AuthenticationPage {
    private final String basicUrl = "https://ok.ru/";
    private static final SelenideElement registrationButton = $(By.xpath("//a[@class='button-pro __sec mb-3x __wide']"));
    private static final SelenideElement usernameField = $("#field_email");
    private static final SelenideElement passwordField = $("#field_password");
    private static final SelenideElement loginButton = $(By.xpath("//input[@value='Войти в Одноклассники']"));
    private static final SelenideElement enterWithQR = $(By.xpath("//a[@class='button-pro __wide qr-code-button mt-2x js-login-nav js-login-qrCode']"));
    private static final SelenideElement QrButton = $(By.xpath("//a[@class='filter_i js-login-nav js-login-qrCode']"));

    public void authOpen() {
        open(basicUrl);
    }

    public static void login(String username, String password) {
        usernameField.setValue(username);
        passwordField.setValue(password);
        loginButton.click();
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
