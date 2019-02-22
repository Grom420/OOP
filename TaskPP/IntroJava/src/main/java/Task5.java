import java.util.Scanner;

public class Task5 {

    public static void main(String[] args){

        long k = Long.parseLong(new Scanner(System.in).next());
        long l = Long.parseLong(new Scanner(System.in).next());
        int count = 0;
        long buf = k;
        while (k < l)
        {
            k = buf * k;
            count++;
        }
        if (k > l)
            count = 0;
        if (count == 0 && k == l)
            System.out.println("YES\n" + count);
        if (count == 0 && k != l)
            System.out.println("NO");
        if (count > 0)
            System.out.println("YES\n" + count);
    }
}
