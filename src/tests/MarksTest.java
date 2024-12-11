package tests;

import org.junit.Before;
import org.junit.Test;

import collegeapplication.student.Marks;

import static org.junit.Assert.*;

public class MarksTest {

    private Marks marks;

    @Before
    public void setUp() {
        marks = new Marks();
    }

    @Test
    public void testSetAndGetSrNo() {
        int srNo = 1;
        marks.setSrNo(srNo);
        assertEquals(srNo, marks.getSrNo());
    }

    @Test
    public void testSetAndGetTheoryMarks() {
        int theoryMarks = 85;
        marks.setTheoryMarks(theoryMarks);
        assertEquals(theoryMarks, marks.getTheoryMarks());
    }

    @Test
    public void testSetAndGetPracticalMarks() {
        int practicalMarks = 90;
        marks.setPracticalMarks(practicalMarks);
        assertEquals(practicalMarks, marks.getPracticalMarks());
    }

    @Test
    public void testSetAndGetStudentName() {
        String studentName = "Alice Smith";
        marks.setStudentName(studentName);
        assertEquals(studentName, marks.getStudentName());
    }

    @Test
    public void testSetAndGetRollNumber() {
        long rollNumber = 1001L;
        marks.setRollNumber(rollNumber);
        assertEquals(rollNumber, marks.getRollNumber());
    }

    @Test
    public void testSubjectFields() {
        // Assuming Marks extends Subject, test inherited fields
        marks.setSubjectCode("MATH101");
        marks.setSubjectName("Mathematics");
        marks.setMaxTheoryMarks(100);
        marks.setMaxPracticalMarks(50);
        marks.setCourceCode("CS101");
        marks.setSemorYear(1);
        marks.setSubjectType("Core");

        assertEquals("MATH101", marks.getSubjectCode());
        assertEquals("Mathematics", marks.getSubjectName());
        assertEquals(100, marks.getMaxTheoryMarks());
        assertEquals(50, marks.getMaxPracticalMarks());
        assertEquals("CS101", marks.getCourceCode());
        assertEquals(1, marks.getSemorYear());
        assertEquals("Core", marks.getSubjectType());
    }

    @Test
    public void testDefaultValues() {
        assertEquals(0, marks.getTheoryMarks());
        assertEquals(0, marks.getPracticalMarks());
    }

    // Add additional tests if there are more methods in the Marks class
}