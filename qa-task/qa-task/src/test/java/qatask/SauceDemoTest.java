package qatask;

import org.junit.jupiter.api.*;
import qatask.config.Config;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SauceDemoTest {

    private static SauceDemoUITest sauceDemoUITest;
    private static SauceDemoAPITest sauceDemoAPITest;

    @BeforeAll
    static void setup() {
        Config.config();
        sauceDemoUITest = new SauceDemoUITest();
        sauceDemoAPITest = new SauceDemoAPITest();
    }


    @Test
    public void loginThenVerifySauceDemoProductsThenPageContainsProducts() {
        sauceDemoUITest.loginThenVerifySauceDemoProductsThenPageContainsProducts();
    }

    @Order(1)
    @Test
    public void createBookingThenVerifyResponseThenExtractIdThenRetrievesByIdThenVerifyMatchesData() {
        sauceDemoAPITest.createBookingThenVerifyResponseThenExtractIdThenRetrievesByIdThenVerifyMatchesData();
    }


    @Test
    public void loginThenVerifySortedProductsThenAddProductToCartThenVerifySelectedProduct() {
        sauceDemoUITest.loginThenVerifySortedProductsThenAddProductToCartThenVerifySelectedProduct();
    }


    @Test
    public void createBookingThenVerifyResponseWithoutBodyOrNotCorrectBodyFieldNameThen500() {
        sauceDemoAPITest.createBookingThenVerifyResponseWithoutBodyOrNotCorrectBodyFieldNameThen500();
    }

    @Test
    public void getByNotExistIdThen404() {
        sauceDemoAPITest.getByNotExistIdThen404();
    }

}
