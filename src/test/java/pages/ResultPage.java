package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class ResultPage {

  private static final String ERROR_SEARCH = "Сожалеем, но ничего не найдено.";
  private final SelenideElement emptySearch = $(".container");

  @Step("Verify no items were found")
  public void verifyNoBrandAvailable() {
    emptySearch.shouldHave(text(ERROR_SEARCH));
  }
}
