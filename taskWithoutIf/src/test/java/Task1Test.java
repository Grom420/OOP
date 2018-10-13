import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class Task1Test{
    int[] x;
    int count;
    int result;
    public Task1Test(int[] x, int count, int result){
        this.x = x;
        this.count = count;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection numbers(){
        return Arrays.asList(new Object[][]{
                {(new int[] {1,2,3,4,5,6,7,8,9,10}), 0, 5},
                {(new int[] {1,2,3,4,5,6,7,4364334,9,10,2525}), 0, 6},
                {(new int[] {-1,-2,6,7,8,9,10}), 0, 3},
                {(new int[] {1,2,3,4,5,6,7,8,0,10}), 0, 4},
                {(new int[] {0,4,5,6,7,8,9,10}), 0, 3}
        });
    }

    @Test
    public void Result() {
        assertEquals(result, Task1.Result(x, count));
    }
}

