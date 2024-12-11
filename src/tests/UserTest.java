package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import collegeapplication.common.User;
import collegeapplication.student.StudentData;
import collegeapplication.faculty.FacultyData;

import java.text.SimpleDateFormat;
import java.util.Date;

// Assuming User is accessible within the tests package
public class UserTest {
    private User user;

    @Before
    public void setUp() {
        user = new User();
    }

    @Test
    public void testSetAndGetUserProfile() {
        String profile = "Student";
        user.setUserProfile(profile);
        assertEquals(profile, user.getUserProfile());
    }

    @Test
    public void testSetAndGetUserId() {
        String userId = "CS101-1-1001";
        user.setUserId(userId);
        assertEquals(userId, user.getUserid());
    }

    @Test
    public void testSetAndGetLoginTime() {
        String loginTime = "10-Oct-2023 08:30:00 AM";
        user.setLoginTime(loginTime);
        assertEquals("08:30 AM", user.getLoginTime());
    }

    @Test
    public void testGetLoginDateWhenToday() {
        // Set login time to current date
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss aaa");
        String currentDateTime = formatter.format(new Date());
        user.setLoginTime(currentDateTime);
        assertEquals("today", user.getLoginDate());
    }

    @Test
    public void testGetLoginDateWhenPast() {
        // Set login time to a past date
        String pastDateTime = "01-Jan-2023 10:00:00 AM";
        user.setLoginTime(pastDateTime);
        assertEquals("01-Jan,2023", user.getLoginDate());
    }

    @Test
    public void testGetCurrentDate() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM,yyyy");
        String expectedDate = dateFormatter.format(new Date());
        assertEquals(expectedDate, user.getCurrentDate());
    }

    @Test
    public void testGetNameForStudent() {
        String userId = "CS101-1-1001";
        user.setUserId(userId);
        user.setUserProfile("Student");

        // Mocking StudentData response
        StudentData studentData = new StudentData();
        String expectedName = "John Doe";
        // Assuming StudentData.setStudentName is available for testing
//        studentData.addStudentName(userId, expectedName);

        String actualName = user.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void testGetNameForFaculty() {
        String userId = "F123-1-2001";
        user.setUserId(userId);
        user.setUserProfile("Faculty");

        // Mocking FacultyData response
        FacultyData facultyData = new FacultyData();
        String expectedName = "Alice Smith";
        // Assuming FacultyData.setFacultyName is available for testing
//        facultyData.addFacultyName(userId, expectedName);

        String actualName = user.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void testGetNameForUnknownProfile() {
        user.setUserProfile("Admin");
        String actualName = user.getName();
        assertEquals("-", actualName);
    }

}