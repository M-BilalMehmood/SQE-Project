package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import collegeapplication.chat.ChatUser;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Test class for ChatUser.java
 */
public class ChatUserTest {
    private ChatUser chatUser;

    @Before
    public void setUp() {
        chatUser = new ChatUser();
    }

    @Test
    public void testSetAndGetReadBy() {
        String readBy = "Admin";
        chatUser.setReadBy(readBy);
        assertEquals(readBy, chatUser.getReadBy());
    }

    @Test
    public void testSetAndGetUserProfile() {
        String userProfile = "Student";
        chatUser.setUserProfile(userProfile);
        assertEquals(userProfile, chatUser.getUserProfile());
    }

    @Test
    public void testSetAndGetSrNo() {
        int srNo = 1;
        chatUser.setSr_no(srNo);
        assertEquals(srNo, chatUser.getSr_no());
    }

    @Test
    public void testSetAndGetFromUserID() {
        String fromUserId = "S1001";
        chatUser.setFromUserID(fromUserId);
        assertEquals(fromUserId, chatUser.getFromUserId());
    }

    @Test
    public void testSetAndGetFromUserName() {
        String fromUserName = "John Doe";
        chatUser.setFromUserName(fromUserName);
        assertEquals(fromUserName, chatUser.getFromUserName());
    }

    @Test
    public void testSetAndGetToUserID() {
        String toUserId = "F2001";
        chatUser.setToUserID(toUserId);
        assertEquals(toUserId, chatUser.getToUserId());
    }

    @Test
    public void testSetAndGetMessageTime() {
        String messageTime = "10:30 AM";
        chatUser.setMessageTime(messageTime);
        assertEquals(messageTime, chatUser.getMessageTime());
    }

    @Test
    public void testSetAndGetMessageDate() {
        String messageDate = "01-Oct,2023";
        chatUser.setMessageDate(messageDate);
        assertEquals(messageDate, chatUser.getMessageDate());
    }

    @Test
    public void testSetAndGetMessage() {
        String message = "Hello, World!";
        chatUser.setMessage(message);
        assertEquals(message, chatUser.getMessage());
    }

    @Test
    public void testSetFromUser() {
        String fromUserId = "S1002";
        String fromUserName = "Jane Smith";
        chatUser.setFromUser(fromUserId, fromUserName);
        assertEquals(fromUserId, chatUser.getFromUserId());
        assertEquals(fromUserName, chatUser.getFromUserName());
    }

    @Test
    public void testSetMessageWithDate() {
        String message = "Good Morning!";
        Date date = new Date();
        chatUser.setMessage(message, date);

        SimpleDateFormat timeFormatter = new SimpleDateFormat("hh:mm aaa");
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM,yyyy");
        String expectedTime = timeFormatter.format(date);
        String expectedDate = dateFormatter.format(date);

        assertEquals(message, chatUser.getMessage());
        assertEquals(expectedTime, chatUser.getMessageTime());
        assertEquals(expectedDate, chatUser.getMessageDate());
    }

    @Test
    public void testSetToUser() {
        String userProfile = "Faculty";
        String toUserId = "F2002";
        String toUserName = "Dr. Alice";
        boolean isActive = true;

        chatUser.setToUser(userProfile, toUserId, toUserName, isActive);

        assertEquals(userProfile, chatUser.getUserProfile());
        assertEquals(toUserId, chatUser.getToUserId());
        assertEquals(toUserName, chatUser.getToUserName());
        assertTrue(chatUser.isActive());
    }

    @Test
    public void testIsActive() {
        chatUser.setToUser("Faculty", "F2003", "Dr. Bob", true);
        assertTrue(chatUser.isActive());

        chatUser.setToUser("Faculty", "F2003", "Dr. Bob", false);
        assertFalse(chatUser.isActive());
    }

    @Test
    public void testGetReadBy() {
        String readBy = "Student";
        chatUser.setReadBy(readBy);
        assertEquals(readBy, chatUser.getReadBy());
    }

    @Test
    public void testGetMessage() {
        String message = "This is a test message.";
        chatUser.setMessage(message);
        assertEquals(message, chatUser.getMessage());
    }

    @Test
    public void testGetFromUserId() {
        String fromUserId = "S1003";
        chatUser.setFromUserID(fromUserId);
        assertEquals(fromUserId, chatUser.getFromUserId());
    }

    @Test
    public void testGetToUserName() {
        String toUserName = "Dr. Charlie";
        chatUser.setFromUserName(toUserName);
        assertEquals(toUserName, chatUser.getToUserName());
    }

    @Test
    public void testGetSrNo() {
        int srNo = 5;
        chatUser.setSr_no(srNo);
        assertEquals(srNo, chatUser.getSr_no());
    }

    @Test
    public void testDefaultValues() {
        assertEquals("", chatUser.getReadBy());
        assertFalse(chatUser.isActive());
        assertEquals(0, chatUser.getSr_no());
    }
}