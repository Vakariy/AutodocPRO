package pages.dashboard;

import static com.codeborne.selenide.Selenide.*;
import static constants.Constant.DataInfo.REG_NUMBER_BMW_3_Berline;

public class Dashboard_logic extends Dashboard_page {

    public Dashboard_logic createCardTabViaRegNumber(){
        carRegNumberInput().setValue(REG_NUMBER_BMW_3_Berline).pressEnter();
        return this;
    }
    public String getRegNumberActiveCar(){
        return activeCarRegNumber().getText();
    }

    public void clickRandomCarModel(){
        firstDropdownSelector().click();
        $$(listSelector()).get((int) (Math.random() * $$(listSelector()).size())).click();
        secondDropdownSelector().click();
        $$(listSelector()).get((int) (Math.random() * $$(listSelector()).size())).click();
        thirdDropdownSelector().click();
        $$(listSelector()).get((int) (Math.random() * $$(listSelector()).size())).click();
        OkButtonSelector().click();
    }
}   