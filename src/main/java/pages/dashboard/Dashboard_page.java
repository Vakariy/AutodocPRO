package pages.dashboard;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Dashboard_page {
    SelenideElement carRegNumberInput() {return $("[name='carRegNumber']");}
    SelenideElement activeCarRegNumber() {return $x("//span[@class='desc--I59Y']");}
}