package pages.listing;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.*;

public class Listing_logic extends Listing_page {
    public Listing_logic AddRandomProductItemToBasketFromListing() {
        int quantity_product_item = product_item_row_listing().size();
        int random_product_item = (int) (Math.random() * quantity_product_item);
        $$(add_product_item_to_basket()).get(random_product_item).click();
        $(notification_successful_added_product_to_basket()).shouldBe(Condition.visible);
        return this;
    }
}