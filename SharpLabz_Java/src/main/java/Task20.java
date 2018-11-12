import java.util.ArrayList;
import java.util.Scanner;

public class Task20 {

    public static void main(String[] args){

        ArrayList<String> strings = new ArrayList<>();



        int x = new Scanner(System.in).nextInt();//сколько строк добавить
        for (int i = 0; i < x; i++) {
            strings.add(new Scanner(System.in).nextLine());//добавляем строки
        }
        deletePunct(strings);
        deleteSpace(strings);
        missingSpace(strings);
        formatNumber(strings);
        strings.add(new Scanner(System.in).nextInt(), "jopa");//по указанному индексу
        System.out.println(String.format("%s %d", strings, strings.size()));//просмотр всех элементов и их число
        strings.subList((new Scanner(System.in).nextInt()), (new Scanner(System.in).nextInt()));//Изменяем размер ArrayList

    }

    static ArrayList<String> deleteSpace(ArrayList<String> strings){

        for (int i = 0; i < strings.size(); i++) {
            while(strings.get(i).contains("  "))
                strings.set(i, strings.get(i).replaceAll("[ ][ ]", " "));
        }
        return strings;
    }

    static ArrayList<String> deletePunct(ArrayList<String> strings){

        for (int i = 0; i < strings.size(); i++) {
            while(strings.get(i).contains(",,"))
                    strings.set(i, strings.get(i).replaceAll(",,", ","));
        }

        for (int i = 0; i < strings.size(); i++) {
            while(strings.get(i).contains(".."))
                    strings.set(i, strings.get(i).replaceAll("[.][.]", "."));
        }

        return strings;
    }

    static ArrayList<String> missingSpace(ArrayList<String> strings){


        for (int i = 0; i < strings.size(); i++)
            strings.set(i, strings.get(i).replaceAll("(?<=\\p{Punct})(?=\\w)", " "));

        return strings;

    }

    static boolean isNumber(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    static ArrayList<String> formatNumber(ArrayList<String> strings){

        for (int i = 0; i < strings.size(); i++) {

            if(isNumber(strings.get(i))){
                strings.set(i, String.format("0.%s", strings.get(i)));
            }

        }
        return strings;
    }
}

