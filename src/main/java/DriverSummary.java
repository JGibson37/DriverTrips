public class DriverSummary implements Comparable<DriverSummary> {

    protected Driver driver;
    protected int totalMiles;
    protected double averageSpeed;

    public DriverSummary(Driver driver, int totalMiles, double averageSpeed) {
        this.driver = driver;
        this.totalMiles = totalMiles;
        this.averageSpeed = averageSpeed;
    }


    @Override
    public int compareTo(DriverSummary o) {
        return Integer.compare(totalMiles, o.totalMiles);
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
