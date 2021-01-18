import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class DriverTripsApp {
    public static void main(String[] args) {
        try {
            TripManager tripManager = informationExtractor();
            ArrayList<DriverSummary> driverSummaries = createDriverSummaries(tripManager);
            generateReport(driverSummaries);
        } catch (Exception e) {
            System.out.println("An error has occurred");
            e.printStackTrace();
        }
    }

    public static TripManager informationExtractor() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\input.txt"));
        String s;
        TripManager tripManager = new TripManager();

        while((s = br.readLine()) != null){
            String[] contentArray = s.split(" ");
            String command = contentArray[0];
            Driver driver = new Driver(contentArray[1]);
            if (command.equals("Driver")){
                if(!tripManager.getAllDriverNames().contains(driver.getName())) {
                    tripManager.saveDriver(driver);
                }
            }
            if(command.equals("Trip")){
                String startTime = contentArray[2];
                String endTime = contentArray[3];
                double milesDriven = Double.parseDouble(contentArray[4]);
                Trip newTrip = new Trip(startTime, endTime, milesDriven);
                for(String driverName : tripManager.getAllDriverNames()){
                    if(driverName.equals(driver.getName())){
                        Driver driverToAddTrip = tripManager.getDriverByName(driverName);
                        tripManager.saveTrip(driverToAddTrip, newTrip);
                    }
                }
            }
        }
        br.close();
        return tripManager;
    }

    public static void generateReport(ArrayList<DriverSummary> driverSummaries) {
        Collections.sort(driverSummaries);
        Collections.reverse(driverSummaries);
        for (DriverSummary summary : driverSummaries){
            System.out.println(summary.getDriver().getName() +": " + summary.getTotalMiles() + " miles @ " + summary.getAverageSpeed() + " mph");
        }
    }


    public static ArrayList<DriverSummary> createDriverSummaries(TripManager tripManager) {
        ArrayList<DriverSummary> driverSummaries = new ArrayList<>();
        for (Driver drv: tripManager.getAllDrivers()) {
            ArrayList<Trip> driversTrips = tripManager.getSpecificDriverTrips(drv);
            if (driversTrips.isEmpty()) {
                DriverSummary driverSummary = new DriverSummary(drv, 0, 0.0);
                driverSummaries.add(driverSummary);
            }else{
                int totalMiles = 0;
                int totalTime = 0;
                for (Trip tripToCalculate : driversTrips) {
                    String startTime = tripToCalculate.getStartTime();
                    int startTimeInt = tripManager.makeTimeInt(startTime);
                    String endTime = tripToCalculate.getEndTime();
                    int endTimeInt = tripManager.makeTimeInt(endTime);
                    double milesDriven = tripToCalculate.getMilesDriven();
                    totalMiles = totalMiles + tripManager.roundMilesDriven(milesDriven);
                    totalTime = totalTime + (endTimeInt - startTimeInt);
                }
                double averageSpeed = ((double)totalMiles / totalTime);
                averageSpeed = Math.round(averageSpeed * 60);
                if (averageSpeed >= 5 && averageSpeed <=100){
                    DriverSummary summary = new DriverSummary(drv, totalMiles, averageSpeed);
                    driverSummaries.add(summary);
                }else{
                    DriverSummary summary = new DriverSummary(drv, 0, 0);
                    driverSummaries.add(summary);
                }
            }
        }
        return driverSummaries;
    }
}
