package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import collegeapplication.common.Notification;

public class NotificationTest {
    private Notification notification;

    @Before
    public void setUp() {
        notification = new Notification();
    }

    @Test
    public void testSetAndGetUserProfile() {
        String profile = "Student";
        notification.setUserProfile(profile);
        assertEquals(profile, notification.getUserProfile());
    }

    @Test
    public void testSetAndGetSrNo() {
        int srNo = 1;
        notification.setSrNo(srNo);
        assertEquals(srNo, notification.getSrNo());
    }

    @Test
    public void testSetAndGetUserId() {
        String userId = "CS101-1-1001";
        notification.setUserId(userId);
        assertEquals(userId, notification.getUserId());
    }

    @Test
    public void testSetAndGetTime() {
        String time = "10-Oct-2023 08:30:00 AM";
        notification.setTime(time);
        assertEquals(time, notification.getTime());
    }

    @Test
    public void testSetAndGetTitle() {
        String title = "Welcome";
        notification.setTitle(title);
        assertEquals(title, notification.getTitle());
    }

    @Test
    public void testSetAndGetMessage() {
        String message = "Welcome to the College Management System.";
        notification.setMessage(message);
        assertEquals(message, notification.getMessage());
    }

    @Test
    public void testSetAndGetReadBy() {
        String readBy = "Admin";
        notification.setReadBy(readBy);
        assertEquals(readBy, notification.getReadBy());
    }

    @Test
    public void testGetNotificationDate() {
        // Assuming there's a method to parse and return the date part from time
        String time = "10-Oct-2023 08:30:00 AM";
        notification.setTime(time);
        String expectedDate = "10-Oct-2023"; // Based on assumed implementation
        assertEquals(expectedDate, notification.getNotificationDate());
    }

    @Test
    public void testGetNotificationTime() {
        String time = "10-Oct-2023 08:30:00 AM";
        notification.setTime(time);
        String expectedTime = "08:30:00 AM"; // Based on assumed implementation
        assertEquals(expectedTime, notification.getNotificationTime());
    }
}