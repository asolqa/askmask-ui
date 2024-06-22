package tests;

import static io.qameta.allure.Allure.step;

import io.qameta.ExtensionForManual.Manual;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Manual tests: future automation")
@Feature("Manual verification")
@Tag("smoke")
public class ManualTests {
    @Test
    @Manual
    @DisplayName("Error on entering incorrect password test")
    @Severity(SeverityLevel.CRITICAL)
    public void unsuccessfulAuthTest() {
        step("Open askmask.ru");
        step("Click on personal area icon in the header");
        step("Switch to 'Вход по логину и паролю' option on appeared form");
        step("Fill field 'Логин' with valid data");
        step("Fill field 'Пароль' with invalid data");
        step("Press button `Войти`");
        step("Verify 'Неверный логин или пароль' appears");
    }
}
