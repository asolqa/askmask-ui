package tests;

import data.TestData;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AskMaskMainPage;


@Feature("Search")
@Tag("smoke")
public class SearchTests extends TestBase{

    AskMaskMainPage askMaskMainPage = new AskMaskMainPage();

    @DisplayName("Search for bestseller product")
    @Test
    public void searchForProductTest() {

        askMaskMainPage.openPage()
                .setSearchProduct(TestData.PRODUCT)
                .verifyCatalogPageResults()
                .clickOnProduct()
                .verifyProductPage();

    }

    @DisplayName("Search for not presented brand")
    @Test
    public void emptySearchTest() {

        askMaskMainPage.openPage()
                .setWrongSearch(TestData.BRAND)
                .verifyNoBrandAvailable();

    }
}
