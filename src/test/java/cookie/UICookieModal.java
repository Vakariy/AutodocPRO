package cookie;

import io.qameta.allure.Step;
import org.testng.Assert;
import base.UIBaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static constants.TranslateFR.Text_FR.COOKIE_TEXT;


public class UICookieModal extends UIBaseTest {
    @Test
    @Step("Click agree cookie button")
    public void AcceptAllCookie(){
        String actual_result = cookieModallogic.getTextFR();
        Assert.assertEquals(actual_result, COOKIE_TEXT);
        cookieModallogic.acceptAllCookieClick();
    }
}