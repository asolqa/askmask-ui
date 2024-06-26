package helpers;

import static com.codeborne.selenide.Selenide.sessionId;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;

import com.codeborne.selenide.Selenide;
import config.ConfigReader;
import config.WebConfig;
import io.qameta.allure.Attachment;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

@SuppressWarnings("UnusedReturnValue")
public class Attach {

    private static final WebConfig WEB_CONFIG = ConfigReader.INSTANCE.webConfig();

    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] screenshotAs(@SuppressWarnings("unused") String attachName) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page source", type = "text/plain")
    public static byte[] pageSource() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "{attachName}", type = "text/plain")
    public static String attachAsText(@SuppressWarnings("unused") String attachName, String message) {
        return message;
    }

    public static void browserConsoleLogs() {
        attachAsText("Browser console logs", String.join("\n", Selenide.getWebDriverLogs(BROWSER)));
    }

    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String addVideo() {
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + getVideoUrl()
                + "'type='video/mp4'></video></body></html>";
    }

    public static URL getVideoUrl() {

        String videoUrl = "https://" + WEB_CONFIG.remoteUrl() + "/video/" + sessionId() + ".mp4";

        try {
            return new URL(videoUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
