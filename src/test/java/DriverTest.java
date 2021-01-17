import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DriverTest {

    @Test
    public void shouldCreateNewDriver(){
        Driver driver = new Driver("Dan");
        assertEquals("Dan", driver.getName());

    }
}
