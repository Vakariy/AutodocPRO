package vehicle_tab;

import io.qameta.allure.Step;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.APIBaseTest;
import java.util.List;
import static org.testng.Assert.assertTrue;

public class APIVehicleTestBaseTab extends APIBaseTest {

    @Test
    @Step("API Delete api/vehicle-tab/number_tab")
    public void TestDeleteAllVehicleTabs() {
        vehicleTab.TabRequest(token);
        List<Integer> tabIds = vehicleTab.GetVehicleTabIds(token);
        assertTrue(tabIds.isEmpty(), "Expected empty list of vehicle tabs");
    }
}
