import org.junit.Test;

import static org.junit.Assert.*;

public class Task10Test {

    @Test
    public void countDivThree() {

        int[] arr = {1, 2, 3, 3, 5, 5, 6, 8};
        assertEquals(3, Task10.CountDivThree(arr));
    }

    @Test
    public void sumPositives() {

        int[] arr = {-1, -22, -3, 3, 5, -5, -6, -8};
        assertEquals(8, Task10.SumPositives(arr));
        }

    @Test
    public void indexOfMaxPositive() {

        int[] arr = {-1, -22, -3, 3, 5, -5, -6, -8};
        assertEquals(4, Task10.IndexOfMaxPositive(arr));
    }

    @Test
    public void containsZero() {

        int[] arr = {-1, -22, -3, 3, 5, 0, -6, -8};
        assertEquals(true, Task10.ContainsZero(arr));
    }
}