package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import collegeapplication.student.Student;

public class StudentTest {
    
    private Student student;
    
    @Before
    public void setUp() {
        student = new Student();
    }

    @Test
    public void testBasicSettersAndGetters() {
        // Setup test data
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setFatherName("James Doe");
        student.setMotherName("Jane Doe");
        student.setFatherOccupation("Engineer");
        student.setMotherOccupation("Doctor");
        student.setRollNumber(12345L);
        student.setOptionalSubject("Physics");
        student.setAdmissionDate("2024-03-20");
        student.setUserId("STU123");
        student.setCourceCode("CS");
        student.setSemorYear(1);

        // Verify all getters
        assertEquals("John", student.getFirstName());
        assertEquals("Doe", student.getLastName());
        assertEquals("James Doe", student.getFatherName());
        assertEquals("Jane Doe", student.getMotherName());
        assertEquals("Engineer", student.getFatherOccupation());
        assertEquals("Doctor", student.getMotherOccupation());
        assertEquals(12345L, student.getRollNumber());
        assertEquals("Physics", student.getOptionalSubject());
        assertEquals("2024-03-20", student.getAdmissionDate());
        assertEquals("STU123", student.getUserId());
        assertEquals("CS", student.getCourceCode());
        assertEquals(1, student.getSemorYear());
    }

    @Test
    public void testGetFullName() {
        student.setFirstName("John");
        student.setLastName("Doe");
        assertEquals("John Doe", student.getFullName());
    }

    @Test
    public void testGetFullNameWithNullValues() {
        assertEquals("null null", student.getFullName());
    }

    @Test
    public void testGenerateUserId() {
        student.setCourceCode("CS");
        student.setSemorYear(1);
        student.setRollNumber(101);
        assertEquals("CS-1-101", student.generateUserId());
    }

    @Test
    public void testGenerateAdmissionDate() {
        String generatedDate = student.generateAdmissionDate();
        assertNotNull(generatedDate);
        assertEquals(generatedDate, student.getAdmissionDate());
    }

    @Test
    public void testInitialValues() {
        Student newStudent = new Student();
        assertNull(newStudent.getFirstName());
        assertNull(newStudent.getLastName());
        assertNull(newStudent.getFatherName());
        assertNull(newStudent.getMotherName());
        assertNull(newStudent.getFatherOccupation());
        assertNull(newStudent.getMotherOccupation());
        assertEquals(0L, newStudent.getRollNumber());
        assertNull(newStudent.getOptionalSubject());
        assertNull(newStudent.getAdmissionDate());
        assertNull(newStudent.getUserId());
    }

    @Test
    public void testNullSetters() {
        student.setFirstName(null);
        student.setLastName(null);
        student.setFatherName(null);
        student.setMotherName(null);
        student.setFatherOccupation(null);
        student.setMotherOccupation(null);
        student.setOptionalSubject(null);
        student.setAdmissionDate(null);
        student.setUserId(null);

        assertNull(student.getFirstName());
        assertNull(student.getLastName());
        assertNull(student.getFatherName());
        assertNull(student.getMotherName());
        assertNull(student.getFatherOccupation());
        assertNull(student.getMotherOccupation());
        assertNull(student.getOptionalSubject());
        assertNull(student.getAdmissionDate());
        assertNull(student.getUserId());
    }

    @Test 
    public void testGetCourceName() {
        student.setCourceCode("CS101");
        String courseName = student.getCourceName();
        // Note: This will return null or actual value depending on database
        // We're just ensuring the method doesn't throw an exception
        assertNotNull(courseName);
    }
}