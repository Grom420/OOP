import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int sqr = sc.nextInt();
        squareTwo(sqr);
    }

    public static int squareTwo(int sqr){

        return 1<<sqr;
    }
}
