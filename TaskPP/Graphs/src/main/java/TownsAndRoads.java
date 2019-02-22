import java.util.Scanner;

public class TownsAndRoads {

    public static void main(String[] args) {

        int[][] arr = {
                {0,1,0,0,0},
                {1,0,1,1,0},
                {0,1,0,0,0},
                {0,1,0,0,0},
                {0,0,0,0,0}
        };

        countRoads(arr);
    }

    public static int countRoads(int[][] arr){

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == arr[j][i] && i!=j && arr[i][j] != 0 && arr[j][i] != 0)
                    count++;
            }
        }
        return count/2;
    }
}
