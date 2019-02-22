public class Task6 {

    public static void main(String[] args){

        int n = 4;
        SumFact(n);
    }

    static int SumFact(int n){

        int result = 1;
        int bufFact = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i+1; j++) {
                bufFact *= j;
            }
            result += bufFact;
            bufFact = 1;
        }
        return result;
    }
}

