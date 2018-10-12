public class Task2 {

    public static void main(String[] args) {
        int[] monthDay = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 30, 31}; //сколько дней в каждом месяце
        String date = "4-2"; //дата задается через "-". то есть 1 февраля - "1-2"
        String[] week = {"выходной", "будни", "будни", "будни", "будни", "будни", "будни"};
        System.out.println(Calendar(date, monthDay, week));
    }

    static String Calendar(String date, int[] monthDay, String[] week){
        String[] subStr;
        String delimiter = "-";
        subStr = date.split(delimiter);
        int day = Integer.parseInt(subStr[0]);
        int month = Integer.parseInt(subStr[1]);
        for (int i = 0; i < month-1; i++) {
            day+=monthDay[i];
        }
        return week[(day%7)];
    }
}
