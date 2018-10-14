import org.junit.Test;

import static org.junit.Assert.*;

public class Task15Test {

    @Test
    public void contains() {
        assertEquals("yes", Task15.Contains("rwrq", "rw"));
        assertEquals("no", Task15.Contains("rwrq", "zzzzzz"));
    }
}