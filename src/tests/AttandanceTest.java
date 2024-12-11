package tests;

import org.junit.Before;
import org.junit.Test;

import collegeapplication.student.Attandance;

import static org.junit.Assert.*;

public class AttandanceTest {

    private Attandance attandance;

    @Before
    public void setUp() {
        attandance = new Attandance();
    }

    @Test
    public void testSetAndGetStudentName() {
        String studentName = "John Doe";
        attandance.setStudentName(studentName);
        assertEquals(studentName, attandance.getStudentName());
    }

    @Test
    public void testSetAndGetAttandanceDate() {
        String date = "2023-10-10";
        attandance.setAttandanceDate(date);
        assertEquals(date, attandance.getAttandanceDate());
    }

    @Test
    public void testSetAndGetAttandance() {
        int attandanceCount = 5;
        attandance.setAttandance(attandanceCount);
        assertEquals(attandanceCount, attandance.getAttandance());
    }

    @Test
    public void testSetAndGetTotalAttandance() {
        int totalAttandance = 10;
        attandance.setTotalAttandance(totalAttandance);
        assertEquals(totalAttandance, attandance.getTotalAttandance());
    }

    @Test
    public void testSetAndGetPresentStatus() {
        attandance.setPresentStatus(true);
        assertTrue(attandance.getPresentStatus());

        attandance.setPresentStatus(false);
        assertFalse(attandance.getPresentStatus());
    }

    @Test
    public void testSetAndGetRollNumber() {
        long rollNumber = 1001L;
        attandance.setRollNumber(rollNumber);
        assertEquals(rollNumber, attandance.getRollNumber());
    }

    @Test
    public void testSubjectFields() {
        // Assuming Attandance extends Subject
        attandance.setSubjectCode("MATH101");
        attandance.setSubjectName("Mathematics");
        attandance.setCourceCode("CS101");
        attandance.setSemorYear(1);
        attandance.setSubjectType("Core");

        assertEquals("MATH101", attandance.getSubjectCode());
        assertEquals("Mathematics", attandance.getSubjectName());
        assertEquals("CS101", attandance.getCourceCode());
        assertEquals(1, attandance.getSemorYear());
        assertEquals("Core", attandance.getSubjectType());
    }

    @Test
    public void testDefaultValues() {
        assertEquals(0, attandance.getAttandance());
        assertEquals(0, attandance.getTotalAttandance());
        assertFalse(attandance.getPresentStatus());
    }

    // Add additional tests if there are more methods in the Attandance class
}