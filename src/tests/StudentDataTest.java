package tests;

import static org.junit.Assert.*;
import org.junit.*;

import collegeapplication.student.Student;
import collegeapplication.student.StudentData;
import collegeapplication.student.Marks;
import collegeapplication.student.Attandance;

import java.awt.Image;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentDataTest {
    private static StudentData studentData;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        studentData = new StudentData();
        // Initialize any required resources
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        StudentData.closeConnection();
    }

    @Test
    public void testAddStudent() {
        Student student = new Student();
        // Set up student data
        student.setCourceCode("CS101");
        student.setSemorYear(1);
        student.setRollNumber(1001);
        student.setOptionalSubject("Mathematics");
        student.setFirstName("John");
        student.setLastName("Doe");
        // Set other necessary fields

        int result = studentData.addStudent(student);
        assertEquals(1, result);
    }

    @Test
    public void testDeleteMarksData() {
        Student student = new Student();
        student.setCourceCode("CS101");
        student.setSemorYear(1);
        student.setRollNumber(1001);

        int result = studentData.deleteMarksData(student);
        assertTrue(result >= 0);
    }

    @Test
    public void testDeleteAttandanceData() {
        Student student = new Student();
        student.setCourceCode("CS101");
        student.setSemorYear(1);
        student.setRollNumber(1001);

        int result = studentData.deleteAttandanceData(student);
        assertTrue(result >= 0);
    }


    @Test
    public void testReArrangeChatSrNoColumn() {
        studentData.reArrangeChatSrNoColumn();
        // Verify if chat serial numbers are rearranged
        // Assertions based on the expected outcome
    }

    @Test
    public void testUpdateStudentData() {
        Student oldStudent = studentData.getStudentDetails("CS101", 1, 1001L);
        Student newStudent = new Student();
        newStudent.setFirstName("Jane");
        newStudent.setLastName("Smith");
        // Set other updated fields

        int result = studentData.updateStudentData(oldStudent, newStudent);
        assertEquals(1, result);
    }

    @Test
    public void testGetTotalStudentInCource() {
        int total = studentData.getTotalStudentInCource("CS101", 1);
        assertTrue(total >= 0);
    }

    @Test
    public void testGetRollNumber() {
        String[] rollNumbers = studentData.getRollNumber("CS101", 1);
        assertNotNull(rollNumbers);
    }

    @Test
    public void testGetStudentinfo() throws Exception {
        ResultSet rs = studentData.getStudentinfo("");
        assertNotNull(rs);
        // Additional assertions can be made based on the expected result set
    }

    @Test
    public void testGetStudentDetails() {
        Student student = studentData.getStudentDetails("CS101", 1, 1001L);
        assertNotNull(student);
        assertEquals("CS101", student.getCourceCode());
        assertEquals(1, student.getSemorYear());
        assertEquals(1001L, student.getRollNumber());
    }

    @Test
    public void testAddStudentTheoryMarks() {
        Marks marks = new Marks();
        // Set up marks data
        marks.setCourceCode("CS101");
        marks.setSemorYear(1);
        marks.setRollNumber(1001);
        marks.setSubjectName("Mathematics");
        marks.setTheoryMarks(80);

        int result = studentData.addStudentTheoryMarks(marks);
        assertEquals(1, result);
    }

    @Test
    public void testAddStudentPracticalMarks() {
        Marks marks = new Marks();
        // Set up marks data
        marks.setCourceCode("CS101");
        marks.setSemorYear(1);
        marks.setRollNumber(1001);
        marks.setSubjectName("Physics");
        marks.setPracticalMarks(85);

        int result = studentData.addStudentPracticalMarks(marks);
        assertEquals(1, result);
    }

    @Test
    public void testGetTotalStudents() {
        int totalStudents = studentData.getTotalStudents();
        assertTrue(totalStudents > 0);
    }

    @Test
    public void testGetMarksheetOfStudent() {
        ArrayList<Marks> marksList = studentData.getMarkssheetOfStudent("CS101", 1, 1001L);
        assertNotNull(marksList);
        assertFalse(marksList.isEmpty());
    }

    @Test
    public void testAddStudentAttandance() {
        Attandance attandance = new Attandance();
        attandance.setSubjectCode("MATH101");
        attandance.setAttandanceDate("2023-10-10");
        attandance.setRollNumber(1001);
        attandance.setPresentStatus(true);
        attandance.setCourceCode("CS101");
        attandance.setSemorYear(1);

        int result = studentData.addStudentAttandance(attandance);
        assertEquals(1, result);
    }

    @Test
    public void testCheckPassword() {
        boolean isValid = studentData.checkPassword("CS101-1-1001", "password123");
        assertTrue(isValid);
    }

    @Test
    public void testChangePassword() {
        int result = studentData.changePassword("CS101-1-1001", "newPassword123");
        assertEquals(1, result);
    }

        @Test
    public void testGetStudentsForAttandance() {
        Attandance a = new Attandance();
        a.setCourceCode("CS101");
        a.setSemorYear(1);
        a.setAttandanceDate("2023-10-10");
        a.setSubjectCode("MATH101");
        a.setSubjectName("Mathematics");
    
        ArrayList<Attandance> list = studentData.getStudentsForAttandance(a);
        assertNotNull(list);
        assertFalse(list.isEmpty());
        // Additional assertions can be added based on expected data
    }
    
    @Test
    public void testIsSubmitted() {
        String subjectCode = "MATH101";
        String date = "2023-10-10";
        boolean submitted = studentData.isSubmitted(subjectCode, date);
        // Assuming attendance is not submitted yet
        assertFalse(submitted);
    }
    
    @Test
    public void testGetAttandanceReportBySubject() {
        Attandance a = new Attandance();
        a.setCourceCode("CS101");
        a.setSemorYear(1);
        a.setSubjectCode("MATH101");
        a.setSubjectName("Mathematics");
    
        ArrayList<Attandance> report = studentData.getAttandanceReportBySubject(a);
        assertNotNull(report);
        assertFalse(report.isEmpty());
    }
    
    @Test
    public void testGetMarksheetReportBySubject() {
        Marks marks = new Marks();
        marks.setCourceCode("CS101");
        marks.setSemorYear(1);
        marks.setSubjectCode("MATH101");
        marks.setSubjectName("Mathematics");
    
        ArrayList<Marks> marksheet = studentData.getMarksheetReportBySubject(marks);
        assertNotNull(marksheet);
        assertFalse(marksheet.isEmpty());
    }
    
    @Test
    public void testGetMarksheetReportByClass() {
        Marks marks = new Marks();
        marks.setCourceCode("CS101");
        marks.setSemorYear(1);
    
        ArrayList<Marks> marksheet = studentData.getMarksheetReportByClass(marks);
        assertNotNull(marksheet);
        assertFalse(marksheet.isEmpty());
    }
    
    @Test
    public void testGetAttandanceReportByClass() {
        Attandance a = new Attandance();
        a.setCourceCode("CS101");
        a.setSemorYear(1);
    
        ArrayList<Attandance> report = studentData.getAttandanceReportByClass(a);
        assertNotNull(report);
        assertFalse(report.isEmpty());
    }
    
    @Test
    public void testGetTotalAttandanceReportOfStudent() {
        Attandance a = new Attandance();
        a.setCourceCode("CS101");
        a.setSemorYear(1);
        a.setRollNumber(1001L);
    
        ArrayList<Attandance> report = studentData.getTotalAttandanceReportOfStudent(a);
        assertNotNull(report);
        assertFalse(report.isEmpty());
    }
    
    @Test
    public void testGetAttandanceReportByStudent() {
        Attandance a = new Attandance();
        a.setCourceCode("CS101");
        a.setSemorYear(1);
        a.setRollNumber(1001L);
    
        ArrayList<Attandance> report = studentData.getAttandanceReportByStudent(a);
        assertNotNull(report);
        assertFalse(report.isEmpty());
    }

    @Test
    public void testGetStudentsDetails() {
        String condition = "WHERE courcecode='CS101'";
        ArrayList<Student> students = studentData.getStudentsDetails(condition);
        assertNotNull(students);
        assertFalse(students.isEmpty());
        for (Student s : students) {
            assertEquals("CS101", s.getCourceCode());
        }
    }
    
    @Test
    public void testIsActive() {
        String userId = "CS101-1-1001";
        boolean isActive = studentData.isActive(userId);
        // Assuming the student is active
        assertTrue(isActive);
    }
    
    @Test
    public void testGetStudentName() {
        String userId = "CS101-1-1001";
        String name = studentData.getStudentName(userId);
        assertNotNull(name);
        assertEquals("John Doe", name);
    }
    
    @Test
    public void testSetActiveStatus() {
        String userId = "CS101-1-1001";
        // Deactivate the student
        int result = studentData.setActiveStatus(false, userId);
        assertEquals(1, result);
        assertFalse(studentData.isActive(userId));
    
        // Reactivate the student
        result = studentData.setActiveStatus(true, userId);
        assertEquals(1, result);
        assertTrue(studentData.isActive(userId));
    }
    
    @Test
    public void testGetLastLogin() {
        String userId = "CS101-1-1001";
        String lastLogin = studentData.getLastLogin(userId);
        assertNotNull(lastLogin);
        // Additional assertions can be made based on expected last login time
    }
    
    @Test
    public void testGetProfilePic() {
        String userId = "CS101-1-1001";
        Image profilePic = studentData.getProfilePic(userId);
        assertNotNull(profilePic);
    }

    @Test
    public void testGetStudentDetailsByRow() {
        // Assuming there's at least one student in the database with sr_no = 1
        int row = 1;
        Student student = studentData.getStudentDetails(row);
        assertNotNull(student);
        assertEquals(1, student.getSrNo());
        // Additional assertions based on expected data
    }
    
    @Test
    public void testGetStudentDetailsByUserId() {
        String userId = "BEE303-3-2022078";
        Student student = studentData.getStudentDetailsByUserId(userId);
        assertNotNull(student);
        assertEquals(userId, student.getUserId());
        // Additional assertions based on expected data
    }

    @After
    public void tearDown() throws Exception {
        // Clean up test data if necessary
    }
}