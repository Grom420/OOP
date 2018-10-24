import java.util.Random;

public class Task10 {

    public static void main(String[] args){

        Random randNum = new Random(); //создаем переменную класса случайных чисел
        int[] arrNum = new int[1000000];
        for (int i = 0; i < arrNum.length; i++)
        {
            arrNum[i] = ((int)(Math.random() * 101) - 50);
        }
        System.out.println();
        int divCount = CountDivThree(arrNum);
        int sumNum = SumPositives(arrNum);
        int elemPositive = IndexOfMaxPositive(arrNum);
        boolean zeroCheck = ContainsZero(arrNum);
        System.out.println("Количество элементов, кратных трем: " + divCount);
        System.out.println("Сумма положительных чисел: " + sumNum);
        System.out.println("Элемент максимального положительного числа: " + elemPositive);
        System.out.println("Есть ли нулевые значения? " + zeroCheck);
        EvenElement(arrNum);
    }

    static int CountDivThree(int[] b)
    {
        int CountDivThree = 0;
        for (int i = 0; i < b.length; i++)
        {
            if (b[i] % 3 == 0 && b[i] != 0)
                CountDivThree++;
        }
        return CountDivThree;
    }
    static int SumPositives(int[] b)
    {
        int SumPositives = 0;
        for (int i = 0; i < b.length; i++)
        {
            if (b[i]>0)
                SumPositives += b[i];
        }
        return SumPositives;
    }
    static int IndexOfMaxPositive(int[] b)
    {
        int maxNum = b[0];
        int IndexOfMaxPositive = 0;
        for (int i = 0; i < b.length; i++)
        {
            if (maxNum < b[i] && b[i]>0)
            {
                maxNum = b[i];
                IndexOfMaxPositive = i;
            }
        }
        return IndexOfMaxPositive;
    }
    static boolean ContainsZero(int[] b)
    {
        for (int i = 0; i < b.length; i++)
        {
            if (b[i] == 0)
            {
                return true;
            }
        }
        return false;
    }

    static void EvenElement(int[] b)
    {
        for (int i = 0; i < b.length; i++)
        {
            if (i % 2 == 0)
                System.out.printf("a[%d] = %d\n", i, b[i]);
        }
    }
}
