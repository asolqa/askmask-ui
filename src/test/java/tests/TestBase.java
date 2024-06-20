package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ConfigReader;
import config.WebConfig;
import helpers.Attach;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

  private static final WebConfig WEB_CONFIG = ConfigReader.INSTANCE.webConfig();

  @BeforeAll
  @Step("Configuring environment")
  static void setUpConfig() {

    Configuration.baseUrl = WEB_CONFIG.baseUrl();
    Configuration.browser = WEB_CONFIG.browser();
    Configuration.browserSize = WEB_CONFIG.browserSize();
    Configuration.browserVersion = WEB_CONFIG.browserVersion();
    Configuration.pageLoadStrategy = WEB_CONFIG.pageLoadStrategy();

    if (WEB_CONFIG.isRemoteEnabled()) {
      Configuration.remote = "https://user1:1234@" + WEB_CONFIG.remoteUrl() + "/wd/hub";
    }

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(
        "selenoid:options",
        Map.<String, Object>of(
            "enableVNC", true,
            "enableVideo", true));

    Configuration.browserCapabilities = capabilities;

    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
  }

  @AfterEach
  @Step("Attach data and close environment")
  void attachAndCloseEnv() {
    makeAttachments();
    closeDriver();
  }

  void makeAttachments() {
    Attach.screenshotAs("Last screenshot");
    Attach.pageSource();
    Attach.browserConsoleLogs();
    Attach.addVideo();
  }

  void closeDriver() {
    Selenide.closeWebDriver();
  }
}
