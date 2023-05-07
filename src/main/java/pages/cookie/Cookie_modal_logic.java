package pages.cookie;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class Cookie_modal_logic extends Cookie_modal_page {
    public Cookie_modal_logic acceptAllCookieClick() {
        acceptAllCookieButton().shouldBe(visible).click();
        return this;
    }
    public String getTextFR() {
        return textFR().shouldBe(visible).getText();
    }
}