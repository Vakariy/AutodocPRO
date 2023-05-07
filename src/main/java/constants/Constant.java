package constants;

public class Constant {

    public static class Url {
        public static final String DOMAIN = "-";

        public static final String SIGN_UP_PAGE = DOMAIN + "fr/signup";
        public static final String SIGN_IN_PAGE = DOMAIN + "fr/signin";
        public static final String DASHBOARD_PAGE = DOMAIN + "fr/dashboard";
        public static final String CATALOG_PAGE = DOMAIN + "fr/catalog";
        public static final String BASKET_PREVIEW_PAGE = DOMAIN + "fr/cart/preview";
        public static final String BASKET_PAYMENT_PAGE = DOMAIN + "fr/cart/payment";

    }
    public static class DataInfo{
        public static final String USER_NUMBER_PHONE = "200+002";
        public static final String REG_NUMBER_BMW_3_Berline = "aj578cf";
    }
    public static class Api_routs{
        public static final String API_URI = "-";
        public static final String AUTH_LOGIN  = API_URI + "/auth/login";
        public static final String BASKET = API_URI + "/basket";
        public static final String BASKET_TAB = API_URI + "/basket-tab/";
        public static final String SEPA = API_URI + "/payment/sepa/mandate";
        public static final String VEHICLE_TAB = API_URI + "/vehicle-tab/";
        public static final String WORKING_HOURS = API_URI + "/settings/working-hours";
        public static final String BASKET_PRODUCT = API_URI + "/basket-product";
    }
}
