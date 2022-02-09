package UI.pages;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class YandexMarketPage {

    private final SelenideElement openedItemTitle = $x("//h3");
    private final SelenideElement catalogueButton = $x("//button[@id = 'catalogPopupButton']");
    private final SelenideElement computersSection = $x("//span[text() = 'Компьютеры']");
    private final SelenideElement computersSectionHeaderText = $x("//h1[text() = 'Компьютеры']");
    private final SelenideElement yandexMarketLogo = $x("//a[@id = 'logoPartMarket']");
    private final SelenideElement maximumPriceInputField = $x("//input[@id = 'glpriceto']");
    private final SelenideElement minimalPriceInputField = $x("//input[@id = 'glpricefrom']");
    private final ElementsCollection showBy = $$x("//span[contains(text(), 'Показывать по')]");
    private final SelenideElement headerSearchInputField = $x("//input[@id = 'header-search']");
    private final SelenideElement searchButton = $x("//button[@data-r = 'search-button']");
    private final ElementsCollection allItemsOnPage = $$x("//h3[@data-zone-name = 'title']");

    @Step("Get shown on first page items")
    public List<String> getShownOnFirstPageItems() {
        Selenide.sleep(2000);
        return allItemsOnPage.texts();
    }

    @Step("Open first found item")
    public YandexMarketPage openFirstFoundItem() {
        allItemsOnPage.get(0).click();
        return this;
    }

    @Step("Click search button")
    public YandexMarketPage clickSearchButton() {
        searchButton.click();
        return this;
    }

    @Step("Click on breadcrumb")
    public YandexMarketPage clickOnBreadCrumb(String title) {
        ElementsCollection breadCrumb = $$x(String.format("//div[@data-zone-name = 'breadcrumb']//span[text() = '%s']", title));
        if (breadCrumb.size() > 0) {
            breadCrumb.first().click();
        }
        return this;
    }

    @Step("Enter term to search input field")
    public YandexMarketPage enterTermToSearchField(String term) {
        headerSearchInputField.clear();
        headerSearchInputField.sendKeys(term);
        return this;
    }

    @Step("Choose show by {count}")
    public YandexMarketPage chooseShowBy(int count) {
        Selenide.sleep(2000);
        if (showBy.size() > 0) {
            showBy.first().parent().parent().click();
            $x(String.format("//button[contains(text(), 'Показывать по %s')]", count)).click();
        }
        return this;
    }

    @Step("Choose manufacturer")
    public YandexMarketPage chooseManufacturer(String manufacturer) {
        $x(String.format("//li//input[contains(@name , '%s')]", manufacturer)).parent().click();
        return this;
    }

    @Step("Set maximum price {maximumPrice}")
    public YandexMarketPage setMaximumPrice(int maximumPrice) {
        maximumPriceInputField.clear();
        maximumPriceInputField.sendKeys(String.valueOf(maximumPrice));
        return this;
    }

    @Step("Set minimal price {minimalPrice}")
    public YandexMarketPage setMinimalPrice(int minimalPrice) {
        minimalPriceInputField.clear();
        minimalPriceInputField.sendKeys(String.valueOf(minimalPrice));
        return this;
    }

    @Step("Click on catalogue button")
    public YandexMarketPage clickOnCatalogueButton() {
        catalogueButton.click();
        return this;
    }

    @Step("Click on Computers section")
    public YandexMarketPage clickOnComputersSection() {
        computersSection.click();
        return this;
    }

    @Step("Click on section {section}")
    public YandexMarketPage clickOnSection(String section) {
        $x(String.format("//a[text() = '%s']", section)).click();
        return this;
    }

    public YandexMarketPage.Verification verification() {
        return new YandexMarketPage.Verification();
    }

    public class Verification {
        private Verification() {
        }

        @Step("Check found name corresponds to the stored value")
        public YandexMarketPage.Verification checkFoundNameCorrespondsToTheStoredValue(String stored) {
            Assertions.assertTrue(stored.contains(openedItemTitle.text()), "Expected: " + stored + " not equals to actual: " + openedItemTitle.text());
            return this;
        }

        @Step("Check Yandex Market main page opened")
        public YandexMarketPage.Verification checkYandexMarketMainPageOpened() {
            Assertions.assertTrue(yandexMarketLogo.shouldBe(Condition.visible).isDisplayed()
                    , "Yandex Market logo is not displayed");
            Assertions.assertTrue(WebDriverRunner.url().contains("market.yandex.ru")
                    , "Yandex Market main page is not opened");
            return this;
        }

        @Step("Check items on page are {count}")
        public YandexMarketPage.Verification checkDisplayedItemsCount(int count) {
            Selenide.sleep(3000);
            if (showBy.size() > 0) {
                Assertions.assertTrue(allItemsOnPage.size() <= count, "Items count is: " + count);
            } else {
                Assertions.assertTrue(allItemsOnPage.size() <= 48, "Items count is: " + count);
            }
            return this;
        }

        @Step("Check Notebooks section opened")
        public YandexMarketPage.Verification checkSectionOpened(String section) {
            Assertions.assertTrue($x(String.format("//h1[text() = '%s']", section))
                            .shouldBe(Condition.visible, Duration.ofSeconds(10)).isDisplayed()
                    , section + "section is not opened");
            return this;
        }

    }

}

