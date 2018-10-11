import java.util.Scanner;

public class Task8 {

    public static void main(String[] args){

        int x = Integer.parseInt(new Scanner(System.in).next());
        String a = new Scanner(System.in).next();
        String[] bufSplit;
        bufSplit = a.split(" ");
        int count = 0;
        for (int i = 0; i < bufSplit.length; i++)
        {
            if (Integer.parseInt(bufSplit[i]) != 0)
            {
                for (int j = i + 1; j < bufSplit.length; j++)
                {
                    if (Integer.parseInt(bufSplit[i]) == Integer.parseInt(bufSplit[j]))
                    {
                        bufSplit[i] = bufSplit[j] = "0";
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count / 2);
    }
}
