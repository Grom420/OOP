import java.util.Scanner;

public class TaskY {

    public static void main(String[] args) {

        int[] transport = new int[3];
        int x = new Scanner(System.in).nextInt();

        while (x >= 35) {
            x = x - 60;
            transport[2]++;
        }

        while (x >= 9) {
            x = x - 10;
            transport[1]++;
        }

        while (x >= 1) {
            x--;
            transport[0]++;
        }

        for (int i = 0; i < transport.length; i++) {

            System.out.print(transport[i] + " ");
        }
    }
}