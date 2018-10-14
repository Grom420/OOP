public class Task3 {

    public static void main(String[] args){
        double m = 3;
        Expression(m);
    }

    static int Expression(double m){
        double numeratorX;
        double denominatorX;
        double result;

        double n = 5;
        double p = 6.7;
        double a = 8.2;
        double b = 2.2;
        double c = 4.6;
        double d = 1.2;
        double e = 3.6;
        double z = 52.7 * (Math.pow(a, n) / Math.pow(b, 2.5));
        numeratorX = Math.pow(2, 1 / n)*(12.3 + z)*(12.3 - z);
        denominatorX = Math.log(Math.sqrt(132 / 5 + Math.sin(Math.pow(e, m)))) - Math.cos(Math.pow(d, p) * c);
        result = numeratorX / denominatorX;
        return (int)result;
    }
}
