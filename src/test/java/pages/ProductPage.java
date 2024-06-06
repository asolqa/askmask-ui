package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    private final SelenideElement pageTitle = $("#pagetitle"),
                                  priceBlock = $(".prices_block"),
                                  creditOption = $(".podeli_widget");
                                  String productTitle = "Dr. Ceuracle, Крем с витамином С";


    @Step("Checking product details page")
    public void verifyProductPage() {

        pageTitle.shouldHave(text(productTitle));
        priceBlock.shouldBe(visible);
        creditOption.shouldBe(visible);

    }

}
