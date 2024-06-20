package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.SubscriptionFormComponent;

public class AskMaskMainPage {
  private static final String HOT_OFFERS = "Успей купить";
  private static final String NEW_ITEMS = "Новинки";
  private static final String SALE_ITEMS = "Акции";
  private static final String BLOG_LATEST = "Последнее в блоге";
  private static final String BRAND_MENU_ITEM = "Бренды";
  private static final String CONTACTS_MENU_ITEM = "Контакты";
  private final SelenideElement logo = $(".logo-block"),
      mainMenu = $(".table-menu"),
      searchBar = $("#title-search_fixed"),
      categories = $(".items"),
      newItems = $("[data-class=catalog_tab_drag]"),
      saleItems = $("[data-class=sale_drag]"),
      blogArticles = $("[data-class=blog_drag]"),
      subscribeButton = $(".subscribe_button"),
      searchField = $("#title-search-input_fixed");

  @Step("Open AskMask main page")
  public AskMaskMainPage openPage() {
    open("/");
    logo.shouldBe(visible);
    return this;
  }

  @Step("Checking main menu contains hot offers is available")
  public void verifyMainMenuHotOffers() {
    mainMenu.shouldBe(visible);
    mainMenu.shouldHave(text(HOT_OFFERS));
  }

  @Step("Checking search bar is available")
  public void verifySearchBar() {
    searchBar.shouldBe(visible);
  }

  @Step("Checking categories are available")
  public void verifyProductCategories() {
    categories.shouldBe(visible);
  }

  @Step("Checking elements on main page are loaded")
  public void verifyElementsAreLoadedWithCorrectTitles() {
    newItems.shouldHave(text(NEW_ITEMS));
    saleItems.shouldHave(text(SALE_ITEMS));
    blogArticles.shouldHave(text(BLOG_LATEST));
  }

  @Step("Open brand menu")
  public AskMaskMainPage openBrandMenu() {
    mainMenu.$(byText(BRAND_MENU_ITEM)).hover();
    return this;
  }

  @Step("Checking officially distributed {value} is available in menu")
  public void verifyOfficialDistributionBrandArePresented(String value) {
    $(withText(value)).should(Condition.exist);
  }

  @Step("Click on Subscription")
  public SubscriptionFormComponent clickOnSubscribeButton() {
    subscribeButton.click();
    return page(SubscriptionFormComponent.class);
  }

  @Step("Open contacts")
  public ContactPage clickOnContacts() {
    mainMenu.$(byText(CONTACTS_MENU_ITEM)).click();
    return page(ContactPage.class);
  }

  @Step("Set search for product")
  public CatalogPage setSearchProduct(String product) {
    searchField.setValue(product).pressEnter();
    return page(CatalogPage.class);
  }

  @Step("Set search for not presented brand")
  public ResultPage setWrongSearch(String brand) {
    searchField.setValue(brand).pressEnter();
    return page(ResultPage.class);
  }
}
