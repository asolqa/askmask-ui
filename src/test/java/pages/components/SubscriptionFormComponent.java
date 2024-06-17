package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class SubscriptionFormComponent {
        private final SelenideElement subscribeForm = $(".subscribe_frame"),
                                      subscribeFormTitle = $(".form_head"),
                                      emailForSubscriptionField = $("[type=email]"),
                                      submitSubscription = $("[name=web_form_submit]"),
                                      subscriptionError = $("#POPUP_EMAIL-error"),
                                      closeSubscription =$(".close");


    @SuppressWarnings("UnusedReturnValue")
    @Step("Checking subscription form appears")
    public SubscriptionFormComponent verifySubscriptionForm() {

        subscribeForm.should(appear);
        subscribeFormTitle.shouldHave(text("Подписка на рассылку"));
        emailForSubscriptionField.shouldBe(visible);
        submitSubscription.shouldBe(visible);
        return this;

    }

    @Step("Submit subscription")
    public SubscriptionFormComponent submitSubscription(){
        submitSubscription.shouldBe(visible).click();
        return this;
    }

    @Step("Checking not allowed subscription without email")
        public SubscriptionFormComponent verifySubscriptionError() {

        //submitSubscription.shouldBe(visible).click();
        subscriptionError.shouldHave(text("Заполните это поле"));
        return this;

    }

    @Step("Close subscription form")
    public void closeSubscriptionForm(){
        closeSubscription.shouldBe(visible).click();
        subscribeForm.shouldNotBe(visible);
    }

    /*@Step("Checking no subscription form is visible")
        public void verifyNoSubscriptionForm() {

        //closeSubscription.shouldBe(visible).click();
        subscribeForm.shouldNotBe(visible);

    }*/
}
