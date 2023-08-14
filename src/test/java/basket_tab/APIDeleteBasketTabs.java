package basket_tab;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.APIBaseTest;
import java.util.List;

import static org.testng.Assert.assertTrue;


public class APIDeleteBasketTabs extends APIBaseTest {
    @Test
    public void TestBasket(){
        basketTab.DeleteBasketTab(token);
        List<Integer> tabIds = basketTab.GetBasketTabIds(token);
        assertTrue(tabIds.isEmpty(), "Expected empty list of vehicle tabs");
    }
}