package api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.response.Response;

import static constants.Constant.Api_routs.SEPA;
import static constants.Credentials.Credential.*;
import static io.restassured.RestAssured.given;

public class Sepa {
    public String SetSepa(String token) {
        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("alias", ALIAS);
        jsonBody.addProperty("iban", IBAN);
        jsonBody.addProperty("bic", BIC);
        String mandat_reference =
                given()
                    .header("Authorization", "Bearer " + token)
                    .contentType("application/json")
                    .body(jsonBody.toString())
                .when()
                    .post(SEPA)
                .then()
                    .statusCode(201)
                    .extract()
                    .path("data.reference");
        return mandat_reference;
    }
    public String Activate_mandat(String token, String mandat_reference){
        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("reference", mandat_reference);
        jsonBody.addProperty("setDefaultPaymentMethod", true);
        String reference =
                given()
                    .header("Authorization", "Bearer " + token)
                    .contentType("application/json")
                    .body(jsonBody.toString())
                .when()
                    .patch(SEPA)
                .then()
                    .statusCode(200)
                    .extract()
                    .path("data.reference");

        return reference;
    }
    public JsonObject GetSepa(String token) {
        Response response =
                given()
                    .header("Authorization", "Bearer " + token)
                .when()
                    .get(SEPA)
                .then()
                    .statusCode(200)
                    .extract()
                    .response();

        JsonObject json = new JsonObject();
        json.addProperty("alias", (String) response.path("data.alias"));
        json.addProperty("iban", (String) response.path("data.iban"));
        json.addProperty("bic", (String) response.path("data.bic"));
        json.addProperty("reference", (String) response.path("data.reference"));

        return json;
    }
    public JsonObject NegativeCaseSetEmpty(String token) {
        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("alias", "");
        jsonBody.addProperty("iban", "");
        jsonBody.addProperty("bic", "");

        Response response =
                (Response) given()
                    .header("Authorization", "Bearer " + token)
                    .contentType("application/json")
                    .body(jsonBody.toString())
                .when()
                    .post(SEPA)
                .then()
                    .statusCode(422)
                    .extract();
        return JsonParser.parseString(response.body().asString()).getAsJsonObject();
    }
}