package basket;

import api.BasketProduct;
import base.APIBaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class APIaddProduct extends APIBaseTest {

    @Test(dataProvider = "BasketProducts", dataProviderClass = BasketProduct.class)
    public void TestBasketProduct(String filePath) {
        basketProduct.AddProduct(token, filePath);
    }
}