import org.junit.Test;

import static org.junit.Assert.*;

public class Task13Test {

    @Test
    public void average() {

        int[][] arr = {
                {1, 2, -3},
                {-5, 6, 0}
        };
        assertEquals(-4, Task13.average(arr), 0);
    }
}