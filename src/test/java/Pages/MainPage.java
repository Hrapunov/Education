package Pages;

import PagesElements.PopUp;
import PagesElements.SideMenuElements;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage extends LoadableComponent<MainPage> {
    private static final By SEARCH_FIELD = By.xpath(".//*[@name='st.query']");
    private static final By BEST_MARCHES = By.xpath(".//div[contains(@class, 'island')]");
    private static final By FIND_COUNT = By.xpath(".//div[contains(@class, 'island_header')]");
    private static final By SIDE_MENU_ROOT = By.xpath(".//*[@id='hook_Block_AsideColumn']");
    private static final By POPUP = By.xpath(".//div[contains(@class, 'dropdown-list')]");
    private static final By POSTING_FORM = By.xpath(".//div[contains(@class, 'posting')]");
    private static final String BASIC_URL = "https://ok.ru/";

    @Override
    public void load() {
        open(BASIC_URL);
    }

    @Override
    protected void isLoaded() throws Error {
        $(SIDE_MENU_ROOT).shouldBe(visible.because("Боковое меню не отобразилось"));
    }

    public SideMenuElements getSideMenu() {
        $(SIDE_MENU_ROOT).shouldBe(visible.because("Не отображается боковое меню"));
        return new SideMenuElements($(SIDE_MENU_ROOT));
    }

    public PopUp getPopUp() {
        $(POPUP).shouldBe(visible.because("Не отображается попап"));
        return new PopUp($(POPUP));
    }

    public String getFindCountText() {
        return $(FIND_COUNT).shouldBe(visible.because("Остров с подходящими результатами не отображается")).getText();
    }

    public boolean isBestMatchesVisible() {
        return $(BEST_MARCHES).shouldBe(visible.because("Не отображаются результаты")).isDisplayed();
    }

    public void setSearchField (String text){
        $(SEARCH_FIELD).shouldBe(visible.because("Не отображается поле поиска")).setValue(text).pressEnter();
    }

    public boolean isPostingFormVisible(){
        return $(POSTING_FORM).shouldBe(visible.because("Форма для поста не отображается")).isDisplayed();

    }
}




