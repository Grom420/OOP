import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Task20Test {

    @Test
    public void deleteSpace() {

        ArrayList<String> actual = new ArrayList<>();
        actual.add(0, "jopa          popopo");
        ArrayList<String> expected = new ArrayList<>();
        expected.add(0, "jopa popopo");
        assertEquals(expected, Task20.deleteSpace(actual));
    }

    @Test
    public void deletePunct() {

        ArrayList<String> actual = new ArrayList<>();
        actual.add(0, "jopa,,,,,popopo......");
        ArrayList<String> expected = new ArrayList<>();
        expected.add(0, "jopa,popopo.");
        assertEquals(expected, Task20.deletePunct(actual));
    }

    @Test
    public void missingSpace() {

        ArrayList<String> actual = new ArrayList<>();
        actual.add(0, "jopa,popopo");
        ArrayList<String> expected = new ArrayList<>();
        expected.add(0, "jopa, popopo");
        assertEquals(expected, Task20.missingSpace(actual));
    }

    @Test
    public void isNumber() {

        assertEquals(false, Task20.isNumber("qeqe"));
    }

    @Test
    public void formatNumber() {

        ArrayList<String> actual = new ArrayList<>();
        actual.add(0, "2353255");
        ArrayList<String> expected = new ArrayList<>();
        expected.add(0, "0.2353255");
        assertEquals(expected, Task20.formatNumber(actual));
    }
}