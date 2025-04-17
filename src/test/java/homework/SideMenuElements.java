package homework;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SideMenuElements {
    private static final SelenideElement newsTape = $(By.xpath("//div[@class='tico null']"));
    private static final SelenideElement post = $(By.xpath("//span[@class='dropdown-button-text__qx55h']"));
    private static final SelenideElement popup = $(By.xpath("//div[@class='dropdown-list__qx55h menu__939in __left__939in']"));
    private static final SelenideElement popupPublic = $(By.xpath("//span[@class='item-container__7e56q']"));
    private static final SelenideElement postingForm = $(By.xpath("//div[@class='posting_itx-w']"));

    public SelenideElement getNewsTape() {
        return newsTape;
    }

    public SelenideElement getPost() {
        return post;
    }

    public SelenideElement getPostingForm(){
        return postingForm;
    }
    public SideMenuElements clickPost() {
        post.shouldBe(visible).click();
        return this;
    }

    public SideMenuElements popupPublicClick() {
        popup.shouldBe(visible);
        popupPublic.shouldBe(visible).click();
        return this;
    }
}