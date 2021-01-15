import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TripManagerTest {

    @Test
    public void shouldSaveTrip() {
        TripManager tripManager = new TripManager();
        Trip newTrip = new Trip("07:15", "07:45", 17.3);
        tripManager.saveTrip(newTrip);
        assertTrue(tripManager.getTripList().contains(newTrip));
    }
    @Test
    public void shouldParseTime(){
        TripManager tripManager = new TripManager();
        Trip newTrip = new Trip("07:15", "07:45", 17.3);
        ArrayList<Trip> tripList = new ArrayList<>();
        Driver dan = new Driver("Dan", tripList);
        String convertedTime = tripManager.removeColon(newTrip.startTime);
        assertFalse(convertedTime.contains(":"));
    }

    @Test
    public void shouldMakeTimeInt(){
        TripManager tripManager = new TripManager();
        Trip newTrip = new Trip("07:15", "07:45", 17.3);
        ArrayList<Trip> tripList = new ArrayList<>();
        Driver dan = new Driver("Dan", tripList);
        int startNumber = tripManager.makeTimeInt(newTrip.startTime);
        assertTrue(startNumber == 715);
        int endNumber = tripManager.makeTimeInt(newTrip.endTime);
        assertTrue(endNumber == 745);
    }

    @Test
    public void shouldCalculateSpeed() {
        TripManager tripManager = new TripManager();
        Trip newTrip = new Trip("07:15", "07:45", 17.3);
        ArrayList<Trip> tripList = new ArrayList<>();
        Driver dan = new Driver("Dan", tripList);
        assertTrue(tripManager.calculateSpeed(newTrip.startTime, newTrip.endTime, newTrip.milesDriven) == 35);
    }

    @Test
    public void shouldRoundMiles(){
        TripManager tripManager = new TripManager();
        Trip newTrip = new Trip("07:15", "07:45", 17.3);
        ArrayList<Trip> tripList = new ArrayList<>();
        Driver dan = new Driver("Dan", tripList);
        assertTrue(tripManager.roundMilesDriven(newTrip.milesDriven)== 17);
    }
}
