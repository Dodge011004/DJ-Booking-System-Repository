package za.ac.cput.domain;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    private String customerName;
    private LocalDate bookingDate;
    private LocalTime bookingTime;

    @ManyToOne(optional = false)
    @JoinColumn(name = "gig_id", nullable = false)
    private Gig gig;

    protected Booking() {}

    private Booking(Builder builder) {
        this.customerName = builder.customerName;
        this.bookingDate = builder.bookingDate;
        this.bookingTime = builder.bookingTime;
        this.gig = builder.gig;
    }

    public Long getBookingId() { return bookingId; }
    public String getCustomerName() { return customerName; }
    public LocalDate getBookingDate() { return bookingDate; }
    public LocalTime getBookingTime() { return bookingTime; }
    public Gig getGig() { return gig; }

    public static class Builder {
        private String customerName;
        private LocalDate bookingDate;
        private LocalTime bookingTime;
        private Gig gig;

        public Builder setCustomerName(String customerName) {
            this.customerName = customerName;
            return this;

        }

        public Builder setBookingDate(LocalDate bookingDate) {
            this.bookingDate = bookingDate;
            return this;
        }

        public Builder setBookingTime(LocalTime bookingTime) {
            this.bookingTime = bookingTime;
            return this;
        }

        public Builder setGig(Gig gig) {
            this.gig = gig;
            return this;
        }

        public Booking build() {
            return new Booking(this);
        }
    }
}


