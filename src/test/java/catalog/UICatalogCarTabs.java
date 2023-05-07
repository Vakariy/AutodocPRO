package catalog;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.UIBaseTest;

import static com.codeborne.selenide.Selenide.open;
import static constants.Constant.Url.CATALOG_PAGE;

public class UICatalogCarTabs extends UIBaseTest {
    @Test
    public void DeleteAllCarTabs() {
        open(CATALOG_PAGE);
        int actual_result_quantity_tab = catalogLogic.RemoveAllCarTabs();
        Assert.assertEquals(actual_result_quantity_tab, 0);
    }
}
