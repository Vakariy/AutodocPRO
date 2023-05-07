package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import java.io.File;
import static constants.Constant.Api_routs.WORKING_HOURS;

public class WorkingHours {
    public Response updateWorkingHours(String token) {
        String filePath = "src/main/java/json_for_api/PUTworkingHours.json";
        File jsonFile = new File(filePath);

        ValidatableResponse validatableResponse = RestAssured.
                given()
                    .header("Authorization", "Bearer " + token)
                    .contentType("application/json")
                    .body(jsonFile)
                    .put(WORKING_HOURS)
                .then()
                    .statusCode(200);

        return validatableResponse.extract().response();
    }
    public Response getWorkingHours(String token) {
        ValidatableResponse validatableResponse = RestAssured.
                given()
                    .header("Authorization", "Bearer " + token)
                    .get(WORKING_HOURS)
                .then()
                    .statusCode(200);
        return validatableResponse.extract().response();
    }
}