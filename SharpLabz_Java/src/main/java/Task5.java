public class Task5 {

    public static void main(String[] args){

        int n = 5;
        Sequence(n);
    }

    static double Sequence(int n){

        double result = 1;
        double bufSum = 1;
        double bufDiv;
        for (int i = 1; i <= n; i++) {
            bufSum += (i + 1);
            bufDiv = 1 / bufSum;
            result += bufDiv;
        }
        return result;
    }
}
