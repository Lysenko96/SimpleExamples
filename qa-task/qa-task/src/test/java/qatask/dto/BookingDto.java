package qatask.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class BookingDto {

    private String bookingid;
    private Booking booking;

    public BookingDto() {
    }

    public BookingDto(String bookingid, Booking booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public String getBookingid() {
        return bookingid;
    }

    public void setBookingid(String bookingid) {
        this.bookingid = bookingid;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;

        BookingDto that = (BookingDto) object;
        return Objects.equals(bookingid, that.bookingid) && Objects.equals(booking, that.booking);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(bookingid);
        result = 31 * result + Objects.hashCode(booking);
        return result;
    }

    @Override
    public String toString() {
        return "BookingDto{" +
                "bookingid='" + bookingid + '\'' +
                ", booking=" + booking +
                '}';
    }
}
