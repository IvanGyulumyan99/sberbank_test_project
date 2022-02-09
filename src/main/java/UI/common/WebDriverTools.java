package UI.common;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebDriver;

public class WebDriverTools {
    private static WebDriver webDriver;

    public WebDriver browserUp(String url) {
        Configuration.browser = "chrome";
        Configuration.timeout = 30 * 1000;
        Configuration.screenshots = true;
        Configuration.startMaximized = true;
        Selenide.open(url);
        return webDriver;
    }

    public void browserTearDown() {
        Selenide.close();
    }
}
