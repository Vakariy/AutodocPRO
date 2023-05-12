package pages.dashboard;

import static constants.Constant.DataInfo.REG_NUMBER_BMW_3_Berline;

public class Dashboard_logic extends Dashboard_page {

    public Dashboard_logic createCardTabViaRegNumber(){
        carRegNumberInput().setValue(REG_NUMBER_BMW_3_Berline).pressEnter();
        return this;
    }
    public String getRegNumberActiveCar(){
        return activeCarRegNumber().getText();
    }

    public void clickFirstCarModel(){
        firstDropdownSelector().click();
            listSelector().first().click();
        secondDropdownSelector().click();
            listSelector().first().click();
        thirdDropdownSelector().click();
            listSelector().first().click();
        OkButtonSelector().click();
    }
}