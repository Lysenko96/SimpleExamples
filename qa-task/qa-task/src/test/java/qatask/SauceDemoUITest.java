package qatask;

import com.codeborne.selenide.ClickOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import qatask.config.Config;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class SauceDemoUITest {

    @BeforeAll
    static void setup() {
        Config.config();
    }

    @Test
    public void loginThenVerifySauceDemoProductsThenPageContainsProducts() {
        login();
        $("span.title").shouldHave(text("Products"), Duration.ofSeconds(5));
        $$(("[data-test='inventory-list']")).shouldHave(size(1), Duration.ofSeconds(5));
        $$(("[data-test='inventory-item']")).shouldHave(size(6), Duration.ofSeconds(5));
    }

    @Test
    public void loginThenVerifySortedProductsThenAddProductToCartThenVerifySelectedProduct() {
        login();
        $("[data-test='product-sort-container']").selectOptionByValue("lohi");
        $(("span.active_option")).shouldHave(text("Price (low to high)"), Duration.ofSeconds(5));
        $(("[data-test='add-to-cart-sauce-labs-onesie']")).click(ClickOptions.withTimeout(Duration.ofSeconds(5)));
        $(("[data-test='shopping-cart-link']")).click(ClickOptions.withTimeout(Duration.ofSeconds(5)));
        $(("div.inventory_item_name")).shouldHave(text("Sauce Labs Onesie"), Duration.ofSeconds(5));
    }

    private static void login() {
        open("https://www.saucedemo.com/");
        $(("[data-test='username']")).setValue("standard_user");
        $(("[data-test='password']")).setValue("secret_sauce");
        $(("[data-test='login-button']")).click(ClickOptions.withTimeout(Duration.ofSeconds(2)));
    }

}
