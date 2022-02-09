package UItests;

import UI.base.YandexUIBaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("UI")
@DisplayName("Yandex Market")
public class YandexMarketTest extends YandexUIBaseTest {
    @Test
    @DisplayName("Check search for Lenovo notebooks cost less than 30000 rub")
    @Story("Check search engine")
    public void searchEngineForNotebooksTest() {
        web.market()
                .clickOnSection("Ноутбуки")
                .verification().checkSectionOpened("Ноутбуки");

        web.market()
                .setMaximumPrice(30000)
                .chooseManufacturer("Lenovo")
                .chooseShowBy(12)
                .verification()
                .checkDisplayedItemsCount(12);

        String storedItem = web.market().getShownOnFirstPageItems().get(0);

        web.market()
                .enterTermToSearchField(storedItem)
                .clickSearchButton()
                .clickOnBreadCrumb(storedItem)
                .getShownOnFirstPageItems();

        web.market().openFirstFoundItem()
                .verification().checkFoundNameCorrespondsToTheStoredValue(storedItem);

    }

    @Test
    @DisplayName("Check search for Xiaomi tablets cost between 20000-95000 rub")
    @Story("Check search engine")
    public void searchEngineForTabletsTest() {
        web.market()
                .clickOnSection("Планшеты")
                .verification().checkSectionOpened("Планшеты");

        web.market()
                .setMinimalPrice(20000)
                .setMaximumPrice(95000)
                .chooseManufacturer("Xiaomi")
                .chooseShowBy(12)
                .verification()
                .checkDisplayedItemsCount(12);

        String storedItem = web.market().getShownOnFirstPageItems().get(0);

        web.market()
                .enterTermToSearchField(storedItem)
                .clickSearchButton()
                .clickOnBreadCrumb(storedItem)
                .getShownOnFirstPageItems();

        web.market().openFirstFoundItem()
                .verification().checkFoundNameCorrespondsToTheStoredValue(storedItem);
    }

}
