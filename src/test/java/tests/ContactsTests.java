package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AskMaskMainPage;

@Tag("smoke")
@Feature("Contacts")
public class ContactsTests extends TestBase{

    AskMaskMainPage askMaskMainPage = new AskMaskMainPage();

    @DisplayName("Contacts are available test")
    @Test
    public void contactPageContainsActualInfoTest() {

        askMaskMainPage.openPage()
                .clickOnContacts()
                .verifyContactPageData()
                .verifyMapVisibility()
                .verifyMessageOption();

    }

}
