package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AskMaskMainPage;

@Feature("Smoke Tests")
@Tag("smoke")
public class AskMaskTests extends TestBase {

    AskMaskMainPage askMaskMainPage = new AskMaskMainPage();

    @DisplayName("Main Page test")
    @Test
    public void mainPageElementsTest() {

        askMaskMainPage.openPage()
                .verifyElementsAreLoaded();
    }

    @DisplayName("Official brands test")
    @Test
    public void officialDistributionBrandsAreShownInMenuTest() {

        askMaskMainPage.openPage()
                .verifyOfficialDistributionBrandsArePresented();

    }

    @DisplayName("Contact Page test")
    @Test
    public void contactPageContainsActualInfoTest() {

        askMaskMainPage.openPage()
                .verifyContacts();
    }

    @DisplayName("Subscription test")
    @Test
    public void subscriptionAvailableTest() {

        askMaskMainPage.openPage()
                .verifySubscription();
    }

    @DisplayName("Search product test")
    @Test
    public void searchForProductTest() {

        askMaskMainPage.openPage()
                .verifySearchForProduct();

    }

    @DisplayName("Empty search test")
    @Test
    public void searchForNotAvailableProductsTest() {

        askMaskMainPage.openPage()
                .verifyNoBrandAvailable();

    }
}