import java.util.Scanner;

public class Task14 {

    public static void main(String[] args){

        String stringA = new Scanner(System.in).nextLine();
        CountWord(stringA);
    }

    static int CountWord(String stringA){
        int countWord = 0;
        int i = 1;
        while (i < stringA.length())
        {
            if (stringA.charAt(i) == ' ' && stringA.charAt(i-1) != ' ')
                countWord++;
            i++;
        }
        if (stringA.charAt(stringA.length()-1) == ' ')
        {
            return countWord;
        }
        else
        {
            return  countWord+1;
        }
    }
}
