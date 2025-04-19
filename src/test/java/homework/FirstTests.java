package homework;

import Pages.AuthenticationPage;
import Pages.MainPage;
import TestsSetups.AuthenticationTestsSetup;
import TestsSetups.MainTestsSetup;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class FirstTests {
    private static final TestBot testBot = new TestBot("technopol62", "technopolisPassword");

    @Nested
    class AuthenticationPageTests extends AuthenticationTestsSetup {

        @Test
        @Tag("authenticationPage")
        @DisplayName("Заход на главную страницу")
        public void loginToMain() {
            AuthenticationPage authenticationPage = new AuthenticationPage();
            MainPage mainPage = authenticationPage.login(testBot.getLogin(), testBot.getPassword());
            assertTrue(
            mainPage.getNewsTape()
            );
        }


        @Test
        @Tag("authenticationPage")
        @DisplayName("Текст кнопки регистрации")
        public void registrationButtonOnPage() {
            AuthenticationPage authenticationPage = new AuthenticationPage();
            assertEquals("Зарегистрироваться", authenticationPage.getRegistrationButtonText());
        }

        @Test
        @Tag("authenticationPage")
        @DisplayName("Варианты QR")
        public void lookingQR() {
            AuthenticationPage authenticationPage = new AuthenticationPage();
            assertAll(
                    authenticationPage::getQrButton,
                    authenticationPage::getEnterWithQR
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
                    mainPage.getPost()
            );
        }

        @Test
        @Tag("mainPage")
        @DisplayName("Ввод в поле поиска")
        public void lookingOnSite() {
            mainPage.setSearchField("something");
            assertTrue(
                    mainPage.getBestMatches()
            );
        }

        @ParameterizedTest
        @ValueSource(strings = {"1", "111111111111111111111111111111111111"})
        @Tag("mainPage")
        @DisplayName("Кол-во символов в поле поиска")
        public void searchLengthTest(String length) {
            mainPage.setSearchField(length);
            assertTrue(
                    mainPage.getFindCountText().startsWith("Найдено")
            );
        }

        @Test
        @Tag("mainPage")
        @DisplayName("Форма для поста")
        public void selectionPopup() {
            assertTrue(
                    mainPage.clickPost()
                            .popupPublicClick()
                            .getPostingForm()
                );
            }
        }

        @Disabled
        @Test
        void skippedTrue() {
            assertTrue(true);
        }
}