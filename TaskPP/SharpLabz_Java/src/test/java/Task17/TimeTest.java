package Task17;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTest {

    Time time = new Time(1,2,3);

    @Test
    public void getSeconds() {

        assertEquals(1, time.getSeconds());
    }

    @Test
    public void getMinutes() {

        assertEquals(2, time.getMinutes());
    }

    @Test
    public void getHours() {

        assertEquals(3, time.getHours());
    }
}