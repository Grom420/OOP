public class Task8 {

    public static void main(String[] args){

        int x = 222362;
        System.out.println(NumberOfOdds(x));
        long millis1 = System.currentTimeMillis() % 1000;
        for (int i = 0; i < 1000000; i++) {
            NumberOfOdds(x);
        }
        long millis2 = System.currentTimeMillis() % 1000;
        System.out.println(millis2-millis1);
    }

    static int NumberOfOdds(int x){
        int bufDigit;
        int count = 0;
        while (x != 0)
        {
            bufDigit = x % 10; //берем последнюю цифру
            if (bufDigit % 2 != 0)
                count++;

            x /= 10;//отбрасываем эту цифру
        }
        return count;
    }
}
