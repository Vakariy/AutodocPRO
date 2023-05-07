package pages.catalog;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.*;

public class Catalog_logic extends Catalog_page {
    public int RemoveAllCarTabs() {
        int tabQuantity;
        do {
            tabQuantity = $$(car_tab_remove_button()).size();
            if (tabQuantity > 0) {
                $$(car_tab_remove_button()).get(0).click();
                Selenide.sleep(3000);
            }
        } while (tabQuantity > 0);
        return tabQuantity;
    }

    public Catalog_logic goToListingThrowCardCatalogItems() {
        for (;;) {
            sleep(5000);
            int product_items_quantity = $$(sub_categories_cards_image()).size();
            int random_catalog_item = (int) (Math.random() * product_items_quantity);
            if (product_items_quantity == 0){
                return this;
            } else if (product_items_quantity > 0) {
                sub_categories_cards_image().get(random_catalog_item).click();
            }
        }
    }
    public void clickRandomCatalogItem() {
        sleep(5000);
        $$(sidebar_category()).get((int) (Math.random() * $$(sidebar_category()).size()))
                .click();
        $(show_more_button_sidebar_catalog())
                .click();
        $$(sub_category_item_sidebar()).get((int) (Math.random() * $$(sub_category_item_sidebar()).size()))
                .click();
    }
}