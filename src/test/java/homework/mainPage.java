package homework;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class mainPage {
    public static SelenideElement newsTape = $(By.xpath("//*[@id=\"tab-item-0\"]/span[1]"));
    public static SelenideElement post = $(By.xpath("//*[@id=\"hook_Block_PostingFormDropdown\"]/posting-form-dropdown/div/button/span[2]"));
    public static SelenideElement searchField = $(By.xpath("//*[@id=\"toolbar_search\"]/toolbar-search/form/div/label/input"));

    public void getNewsTape(String text) {
        newsTape.shouldHave(text(text));
    }

    public void getPost(String text) {
        post.shouldBe(visible).shouldHave(text(text));
    }
    public void search(String text){
        searchField.setValue(text).pressEnter();
    }
}



