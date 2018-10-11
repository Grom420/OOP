import java.util.Scanner;

public class Task9 {

    public static void main(String[] args){

        long[] t = new long[21];
        long x = Long.parseLong(new Scanner(System.in).next());
        String[] a = new Scanner(System.in).next().split(" ");
        long count = 0;
        for (int i = 0; i < a.length; i++)
        {
            t[10 + Integer.parseInt(a[i])]++;
        }
        for (int i = 0; i < 10; i++)
        {
            count += t[i] * t[20 - i];
        }
        count += (t[10] - 1) * t[10] / 2;
        System.out.println(count);
    }
}
