public class DriverSummary implements Comparable<DriverSummary> {

    protected Driver driver;
    protected int totalMiles;
    protected double averageSpeed;
    protected int numberOfTrips;

    public DriverSummary(Driver driver, int totalMiles, double averageSpeed, int numberOfTrips) {
        this.driver = driver;
        this.totalMiles = totalMiles;
        this.averageSpeed = averageSpeed;
        this.numberOfTrips = numberOfTrips;
    }
    
    @Override
    public int compareTo(DriverSummary o) {
        return Integer.compare(totalMiles, o.totalMiles);
    }

    public int getNumberOfTrips(){
        return numberOfTrips;
    }

    public Driver getDriver() {
        return driver;
    }

    public int getTotalMiles() {
        return totalMiles;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }
}
