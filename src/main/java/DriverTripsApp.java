import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DriverTripsApp {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\input.txt"));
            String s;
            TripManager tripManager = new TripManager();
            ArrayList<Trip> tripList = new ArrayList<>();

            while((s = br.readLine()) != null){
                String[] contentArray = s.split(" ");
                String command = contentArray[0];
                if (command.equals("Driver")){
                    String name = contentArray[1];
                    Driver newDriver = new Driver(name);
                    System.out.println("New Driver | " + newDriver.getName());
                    System.out.println();
                }
                if(command.equals("Trip")){
                    String name = contentArray[1];
                    String startTime = contentArray[2];
                    String endTime = contentArray[3];
                    double milesDriven = Double.parseDouble(contentArray[4]);
                    Trip trip = new Trip(startTime, endTime, milesDriven);


                    System.out.println(command + "-" + name + "-" + startTime + "-" + endTime+ "-" + milesDriven);
                    System.out.println();
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
