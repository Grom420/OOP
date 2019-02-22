public class Task4 {

    public static void main(String[] args){


        int n = 5;
        Sequence(n);
    }

    static double Sequence(int n){
        double result = 0;
        for (int k = 1; k <= 2*n; k++)
        {
            if (k % 3 != 0)
            {
                result += (Math.pow(-1, (k+1)) / k);
            }
            else if (k == 0)
            {
                result += (Math.pow(-1, (k+1)) / k);
            }
        }
        return result;
    }
}
