import java.util.Scanner;

public class Task4 {

    public static void main(String[] args){

        int[] cards = new int[] { 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 1, 1, 1, 1 };
        int n = Integer.parseInt(new Scanner(System.in).next());
        int queen = 10;
        int count = 0;
        for (Integer item : cards) {
            if (queen + item == n)
                count++;
        }
        System.out.println(count);
    }
}
