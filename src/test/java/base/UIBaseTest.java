package base;
import static com.codeborne.selenide.Selenide.*;
import static constants.Constant.Url.SIGN_IN_PAGE;

import com.codeborne.selenide.Selenide;
import cookie.UICookieModal;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import authorization.UIBaseTestAuthorization;
import org.testng.annotations.Listeners;
import pages.basket.Basket_logic;
import pages.catalog.Catalog_logic;
import pages.cookie.Cookie_modal_logic;
import pages.dashboard.Dashboard_logic;
import pages.listing.Listing_logic;
import pages.signin.Sign_in_logic;

@Listeners({ io.qameta.allure.testng.AllureTestNg.class })
public class UIBaseTest {
    protected Sign_in_logic signInpage = new Sign_in_logic();
    protected Dashboard_logic dashboard = new Dashboard_logic();
    protected Cookie_modal_logic cookieModallogic = new Cookie_modal_logic();
    protected Catalog_logic catalogLogic = new Catalog_logic();
    protected Listing_logic listingPage = new Listing_logic();
    protected Basket_logic basketLogic = new Basket_logic();



    @BeforeSuite
    public static void SetUpSelenide(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        Configuration.headless = false;
        open(SIGN_IN_PAGE);
        UICookieModal cookieTest = new UICookieModal();
        UIBaseTestAuthorization loginTest = new UIBaseTestAuthorization();
        cookieTest.AcceptAllCookie();
        loginTest.testLogin();
    }

    @AfterSuite
    public void AfterSuite() {
        Selenide.closeWebDriver();
    }
}