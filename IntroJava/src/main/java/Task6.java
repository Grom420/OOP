import java.util.Scanner;

public class Task6 {

    public static void main(String[] args){

        String[] coord = new Scanner(System.in).next().split(" ");
        int a = Integer.parseInt(coord[0]);
        int b = Integer.parseInt(coord[1]);
        int x1 = Integer.parseInt(coord[2]);
        int y1 = Integer.parseInt(coord[3]);
        int x2 = Integer.parseInt(coord[4]);
        int y2 = Integer.parseInt(coord[5]);
        int x, y;
        x = x1;
        y = y1;
        x1 = x + y;
        y1 = y - x;
        x = x2;
        y = y2;
        x2 = x + y;
        y2 = y - x;
        a *= 2;
        b *= 2;
        x1 = x1 / a + ((x1 > 0) ? 1 : 0);
        x2 = x2 / a + ((x2 > 0) ? 1 : 0);
        y1 = y1 / b + ((y1 > 0) ? 1 : 0);
        y2 = y2 / b + ((y2 > 0) ? 1 : 0);
        System.out.println(Math.max(Math.abs(y2 - y1), Math.abs(x2 - x1)));;
    }
}
