package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultPage {

    private final SelenideElement emptySearch = $(".container");
    private static final String ERROR_SEARCH = "Сожалеем, но ничего не найдено.";

    @Step("Verify no items were found")
    public void verifyNoBrandAvailable() {
        emptySearch.shouldHave(text(ERROR_SEARCH));

    }
}
