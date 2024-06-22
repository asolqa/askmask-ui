package pages.components;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class SubscriptionFormComponent {
  private static final String SUBSCRIPTION_FORM_TITLE = "Подписка на рассылку";
  private static final String SUBSCRIBE_ERROR = "Заполните это поле";
  private final SelenideElement subscribeForm = $(".subscribe_frame"),
      subscribeFormTitle = $(".form_head"),
      emailForSubscriptionField = $("[type=email]"),
      submitSubscription = $("[name=web_form_submit]"),
      subscriptionError = $("#POPUP_EMAIL-error"),
      closeSubscription = $(".close");

  @Step("Checking subscription form appears")
  public SubscriptionFormComponent verifySubscriptionForm() {
    subscribeForm.should(appear);
    subscribeFormTitle.shouldHave(text(SUBSCRIPTION_FORM_TITLE));
    emailForSubscriptionField.shouldBe(visible);
    submitSubscription.shouldBe(visible);
    return this;
  }

  @Step("Submit subscription")
  public SubscriptionFormComponent submitSubscription() {
    submitSubscription.shouldBe(visible).click();
    return this;
  }

  @Step("Checking not allowed subscription without email")
  public SubscriptionFormComponent verifySubscriptionError() {
    subscriptionError.shouldHave(text(SUBSCRIBE_ERROR));
    return this;
  }

  @Step("Close subscription form")
  public void closeSubscriptionForm() {
    closeSubscription.shouldBe(visible).click();
    subscribeForm.shouldNotBe(visible);
  }
}
