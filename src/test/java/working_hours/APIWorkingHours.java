package working_hours;

import api.WorkingHours;
import base.APIBaseTest;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class APIWorkingHours extends APIBaseTest {

    String filePath = "src/main/java/json_for_api/GETworkingHours.json";
    @Test
    @Step("API Put api/settings/working-hours")
    public void TestWorkingHours() throws IOException {
        workingHours.updateWorkingHours(token);
        workingHours.getWorkingHours(token);

        String expected = new String(Files.readAllBytes(Paths.get(filePath)));
        String actual = workingHours.getWorkingHours(token).getBody().asString();

        JsonObject expectedJson = JsonParser.parseString(expected).getAsJsonObject();
        JsonObject actualJson = JsonParser.parseString(actual).getAsJsonObject();

        Assert.assertEquals(actualJson, expectedJson);
    }
}
