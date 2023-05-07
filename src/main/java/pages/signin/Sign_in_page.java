package pages.signin;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class Sign_in_page {
    SelenideElement loginInput() { return $("[name='login']"); }
    SelenideElement signInButton() { return $x("//button[@data-test-id='signin-btn-access']"); }
    SelenideElement passwordInput() { return $("[name='password']"); }
}