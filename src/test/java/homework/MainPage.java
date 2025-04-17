package homework;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class MainPage extends SideMenuElements {
    private static final SelenideElement searchField = $(By.xpath("//input[@name='st.query']"));
    private static final SelenideElement bestMatches = $(By.xpath("//div[@class='island_cnt__pyx2y island-content__zdst2']"));
    private static final SelenideElement findCount = $(By.xpath("//h2[@class='heading__h2__unijc']"));

    public static SelenideElement getFindCount() {
        return findCount;
    }

    public static SelenideElement getBestMatches() {
        return bestMatches;
    }

    public void setSearchField (String text){
        searchField.shouldBe(visible).setValue(text).pressEnter();
    }
}



