package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class ProductPage {
    private static final String PRODUCT_PAGE_TITLE = "Dr. Ceuracle, Крем с витамином С";
    private static final String BUY_OPTION_TITLE = "В корзину";
    private final SelenideElement pageTitle = $("#pagetitle");
    private final SelenideElement priceBlock = $(".prices_block");
    private final SelenideElement buyBlock = $(".buy_block");

    @Step("Checking product details page")
    public void verifyProductPage() {
        pageTitle.shouldHave(text(PRODUCT_PAGE_TITLE));
        priceBlock.shouldBe(visible);
        buyBlock.shouldHave(text(BUY_OPTION_TITLE));
    }
}
