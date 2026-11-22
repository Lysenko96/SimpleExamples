package qatask;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class SauceDemoUITest {

    @BeforeAll
    static void setup() {
        Configuration.browser = "chrome";
        Configuration.headless = true;
        Configuration.browserSize = "1920x1080";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless=new");

        Configuration.browserCapabilities = options;
    }

    @Test
    public void loginThenVerifySauceDemoProductsThenPageContainsProducts() {
        open("https://www.saucedemo.com/");
        $(("[data-test='username']")).setValue("standard_user");
        $(("[data-test='password']")).setValue("secret_sauce");
        $(("[data-test='login-button']")).click();
        $("span.title").shouldHave(text("Products"));
        $$(("[data-test='inventory-list']")).shouldHave(size(1));
        $$(("[data-test='inventory-item']")).shouldHave(size(6));
    }

    @Test
    public void loginThenVerifySortedProductsThenAddProductToCartThenVerifySelectedProduct() {
        open("https://www.saucedemo.com/");
        $(("[data-test='username']")).setValue("standard_user");
        $(("[data-test='password']")).setValue("secret_sauce");
        $(("[data-test='login-button']")).click();
        $("[data-test='product-sort-container']").selectOptionByValue("lohi");
        $(("span.active_option")).shouldHave(text("Price (low to high)"));
        $(("[data-test='add-to-cart-sauce-labs-onesie']")).click();
        $(("[data-test='shopping-cart-link']")).click();
        $(("div.inventory_item_name")).shouldHave(text("Sauce Labs Onesie"));
    }

}
