package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class ProductPage {
  private static final String PRODUCT_PAGE_TITLE = "Dr. Ceuracle, Крем с витамином С";
  private final SelenideElement pageTitle = $("#pagetitle"),
      priceBlock = $(".prices_block"),
      creditOption = $(".podeli_widget");

  @Step("Checking product details page")
  public void verifyProductPage() {
    pageTitle.shouldHave(text(PRODUCT_PAGE_TITLE));
    priceBlock.shouldBe(visible);
    creditOption.shouldBe(visible);
  }
}
