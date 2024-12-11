package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.sql.Connection;
import collegeapplication.subject.SubjectData;
import collegeapplication.common.DataBaseConnection;

public class SubjectDataTest {
    
    private SubjectData subjectData;
    private Connection connection;
    
    @Before
    public void setUp() {
        try {
            // Get database connection
            connection = DataBaseConnection.getConnection();
            subjectData = new SubjectData();
            
            // Clear existing test data
            clearTestData();
            
            // Insert test data
            setupTestData();
        } catch (Exception e) {
            fail("Failed to set up test: " + e.getMessage());
        }
    }
    
    private void clearTestData() throws Exception {
        connection.createStatement().execute(
            "DELETE FROM subject WHERE courcecode='TEST101'"
        );
    }
    
    private void setupTestData() throws Exception {
        // Insert sample subject data
        connection.createStatement().execute(
            "INSERT INTO subject (subjectname, courcecode, semoryear, subjecttype) " +
            "VALUES ('Test Subject', 'TEST101', 1, 'optional')"
        );
    }
    
    @Test
    public void testGetTotalOptionalSubject() {
        int result = subjectData.gettotalOptionalSubject("TEST101", 1);
        assertEquals(1, result);
    }
    
    @Test
    public void testGetSubjectinCource() {
        String[] subjects = subjectData.getSubjectinCource("TEST101", 1);
        assertNotNull(subjects);
        assertEquals("Test Subject", subjects[1]);
    }
    
    @org.junit.After
    public void tearDown() {
        try {
            clearTestData();
            connection.close();
        } catch (Exception e) {
            fail("Failed to clean up test: " + e.getMessage());
        }
    }
}