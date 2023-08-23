package base;

import api.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners({ io.qameta.allure.testng.AllureTestNg.class })
public class APIBaseTest {

    protected String token;
    protected BasketProduct basketProduct = new BasketProduct();
    protected BasketTab basketTab = new BasketTab();
    protected Sepa sepa = new Sepa();
    protected VehicleTab vehicleTab = new VehicleTab();
    protected WorkingHours workingHours = new WorkingHours();
    protected SignUp signUp = new SignUp();

    protected Cowin cowin = new Cowin();

//    @BeforeClass
//    public void setUp() {
//        token = Auth.GetToken();
//    }
}
