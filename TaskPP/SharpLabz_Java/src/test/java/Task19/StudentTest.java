package Task19;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    Student stud = new Student("Кокорин", "Алексей", 2, 3, 5);

    @Test
    public void getsName() {

        assertEquals("Кокорин", stud.getsName());
    }

    @Test
    public void getName() {

        assertEquals("Алексей", stud.getName());
    }

    @Test
    public void getMath() {

        assertEquals(2, stud.getMath());
    }

    @Test
    public void getPhys() {

        assertEquals(3, stud.getPhys());
    }

    @Test
    public void getInf() {

        assertEquals(5, stud.getInf());
    }

}