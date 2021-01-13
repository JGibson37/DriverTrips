import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TripTest {

    @Test
    public void createTrip() {
        Driver dan = new Driver("Dan");
        Trip newTrip = new Trip( dan, "07:15", "07:45", 17.3);
    }

    @Test
    public void parseTime(){
        Driver dan = new Driver("Dan");
        Trip newTrip = new Trip( dan, "07:15", "07:45", 17.3);
        String convertedTime = newTrip.removeColon(newTrip.startTime);
        assertFalse(convertedTime.contains(":"));
    }

    @Test
    public void shouldMakeTimeInt(){
        Driver dan = new Driver("Dan");
        Trip newTrip = new Trip( dan, "07:15", "07:45", 17.3);
        int startNumber = newTrip.makeTimeInt(newTrip.startTime);
        assertTrue(startNumber == 715);
        int endNumber = newTrip.makeTimeInt(newTrip.endTime);
        assertTrue(endNumber == 745);
    }
    @Test
    public void shouldCalculateSpeed() {
        Driver dan = new Driver("Dan");
        Trip newTrip = new Trip( dan, "07:15", "07:45", 17.3);
        assertTrue(newTrip.calculateSpeed(newTrip.startTime, newTrip.endTime) == 35);
    }

    @Test
    public void shouldRoundMiles(){
        Driver dan = new Driver("Dan");
        Trip newTrip = new Trip( dan, "07:15", "07:45", 17.3);
        assertTrue(newTrip.roundMilesDriven(newTrip.milesDriven)== 17);
    }

}
