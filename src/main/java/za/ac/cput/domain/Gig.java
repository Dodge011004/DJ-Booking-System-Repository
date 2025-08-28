package za.ac.cput.domain;
import jakarta.persistence.*;

@Entity
public class Gig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gigId;

    private double gigFee;
    private String gigVenue;
    private String timeslot;
    private String dayOfWeek;

    @ManyToOne(optional = false)
    @JoinColumn(name = "dj_id", nullable = false)
    private DJ dj;

    protected Gig() {
    }

    public Gig(Long gigId, double gigFee, String gigVenue, String timeslot, String dayOfWeek, DJ dj) {
        this.gigId = gigId;
        this.gigFee = gigFee;
        this.gigVenue = gigVenue;
        this.timeslot = timeslot;
        this.dayOfWeek = dayOfWeek;
        this.dj = dj;
    }

    public Long getGigId() {
        return gigId;
    }

    public double getGigFee() {
        return gigFee;
    }

    public String getGigVenue() {
        return gigVenue;
    }

    public String getTimeslot() {
        return timeslot;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public DJ getDj() {
        return dj;
    }

    public String getVenue() {

        return "";
    }
}