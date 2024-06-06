package tests;

import io.qameta.allure.Manual;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class ManualTest {
    @Test
    @Manual
    @DisplayName("Unsuccessful auth: Entering incorrect password")
    public void unsuccessfulAuth() {
        step("Open askmask.ru");
        step("Enter `Вход` in header");
        step("Enter field 'Email' with valid data");
        step("Enter field 'Пароль' with invalid data ");
        step("Press button `Войти`");
        step("Verify 'Неверный логин или пароль' appears");
    }
}
