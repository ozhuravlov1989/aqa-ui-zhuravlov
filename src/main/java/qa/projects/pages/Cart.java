package qa.projects.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Cart {
    public static SelenideElement cartBtn = $(".header-actions__item--cart .header__button");
    public static SelenideElement cartIsEmpty = $("[data-testid=\"empty-cart\"]");
    public static SelenideElement cartCloseBtn = $(".modal__header .modal__close");
    public static SelenideElement cartBadge = $(".header-actions__item--cart .badge");
    public static SelenideElement cartProductTitle = $("div .cart-product__title");
    public static SelenideElement cartProductActions = $("#cartProductActions0");
    public static SelenideElement cartProductActionsRemove = $("rz-trash-icon");

    public static void openCart() {
        cartBtn.click();
    }

    public static void closeCart() {
        cartCloseBtn.click();
    }

    public static void removeProduct() {
        cartProductActions.click();
        cartProductActionsRemove.click();
    }

}
