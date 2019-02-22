import org.junit.Test;

import static org.junit.Assert.*;

public class Task1Test {

    @Test
    public void pow() {
        assertEquals(64,Task1.Pow(2));
        assertEquals(729, Task1.Pow(3));
    }
}