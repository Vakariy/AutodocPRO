package authorization;

import base.UIBaseTest;
import io.qameta.allure.Step;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class UIBaseTestAuthorization extends UIBaseTest {
    @Step("User log in")
    public void testLogin() {
        signInpage
                .InputLogin()
                .InputPassword()
                .ClickLoginButton();
        $(".wrapper-node--OPTE")
                .shouldBe(visible);
    }
}