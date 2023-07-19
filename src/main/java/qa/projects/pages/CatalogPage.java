package qa.projects.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class CatalogPage {

    public static ElementsCollection gridCategories = $$("li.portal-grid__cell");
    public static ElementsCollection gridProducts = $$(".catalog-grid__cell");
    public static SelenideElement firstProductCartBtn = gridProducts.first().find(".buy-button");
    public static SelenideElement ipadCategory = $(".tile-cats__heading[title=\"iPad\"]");
    public static SelenideElement catalogHeader = $("div .catalog-heading");
    public static ElementsCollection activeFilters = $$("a.checkbox-filter__link");
    public static SelenideElement productCardSmall = $x("(//div[@data-tile='small'])[1]");
    public static SelenideElement productCardBig = $x("(//div[@data-tile='big'])[1]");
    public static SelenideElement bigTileBtn = $(".catalog-view__switch button:first-child");
    public static SelenideElement rozetkaFilter = $(".checkbox-filter__link[data-id=\"Rozetka\"]");
    public static SelenideElement sortingSettings = $(".select-css");
    public static SelenideElement sortingExpensive = $(".select-css [value=\"2: expensive\"]");
    public static SelenideElement preloader = $(".preloader");
    public static ElementsCollection productsPrices = $$("span.goods-tile__price-value");

    public static void isFilterActive(String filter){
        activeFilters.find(Condition.text(filter)).shouldBe(Condition.visible);
        activeFilters.find(Condition.text(filter)).shouldHave(Condition.cssClass("checkbox-filter__link--checked"));
    }

    public static void sortFromHigherPrice(){
        sortingSettings.click();
        sortingExpensive.click();
        preloader.shouldBe(Condition.hidden);
    }

    public static int getProductPrice(int a) {
        return Integer.parseInt((productsPrices.texts().get(a).replaceAll("[^0-9]","")));
    }
}

