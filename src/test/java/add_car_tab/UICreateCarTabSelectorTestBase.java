package add_car_tab;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.UIBaseTest;
import static com.codeborne.selenide.Selenide.open;
import static constants.Constant.Url.DASHBOARD_PAGE;

public class UICreateCarTabSelectorTestBase extends UIBaseTest {
    @Test
    @Step("Create car tab via reg number from dashboard page")
    public void AddCarTabViaRegNumber(){
        open(DASHBOARD_PAGE);
        dashboard.createCardTabViaRegNumber();
        String actual_result = dashboard.getRegNumberActiveCar();
        Assert.assertEquals(actual_result, "Immat.: aj578cf");
    }
}