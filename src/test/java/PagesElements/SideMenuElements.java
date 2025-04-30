package PagesElements;

import Pages.MainPage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;

public class SideMenuElements {
    private static final By NEWS_TAPE = By.xpath(".//*[@href='/feed']");
    private static final By POST = By.xpath(".//span[contains(@class, 'dropdown-button')]");
    private final SelenideElement ITEM;


    public SideMenuElements(SelenideElement item) {
        this.ITEM = item;
    }

    public boolean isNewsTapeVisible() {
         return ITEM.$(NEWS_TAPE).shouldBe(visible.because("Кнопка ленты не отображается")).isDisplayed();
    }

    public boolean isPostVisible() {
        return ITEM.$(POST).shouldBe(visible.because("Кнопка Опубликовать не отображается")).isDisplayed();
    }

    public MainPage clickPost() {
        ITEM.$(POST).shouldBe(visible.because("Кнопка опубликовать не отображается")).click();
        return new MainPage();
    }

}