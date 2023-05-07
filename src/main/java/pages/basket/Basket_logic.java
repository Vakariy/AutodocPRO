package pages.basket;


import static com.codeborne.selenide.Condition.visible;

public class Basket_logic extends Basket_page {
    public Basket_logic CreateOrder() {
        tablePrice().shouldBe(visible);
        basketButton().click();
        return this;
    }
}