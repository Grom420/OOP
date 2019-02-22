import org.junit.Test;

import static org.junit.Assert.*;

public class Task8Test {

    @Test
    public void numberOfOdds() {

        assertEquals(2, Task8.NumberOfOdds(86576));
        assertEquals(2, Task8.NumberOfOdds(824576));
    }
}