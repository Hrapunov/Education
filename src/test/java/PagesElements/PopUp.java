package PagesElements;

import Pages.MainPage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;

public class PopUp {
    private static final By POPUP_PUBLIC = By.xpath(".//a[contains(@href, '/post')]");
    private final SelenideElement ITEM;

    public PopUp(SelenideElement item) {
        this.ITEM = item;
    }

    public MainPage popupPublicClick() {
        ITEM.$(POPUP_PUBLIC).shouldBe(visible.because("Кнопка поста не отображается")).click();
        return new MainPage();
    }
}

