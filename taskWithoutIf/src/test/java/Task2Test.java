import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class Task2Test {

    String date;
    int[] monthDay;
    String[] week;
    String result;

    public Task2Test(String date, int[] monthDay, String[] week, String result){
        this.date = date;
        this.monthDay = monthDay;
        this.week = week;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection numbers(){
        return Arrays.asList(new Object[][]{
                {"1-12", (new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 30, 31}), (new String[] {"выходной", "будни", "будни", "будни", "будни", "будни", "будни"}), "будни"}
        });
    }

    @Test
    public void calendar() {
        assertEquals(result, Task2.Calendar(date, monthDay, week));
    }
}