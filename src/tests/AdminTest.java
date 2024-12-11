package tests;

import org.junit.Before;
import org.junit.Test;

import collegeapplication.admin.Admin;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.*;

public class AdminTest {

    private Admin admin;

    @Before
    public void setUp() {
        admin = new Admin();
    }

    @Test
    public void testSetAndGetWebsite() {
        String website = "https://example.com";
        admin.setWebsite(website);
        assertEquals("Website should match the set value", website, admin.getWebsite());
    }

    @Test
    public void testSetAndGetContactNumber() {
        String contactNumber = "1234567890";
        admin.setContactNumber(contactNumber);
        assertEquals("Contact number should match the set value", contactNumber, admin.getContactNumber());
    }

    @Test
    public void testSetAndGetEmailId() {
        String email = "admin@example.com";
        admin.setEmailId(email);
        assertEquals("Email ID should match the set value", email, admin.getEmailId());
    }

    @Test
    public void testSetAndGetCollageName() {
        String collageName = "Example College";
        admin.setCollageName(collageName);
        assertEquals("Collage name should match the set value", collageName, admin.getCollageName());
    }

    @Test
    public void testSetAndGetPassword() {
        String password = "securePassword123";
        admin.setPassword(password);
        assertEquals("Password should match the set value", password, admin.getPassword());
    }

    @Test
    public void testSetAndGetActiveStatus() {
        admin.setActiveStatus(true);
        assertTrue("Active status should be true", admin.getActiveStatus());

        admin.setActiveStatus(false);
        assertFalse("Active status should be false", admin.getActiveStatus());
    }

    @Test
    public void testSetAndGetProfilePicUsingBytes() throws IOException {
        byte[] imageData = new byte[]{(byte) 255, (byte) 216, (byte) 255}; // Sample JPEG header bytes
        admin.setProfilePic(imageData);
        Image profilePic = admin.getProfilePic();
        assertNotNull("Profile picture should not be null after setting", profilePic);
    }

    @Test
    public void testSetAndGetProfilePicUsingImage() {
        BufferedImage mockImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        admin.setProfilePic(mockImage);
        Image profilePic = admin.getProfilePic();
        assertNotNull("Profile picture should not be null after setting", profilePic);
    }

    @Test
    public void testGetProfilePicInBytes() {
        BufferedImage mockImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        admin.setProfilePic(mockImage);
        byte[] profilePicBytes = admin.getProfilePicInBytes();
        assertNotNull("Profile picture bytes should not be null", profilePicBytes);
        assertTrue("Profile picture bytes should not be empty", profilePicBytes.length > 0);
    }

    @Test
    public void testSocialMediaLinks() {
        admin.setFaceBookLink("https://facebook.com/admin");
        assertEquals("Facebook link should match", "https://facebook.com/admin", admin.getFacebookLink());

        admin.setInstagramLink("https://instagram.com/admin");
        assertEquals("Instagram link should match", "https://instagram.com/admin", admin.getInstagramLink());

        admin.setTwitterLink("https://twitter.com/admin");
        assertEquals("Twitter link should match", "https://twitter.com/admin", admin.getTwitterLink());

        admin.setLinkedinLink("https://linkedin.com/in/admin");
        assertEquals("LinkedIn link should match", "https://linkedin.com/in/admin", admin.getLinkedinLink());
    }

    @Test
    public void testSetAndGetAddress() {
        String address = "123 Example Street, City, Country";
        admin.setAddress(address);
        assertEquals("Address should match the set value", address, admin.getAddress());
    }
    
    @Test
    public void testSetAndGetLastLogin() {
        String lastLogin = "2024-12-11 10:30:00";
        admin.setLastLogin(lastLogin);
        assertEquals("Last login should match the set value", lastLogin, admin.getLastLogin());
    }

    @Test
    public void testGetRoundedProfilePic() {
        BufferedImage mockImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        admin.setProfilePic(mockImage);
        BufferedImage roundedImage = admin.getRoundedProfilePic(50, 50, 10);
        assertNotNull("Rounded profile picture should not be null", roundedImage);
    }
}
