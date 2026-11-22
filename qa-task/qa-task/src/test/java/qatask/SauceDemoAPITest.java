package qatask;

import com.codeborne.selenide.Configuration;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import qatask.dto.Booking;
import qatask.dto.BookingDto;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;



public class SauceDemoAPITest {

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
    public void createBookingThenVerifyResponseThenExtractIdThenRetrievesByIdThenVerifyMatchesData() {
        String requestBody = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        BookingDto create = given().auth()
                .basic("admin", "password123")
                .header("Content-Type", ContentType.JSON)
                .body(requestBody)
                .when()
                .post("https://restful-booker.herokuapp.com/booking")
                .then()
                .statusCode(200)
                .body("bookingid", notNullValue())
                .body("booking.firstname", equalTo("Jim"))
                .body("booking.lastname", equalTo("Brown"))
                .body("booking.totalprice", equalTo(111))
                .body("booking.depositpaid", equalTo(true))
                .body("booking.bookingdates.checkin", equalTo("2018-01-01"))
                .body("booking.bookingdates.checkout", equalTo("2019-01-01"))
                .body("booking.additionalneeds", equalTo("Breakfast"))
                .extract()
                .as(BookingDto.class);
        Booking get = given().auth()
                .basic("admin", "password123")
                .header("Content-Type", ContentType.JSON)
                .when()
                .get("https://restful-booker.herokuapp.com/booking/" + create.getBookingid())
                .then()
                .statusCode(200)
                .body("firstname", not(emptyOrNullString()))
                .body("lastname", not(emptyOrNullString()))
                .body("totalprice", greaterThan(0))
                .body("depositpaid", isA(Boolean.class))
                .body("bookingdates.checkin", not(emptyOrNullString()))
                .body("bookingdates.checkout", not(emptyOrNullString()))
                .body("firstname", equalTo("Jim"))
                .body("lastname", equalTo("Brown"))
                .body("totalprice", equalTo(111))
                .body("depositpaid", equalTo(true))
                .body("bookingdates.checkin", equalTo("2018-01-01"))
                .body("bookingdates.checkout", equalTo("2019-01-01"))
                .extract().as(Booking.class);
        Assertions.assertEquals(get.getFirstname(), create.getBooking().getFirstname());
        Assertions.assertEquals(get.getLastname(), create.getBooking().getLastname());
        Assertions.assertEquals(get.getTotalprice(), create.getBooking().getTotalprice());
        Assertions.assertEquals(get.getDepositpaid(), create.getBooking().getDepositpaid());
        Assertions.assertEquals(get.getBookingdates(), create.getBooking().getBookingdates());
    }

    @Test
    public void createBookingThenVerifyResponseWithoutBodyOrNotCorrectBodyFieldNameThen500() {
        String requestBody = "{\n" +
                "    \"firstname1\" : \"Jim1\",\n" +
                "    \"lastname\" : \"Brown1\",\n" +
                "    \"totalprice\" : 1111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-02\",\n" +
                "        \"checkout\" : \"2019-01-02\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast1\"\n" +
                "}";
        given().auth()
                .basic("admin", "password123")
                .header("Content-Type", ContentType.JSON)
                .body(requestBody)
                .when()
                .post("https://restful-booker.herokuapp.com/booking")
                .then()
                .statusCode(500);
        given().auth()
                .basic("admin", "password123")
                .header("Content-Type", ContentType.JSON)
                .when()
                .post("https://restful-booker.herokuapp.com/booking")
                .then()
                .statusCode(500);

    }

    @Test
    public void getByNotExistIdThen404() {
        given().auth()
                .basic("admin", "password123")
                .header("Content-Type", ContentType.JSON)
                .when()
                .get("https://restful-booker.herokuapp.com/booking/" + 10000000)
                .then()
                .statusCode(404);
    }

}
