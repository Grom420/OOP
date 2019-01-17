public class Mockery {

    public static void main(String[] args) {

        int[][] arrMatrix = {
                {0, 20, 10, 30, 40},
                {20, 0, 30, 1, 1000},
                {10, 30, 0, 40, 2},
                {30, 1, 40, 0, 21},
                {40, 2, 1000, 21, 0}
        };
        route(arrMatrix);
    }

    public static void route(int[][] arrMatrix){

        int[] square = new int[3];
        int len = 10000;
        int minLen;
        for (int i = 0; i < arrMatrix.length-2; i++) {
            for (int j = i+1; j < arrMatrix.length-1; j++) {
                for (int k = j+1; k < arrMatrix.length; k++) {
                    minLen = arrMatrix[i][j] + arrMatrix[j][k] + arrMatrix[k][i];
                    if (minLen< len) {
                        len = minLen;
                        square[0] = i;
                        square[1] = j;
                        square[2] = k;
                    }
                }
            }
        }
        System.out.printf("%d %d %d", square[0]+1, square[1]+1, square[2]+1);
    }
}
