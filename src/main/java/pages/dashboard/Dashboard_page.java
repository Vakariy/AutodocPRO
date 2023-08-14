package pages.dashboard;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class Dashboard_page {
    SelenideElement carRegNumberInput() {
        return $("[name='carRegNumber']");}
    SelenideElement activeCarRegNumber() {
        return $x("//span[@class='desc--I59Y']");}
    ElementsCollection listSelector() {
        return $$x("//div[@class='select--vpoz__option select--vpoz__option--is-focused css-7fm776-option']");
    }

    SelenideElement firstDropdownSelector() {
        return $(".select--vpoz__control.css-161na10-control #react-select-carMaker-input");
    }
    SelenideElement secondDropdownSelector() {
        return $(".select--vpoz__control.css-161na10-control #react-select-carModel-input");
    }
    SelenideElement thirdDropdownSelector() {
        return $(".select--vpoz__control.css-161na10-control #react-select-carEngine-input");
    }
    SelenideElement OkButtonSelector() {
        return $x("//button[@class='ant-btn ant-btn-primary ant-btn-lg ant-btn-block btn--9PFw']/span[text" +
                "()='Ok']");
    }
    public SelenideElement modalBody() {
        return $(".ant-modal-body");}
}