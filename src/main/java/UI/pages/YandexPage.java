package UI.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$x;

public class YandexPage {

    private final SelenideElement yandexMarketLogo = $x("//a[@data-id = 'market']");
    private final SelenideElement yandexLogo = $x("//a[@data-statlog = 'logo.default']");

    @Step("Click on Yandex Market logo")
    public YandexPage clickOnYandexMarketLogo() {
        yandexMarketLogo.click();
        Selenide.switchTo().window(1);
        return this;
    }

    public YandexPage.Verification verification() {
        return new YandexPage.Verification();
    }

    public class Verification {
        private Verification() {
        }

        @Step("Check Yandex main page opened")
        public YandexPage.Verification checkYandexMainPageOpened() {
            Assertions.assertTrue(yandexLogo.isDisplayed(), "Yandex main page is not opened");
            return this;
        }

    }

}
