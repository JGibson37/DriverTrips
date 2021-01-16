import org.junit.Test;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TripManagerTest {

    @Test
    public void shouldSaveDriver(){
        TripManager tripManager = new TripManager();
        Driver dan = new Driver("Dan");
        tripManager.saveDriver(dan);
        assertTrue(tripManager.driverTrips.containsKey(dan));
    }
    
    @Test
    public void shouldSaveTrip() {
        TripManager tripManager = new TripManager();
        Driver dan = new Driver("Dan");
        tripManager.saveDriver(dan);
        Trip newTrip = new Trip("07:15", "07:45", 17.3);
        Trip newTrip2 = new Trip("06:12", "06:32", 21.8);
        tripManager.saveTrip(dan,newTrip);
        tripManager.saveTrip(dan,newTrip2);
        Map<Driver, ArrayList<Trip>> dansTrips = tripManager.getDriverTrips();
        assertFalse(dansTrips.isEmpty());
    }
    @Test
    public void shouldParseTime(){
        TripManager tripManager = new TripManager();
        Trip newTrip = new Trip("07:15", "07:45", 17.3);
        String convertedTime = tripManager.removeColon(newTrip.startTime);
        assertFalse(convertedTime.contains(":"));
    }

    @Test
    public void shouldMakeTimeInt(){
        TripManager tripManager = new TripManager();
        Trip newTrip = new Trip("07:15", "07:45", 17.3);
        int startNumber = tripManager.makeTimeInt(newTrip.startTime);
        assertTrue(startNumber == 715);
        int endNumber = tripManager.makeTimeInt(newTrip.endTime);
        assertTrue(endNumber == 745);
    }

    @Test
    public void shouldCalculateSpeed() {
        TripManager tripManager = new TripManager();
        Trip newTrip = new Trip("07:15", "07:45", 17.3);
        assertTrue(tripManager.calculateSpeed(newTrip.startTime, newTrip.endTime, newTrip.milesDriven) == 35);
    }

    @Test
    public void shouldRoundMiles(){
        TripManager tripManager = new TripManager();
        Trip newTrip = new Trip("07:15", "07:45", 17.3);
        assertTrue(tripManager.roundMilesDriven(newTrip.milesDriven)== 17);
    }

    @Test
    public void shouldAddNewDriver(){
        TripManager tripManager = new TripManager();
        ArrayList<Trip> tripList = new ArrayList<>();
        Driver dan = new Driver("Dan");
        tripManager.saveDriver(dan);

    }
}
