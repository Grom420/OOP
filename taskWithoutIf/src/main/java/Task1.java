public class Task1 {

    public static void main(String[] args) {
        int[] x = {1,2,3,4,5,6,7,4364334,9,10,2525};
        int count = 0;
        System.out.println(Result(x, count));
    }

    static int Result(int[] x, int count){
        for (int i = 0; i < x.length; i++) {
            count += Math.abs(x[i]%2);
        }
        return count;
    }
}


