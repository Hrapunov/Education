package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.LoadableComponent;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AuthenticationPage extends LoadableComponent<AuthenticationPage> {
    private static final SelenideElement registrationButton = $(By.xpath(".//*[@class='button-pro __sec mb-3x __wide']"));
    private static final SelenideElement usernameField = $("#field_email");
    private static final SelenideElement passwordField = $("#field_password");
    private static final SelenideElement loginButton = $(By.xpath(".//*[@value='Войти в Одноклассники']"));
    private static final SelenideElement enterWithQR = $(By.xpath(".//span[contains(@class, 'qr-button')]"));
    private static final SelenideElement QrButton = $(By.xpath(".//a[contains(@class, 'qrCode')]"));

    @Override
    public void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        try {
            $(loginButton).shouldBe(visible);
        } catch (NoSuchElementException e){
            System.out.println("Кнопка логина не отобразилась");
        }
    }

    public MainPage login(String login, String password) {
        $(usernameField).shouldBe(visible).setValue(login);
        $(passwordField).shouldBe(visible).setValue(password);
        $(loginButton).shouldBe(visible).click();
        return new MainPage();
    }

    public String getRegistrationButtonText() {
        return $(registrationButton).shouldBe(visible.because("Кнопка регистрации не отображается")).getText();
    }

    public boolean getEnterWithQR() {
        return $(enterWithQR).shouldBe(visible.because("Кнопка Войти по QR-коду не отображается")).isDisplayed();
    }

    public boolean getQrButton() {
        return $(QrButton).shouldBe(visible.because("Кнопка QR-код не отображается")).isDisplayed();
    }
}

