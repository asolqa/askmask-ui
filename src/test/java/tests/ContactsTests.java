package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.AskMaskMainPage;

@DisplayName("Contacts tests")
@Feature("Contacts")
@Tag("smoke")
public class ContactsTests extends TestBase {

  AskMaskMainPage askMaskMainPage = new AskMaskMainPage();

  @DisplayName("Contacts are available test")
  @Severity(SeverityLevel.CRITICAL)
  @ParameterizedTest(name = "(Item {0})")
  @CsvFileSource(resources = "/contacts.csv")
  public void contactPageContainsActualInfoTest(String label, String expectedValue) {

    askMaskMainPage
        .openPage()
        .clickOnContacts()
        .verifyContactPageData(label, expectedValue)
        .verifyMapVisibility()
        .verifyMessageOption();
  }
}
