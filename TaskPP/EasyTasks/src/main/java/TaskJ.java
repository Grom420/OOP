import java.util.Scanner;

public class TaskJ {

    public static void main(String[] args) {

        String y = Integer.toBinaryString(new Scanner(System.in).nextInt());
        if (y.length() <= 8)
            System.out.println(eightBit(y));
    }

    public static String eightBit(String y){

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 8 - y.length(); i++) {
            stringBuilder.append(0);
        }
        stringBuilder.append(y);
        return stringBuilder.toString();
    }
}
