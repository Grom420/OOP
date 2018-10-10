public class Task1 {

    public static void main(String[] args) {
        int[] x = {1,2,3,4,5,6,7,8,9,10};
        int count = 0;
        for (int i = 0; i < x.length; i++) {
            count += x[i]%2;
        }
        System.out.println(count);
    }

}
