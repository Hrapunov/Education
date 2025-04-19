package PagesElements;

import Pages.MainPage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SideMenuElements {
    private static final SelenideElement newsTape = $(By.xpath(".//*[@href='/feed']"));
    private static final SelenideElement post = $(By.xpath(".//span[contains(@class, 'dropdown-button')]"));
    private static final SelenideElement popup = $(By.xpath(".//div[contains(@class, 'dropdown-list')]"));
    private static final SelenideElement popupPublic = $(By.xpath(".//a[contains(@href, '/post')]"));
    private static final SelenideElement postingForm = $(By.xpath(".//div[contains(@class, 'posting')]"));

    public boolean getNewsTape() {
         return newsTape.shouldBe(visible.because("Кнопка ленты не отображается")).isDisplayed();
    }

    public boolean getPost() {
        return post.shouldBe(visible.because("Кнопка Опубликовать не отображается")).isDisplayed();
    }

    public boolean getPostingForm(){
        return postingForm.shouldBe(visible.because("Форма для поста не отображается")).isDisplayed();
    }
    public MainPage clickPost() {
        post.shouldBe(visible.because("Кнопка опубликовать не отображается")).click();
        return new MainPage();
    }

    public MainPage popupPublicClick() {
        popup.shouldBe(visible.because("Поп-ап не отображается"));
        popupPublic.shouldBe(visible.because("Кнопка поста не отображается")).click();
        return new MainPage();
    }
}