package catalog;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.UIBaseTest;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static constants.Constant.Url.CATALOG_PAGE;

public class UIGraphicCatalog extends UIBaseTest {
    //Add car tab via dashboard page -> go throw all catalog items by random way -> we are on listing
    @Test
    public void CheckGoingToListingTest() {
        open(CATALOG_PAGE);
        catalogLogic.RemoveAllCarTabs();
        dashboard.createCardTabViaRegNumber();
        catalogLogic.goToListingThrowCardCatalogItems();
        $x("//aside[@class='sub-category-details-sidebar--o7FE']").shouldBe(visible);
    }
}