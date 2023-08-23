package api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;

import static constants.Constant.Api_routs.AUTH_COWIN;
import static io.restassured.RestAssured.given;

public class Cowin {
    protected int propertyValue2;
    protected String propertyName2;
    protected int propertyId2;
    protected int responseCustomerId;
    protected int propertyId1;
    protected int managerId = 15919;
    protected int b2bType;
    protected String companyName;
    protected String companyRegNumber;
    protected int customerType;
    protected String vatNumber;
    protected String created;
    protected String propertyName1;
    protected String id;
    protected int propertyValue1;
    protected boolean isTest;
    public String loginCowin() {
        String filePath = "src/main/java/json_for_api/cowin/login.json";
        File jsonFile = new File(filePath);

        String hash_sign_up = RestAssured.
                given()
                .contentType("application/json")
                .body(jsonFile)
                .post(AUTH_COWIN)
                .then()
                .statusCode(200)
                .extract()
                .path("data.access_token");

        return hash_sign_up;
    }

    public void getInfoByCustomerId(int customerId, String tokenCowin) {
    String linkGetByCustomerId = "https://apis.cowin.autodoc.de/api/customer/b2b-verification-form-info?customerId="
            + customerId + "&status=&customerType=&employees=&salesPerDay=&turnoverMonth=&fleet=&autolift=&vatConfirmed=" +
            "&vatPayer=&customerB2bType=&country=&project=&dateFrom=&dateTo=&perPage=20&page=1";

        //Get user info from COWIN and save need info for confirmation
        Response response =
                given()
                        .header("Authorization", "Bearer " + tokenCowin)
                        .when()
                        .get(linkGetByCustomerId);

        JsonPath jsonPath = response.jsonPath();

        responseCustomerId = jsonPath.getInt("data.results[0].customerId");
        b2bType = jsonPath.getInt("data.results[0].b2bType");
        customerType = jsonPath.getInt("data.results[0].customerType");

        propertyId1 = jsonPath.getInt("data.results[0].properties[0].propertyId");
        propertyName1 = jsonPath.get("data.results[0].properties[0].propertyName");
        propertyValue1 = jsonPath.getInt("data.results[0].properties[0].propertyValue");

        propertyId2 = jsonPath.getInt("data.results[0].properties[1].propertyId");
        propertyName2 = jsonPath.get("data.results[0].properties[1].propertyName");
        propertyValue2 = jsonPath.getInt("data.results[0].properties[1].propertyValue");

        companyName = jsonPath.get("data.results[0].companyName");
        companyRegNumber = jsonPath.get("data.results[0].companyRegNumber");
        vatNumber = jsonPath.get("data.results[0].vatNumber");
        isTest = jsonPath.get("data.results[0].isTest");
        created = jsonPath.get("data.results[0].created");
        id = "1_" + vatNumber + "_null_" + customerId;
    }

    public void postConfirmationCustomerCowin(int customerId, String tokenCowin) {
        String linkGetByCustomerId = "https://apis.cowin.autodoc.de/api/customer/b2b-verification-form-info?customerId="
                + customerId + "&status=&customerType=&employees=&salesPerDay=&turnoverMonth=&fleet=&autolift=&vatConfirmed=" +
                "&vatPayer=&customerB2bType=&country=&project=&dateFrom=&dateTo=&perPage=20&page=1";

        JsonObject property1 = new JsonObject();
        property1.addProperty("propertyId", propertyId1);
        property1.addProperty("propertyName", propertyName1);
        property1.addProperty("propertyValue", propertyValue1);

        JsonObject property2 = new JsonObject();
        property2.addProperty("propertyId", propertyId2);
        property2.addProperty("propertyName", propertyName2);
        property2.addProperty("propertyValue", propertyValue2);

        JsonArray propertiesArray = new JsonArray();
        propertiesArray.add(property1);
        propertiesArray.add(property2);

        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("adminPage", true);
        jsonBody.addProperty("id", id);
        jsonBody.addProperty("customerId", customerId);
        jsonBody.addProperty("companyName", companyName);
        jsonBody.addProperty("projectId", (Boolean) null);
        jsonBody.addProperty("projectName", "pro_fr");
        jsonBody.addProperty("countryName", "FR");
        jsonBody.addProperty("companyRegNumber", vatNumber);
        jsonBody.addProperty("statusId", 4);
        jsonBody.addProperty("contactPhone", "200+002");
        jsonBody.addProperty("customerType", customerType);
        jsonBody.addProperty("isB2B", false);
        jsonBody.add("properties", propertiesArray);
        jsonBody.addProperty("status", "Confirmed");
        jsonBody.addProperty("vatNumber", vatNumber);
        jsonBody.addProperty("creationDate", created);
        jsonBody.addProperty("isTest", false);
        jsonBody.addProperty("comment", "");
        jsonBody.addProperty("countryId", "");
        jsonBody.addProperty("postCode", "");
        jsonBody.addProperty("street", "");
        jsonBody.addProperty("city", "");
        jsonBody.addProperty("house", "");
        jsonBody.addProperty("confirmBilling", false);
        jsonBody.addProperty("vatConfirmed", 1);
        jsonBody.addProperty("vatPayer", 0);
        jsonBody.addProperty("managerId", managerId);
        jsonBody.addProperty("b2bType", b2bType);

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + tokenCowin)
                .contentType("application/json")
                .body(jsonBody.toString())
                .post(linkGetByCustomerId);
    }
}