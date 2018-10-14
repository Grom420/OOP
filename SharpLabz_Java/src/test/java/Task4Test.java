import org.junit.Test;

import static org.junit.Assert.*;

public class Task4Test {

    @Test
    public void sequence() {
        assertEquals(0.5, Task4.Sequence(1), 0);
        assertEquals(0.25, Task4.Sequence(2), 0);
    }
}