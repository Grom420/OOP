import java.util.ArrayList;
import java.util.Arrays;

public class Task12 {

    public static void main(String[] args){

        int[] x = {1, 92, 6, 7};
        int[] y = {8, 9, 12};
        AddArray(x, y);
    }

    static int[] AddArray(int[] x, int[] y){

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (Integer item : x){
            arrayList.add(item);
        }
        for (Integer item : y){
            arrayList.add(item);
        }
        int[] result = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            result[i] = arrayList.get(i);
        }
        Arrays.sort(result);
        return result;
    }
}
