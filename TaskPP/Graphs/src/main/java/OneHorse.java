import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class OneHorse {

    public static void main(String[] args) {

        int moveX[] = { -2, -2, -1, -1, 1, 1, 2, 2 };
        int moveY[] = { -1, 1, -2, 2, -2, 2, -1, 1 };

        int n = 5;
        Point begin = new Point();
        Point end = new Point();
        begin.x = 0;//на единицу меньше все координаты (ШО? ясно хуита)
        begin.y = 0;
        end.x = 2;
        end.y = 0;

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -1;
            }
        }
        ArrayList<ArrayList<Integer>> arrRoad = new ArrayList<>();
        matrix[begin.x][begin.y] = 0;
        ArrayDeque<Point> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(begin);
        arrRoad.add(new ArrayList<>(Arrays.asList(begin.x+1, begin.y+1)));
        while (!arrayDeque.isEmpty()) {
            Point buf = arrayDeque.pollFirst();
            for (int i = 0; i < 8; i++) {
                int x = buf.x + moveX[i];
                int y = buf.y + moveY[i];
                if (correct(x, y, n) && matrix[x][y] == -1) {
                    matrix[x][y] = matrix[buf.x][buf.y] + 1;
                    arrRoad.add(new ArrayList<>(Arrays.asList(x+1, y+1)));
                    if (end.x == x && end.y == y) {
                        System.out.println(matrix[end.x][end.y]);
                        System.out.println(arrRoad.toString());
                        return;
                    }
                    arrayDeque.add(new Point(x, y));
                }
                for (int j = 0; j < matrix.length; j++) {
                    for (int k = 0; k < matrix.length; k++) {
                        System.out.print(matrix[j][k] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }
    }

    public static boolean correct(int x, int y, int n){

            if (x < 0 || y < 0)
                return false;
            if (x >= n || y >= n)
                return false;
            return true;
    }
}
