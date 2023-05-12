package selector;

import base.UIBaseTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;

public class Selector_list extends UIBaseTest {
    @Test
    public void clickCarModel(){
        dashboard.clickFirstCarModel();
    }
}
