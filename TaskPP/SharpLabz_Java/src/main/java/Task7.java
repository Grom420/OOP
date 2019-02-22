public class Task7 {

    public static void main(String[] args){

        int x = 50;
        Squares(x);
    }

    static void Squares(int x){
        int i = 1;
        while (i*i<x){
            System.out.println(i*i++);
        }
    }
}
