import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void squareInt1() {
        List<Integer> arrList = Arrays.asList(5,5,5,6);
        assertEquals(0, Main.squareInt(arrList));
    }

    @Test
    public void squareInt2() {
        List<Integer> arrList = Arrays.asList(8, 7, 7, 1, 10, 0, 7, 1, 6, 6);
        assertEquals(14, Main.squareInt(arrList));
    }

    @Test
    public void squareInt3() {
        List<Integer> arrList = Arrays.asList(0,0,0,0);
        assertEquals(0, Main.squareInt(arrList));
    }

    @Test
    public void squareSub() {

        int[] arr = {2,5,1,2,3,4,7,7,6};
        assertEquals(10, Main.squareSub(arr));
    }
}