package pages.basket;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Basket_page {
    SelenideElement basketButton() { return $x("//button[@class='ant-btn ant-btn-primary ant-btn-lg" +
            " ant-btn-block ant-btn-dangerous btn--9PFw']");
    }
    SelenideElement tablePrice() {
        return $("span.price--rfMa");
    }
}

