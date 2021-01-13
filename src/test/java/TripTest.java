import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

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
        boolean timeEnd = false;
        newTrip.saveConvertedTime(timeEnd, convertedTime);
        assertFalse(newTrip.startTime.contains(":"));
    }
}
