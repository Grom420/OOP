import java.util.Scanner;

public class Task2 {

    public static void main(String[] args){

        String x = new Scanner(System.in).next();
        int count = 0;
        int buf = 0;
        while (x.length() >= 2)
        {
            for (int j = 0; j < x.length(); j++)
            {
                buf += (x.charAt(j) - 48);
            }
            x = String.valueOf(buf);
            buf = 0;
            count++;
        }
        System.out.println(count);
    }
}
