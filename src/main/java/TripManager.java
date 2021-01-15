import java.util.ArrayList;

public class TripManager {

    protected ArrayList<Trip> tripList = new ArrayList<>();

    public void saveTrip(Trip trip) {
        tripList.add(trip);
    }

    public ArrayList<Trip> getTripList() {
        return tripList;
    }

    public String removeColon(String time){
        int colonLocation = time.indexOf(":");
        String firstHalf = time.substring(0, colonLocation);
        String secondHalf = time.substring(colonLocation + 1);
        return time = firstHalf + secondHalf;
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
}
