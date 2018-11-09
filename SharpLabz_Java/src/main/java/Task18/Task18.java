package Task18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task18 {

    public static void main(String[] args){

        Student[] studs = new Student[7];
        int n = 4; //группы студентов
        studs[0] = new Student("Жока", "Боков", Spec.ПО);
        studs[1] = new Student("Пидор", "Соколов", Spec.РПИС);
        studs[2] = new Student("Кидор1", "Соколо1", Spec.ПО);
        studs[3] = new Student("Сидор2", "Соколов2", Spec.УИТС);
        studs[4] = new Student("Зидор3", "Соколов3", Spec.РПИС);
        studs[5] = new Student("Цикало", "Соколов3", Spec.ПО);
        studs[6] = new Student("Зорин", "Соколов3", Spec.УИТС);
        Arrays.sort(studs, Student::compareTo);
        Group group = new Group();
        System.out.println(group.getGroup(studs, n));
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
}

class Group{

    public String getGroup(Student[] studs, int n){

        StringBuilder sb = new StringBuilder();

        long groupID = Math.round((double)studs.length/(double)n);
        int countStud = 0;

        for (int i = 0; i < n; i++) {//цикл количества групп
            sb.append("Группа ").append(i+1).append(": ");
            for (int j = 0; j < groupID; j++) {//цикл распределения челов по группам (сколько человек на одну группу)
                if (i == n-1){//если последний чел
                    for (int k = countStud; k < studs.length; k++) {//кидаем оставшихся в последнюю группу
                        sb.append(studs[countStud].toString());
                        countStud++;
                    }
                    continue;
                }
                if (i < n-1){//если не последний чел
                    sb.append(studs[countStud].toString()).append(", ");
                    countStud++;
                }
            }
            if (i != n-1)
                sb.append("\n");
        }
        return sb.toString();
    }
}

