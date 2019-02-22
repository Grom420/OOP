package Task18;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class GroupTest {

    @Test
    public void getGroup() {

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
        StringBuilder sb = new StringBuilder();
        sb.append("Группа 1: Жока Боков (ПО), Зидор3 Соколов3 (РПИС), \n");
        sb.append("Группа 2: Зорин Соколов3 (УИТС), Кидор1 Соколо1 (ПО), \n");
        sb.append("Группа 3: Пидор Соколов (РПИС), Сидор2 Соколов2 (УИТС), \n");
        sb.append("Группа 4: Цикало Соколов3 (ПО), ");
        assertEquals(sb.toString(), new Group().getGroup(studs, n));
    }
}