package UI.pagemanager;

import UI.common.WebDriverTools;
import UI.pages.YandexMarketPage;
import UI.pages.YandexPage;

public class PageManager {
    private final YandexMarketPage yandexMarketPage = new YandexMarketPage();
    private final YandexPage yandexPage = new YandexPage();
    private final WebDriverTools webDriverTools = new WebDriverTools();

    public YandexMarketPage market() {
        return yandexMarketPage;
    }

    public YandexPage yandex() {
        return yandexPage;
    }

    public WebDriverTools driver() {
        return webDriverTools;
    }

}
