public class ColorRain {

    public static void main(String[] args) {

        int[][] arrMatrix = {
                {0, 1, 0, 0, 0, 1, 1},
                {1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 1, 0},
                {1, 0, 1, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0}
        };

        int[] arrColor = {1, 1, 1, 1, 1, 3, 3};
        int n = 7;
        System.out.println(badBridge(arrMatrix, arrColor, n));
    }

    public static int badBridge(int[][] arrMatrix, int[] arrColor, int n){

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (arrMatrix[i][j] == 1){
                    if (arrColor[i] != arrColor[j])
                        count++;
                }
            }
        }
        return count;
    }
}
