package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ContactPage {
    private final SelenideElement pageTitle = $("#pagetitle"),
                                  mainBlock = $(".bottom_block"),
                                  map = $(".bx-yandex-view-map");


    @Step("Checking contact page has data and map")
    public void verifyContactPageData() {

        pageTitle.shouldHave(text("Контакты"));
        mainBlock.shouldHave(text("Режим работы"));
        mainBlock.shouldHave(text("с 10.00 до 19.00"));
        mainBlock.shouldHave(text("Телефон"));
        mainBlock.shouldHave(text("+7 (495) 185-04-22"));
        mainBlock.shouldHave(text("E-mail"));
        mainBlock.shouldHave(text("ask@askmask.ru"));
        map.shouldBe(visible);

    }
}