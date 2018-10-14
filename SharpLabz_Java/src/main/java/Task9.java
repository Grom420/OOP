public class Task9 {

    public static void main(String[] args){

        int x = 1234567;
        System.out.println(Reverse(x));
        long millis1 = System.currentTimeMillis() % 1000;
        for (int i = 0; i < 1000000; i++) {
            Reverse(x);
        }
        long millis2 = System.currentTimeMillis() % 1000;
        System.out.println(millis2-millis1);
    }

    static int Reverse(int x){

        StringBuffer y = new StringBuffer();
        while (x != 0) {
            y.append(x % 10);
            x /= 10;//отбрасываем эту цифру
        }
        return Integer.parseInt(y.toString());
    }
}
