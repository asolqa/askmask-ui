package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.SubscriptionFormComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class AskMaskMainPage {
    private final SelenideElement logo =  $(".logo-block"),
                                mainMenu = $(".table-menu"),
                                searchBar = $("#title-search_fixed"),
                                categories = $(".items"),
                                newItems = $("[data-class=catalog_tab_drag]"),
                                saleItems = $("[data-class=sale_drag]"),
                                blogArticles = $("[data-class=blog_drag]"),
                                subscribeButton = $(".subscribe_button"),
                                searchField = $("#title-search-input_fixed"),
                                emptySearch = $(".container");
                                String productTitle = "Dr. Ceuracle, Крем с витамином С";
                                String Brand = "Paula's Choice";


    ContactPage contactPage = new ContactPage();
    SubscriptionFormComponent subscriptionFormComponent = new SubscriptionFormComponent();
    CatalogPage catalogPage = new CatalogPage();
    ProductPage productPage = new ProductPage();

    @Step("Open AskMask main page")
    public AskMaskMainPage openPage() {
        open("/");
        logo.shouldBe(visible);
        return this;
    }

    @Step("Checking elements on main page are loaded")
    public void verifyElementsAreLoaded() {

        mainMenu.shouldHave(text("Успей купить"));
        searchBar.shouldBe(visible);
        categories.shouldBe(visible);
        newItems.shouldHave(text("Новинки"));
        saleItems.shouldHave(text("Акции"));
        blogArticles.shouldHave(text("Последнее в блоге"));

    }
    @Step("Checking officially distributed brands are available in menu")
    public void verifyOfficialDistributionBrandsArePresented() {

        mainMenu.$(byText("Бренды")).hover();
        $(withText("Dr.Ceuracle")).should(Condition.exist);
        $(withText("Blithe")).should(Condition.exist);
        $(withText("Sioris")).should(Condition.exist);
        $(withText("Uteki")).should(Condition.exist);

    }

    @Step("Checking subscription is available")
    public void verifySubscription() {

        subscribeButton.click();
        subscriptionFormComponent.verifySubscriptionForm();
        subscriptionFormComponent.verifySubscriptionError();
        subscriptionFormComponent.verifyNoSubscriptionForm();
    }

    @Step("Checking contacts page contains actual information")
    public void verifyContacts(){

        mainMenu.$(byText("Контакты")).click();
        contactPage.verifyContactPageData();

    }

    @Step("Searching for bestseller product")
    public void verifySearchForProduct() {

        searchField.setValue(productTitle).pressEnter();
        catalogPage.verifyCatalogPage();
        productPage.verifyProductPage();

    }

    @Step("Searching for not presented brand")
    public void verifyNoBrandAvailable() {

        searchField.setValue(Brand).pressEnter();
        emptySearch.shouldHave(text("Сожалеем, но ничего не найдено."));

    }

}
