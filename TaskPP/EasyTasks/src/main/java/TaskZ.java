import java.util.Scanner;

public class TaskZ {

    public static void main(String[] args) {

        int[] transport = new int[5];
        int x = new Scanner(System.in).nextInt();

        while (x >= 36) {
            x = x - 60;
            transport[4]++;
        }

        while (x >= 18) {
            x = x - 20;
            transport[3]++;
        }

        while (x >= 9) {
            x = x - 10;
            transport[2]++;
        }

        while (x >= 5){
            x = x - 5;
            transport[1]++;
        }

        while (x >= 1){
            x--;
            transport[0]++;
        }

        for (int i = 0; i < transport.length; i++) {

            System.out.print(transport[i] + " ");
        }
    }
}