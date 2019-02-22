public class Task15 {

    public static void main(String[] args){

        String a = "rwrq";
        String b = "rw";
        System.out.println((int)'a');
        Contains(a,b);
    }

    static String Contains(String a, String b){
        if (a.contains(b))
            return "yes";
        else
            return "no";
    }
}
