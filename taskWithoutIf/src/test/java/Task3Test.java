import org.junit.Test;

import static org.junit.Assert.*;

public class Task3Test {

    @Test
    public void parseInt() {
        assertEquals(400, Task3.ParseInt(20));
    }

    @Test
    public void parseString() {
        assertEquals("jjeeppaa", Task3.ParseString("jepa"));
    }
}