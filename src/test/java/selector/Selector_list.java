package selector;

import base.UIBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class Selector_list extends UIBaseTest {
    @Test
    public void clickCarModel() {
        dashboard.clickFirstCarModel();
        try {
            dashboardPage.modalBody().shouldBe(visible);
            System.out.println("modalBody visible");
        } catch (AssertionError e) {
            catalogPage.breadcrumbs().shouldBe(visible);
            System.out.println("breadcrumbs visible");
        }

        Assert.assertTrue(dashboardPage.modalBody().isDisplayed() || catalogPage.breadcrumbs().isDisplayed(),
                "error");
    }

}
