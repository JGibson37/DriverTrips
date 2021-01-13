public class Trip {

    Driver driver;
    String startTime;
    String endTime;
    double milesDriven;

    public Trip(Driver driver, String startTime, String endTime, double milesDriven) {
        this.driver = driver;
        this.startTime = startTime;
        this.endTime = endTime;
        this.milesDriven = milesDriven;
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

    public int calculateSpeed(String startTime, String endTime){
        int startInt = makeTimeInt(startTime);
        int endInt = makeTimeInt(endTime);
        int timeTravelled = endInt - startInt;
        double speed = (milesDriven/timeTravelled)*60;
        return (int) Math.round(speed);
    }
}
