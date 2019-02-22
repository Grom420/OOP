import java.util.Scanner;

public class Task3 {

    public static void main(String[] args){

        int n = Integer.parseInt(new Scanner(System.in).next());
        int max = 0;
        int y = 0;
        String z;
        int a;
        int b;
        for (int i = 0; i < n; i++)
        {
            z = new Scanner(System.in).next();
            String[] bufSplit;
            bufSplit = z.split(" ");
            a = Integer.parseInt(bufSplit[0]);
            b = Integer.parseInt(bufSplit[1]);
            y = y - a + b;
            if (y > max)
                max = y;
        }
        System.out.println(max);
    }
}
