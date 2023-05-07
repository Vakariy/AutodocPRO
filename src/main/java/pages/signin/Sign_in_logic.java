package pages.signin;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static constants.Credentials.Credential.*;


public class Sign_in_logic extends Sign_in_page {
    public Sign_in_logic InputLogin(){
        $(loginInput()).setValue(USER_NAME);
        return this;
    }

    public Sign_in_logic InputPassword(){
        $(passwordInput()).setValue(PASSWORD);
        return this;
    }

    public Sign_in_logic ClickLoginButton(){
        $(signInButton())
                .shouldBe(visible)
                .click();
        return this;
    }
}