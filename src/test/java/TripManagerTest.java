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
    public void shouldReturnAllDrivers(){
        TripManager tripManager = new TripManager();
        Driver dan = new Driver("Dan");
        tripManager.saveDriver(dan);
        Driver kumi = new Driver("Kumi");
        tripManager.saveDriver(kumi);
        Driver lauren = new Driver("Lauren");
        tripManager.saveDriver(lauren);
        assertTrue(tripManager.getAllDrivers().contains(dan));
    }

    @Test
    public void shouldReturnAllDriverNames(){
        TripManager tripManager = new TripManager();
        Driver dan = new Driver("Dan");
        tripManager.saveDriver(dan);
        Driver kumi = new Driver("Kumi");
        tripManager.saveDriver(kumi);
        Driver lauren = new Driver("Lauren");
        tripManager.saveDriver(lauren);
        assertTrue(tripManager.getAllDriverNames().contains("Dan"));

    }

    @Test
    public void shouldGetDriverByName(){
        TripManager tripManager = new TripManager();
        Driver dan = new Driver("Dan");
        tripManager.saveDriver(dan);
        assertEquals(dan, tripManager.getDriverByName("Dan"));
    }

    @Test
    public void shouldSaveTrip() {
        TripManager tripManager = new TripManager();
        Driver dan = new Driver("Dan");
        tripManager.saveDriver(dan);
        Trip newTrip = new Trip("07:15", "07:45", 17.3);
        tripManager.saveTrip(dan,newTrip);
        Trip newTrip2 = new Trip("06:12", "06:32", 21.8);
        tripManager.saveTrip(dan,newTrip2);
        Map<Driver, ArrayList<Trip>> driverTrips = tripManager.getAllDriverTrips();
        System.out.println(tripManager.getAllDriverTrips());
        assertFalse(driverTrips.isEmpty());
    }

    @Test
    public void getSpecificDriverTrips(){
        TripManager tripManager = new TripManager();
        Driver dan = new Driver("Dan");
        tripManager.saveDriver(dan);
        Trip newTrip = new Trip("07:15", "07:45", 17.3);
        tripManager.saveTrip(dan,newTrip);
        Driver kumi = new Driver("Dan");
        tripManager.saveDriver(kumi);
        Trip newTrip2 = new Trip("06:12", "06:32", 21.8);
        tripManager.saveTrip(kumi,newTrip2);
        assertTrue(tripManager.getSpecificDriverTrips(kumi).contains(newTrip2));
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
