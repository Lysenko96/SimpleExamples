package qatask.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Booking {

    private String firstname;
    private String lastname;
    private String totalprice;
    private String depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;

    public Booking() {
    }

    public Booking(String firstname, String lastname, String totalprice, String depositpaid, BookingDates bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public String getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(String depositpaid) {
        this.depositpaid = depositpaid;
    }

    public BookingDates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;

        Booking booking = (Booking) object;
        return Objects.equals(firstname, booking.firstname) && Objects.equals(lastname, booking.lastname) && Objects.equals(totalprice, booking.totalprice) && Objects.equals(depositpaid, booking.depositpaid) && Objects.equals(bookingdates, booking.bookingdates) && Objects.equals(additionalneeds, booking.additionalneeds);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(firstname);
        result = 31 * result + Objects.hashCode(lastname);
        result = 31 * result + Objects.hashCode(totalprice);
        result = 31 * result + Objects.hashCode(depositpaid);
        result = 31 * result + Objects.hashCode(bookingdates);
        result = 31 * result + Objects.hashCode(additionalneeds);
        return result;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice='" + totalprice + '\'' +
                ", depositpaid='" + depositpaid + '\'' +
                ", bookingdates=" + bookingdates +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }
}
