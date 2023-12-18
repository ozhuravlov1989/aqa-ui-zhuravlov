package qa.projects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.projects.pages.BasePage;
import qa.projects.pages.Cart;
import qa.projects.pages.CatalogPage;

public class RozetkaTest {

    @BeforeMethod
    public void before() {
//        Configuration.browserSize = "1980x1080";
        Selenide.open(BasePage.baseUrl);
    }

    @Test
    public void Task1() {
        Cart.openCart();
        Cart.cartIsEmpty.shouldBe(Condition.visible);
        Cart.closeCart();
        BasePage.searchField.setValue("iphone").pressEnter();
        CatalogPage.getFirstProductCartBtn();
        Cart.cartBadge.shouldHave(Condition.text("1"));
        Cart.openCart();
        Cart.cartProductTitle.shouldHave(Condition.text("Мобільний телефон Apple iPhone 13"));
        Cart.removeProduct();
        Cart.cartIsEmpty.shouldBe(Condition.visible);
    }

    @Test
    public void Task2() {
        BasePage.searchField.setValue("Apple");
        BasePage.searchBtn.click();
        CatalogPage.gridCategories.shouldHave(CollectionCondition.size(20));
        CatalogPage.ipadCategory.click();
        CatalogPage.catalogHeader.shouldHave(Condition.text("Apple"));
    }

    @Test
    public void Task3() {
        BasePage.searchField.setValue("iphone 13").pressEnter();
        CatalogPage.isFilterActive("iPhone 13");
        int results1 = CatalogPage.gridProducts.size();
        CatalogPage.rozetkaFilter.click();
        int results2 = CatalogPage.gridProducts.size();
        Assert.assertEquals(results1,results2,"Quantity of goods mismatch");
    }

    @Test
    public void Task4() {
        BasePage.searchField.setValue("iphone 13").pressEnter();
        Assert.assertEquals(CatalogPage.productCardSmall.getSize().getHeight(),458);
        Assert.assertEquals(CatalogPage.productCardSmall.getSize().getWidth(),209);
        CatalogPage.bigTileBtn.click();
        Assert.assertEquals(CatalogPage.productCardBig.getSize().getHeight(),527);
        Assert.assertEquals(CatalogPage.productCardBig.getSize().getWidth(),262);
    }

    @Test
    public void Task5() {
        BasePage.searchField.setValue("iphone").pressEnter();
        CatalogPage.sortFromHigherPrice();
        int firstProductPrice = CatalogPage.getProductPrice(0);
        int secondProductPrice = CatalogPage.getProductPrice(1);
        Assert.assertTrue(firstProductPrice > secondProductPrice,"1st product price is less than second product price");
    }
}
