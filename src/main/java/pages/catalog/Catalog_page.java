package pages.catalog;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class Catalog_page {
    ElementsCollection sub_categories_cards_image() {return $$x("//article[@class='card--HGBA']");}
    ElementsCollection sidebar_category() {return $$x("//span[@class='title--Ij3_ small--Kqdv']");}
    ElementsCollection sub_category_item_sidebar() {return $$(".list-item--uBiY");}
    ElementsCollection car_tab_remove_button() {return $$x("//button[@aria-label='remove']");}
    SelenideElement show_more_button_sidebar_catalog() {return $("button.ant-btn.ant-btn-link." +
            "ant-btn-sm.btn--9PFw.");}
    public SelenideElement breadcrumbs() {return $(".breadcrumbs--cYx3");}
}