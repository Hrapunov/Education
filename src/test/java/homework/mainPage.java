package homework;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class mainPage {
    public static SelenideElement newsTape = $(By.xpath("//div[@class='tico null']"));
    public static SelenideElement post = $(By.xpath("//button[@class='dropdown-button__qx55h']"));
    public static SelenideElement searchField = $(By.xpath("//input[@name='st.query']"));


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



