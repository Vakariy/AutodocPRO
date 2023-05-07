package pages.cookie;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Cookie_modal_page {
    SelenideElement acceptAllCookieButton() { return $("[data-test-id='user-consent-cookies-btn-allow-all']");}
    SelenideElement textFR() { return $(".text--rb4k.text-font-base--cFRK.text-font-weight-400--D3uZ.text-size-12-" +
            "-KyOA.text-color-gray-700--lLAx.text-alignment-horizontal-left--_zRs");}
}