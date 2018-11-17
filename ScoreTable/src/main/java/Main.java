import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        StreamTokenizer streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);
        streamTokenizer.nextToken();
        int n = (int)streamTokenizer.nval;
        int[][] arr = new int [n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                streamTokenizer.nextToken();
                arr[i][j] = (int)streamTokenizer.nval;
            }
        }
        arr = sort(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                out.print(arr[i][j] + " ");
            }
            out.print("\n");
        }
        out.close();
        out.flush();
    }

    public static int[][] sort(int[][] arr) {
        if (arr.length < 2)
            return arr;
        int middle = arr.length / 2;
        return merge(sort(Arrays.copyOfRange(arr, 0, middle)),
                sort(Arrays.copyOfRange(arr, middle, arr.length)), arr.length);
    }

    public static int[][] merge(int[][] arrOne, int[][] arrTwo, int len) {
        int indexOne = 0;
        int indexTwo = 0;
        int[][] result = new int[len][2];
        for (int i = 0; i < len; i++) {
            if (indexTwo < arrTwo.length && indexOne < arrOne.length) {
                if (arrOne[indexOne][1] < arrTwo[indexTwo][1]) result[i] = arrTwo[indexTwo++];
                else result[i] = arrOne[indexOne++];
            } else if (indexTwo < arrTwo.length) {
                result[i] = arrTwo[indexTwo++];
            } else {
                result[i] = arrOne[indexOne++];
            }
        }
        return result;
    }
}
