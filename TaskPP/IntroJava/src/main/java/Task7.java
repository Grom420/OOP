import java.util.Scanner;

public class Task7 {

    public static void main(String[] args){

        int a = Integer.parseInt(new Scanner(System.in).next());
        String b = new Scanner(System.in).next();
        String[] bufSplit;
        bufSplit = b.split(" ");
        int count = 0;
        int sum = 0;
        for (int i = 0; i < bufSplit.length; i++)
        {
            for (int j = 0; j < bufSplit.length; j++)
            {
                if (j != i)
                    sum += Integer.parseInt(bufSplit[j]);
            }
            if (sum % 2 == 0)
                count++;
            sum = 0;
        }
        System.out.println(count);
    }
}
