import java.util.*;

public class TripManager {
    protected HashMap<Driver, ArrayList<Trip>> driverTrips = new HashMap<>();

    public void saveTrip(Driver name, Trip trip) {
        driverTrips.get(name).add(trip);
    }

    public Map<Driver, ArrayList<Trip>> getAllDriverTrips() {
        return driverTrips;
    }

    public String removeColon(String time){
        int colonLocation = time.indexOf(":");
        String firstHalf = time.substring(0, colonLocation);
        String secondHalf = time.substring(colonLocation + 1);
        return firstHalf + secondHalf;
    }

    public int makeTimeInt (String time){
        time = removeColon(time);
        return Integer.parseInt(time);
    }

    public int calculateSpeed(String startTime, String endTime, double milesDriven){
        int startInt = makeTimeInt(startTime);
        int endInt = makeTimeInt(endTime);
        int timeTravelled = endInt - startInt;
        double speed = (milesDriven/timeTravelled)*60;
        return (int) Math.round(speed);
    }

    public int roundMilesDriven(double miles){
        return (int) Math.round(miles);
    }

    public void saveDriver(Driver name) {
        driverTrips.put(name, new ArrayList<Trip>());
    }

    public void getDriver(Driver name) {
        driverTrips.get(name);
    }

    public ArrayList<Trip> getSpecificDriverTrips(Driver name) {
        return driverTrips.get(name);
    }

    public Set<Driver> getAllDrivers() {
        return driverTrips.keySet();
    }

    public ArrayList<String> getAllDriverNames() {
        ArrayList<String> driverNames = new ArrayList<>();
        for(Driver driver : driverTrips.keySet()){
            driverNames.add(driver.getName());
        }
        return driverNames;
    }

    public Driver getDriverByName(String driverName) {
        Driver driverToReturn = null;
        for(Driver driver : driverTrips.keySet()){
            if(driver.getName().equals(driverName)){
                driverToReturn = driver;
            }
        }
        return driverToReturn;
    }
}
