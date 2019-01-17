import java.util.ArrayList;

public class TrafficLights {

    public static void main(String[] args) {

        int n = 7;

        int[][] arr = {
                {5, 1},
                {3, 2},
                {7, 1},
                {5, 2},
                {7, 4},
                {6, 5},
                {6, 4},
                {7, 5},
                {2, 1},
                {5, 3}
        };
        System.out.println(countTrafficLights(arr, n));
    }

    public static ArrayList<Integer> countTrafficLights(int[][] arr, int n){
        ArrayList<Integer> count = new ArrayList<>();
        int buf = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < arr.length; j++) {
                if ((i == arr[j][0] || i == arr[j][1]) && (i != arr[j][0] || i != arr[j][1]))
                    buf++;
            }
            count.add(buf);
            buf = 0;
        }
        return count;
    }
}
