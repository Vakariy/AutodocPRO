package sign_up;

import base.APIBaseTest;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class API_SignUp extends APIBaseTest {
    @Test
    @Step("End-to-end scenario create of a new customer")
    public void SetUpNewCustomerTest() {
        String hash = signUp.registerNewLead();
        signUp.registerCompanyInformation(hash);
        signUp.registerDeliveryAddress(hash);
        signUp.registerContactDetails(hash);
        int customer_id = signUp.registerLeadInAWS(hash);

        String tokenCowin = cowin.loginCowin();
        cowin.getInfoByCustomerId(customer_id, tokenCowin);
        cowin.postConfirmationCustomerCowin(customer_id, tokenCowin);

        System.out.println(customer_id);
        System.out.println("7djaA36$");
    }
}