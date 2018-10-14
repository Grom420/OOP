public class Task16 {

    public static void main(String[] args){

        StringBuilder s = new StringBuilder();
        int l = 12;
        char[] symbol = { '!', '?', ';' };
        for (int i = 0; i<(l-3); i++)
        {
            s.append((char)(Random(97,104)));//код символов "a" и "h"
            s.append(Random(1, 7));
            s.append(symbol[Random(0, 2)]);

        }
        System.out.println(s.toString());
        System.out.println(Replace(s));
    }

    static String Replace(StringBuilder s){
        return s.toString().replace(';', '_');
    }

    public static int Random(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
