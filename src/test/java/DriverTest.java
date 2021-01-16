import org.junit.Test;

import java.util.ArrayList;

public class DriverTest {

    @Test
    public void shouldCreateNewDriver(){
        ArrayList<Trip> tripList = new ArrayList<>();
        Driver driver = new Driver("Dan");
    }
}
