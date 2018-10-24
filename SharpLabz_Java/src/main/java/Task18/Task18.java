package Task18;

import java.util.Arrays;

public class Task18 {

    public static void main(String[] args){

        Student[] studs = new Student[7];
        int n = 3; //группы студентов
        studs[0] = new Student("Жока", "Боков", Spec.ПО);
        studs[1] = new Student("Пидор", "Соколов", Spec.РПИС);
        studs[2] = new Student("Кидор1", "Соколо1", Spec.ПО);
        studs[3] = new Student("Сидор2", "Соколов2", Spec.УИТС);
        studs[4] = new Student("Зидор3", "Соколов3", Spec.РПИС);
        studs[5] = new Student("Цикало", "Соколов3", Spec.ПО);
        studs[6] = new Student("Зорин", "Соколов3", Spec.УИТС);
        Arrays.sort(studs, Student::compareTo);
        long groupID = Math.round((double)studs.length/(double)n);
        System.out.println(groupID);
        //countStud++;
        //System.out.println(sb);
        //sb.delete(0,sb.length());
        int countStud = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("Группа ").append(i+1).append(" ");
            for (int j = 0; j < groupID; j++) {
                if (i == n-1){
                    for (int k = countStud; k < studs.length; k++) {
                        sb.append(studs[countStud].toString()).append(", ");
                    }
                    System.out.println(sb);
                    continue;
                }
                if (i < n-1){
                    sb.append(studs[countStud].toString()).append(", ");
                    System.out.println(sb);
                    sb.delete(0,sb.length());
                }
            }
        }
    }
}


enum Spec  { ПО, РПИС, УИТС }

class Student implements Comparable<Student>
{
    public int compareTo(Student other){
        return (name.charAt(0) - other.name.charAt(0));
    }

    private String name;
    private String sName;
    private Spec special;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(name).append(" ").append(sName).append(" ").append("(").append(special).append(")");
        return sb.toString();
    }

    public Student(String name, String sName, Spec special) {
        this.name = name;
        this.sName = sName;
        this.special = special;
    }

    public Student(){
        this.name = null;
        this.sName = null;
        this.special = null;
    }
}

