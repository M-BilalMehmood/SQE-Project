package tests;

import static org.junit.Assert.*;
import org.junit.*;

import collegeapplication.chat.ChatData;
import collegeapplication.chat.ChatUser;
import collegeapplication.faculty.Faculty;
import collegeapplication.student.Student;
import collegeapplication.cource.CourceData;
import collegeapplication.common.DataBaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 * Test class for ChatData.java
 */
public class ChatDataTest {
    private static ChatData chatData;
    private static Connection connection;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        chatData = new ChatData();
        connection = DataBaseConnection.getConnection();
        setupTestData();
    }

    private static void setupTestData() throws Exception {
        Statement st = connection.createStatement();
        
        // Insert sample chat messages for testing
        // Message 1: Individual chat from Student to Faculty
        st.executeUpdate("INSERT INTO chat (fromuserid, fromusername, touserid, message, messagetime, messagedate, readby) " +
                "VALUES ('S1001', 'John Doe', 'F2001', 'Hello Faculty!', '10:30 AM', '01-Oct,2023', 'F2001');");
        
        // Message 2: Group chat to TEST_GROUP
        st.executeUpdate("INSERT INTO chat (fromuserid, fromusername, touserid, message, messagetime, messagedate, readby) " +
                "VALUES ('S1002', 'Jane Smith', 'TEST_GROUP', 'Hello Group!', '11:00 AM', '01-Oct,2023', '');");
        
        // Message 3: Individual chat from Faculty to Student
        st.executeUpdate("INSERT INTO chat (fromuserid, fromusername, touserid, message, messagetime, messagedate, readby) " +
                "VALUES ('F2002', 'Dr. Alice', 'S1001', 'Hello Student!', '11:30 AM', '01-Oct,2023', 'S1001');");
        
        st.close();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        cleanUpTestData();
        ChatData chatData2 = new ChatData();
		chatData2.closeConnection();
        connection.close();
    }

    private static void cleanUpTestData() throws Exception {
        Statement st = connection.createStatement();
        
        // Delete the inserted test chat messages
        st.executeUpdate("DELETE FROM chat WHERE touserid IN ('F2001', 'TEST_GROUP', 'S1001');");
        
        st.close();
    }

    @Test
    public void testGetMessages() throws Exception {
        ArrayList<ChatUser> messages = chatData.getMessages();
        assertNotNull(messages);
        assertTrue(messages.size() >= 3);
        
        // Optionally, verify specific message contents
        boolean foundMessage1 = false;
        boolean foundMessage2 = false;
        boolean foundMessage3 = false;
        
        for (ChatUser user : messages) {
            if (user.getMessage().equals("Hello Faculty!")) {
                foundMessage1 = true;
            } else if (user.getMessage().equals("Hello Group!")) {
                foundMessage2 = true;
            } else if (user.getMessage().equals("Hello Student!")) {
                foundMessage3 = true;
            }
        }
        
        assertTrue(foundMessage1);
        assertTrue(foundMessage2);
        assertTrue(foundMessage3);
    }

    @Test
    public void testGetUserMessagesForIndividual() throws Exception {
        ChatUser individualChatUser = new ChatUser();
        individualChatUser.setFromUserID("F2001");
        individualChatUser.setFromUserID("S1001");
        
        ArrayList<ChatUser> individualMessages = chatData.getUserMessages(individualChatUser);
        assertNotNull(individualMessages);
        assertEquals(1, individualMessages.size());
        
        ChatUser message = individualMessages.get(0);
        assertEquals("Hello Faculty!", message.getMessage());
        assertEquals("S1001", message.getFromUserId());
        assertEquals("F2001", message.getToUserId());
    }

    @Test
    public void testGetUserMessagesForGroup() throws Exception {
        ChatUser groupChatUser = new ChatUser();
        groupChatUser.setFromUserID("TEST_GROUP");
        
        ArrayList<ChatUser> groupMessages = chatData.getUserMessages(groupChatUser);
        assertNotNull(groupMessages);
        assertEquals(1, groupMessages.size());
        
        ChatUser message = groupMessages.get(0);
        assertEquals("Hello Group!", message.getMessage());
        assertEquals("S1002", message.getFromUserId());
        assertEquals("TEST_GROUP", message.getToUserId());
    }

    @Test
    public void testGetUnreadMessageCountStudent() throws Exception {
        Student testStudent = new Student();
        testStudent.setUserId("S1001");
        testStudent.setCourceCode("TEST101");
        testStudent.setSemorYear(1);
        
        int unreadCount = chatData.getUndreadMessageCountStudent(testStudent);
        // In setup, there are no unread messages for S1001
        assertEquals(0, unreadCount);
        
        // Insert an unread message for S1001
        Statement st = connection.createStatement();
        st.executeUpdate("INSERT INTO chat (fromuserid, fromusername, touserid, message, messagetime, messagedate, readby) " +
                "VALUES ('F2001', 'Dr. Bob', 'S1001', 'Please submit your assignment.', '12:00 PM', '01-Oct,2023', '');");
        st.close();
        
        // Recount unread messages
        unreadCount = chatData.getUndreadMessageCountStudent(testStudent);
        assertEquals(1, unreadCount);
    }

    @Test
    public void testGetUnreadMessageCountFaculty() throws Exception {
        Faculty testFaculty = new Faculty();
        testFaculty.setFacultyId(2001);
        testFaculty.setCourceCode("TEST101");
        testFaculty.setSemorYear(1);
        
        int unreadCount = chatData.getUndreadMessageCountFaculty(testFaculty);
        // In setup, there are no unread messages for F2001
        assertEquals(0, unreadCount);
        
        // Insert an unread message for F2001
        Statement st = connection.createStatement();
        st.executeUpdate("INSERT INTO chat (fromuserid, fromusername, touserid, message, messagetime, messagedate, readby) " +
                "VALUES ('S1003', 'Mike Ross', 'F2001', 'Can you review my project?', '01:00 PM', '01-Oct,2023', '');");
        st.close();
        
        // Recount unread messages
        unreadCount = chatData.getUndreadMessageCountFaculty(testFaculty);
        assertEquals(1, unreadCount);
    }

    @Test
    public void testGetUndreadMessageCountStudentWithMultipleUnread() throws Exception {
        Student testStudent = new Student();
        testStudent.setUserId("S1001");
        testStudent.setCourceCode("TEST101");
        testStudent.setSemorYear(1);
        
        // Insert multiple unread messages for S1001
        Statement st = connection.createStatement();
        st.executeUpdate("INSERT INTO chat (fromuserid, fromusername, touserid, message, messagetime, messagedate, readby) " +
                "VALUES ('F2001', 'Dr. Bob', 'S1001', 'Reminder for seminar.', '02:00 PM', '01-Oct,2023', '');");
        st.executeUpdate("INSERT INTO chat (fromuserid, fromusername, touserid, message, messagetime, messagedate, readby) " +
                "VALUES ('F2002', 'Dr. Alice', 'S1001', 'Meeting at 3 PM.', '02:30 PM', '01-Oct,2023', '');");
        st.close();
        
        int unreadCount = chatData.getUndreadMessageCountStudent(testStudent);
        assertEquals(2, unreadCount);
    }

    @Test
    public void testGetUndreadMessageCountFacultyWithMultipleUnread() throws Exception {
        Faculty testFaculty = new Faculty();
        testFaculty.setFacultyId(2001);
        testFaculty.setCourceCode("TEST101");
        testFaculty.setSemorYear(1);
        
        // Insert multiple unread messages for F2001
        Statement st = connection.createStatement();
        st.executeUpdate("INSERT INTO chat (fromuserid, fromusername, touserid, message, messagetime, messagedate, readby) " +
                "VALUES ('S1004', 'Emma Watson', 'F2001', 'Could you assist with my thesis?', '03:00 PM', '01-Oct,2023', '');");
        st.executeUpdate("INSERT INTO chat (fromuserid, fromusername, touserid, message, messagetime, messagedate, readby) " +
                "VALUES ('S1005', 'Liam Neeson', 'F2001', 'Need feedback on my presentation.', '03:30 PM', '01-Oct,2023', '');");
        st.close();
        
        int unreadCount = chatData.getUndreadMessageCountFaculty(testFaculty);
        assertEquals(2, unreadCount);
    }

    @Test
    public void testGetUserMessagesWithNoMessages() throws Exception {
        ChatUser newUser = new ChatUser();
        newUser.setFromUserID("NON_EXISTENT_USER");
        
        ArrayList<ChatUser> messages = chatData.getUserMessages(newUser);
        assertNotNull(messages);
        assertTrue(messages.isEmpty());
    }

    @Test
    public void testGetMessagesAfterDeleting() throws Exception {
        // Delete a message and verify it's no longer retrieved
        Statement st = connection.createStatement();
        st.executeUpdate("DELETE FROM chat WHERE message = 'Hello Group!';");
        st.close();
        
        ArrayList<ChatUser> messages = chatData.getMessages();
        assertNotNull(messages);
        // Assuming initially there were 3 messages, now should be 2
        assertTrue(messages.size() >= 2);
        
        for (ChatUser user : messages) {
            assertNotEquals("Hello Group!", user.getMessage());
        }
    }

    @Test
    public void testGetMessagesWithExceptionHandling() {
        // Temporarily close the connection to simulate an exception
        try {
            connection.close();
            ArrayList<ChatUser> messages = chatData.getMessages();
            assertNotNull(messages); // Should return an empty list or handle exception internally
            // Depending on implementation, you might check if an empty list is returned
        } catch (Exception e) {
            fail("Exception should be handled within getMessages()");
        } finally {
            try {
                // Re-establish connection for other tests
                connection = DataBaseConnection.getConnection();
                setupTestData();
            } catch (Exception e) {
                fail("Failed to re-establish connection in tearDown.");
            }
        }
    }
    
    @After
    public void tearDown() throws Exception {
        // Optional: Clean up any additional test data if required
    }
}