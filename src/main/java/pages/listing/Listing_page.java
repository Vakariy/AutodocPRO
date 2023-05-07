package pages.listing;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class Listing_page {
    ElementsCollection product_item_row_listing() {return $$x("//tr[@class='ant-table-row ant-table-row-" +
            "level-0 editable-row']");}
    ElementsCollection add_product_item_to_basket() {return $$x("//tr[@class='ant-table-row ant-table" +
            "-row-level-0 editable-row']/" +
            "td[@title='Ajouter']/button[@type='submit']");}
    SelenideElement notification_successful_added_product_to_basket() {return $x("//div[@class=" +
            "'ant-notification-notice" +
            " notification--tiSb ant-notification-notice-closable']");}
}
