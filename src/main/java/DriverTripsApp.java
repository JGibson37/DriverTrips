import java.io.BufferedReader;
import java.io.FileReader;

public class DriverTripsApp {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\input.txt"));
            String s;
            TripManager tripManager = new TripManager();

            while((s = br.readLine()) != null){
                String[] contentArray = s.split(" ");
                String command = contentArray[0];
                Driver driver = new Driver(contentArray[1]);
                if (command.equals("Driver")){

                    if(tripManager.getAllDriverNames().contains(driver.getName())) {
                        System.out.println("Driver already exists");
                    }else{
                        tripManager.saveDriver(driver);
                        System.out.println("Saved Driver");
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
                            System.out.println("Added Trip |" + startTime + "-" + endTime+ "-" + milesDriven + " To Driver " + driverToAddTrip.getName());
                            System.out.println();
                        }
                    }
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("An error has occured");
            e.printStackTrace();
        }
    }
}
