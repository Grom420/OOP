import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        String input = new Scanner(System.in).next();
        try {
            int number = Integer.parseInt(input); //если число
            System.out.println(ParseInt(number));
        } catch (NumberFormatException e){
            System.out.println(ParseString(input)); //если строка
        }
    }

    static int ParseInt(int numer){
        return numer*numer;
    }

    static String ParseString(String x){
        StringBuffer newStringX2 = new StringBuffer();
        for (int i = 0; i < x.length(); i++) {
           newStringX2.append(x.charAt(i));
           newStringX2.append(x.charAt(i));
        }
        return newStringX2.toString();
    }
}
