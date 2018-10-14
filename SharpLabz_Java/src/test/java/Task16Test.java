import org.junit.Test;

import static org.junit.Assert.*;

public class Task16Test {

    @Test
    public void replace() {

        assertEquals("jew_wq", Task16.Replace(new StringBuilder("jew;wq")));
    }
}