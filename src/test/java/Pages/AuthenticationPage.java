package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AuthenticationPage extends LoadableComponent<AuthenticationPage> {
    private static final String BASIC_URL = "https://ok.ru/";
    private static final By REGISTRATION_BUTTON = By.xpath(".//*[@class='button-pro __sec mb-3x __wide']");
    private static final By USERNAME_FIELD = By.cssSelector("#field_email");
    private static final By PASSWORD_FIELD = By.cssSelector("#field_password");
    private static final By LOGIN_BUTTON = By.xpath(".//*[@value='Войти в Одноклассники']");
    private static final By ENTER_WITH_QR = By.xpath(".//span[contains(@class, 'qr-button')]");
    private static final By QR_BUTTON = By.xpath(".//a[contains(@class, 'qrCode')]");

    @Override
    public void load() {
        open(BASIC_URL);
    }

    @Override
    protected void isLoaded() throws Error {
        $(LOGIN_BUTTON).shouldBe(visible.because("Кнопка логина не отобразилась"));
    }

    public MainPage login(String login, String password) {
        $(USERNAME_FIELD).shouldBe(visible.because("Поле логина не отобразилась")).setValue(login);
        $(PASSWORD_FIELD).shouldBe(visible.because("Поле пароля не отобразилась")).setValue(password);
        $(LOGIN_BUTTON).shouldBe(visible.because("Кнопка логина не отобразилась")).click();
        return new MainPage();
    }

    public String getRegistrationButtonText() {
        return $(REGISTRATION_BUTTON).shouldBe(visible.because("Кнопка регистрации не отображается")).getText();
    }

    public boolean isEnterWithQrVisible() {
        return $(ENTER_WITH_QR).shouldBe(visible.because("Кнопка Войти по QR-коду не отображается")).isDisplayed();
    }

    public boolean isQrButtonVisible() {
        return $(QR_BUTTON).shouldBe(visible.because("Кнопка QR-код не отображается")).isDisplayed();
    }
}

