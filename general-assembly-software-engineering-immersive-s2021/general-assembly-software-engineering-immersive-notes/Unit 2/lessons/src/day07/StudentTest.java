package day07;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {
    private Student student;

    //Before any unit test, run this method first.
    @Before
    public void createStudentObject() {
        student = new Student("Parham", "Keshavarzi", 'A');
    }

    @Test
    public void getFirstName() {
        String expected = "Parham";
        String actual = student.getFirstName();
        assertEquals(expected, actual);
    }

    @Test
    public void getLastName() {
        String expected = "Keshavarzi";
        String actual = student.getLastName();
        assertEquals(expected, actual);
    }


}
