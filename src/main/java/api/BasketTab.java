package api;
import java.util.List;

import static constants.Constant.Api_routs.*;
import static io.restassured.RestAssured.given;

public class BasketTab {
    public void DeleteBasketTab(String token) {
        given()
                .header("Authorization", "Bearer " + token)
                .when()
                    .get(BASKET)
                .then()
                    .statusCode(200)
                    .extract()
                    .response()
                    .jsonPath()
                    .getList("data.tabs.id")
                    .forEach(tabId ->
                        given()
                                .header("Authorization", "Bearer " + token)
                                .when()
                                .delete(BASKET_TAB + tabId)
                                .then()
                                    .statusCode(204));
    }
    public List<Integer> GetBasketTabIds(String token) {
        return given()
                .header("Authorization", "Bearer " + token)
                .when()
                    .get(BASKET)
                .then()
                    .statusCode(200)
                    .extract()
                    .response()
                    .jsonPath()
                    .getList("data.tabs.id");
    }
}