package api;
import java.util.List;

import static constants.Constant.Api_routs.VEHICLE_TAB;
import static io.restassured.RestAssured.given;

public class VehicleTab {
    public void TabRequest(String token) {
        given()
                .header("Authorization", "Bearer " + token)
                .when()
                    .get(VEHICLE_TAB)
                .then()
                    .statusCode(200)
                    .extract()
                    .response()
                    .jsonPath()
                    .getList("data.items.id")
                .forEach(tabId ->
                        given()
                                    .header("Authorization", "Bearer " + token)
                                .when()
                                    .delete(VEHICLE_TAB + tabId)
                                .then()
                                    .statusCode(204));
    }
    public List<Integer> GetVehicleTabIds(String token) {
        return given()
                    .header("Authorization", "Bearer " + token)
                .when()
                    .get(VEHICLE_TAB)
                .then()
                    .statusCode(200)
                    .extract()
                    .response()
                    .jsonPath()
                    .getList("data.items.id");
    }
}