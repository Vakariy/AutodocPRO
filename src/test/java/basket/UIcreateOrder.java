package basket;

import api.Auth;
import api.BasketProduct;
import api.BasketTab;
import api.Sepa;
import base.UIBaseTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static constants.Constant.Url.BASKET_PAYMENT_PAGE;
import static constants.Constant.Url.BASKET_PREVIEW_PAGE;

public class UIcreateOrder extends UIBaseTest {
    @Test
    public void CreateOrder(){
        open(BASKET_PREVIEW_PAGE);
        basketLogic.CreateOrder();
        open(BASKET_PAYMENT_PAGE);
        basketLogic.CreateOrder();
    }
    @BeforeSuite
    public void BeforeSuite() {
        BasketTab basketTabRequest = new BasketTab();
        Sepa sepa = new Sepa();
        BasketProduct basketProduct = new BasketProduct();

        basketTabRequest.DeleteBasketTab(Auth.GetToken());
        basketProduct.AddProduct(Auth.GetToken(), "src/main/java/json_for_api/POSTbasketProduct.json");

        String sepa_reference = sepa.SetSepa(Auth.GetToken());
        sepa.Activate_mandat(Auth.GetToken(), sepa_reference);
    }
}