public class Task2 {

    public static void main(String[] args) {
        int[] monthDay = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 30, 31}; //сколько дней в каждом месяце
        String date = "31-12"; //дата задается через "-". то есть 1 февраля - "1-2"
        Calendar(date, monthDay);
    }

    static void Calendar(String date, int[] monthDay){
        String[] subStr;
        String delimiter = "-";
        subStr = date.split(delimiter);
        int day = Integer.parseInt(subStr[0]);
        int month = Integer.parseInt(subStr[1]);
        for (int i = 0; i < month-1; i++) {
            day+=monthDay[i];
        }
        if(day%7 == 0) //определяем выходной день - воскресенье; год начался с понедельника
            System.out.println("выходной");
        else System.out.println("будни");
    }
}
