package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class CatalogPage {
    private final SelenideElement pageTitle = $("#pagetitle"),
                                  leftMenuBlock = $(".sticky-sidebar__inner"),
                                  filterSections =$(".bx_filter_section"),
                                  productID = $("#bx_3966226736_2081");


    @Step("Checking product in catalog")
    public void verifyCatalogPage() {

        pageTitle.shouldHave(text("Поиск"));
        leftMenuBlock.shouldBe(visible);
        filterSections.shouldBe(visible);
        productID.shouldBe(visible).click();

    }
}
