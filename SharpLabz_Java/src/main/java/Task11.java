import java.util.Scanner;

public class Task11 {

    public static void main(String[] args){

        int[] x = { 1, 2, 3, 5, 6};
        ShiftArray(x);
    }

    static int[] ShiftArray(int[] x){
        int[] y = new int[x.length];
        for (int i = 0; i < 1; ++i)
        {
            int aLast = x[x.length-1];
            for (int j = x.length-1; j>0; j--)
                x[j] = x[j-1];
            x[0] = aLast;
        }
        for (int i = 0; i < x.length; i++) {
            y[i] = x[i];
        }

        return y;
    }
}
