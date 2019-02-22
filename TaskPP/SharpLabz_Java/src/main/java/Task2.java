public class Task2 {

    public static void main(String[] args){

        double x = 12353414.56;

        Tens(x);
    }

    static int Tens(double x){
        return (int)x%100/10;
    }
}
