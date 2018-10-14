import org.junit.Test;

import static org.junit.Assert.*;

public class Task12Test {

    @Test
    public void addArray() {
        assertArrayEquals((new int[] {1,6,7,8,9,12,92}), Task12.AddArray((new int[] {1, 92, 6, 7}), (new int[] {8, 9, 12})));
    }
}