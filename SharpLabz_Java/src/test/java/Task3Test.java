import org.junit.Test;

import static org.junit.Assert.*;

public class Task3Test {

    @Test
    public void expression() {
        assertEquals(-2.147483648E9, Task3.Expression(3), 0);
        assertEquals(-2.147483648E9, Task3.Expression(1.5), 0);
    }
}