package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import collegeapplication.subject.Subject;

public class SubjectTest {

    private Subject subject;

    @Before
    public void setUp() {
        subject = new Subject();
    }

    @Test
    public void testSetAndGetSubjectName() {
        String expectedName = "Mathematics";
        subject.setSubjectName(expectedName);
        assertEquals(expectedName, subject.getSubjectName());
    }

    @Test
    public void testSetAndGetSubjectCode() {
        String expectedCode = "MATH101";
        subject.setSubjectCode(expectedCode);
        assertEquals(expectedCode, subject.getSubjectCode());
    }

    @Test
    public void testSetAndGetSubjectType() {
        String expectedType = "Core";
        subject.setSubjectType(expectedType);
        assertEquals(expectedType, subject.getSubjectType());
    }

    @Test
    public void testSetAndGetMaxTheoryMarks() {
        int expectedMarks = 100;
        subject.setMaxTheoryMarks(expectedMarks);
        assertEquals(expectedMarks, subject.getMaxTheoryMarks());
    }

    @Test
    public void testSetAndGetMaxPracticalMarks() {
        int expectedMarks = 50;
        subject.setMaxPracticalMarks(expectedMarks);
        assertEquals(expectedMarks, subject.getMaxPracticalMarks());
    }

    @Test
    public void testDefaultTheoryMarks() {
        assertEquals(0, subject.getMaxTheoryMarks());
    }

    @Test
    public void testDefaultPracticalMarks() {
        assertEquals(0, subject.getMaxPracticalMarks());
    }
}