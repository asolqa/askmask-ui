package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class ContactPage {
    private static final String CONTACTS_PAGE_TITLE = "Контакты";
    private final SelenideElement pageTitle = $("#pagetitle");
    private final SelenideElement mainBlock = $(".bottom_block");
    private final SelenideElement map = $(".bx-yandex-view-map");
    private final SelenideElement messageButton = $("[data-name=contacts]");

    @Step("Checking contact page has {label} data")
    public ContactPage verifyContactPageData(String label, String expectedValue) {

        pageTitle.shouldHave(text(CONTACTS_PAGE_TITLE));
        mainBlock.shouldHave(text(label));
        mainBlock.shouldHave(text(expectedValue));
        return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    @Step("Checking contact page has a map")
    public ContactPage verifyMapVisibility() {
        map.shouldBe(visible);
        return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    @Step("Checking option to send message is available")
    public ContactPage verifyMessageOption() {
        messageButton.shouldBe(visible);
        return this;
    }
}
