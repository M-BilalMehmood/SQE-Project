package tests;

import org.junit.Before;
import org.junit.Test;

import collegeapplication.faculty.Faculty;

import static org.junit.Assert.*;

public class FacultyTest {

    private Faculty faculty;

    @Before
    public void setUp() {
        faculty = new Faculty();
    }

    @Test
    public void testSetAndGetFacultyId() {
        int facultyId = 1;
        faculty.setFacultyId(facultyId);
        assertEquals(facultyId, faculty.getFacultyId());
    }

    @Test
    public void testSetAndGetFacultyName() {
        String name = "Dr. John Doe";
        faculty.setFacultyName(name);
        assertEquals(name, faculty.getFacultyName());
    }

    @Test
    public void testSetAndGetQualification() {
        String qualification = "Ph.D. in Computer Science";
        faculty.setQualification(qualification);
        assertEquals(qualification, faculty.getQualification());
    }

    @Test
    public void testSetAndGetExperience() {
        String experience = "10 years";
        faculty.setExperience(experience);
        assertEquals(experience, faculty.getExperience());
    }

    @Test
    public void testSetAndGetSubject() {
        String subject = "Data Structures";
        faculty.setSubject(subject);
        assertEquals(subject, faculty.getSubject());
    }

    @Test
    public void testSetAndGetPosition() {
        String position = "Professor";
        faculty.setPosition(position);
        assertEquals(position, faculty.getPosition());
    }

    @Test
    public void testSetAndGetJoinedDate() {
        String joinedDate = "2020-01-15";
        faculty.setJoinedDate(joinedDate);
        assertEquals(joinedDate, faculty.getJoinedDate());
    }

    @Test
    public void testPersonFields() {
        // Testing inherited fields from Person class
        faculty.setEmailId("john.doe@example.com");
        faculty.setContactNumber("1234567890");
        faculty.setBirthDate("1980-05-20");
        faculty.setGender("Male");
        faculty.setState("California");
        faculty.setCity("Los Angeles");
        faculty.setFacultyId(105);
        faculty.setPassword("securepassword");

        assertEquals("john.doe@example.com", faculty.getEmailId());
        assertEquals("1234567890", faculty.getContactNumber());
        assertEquals("1980-05-20", faculty.getBirthDate());
        assertEquals("Male", faculty.getGender());
        assertEquals("California", faculty.getState());
        assertEquals("Los Angeles", faculty.getCity());
        assertEquals(105, faculty.getFacultyId());
        assertEquals("securepassword", faculty.getPassword());
    }

    @Test
    public void testProfilePic() {
        byte[] profilePic = new byte[]{1, 2, 3};
        faculty.setProfilePic(profilePic);
        //assertArrayEquals(profilePic, faculty.getProfilePic());
    }

    @Test
    public void testActiveStatus() {
        faculty.setActiveStatus(true);
        assertTrue(faculty.getActiveStatus());

        faculty.setActiveStatus(false);
        assertFalse(faculty.getActiveStatus());
    }

    @Test
    public void testLastLogin() {
        String lastLogin = "2023-10-15 10:00:00";
        faculty.setLastLogin(lastLogin);
        assertEquals(lastLogin, faculty.getLastLogin());
    }

    @Test
    public void testSrNo() {
        int srNo = 100;
        faculty.setSrNo(srNo);
        assertEquals(srNo, faculty.getSrNo());
    }
}