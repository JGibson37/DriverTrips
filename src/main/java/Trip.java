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

    public String saveConvertedStartTime(String convertedTime) {
        startTime = convertedTime;
        return startTime;
    }
}
