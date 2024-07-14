package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AskMaskMainPage;

@DisplayName("Subscription tests")
@Feature("Subscription")
public class SubscriptionTests extends TestBase {

    AskMaskMainPage askMaskMainPage = new AskMaskMainPage();

    @DisplayName("Subscription form test")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void subscriptionAvailableTest() {

        askMaskMainPage
                .openPage()
                .clickOnSubscribeButton()
                .verifySubscriptionForm()
                .closeSubscriptionForm();
    }

    @DisplayName("Subscription is not available without email test")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void subscriptionErrorTest() {

        askMaskMainPage
                .openPage()
                .clickOnSubscribeButton()
                .submitSubscription()
                .verifySubscriptionError()
                .closeSubscriptionForm();
    }
}
