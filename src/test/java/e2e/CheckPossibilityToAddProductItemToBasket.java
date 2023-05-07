package e2e;

import api.Auth;
import api.BasketTab;
import api.Sepa;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.UIBaseTest;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;
import static constants.Constant.Url.*;

public class CheckPossibilityToAddProductItemToBasket extends UIBaseTest {
    @Test
    @Step("End-to-end scenario of place order")
    public void CheckPossibilityToPlaceAnOrderTest() {
        open(CATALOG_PAGE);
        catalogLogic.RemoveAllCarTabs();
        open(DASHBOARD_PAGE);
        dashboard.createCardTabViaRegNumber();
        catalogLogic.goToListingThrowCardCatalogItems();
        listingPage.AddRandomProductItemToBasketFromListing();
        open(BASKET_PREVIEW_PAGE);
        basketLogic.CreateOrder();
        open(BASKET_PAYMENT_PAGE);
        basketLogic.CreateOrder();
    }

    @BeforeSuite
    public void BeforeSuite() {
        BasketTab basketTabRequest = new BasketTab();
        Sepa sepa = new Sepa();

        basketTabRequest.DeleteBasketTab(Auth.GetToken());
        String sepa_reference = sepa.SetSepa(Auth.GetToken());
        sepa.Activate_mandat(Auth.GetToken(), sepa_reference);
    }
}
