package api;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import java.io.File;
import static constants.Constant.Api_routs.*;

public class SignUp {
    public String registerNewLead() {
        String filePath = "src/main/java/json_for_api/sign_up/POSTregisterNewLead.json";
        File jsonFile = new File(filePath);

        String hash_sign_up = RestAssured.
                given()
                .contentType("application/json")
                .body(jsonFile)
                .post(REGISTER_NEW_LEAD)
                .then()
                .statusCode(201)
                .extract()
                .path("data.id");

        return hash_sign_up;
    }

    public Response registerCompanyInformation(String id) {
        String originalString = REGISTER_COMPANY_INFORMATION;
        String linkWithHash = originalString.replace("{hash}", id);

        String filePath = "src/main/java/json_for_api/sign_up/POSTcompanyInformation.json";
        File jsonFile = new File(filePath);

        ValidatableResponse validatableResponse = RestAssured.
                given()
                .contentType("application/json")
                .body(jsonFile)
                .post(linkWithHash)
                .then()
                .statusCode(200);

        return validatableResponse.extract().response();
    }

    public Response registerDeliveryAddress(String id) {
        String originalString = REGISTER_DELIVERY_ADDRESS;
        String linkWithHash = originalString.replace("{hash}", id);

        String filePath = "src/main/java/json_for_api/sign_up/POSTleadAddress.json";
        File jsonFile = new File(filePath);

        ValidatableResponse validatableResponse = RestAssured.
                given()
                .contentType("application/json")
                .body(jsonFile)
                .post(linkWithHash)
                .then()
                .statusCode(200);

        return validatableResponse.extract().response();
    }

    public Response registerContactDetails(String id) {
        String originalString = REGISTER_CONTACT_DETAILS;
        String replacement = id;
        String linkWithHash = originalString.replace("{hash}", id);

        String filePath = "src/main/java/json_for_api/sign_up/POSTcontactDetails.json";
        File jsonFile = new File(filePath);

        ValidatableResponse validatableResponse = RestAssured.
                given()
                .contentType("application/json")
                .body(jsonFile)
                .post(linkWithHash)
                .then()
                .statusCode(200);

        return validatableResponse.extract().response();
    }

        public String registerLeadInAWS(String id) {
            JsonObject jsonBody = new JsonObject();
            jsonBody.addProperty("hash", id);
            jsonBody.addProperty("newPassword", "7djaA36$");
            jsonBody.addProperty("newPasswordConfirm", "7djaA36$");

            Response response = RestAssured
                    .given()
                    .contentType("application/json")
                    .body(jsonBody.toString())
                    .when()
                    .post(REGISTER_LEAD_IN_AWS);

            Object customerIdObj = response
                    .then()
                    .statusCode(200)
                    .extract()
                    .path("data.customerId");

            String customerId;
            if (customerIdObj instanceof Integer) {
                customerId = String.valueOf(customerIdObj);
            } else {
                customerId = (String) customerIdObj;
            }

            return customerId;
        }
}
