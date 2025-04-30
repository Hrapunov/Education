package homework;

import Pages.AuthenticationPage;
import Pages.MainPage;
import TestsSetups.AuthenticationTestsSetup;
import TestsSetups.MainTestsSetup;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


public class FirstTests {
    private static final TestBot TEST_BOT = new TestBot("technopol62", "technopolisPassword");
    private static final String SET_SEARCH_FIELD_TEXT = "something";
    private static final String FIND_COUNT_TEXT = "Найдено";
    private static final String SYMBOL_NUMBER = "1";
    private static final String SYMBOLS_NUMBERS = "111111111111111111111111111111111111";
    private static final String REGISTRATION_BUTTON_TEXT = "Зарегистрироваться";
    private static final String REGISTRATION_BUTTON_FIRST_LETTER = "З";
    private static final String REGISTRATION_BUTTON_CONTAINS_TEXT = "арегистрироваться";


    @Nested
    class AuthenticationPageTests extends AuthenticationTestsSetup {

        @Test
        @Tag("authenticationPage")
        @DisplayName("Заход на главную страницу")
        public void loginToMain() {
            MainPage mainPage = new AuthenticationPage().login(TEST_BOT.getLogin(), TEST_BOT.getPassword());
            assertTrue(
            mainPage.getSideMenu().isNewsTapeVisible(),
                    "Не отображается боковое меню с кнопкой ленты"
            );
        }


        @Test
        @Tag("authenticationPage")
        @DisplayName("Текст кнопки регистрации")
        public void registrationButtonOnPage() {
            assertThat(new AuthenticationPage().getRegistrationButtonText())
                    .as("Текст кнопки регистрации")
                    .withFailMessage("Текст кнопки должен быть 'Зарегистрироваться'")
                    .isEqualTo(REGISTRATION_BUTTON_TEXT)
                    .withFailMessage("Текст должен начинаться с 'З'")
                    .startsWith(REGISTRATION_BUTTON_FIRST_LETTER)
                    .withFailMessage("Текст должен содержать 'арегистрироваться'")
                    .contains(REGISTRATION_BUTTON_CONTAINS_TEXT);

        }

        @Test
        @Tag("authenticationPage")
        @DisplayName("Варианты QR")
        public void lookingQR() {
            AuthenticationPage authenticationPage = new AuthenticationPage();
            assertAll(
                    () -> assertTrue(authenticationPage.isQrButtonVisible(), "Нет кнопки QR"),
                    () -> assertTrue(authenticationPage.isEnterWithQrVisible(), "Нет кнопки войти по QR")
            );
        }

        @ParameterizedTest
        @MethodSource("testsBotsStream")
        @Tag("mainPage")
        @DisplayName("Авторизация ботов")
        public void botsLogin(TestBot testbot) {
            MainPage mainPage = new AuthenticationPage().login(testbot.getLogin(), testbot.getPassword());
            assertTrue(
                    mainPage.getSideMenu().isNewsTapeVisible(),
                    "Не отображается боковое меню с кнопкой ленты"
            );
        }

    }


    @Nested
    class MainPageTests extends MainTestsSetup {

        @Test
        @Tag("mainPage")
        @DisplayName("Кнопка опубликовать")
        public void postTest() {
            assertTrue(
                    mainPage.getSideMenu().isPostVisible(),
                    "Кнопка опубликовать не отобразилась"
            );
        }

        @Test
        @Tag("mainPage")
        @DisplayName("Ввод в поле поиска")
        public void lookingOnSite() {
            mainPage.setSearchField(SET_SEARCH_FIELD_TEXT);
            assertTrue(
                    mainPage.isBestMatchesVisible(),
                    "Блок с лучшими совпадениями не отобразился"
            );
        }

        @ParameterizedTest
        @ValueSource(strings = {SYMBOL_NUMBER, SYMBOLS_NUMBERS})
        @Tag("mainPage")
        @DisplayName("Кол-во символов в поле поиска")
        public void searchLengthTest(String length) {
            mainPage.setSearchField(length);
            assertTrue(
                    mainPage.getFindCountText().startsWith(FIND_COUNT_TEXT),
                    "Текст поля не соответствует"
            );
        }

        @Test
        @Tag("mainPage")
        @DisplayName("Форма для поста")
        public void selectionPopup() {
            assertTrue(
                    mainPage.getSideMenu().clickPost()
                            .getPopUp()
                            .popupPublicClick()
                            .isPostingFormVisible(),
                    "Шаблон поста не отобразился"
                );
            }
        }

        @Disabled
        @Test
        void skippedTrue() {
            assertTrue(true);
        }
}