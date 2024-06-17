package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.AskMaskMainPage;


@Feature("Main Page")
@Tag("smoke")
public class MainPageTests extends TestBase {

    AskMaskMainPage askMaskMainPage = new AskMaskMainPage();

    @DisplayName("Main Page test")
    @Test
    public void mainPageSmokeTest() {

        askMaskMainPage.openPage()
                .verifyMainMenuHotOffers();
        askMaskMainPage.verifySearchBar();
        askMaskMainPage.verifyProductCategories();
        askMaskMainPage.verifyElementsAreLoadedWithCorrectTitles();
    }


    @DisplayName("Official brands test")
    @ParameterizedTest (name = "(Brand {0})")
    @CsvFileSource(resources = "/brands.csv")
    public void officialDistributionBrandsAreShownInMenuTest(String value) {

        askMaskMainPage.openPage()
                .openBrandMenu()
                .verifyOfficialDistributionBrandArePresented(value);
    }
}