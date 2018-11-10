import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1723 {

    public static void main(String[] args) {

        String x = new Scanner(System.in).next();
        String strings = null;
        int count = 0;
        int max = 0;
        for (int i = 0; i < x.length(); i++) {
            Pattern pattern = Pattern.compile(x.substring(i, i+1));
            Matcher matcher = pattern.matcher(x);
            while (matcher.find()) {
                count++;
            }
            if (count > max) {
                max = count;
                strings = x.substring(i, i+1);
            }
            count = 0;
        }
        System.out.println(strings);
    }
}
