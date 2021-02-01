import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DriverSummaryTest {

    @Test
    public void shouldReturnGreaterSpeed(){
        Driver dan = new Driver("Dan");
        DriverSummary summary1 = new DriverSummary(dan, 40, 65, 1);
        Driver lauren = new Driver("Lauren");
        DriverSummary summary2 = new DriverSummary(lauren, 10, 65, 1);
        assertTrue(summary1.compareTo(summary2) > summary2.compareTo(summary1));

    }
}
