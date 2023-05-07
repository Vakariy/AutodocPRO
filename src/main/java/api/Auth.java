package api;

import com.google.gson.JsonObject;

import static constants.Constant.Api_routs.AUTH_LOGIN;
import static constants.Credentials.Credential.PASSWORD;
import static constants.Credentials.Credential.USER_NAME;
import static io.restassured.RestAssured.given;

public class Auth {
    public static String GetToken() {
        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("login", USER_NAME);
        jsonBody.addProperty("password", PASSWORD);

        return given()
                .contentType("application/json")
                .body(jsonBody.toString())
                .when()
                    .post(AUTH_LOGIN)
                .then()
                    .statusCode(200)
                    .extract()
                    .path("data.token");
    }
}