import java.util.ArrayList;

public class Trip {


    protected String startTime;
    protected String endTime;
    protected double milesDriven;

    public Trip(String startTime, String endTime, double milesDriven) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.milesDriven = milesDriven;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public double getMilesDriven() {
        return milesDriven;
    }
}
