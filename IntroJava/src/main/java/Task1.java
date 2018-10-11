import java.util.Scanner;

public class Task1 {

    public static void main(String[] args){

        String a = new Scanner(System.in).next();
        String b = new Scanner(System.in).next();
        int res = 0;
        int i = 0;
        do
        {
            if (a.toLowerCase().charAt(i) == b.toLowerCase().charAt(i))
                res = 0;
            if (a.toLowerCase().charAt(i) < b.toLowerCase().charAt(i))
                res = -1;
            if (b.toLowerCase().charAt(i) < a.toLowerCase().charAt(i))
                res = 1;
            i++;
        }
        while (res == 0 && i<a.length());
        System.out.println(res);
    }
}
