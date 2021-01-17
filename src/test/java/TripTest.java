import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TripTest {

    @Test
    public void createTrip() {
        Trip newTrip = new Trip("07:15", "07:45", 17.3);
        assertEquals("07:15", newTrip.getStartTime());
        assertEquals("07:45", newTrip.getEndTime());
        assertEquals(17.3, newTrip.getMilesDriven(), .0);
    }


}
