import org.junit.Test;

import static org.junit.Assert.*;

public class Task14Test {

    @Test
    public void countWord() {
        assertEquals(3, Task14.CountWord("wrhwq wqjr   wqjr"));
        assertEquals(4, Task14.CountWord("  wrhwq wqjr   wqjr       sf     "));
    }
}