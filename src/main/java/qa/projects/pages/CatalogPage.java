package qa.projects.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class CatalogPage {
    public static SelenideElement firstProductCartBtn = $x("(//app-buy-button/button)[1]");
    public static ElementsCollection gridCategories = $$("li.portal-grid__cell");
    public static ElementsCollection gridProducts = $$(".catalog-grid__cell");
    public static SelenideElement ipadCategory = $(".tile-cats__heading[title=\"iPad\"]");
    public static SelenideElement catalogHeader = $("div .catalog-heading");
    public static ElementsCollection activeFilters = $$("a.checkbox-filter__link");
    public static SelenideElement productCardSmall = $x("(//div[@data-tile='small'])[1]");
    public static SelenideElement productCardBig = $x("(//div[@data-tile='big'])[1]");
    public static SelenideElement bigTileBtn = $("[title='Крупна плитка']");
    public static SelenideElement rozetkaFilter = $(".checkbox-filter__link[data-id=\"Rozetka\"]");

    public static void isFilterActive(String filter){
        activeFilters.find(Condition.text(filter)).shouldBe(Condition.visible);
        activeFilters.find(Condition.text(filter)).shouldHave(Condition.cssClass("checkbox-filter__link--checked"));
    }

    public static void sortFromHigherPrice(){
        $(".select-css").click();
        $(".select-css [value=\"2: expensive\"]").click();
        $(".preloader").shouldBe(Condition.hidden);
    }

    public static int getProductPrice(int a) {
        return Integer.parseInt(($$("span.goods-tile__price-value").texts().get(a).replaceAll("[^0-9]","")));
    }
}

