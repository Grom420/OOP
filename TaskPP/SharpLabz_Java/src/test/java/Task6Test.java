import org.junit.Test;

import static org.junit.Assert.*;

public class Task6Test {

    @Test
    public void sumFact() {

        assertEquals(873, Task6.SumFact(5));
        assertEquals(153, Task6.SumFact(4));
    }
}