package Pages;

import com.codeborne.selenide.SelenideElement;
import PagesElements.SideMenuElements;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends SideMenuElements {
    private static final SelenideElement searchField = $(By.xpath(".//*[@name='st.query']"));
    private static final SelenideElement bestMatches = $(By.xpath(".//div[contains(@class, 'island')]"));
    private static final SelenideElement findCount = $(By.xpath(".//div[contains(@class, 'island_header')]"));

    public String getFindCountText() {
        return $(findCount).shouldBe(visible.because("Остров с подходящими результатами не отображается")).getText();
    }

    public boolean getBestMatches() {
        return $(bestMatches).shouldBe(visible.because("Не отображаются результаты")).isDisplayed();
    }

    public void setSearchField (String text){
        $(searchField).shouldBe(visible.because("Не отображается поле поиска")).setValue(text).pressEnter();
    }
}



