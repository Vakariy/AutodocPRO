package api;

import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import java.io.File;
import static constants.Constant.Api_routs.*;

public class BasketProduct {
        public void AddProduct(String token, String filePath) {
            File jsonFile = new File(filePath);
            RestAssured.given()
                    .header("Authorization", "Bearer " + token)
                    .contentType("application/json")
                    .body(jsonFile)
                    .post(BASKET_PRODUCT)
                    .then()
                        .statusCode(204);
        }
        @DataProvider(name = "BasketProducts")
        public Object[][] BasketProducts() {
            return new Object[][]{
                    {"src/main/java/json_for_api/POSTbasketProduct.json"},
                    {"src/main/java/json_for_api/POSTbasketProduct2.json"}
            };
        }
    }

