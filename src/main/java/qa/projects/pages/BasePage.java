package qa.projects.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    public static String baseUrl = "https://rozetka.com.ua/ua/";
    public static SelenideElement searchField = $("input.search-form__input");
    public static SelenideElement searchBtn = $("button.search-form__submit");

}