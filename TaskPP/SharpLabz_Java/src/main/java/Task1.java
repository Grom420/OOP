public class Task1 {

    public static void main(String[] args){

        int x = 2;
        Pow(x);
    }

    static int Pow(int x){
        int x2 = x*x;
        int x4 = x2*x2;
        int x6 = x4*x2;
        return x6;
    }
}
