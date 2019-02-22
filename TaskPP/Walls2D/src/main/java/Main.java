import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> arrList = Arrays.asList(5,5,5,6);
        squareInt(arrList);
    }

    public static int squareInt(List<Integer> arrList){ //разбиваем на несколько сублистов между нулями

        List<Integer> sub = new ArrayList<>();

        int square = 0;
        int countZero = 0;

        for (int i = 0; i < arrList.size(); i++) {

            if (arrList.get(i) == 0)
                countZero++;
            else
                countZero = 0;
            if (arrList.get(i) != 0 && countZero < 2)
                sub.add(arrList.get(i));
            else if (countZero<2 && i != 0){
                square += squareSub(sub.stream().mapToInt(Integer::intValue).toArray());
                sub.clear();
            }
        }

        if (sub.size() != 0)
            square += squareSub(sub.stream().mapToInt(Integer::intValue).toArray());

        return square;
    }

    public static int squareSub(int[] arr){//высчитываем лунки в отдельном сублисте

        int rightMax = 0;
        int right = arr.length - 1;
        int left = 0;
        int leftMax = 0;
        int localLeftSquare = 0;
        int localRightSquare = 0;
        int max = 0;

        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] > max)
                max = arr[i];
        }

        while (arr[left] < max)
        {

            if (arr[left] > leftMax)
            {
                leftMax = arr[left];
            }
            localLeftSquare += leftMax - arr[left];
            left++;
        }

        while (arr[right] < max)
        {
            if (arr[right] > rightMax)
            {
                rightMax = arr[right];
            }
            localRightSquare += rightMax - arr[right];
            right--;
        }
        return localLeftSquare+localRightSquare;
    }
}
