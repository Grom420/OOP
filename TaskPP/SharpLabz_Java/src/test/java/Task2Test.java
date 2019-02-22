import org.junit.Test;

import static org.junit.Assert.*;

public class Task2Test {

    @Test
    public void tens() {
        assertEquals(1, Task2.Tens(12353414.56));
        assertEquals(3, Task2.Tens(12353434.56435));
    }
}