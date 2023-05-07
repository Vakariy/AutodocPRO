package catalog;

import base.UIBaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static constants.Constant.Url.CATALOG_PAGE;

public class UICatalogSideBar extends UIBaseTest {
    @Test
    public void CatalogSideBarTest() {
        open(CATALOG_PAGE);
        catalogLogic.RemoveAllCarTabs();
        catalogLogic.clickRandomCatalogItem();
    }
}