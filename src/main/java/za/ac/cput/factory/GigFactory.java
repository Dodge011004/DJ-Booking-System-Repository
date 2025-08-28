package za.ac.cput.factory;
import za.ac.cput.domain.Gig;
import za.ac.cput.domain.DJ;

public class GigFactory {
    public static Gig build(Long gigId, double fee, String venue, String timeslot, String dayOfWeek, DJ dj) {
        return new Gig(gigId, fee, venue, timeslot, dayOfWeek, dj);
    }
}
