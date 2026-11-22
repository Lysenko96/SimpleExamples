package qatask.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class BookingDates {

    private LocalDate checkin;
    private LocalDate checkout;

    public BookingDates() {
    }

    public BookingDates(LocalDate checkin, LocalDate checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDate checkin) {
        this.checkin = checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDate checkout) {
        this.checkout = checkout;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;

        BookingDates that = (BookingDates) object;
        return Objects.equals(checkin, that.checkin) && Objects.equals(checkout, that.checkout);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(checkin);
        result = 31 * result + Objects.hashCode(checkout);
        return result;
    }

    @Override
    public String toString() {
        return "BookingDates{" +
                "checkin=" + checkin +
                ", checkout=" + checkout +
                '}';
    }
}
