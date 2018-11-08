import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int i = sc.nextInt();
        shiftLeft(a,i);
    }

    public static int shiftLeft(int a, int i){

        return a&(-(1<<i));
    }
}
