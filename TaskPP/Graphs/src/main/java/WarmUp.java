public class WarmUp {

    public static void main(String[] args) {

        int n = 4;
        int[][] arr = {
                {25, 1},
                {70, 1},
                {100, 0},
                {40, 1}
        };
        max(arr, n);
    }

    public static int max(int[][] arr, int n){

        int max = 0;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i][1] == 1 && arr[i][0] > max) {
                max = arr[i][0];
                index = i;
            }
        }
        if (index == -1)
            return index;
            else
        return index+1;
    }
}
