import java.util.ArrayList;
import java.util.Scanner;

public class Task20 {

    public static void main(String[] args){

        ArrayList<String> strings = new ArrayList<>();
        int x = new Scanner(System.in).nextInt();//сколько строк добавить
        for (int i = 0; i < x; i++) {
            strings.add(new Scanner(System.in).next());//добавляем строки
        }
        strings.add(new Scanner(System.in).nextInt(), "jopa");//по указанному индексу
        System.out.println(String.format("%s %d", strings, strings.size()));//просмотр всех элементов и их число
        strings.subList((new Scanner(System.in).nextInt()), (new Scanner(System.in).nextInt()));//Изменяем размер ArrayList

    }

    static ArrayList<String> fer(ArrayList<String> strings){

        return null;
    }
}

