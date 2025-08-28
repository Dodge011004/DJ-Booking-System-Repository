package za.ac.cput.factory;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Gig;
import java.time.LocalDate;
import java.time.LocalTime;

public class BookingFactory {
    public static Booking build(String customerName, LocalDate date, LocalTime time, Gig gig) {
        return new Booking.Builder()
                .setCustomerName(customerName)
                .setBookingDate(date)
                .setBookingTime(time)
                .setGig(gig)
                .build();
    }
}
