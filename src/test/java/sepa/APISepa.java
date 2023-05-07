package sepa;

import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.APIBaseTest;

import static constants.Credentials.Credential.*;

public class APISepa extends APIBaseTest {

    @Test
    public void TestSepa() {
        sepa.SetSepa(token);
        String mandat_reference = sepa.Activate_mandat(token, sepa.SetSepa(token));
        JsonObject sepaData = sepa.GetSepa(token);
        String alias = sepaData.get("alias").getAsString();
        String iban = sepaData.get("iban").getAsString();
        String bic = sepaData.get("bic").getAsString();
        String reference = sepaData.get("reference").getAsString();
        Assert.assertEquals(ALIAS, alias);
        Assert.assertEquals(IBAN, iban);
        Assert.assertEquals(BIC, bic);
        Assert.assertEquals(mandat_reference, reference);
    }

    @Test
    public void TestEmptySepa(){
        JsonObject response = sepa.NegativeCaseSetEmpty(token);
        Assert.assertEquals(response.get("error").getAsJsonObject().get("errors").getAsJsonObject().get("alias")
                .getAsJsonObject().get("alias").getAsString(), "validation.is_blank_error");

        Assert.assertEquals(response.get("error").getAsJsonObject().get("errors").getAsJsonObject().get("iban")
                .getAsJsonObject().get("alias").getAsString(), "validation.is_blank_error");

        Assert.assertEquals(response.get("error").getAsJsonObject().get("errors").getAsJsonObject().get("bic")
                .getAsJsonObject().get("alias").getAsString(), "validation.is_blank_error");
    }
}