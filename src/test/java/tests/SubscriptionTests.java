package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AskMaskMainPage;

@Feature("Subscription")
@Tag("smoke")
public class SubscriptionTests extends TestBase {

    AskMaskMainPage askMaskMainPage = new AskMaskMainPage();
    @DisplayName("Subscription form test")
    @Test
    public void subscriptionAvailableTest() {

        askMaskMainPage.openPage()
                .clickOnSubscribeButton()
                .verifySubscriptionForm()
                .closeSubscriptionForm();

    }

    @DisplayName("Subscription is not available without email test")
    @Test
    public void subscriptionErrorTest() {

        askMaskMainPage.openPage()
                .clickOnSubscribeButton()
                .submitSubscription()
                .verifySubscriptionError()
                .closeSubscriptionForm();
    }

}
