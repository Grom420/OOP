import org.junit.Test;

import static org.junit.Assert.*;

public class Task11Test {

    @Test
    public void shiftArray() {

        assertArrayEquals((new int[] {5, 1, 2, 3}), Task11.ShiftArray(new int[] {1, 2, 3, 5}));
        assertArrayEquals((new int[] {6, 1, 2, 3, 5}), Task11.ShiftArray(new int[] {1, 2, 3, 5, 6}));
    }
}