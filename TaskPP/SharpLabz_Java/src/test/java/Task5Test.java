import org.junit.Test;

import static org.junit.Assert.*;

public class Task5Test {

    @Test
    public void sequence() {

        assertEquals(1.7142857142857144, Task5.Sequence(5), 0);
        assertEquals(1.6666666666666667, Task5.Sequence(4), 0);
    }
}