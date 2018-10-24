import java.util.Scanner;

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
        int count = 0;
        for (int[] items : N) {
            for (int item : items){
                if (item < 0)
                {
                    sumNegativeNum += item;
                    count++;
                }
            }
        }
        return sumNegativeNum / count;
    }
}
