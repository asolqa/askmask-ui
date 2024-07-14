package tests;

import data.TestData;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AskMaskMainPage;

@DisplayName("Search tests")
@Feature("Search")
public class SearchTests extends TestBase {

    AskMaskMainPage askMaskMainPage = new AskMaskMainPage();

    @DisplayName("Search for bestseller product")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void searchForProductTest() {

        askMaskMainPage
                .openPage()
                .setSearchProduct(TestData.PRODUCT)
                .verifyCatalogPageResults()
                .clickOnProduct()
                .verifyProductPage();
    }

    @DisplayName("Search for not presented brand")
    @Test
    @Severity(SeverityLevel.NORMAL)
    public void emptySearchTest() {
        askMaskMainPage
                .openPage()
                .setWrongSearch(TestData.BRAND)
                .verifyNoBrandAvailable();
    }
}
