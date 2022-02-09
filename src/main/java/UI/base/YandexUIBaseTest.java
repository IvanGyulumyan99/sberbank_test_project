package UI.base;

import UI.pagemanager.PageManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class YandexUIBaseTest {
    public PageManager web = new PageManager();

    @BeforeEach
    public void setup() {
        web.driver().browserUp("https://yandex.ru");

        web.yandex()
                .verification().checkYandexMainPageOpened();

        web.yandex()
                .clickOnYandexMarketLogo();

        web.market()
                .verification().checkYandexMarketMainPageOpened();

        web.market()
                .clickOnCatalogueButton()
                .clickOnComputersSection()
                .verification().checkSectionOpened("Компьютеры");

    }

    @AfterEach
    public void tearDown() {
        web.driver().browserTearDown();
    }
}
