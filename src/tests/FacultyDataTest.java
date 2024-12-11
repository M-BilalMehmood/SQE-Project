package tests;

import static org.junit.Assert.*;
import org.junit.*;

import collegeapplication.faculty.Faculty;
import collegeapplication.faculty.FacultyData;
import collegeapplication.common.Notification;
import collegeapplication.common.NotificationData;

import java.sql.ResultSet;
import java.util.ArrayList;

public class FacultyDataTest {
    private static FacultyData facultyData;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        facultyData = new FacultyData();
        // Initialize any required resources
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        FacultyData.closeConnection();
    }

    @Test
    public void testAddFacultyData() {
        Faculty faculty = new Faculty();
        // Set up faculty data
        faculty.setFacultyId(facultyData.createFacultyID());
        faculty.setFacultyName("Alice Johnson");
        faculty.setState("California");
        faculty.setCity("Los Angeles");
        faculty.setEmailId("alice.johnson@example.com");
        faculty.setContactNumber("1234567890");
        faculty.setQualification("Ph.D. in Computer Science");
        faculty.setExperience("10 years");
        faculty.setBirthDate("1980-05-15");
        faculty.setGender("Female");
        // Set other necessary fields

        int result = facultyData.addFacultyData(faculty);
        assertEquals(1, result);
    }

    @Test
    public void testGetFacultyName() {
        String facultyId = "F123";
        String facultyName = facultyData.getFacultyName(facultyId);
        assertNotNull(facultyName);
        assertEquals("Alice Johnson", facultyName);
    }

    @Test
    public void testUpdateFacultyData() {
        Faculty oldFaculty = facultyData.getFacultyInfobyId(101);
        Faculty newFaculty = new Faculty();
        newFaculty.setFacultyName("Alice Smith");
        newFaculty.setQualification("Ph.D. in Software Engineering");
        // Set other updated fields

        int result = facultyData.updateFacultyData(oldFaculty, newFaculty);
        assertEquals(1, result);
    }

    @Test
    public void testGetFacultyInfobyId() {
        int facultyId = 101;
        Faculty faculty = facultyData.getFacultyInfobyId(facultyId);
        assertNotNull(faculty);
        assertEquals(facultyId, faculty.getFacultyId());
        assertEquals("Alice Smith", faculty.getFacultyName());
    }

    @Test
    public void testCheckPassword() {
        String facultyId = "F123";
        String password = "securePassword";
        boolean isValid = facultyData.checkPassword(facultyId, password);
        assertTrue(isValid);
    }

    @Test
    public void testChangePassword() {
        String facultyId = "F123";
        String newPassword = "newSecurePassword";
        int result = facultyData.changePassword(facultyId, newPassword);
        assertEquals(1, result);
    }

    @Test
    public void testGetTotalFaculaty() {
        int totalFaculty = facultyData.getTotalFaculaty();
        assertTrue(totalFaculty > 0);
    }

    @Test
    public void testGetFacultyInfo() {
        String condition = "WHERE state='California'";
        ResultSet rs = facultyData.getFacultyInfo(condition);
        assertNotNull(rs);
        // Additional assertions based on expected ResultSet
    }

    @Test
    public void testIsActive() {
        String facultyId = "F123";
        boolean isActive = facultyData.isActive(facultyId);
        assertTrue(isActive);
    }

    @After
    public void tearDown() throws Exception {
        // Clean up test data if necessary
    }
}