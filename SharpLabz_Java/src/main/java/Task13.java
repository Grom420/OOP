import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Task13 {

    public static void main(String[] args){

        int sizeN = new Scanner(System.in).nextInt();
        int sizeM = new Scanner(System.in).nextInt();
        int[][] N = new int[sizeN][sizeM];
        for (int i = 0; i < sizeN; i++)
        {
            for (int j = 0; j < sizeM; j++)
            {
                N[i][j] = ((int)(Math.random() * 31) - 15);
                System.out.print(N[i][j] + "\t");
            }
            System.out.println();
        }
        int jmin;
        for (int j = 0; j < sizeM; j++)
        {
            jmin = N[0][j];
            for (int i = 1; i < sizeN; i++)
            {
                if (jmin > N[i][j])
                    jmin = N[i][j];
            }
            System.out.printf("Минимальное число %d столбца: %d\n", j+1, jmin);
        }
        System.out.println(average(N));
    }

    public static double average(int[][] N){

        double sumNegativeNum = 0;
        long count = 0;
        for (int[] items : N) {

            sumNegativeNum += Arrays.stream(items).filter((s) -> s < 0).sum();
            count += Arrays.stream(items).filter(s-> s<0).count();
        }
        System.out.println(count);
        return sumNegativeNum / count;
    }
}
