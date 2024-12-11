package tests;

import static org.junit.Assert.*;

import java.awt.Image;
import java.sql.Connection;
import java.sql.Statement;

import org.junit.*;

import collegeapplication.admin.Admin;
import collegeapplication.admin.AdminData;
import collegeapplication.common.DataBaseConnection;

/**
 * Test class for AdminData.java
 */
public class AdminDataTest {

    private static Connection connection;
    private static AdminData adminData;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        connection = DataBaseConnection.getConnection();
        adminData = new AdminData();
        setupTestData();
    }

    private static void setupTestData() throws Exception {
        Statement st = connection.createStatement();

        // Insert initial admin data
        st.executeUpdate("INSERT INTO admin (collagename, address, emailid, contactnumber, website, lastlogin, password, logo, activestatus, facebook, instagram, twitter, linkedin) "
                + "VALUES ('Test College', '123 Test St', 'admin@test.com', '1234567890', 'www.test.com', '2024-12-10 10:00:00', 'password123', null, true, 'fb.com/test', 'insta.com/test', 'twitter.com/test', 'linkedin.com/test');");

        st.close();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        cleanUpTestData();
        connection.close();
    }

    private static void cleanUpTestData() throws Exception {
        Statement st = connection.createStatement();
        st.executeUpdate("DELETE FROM admin");
        st.close();
    }

    @Test
    public void testUpdateAdminLink() throws Exception {
        Admin admin = new Admin();
        admin.setFaceBookLink("fb.com/newtest");
        admin.setInstagramLink("insta.com/newtest");
        admin.setTwitterLink("twitter.com/newtest");
        admin.setLinkedinLink("linkedin.com/newtest");

        int result = adminData.updateAdminLink(admin);
        assertEquals(1, result);
    }

    @Test
    public void testGetLastLogin() throws Exception {
        String lastLogin = adminData.getLastLogin();
        assertNotNull(lastLogin);
        assertEquals("2024-12-10 10:00:00", lastLogin);
    }

    @Test
    public void testUpdateAdminDetails() throws Exception {
        Admin admin = new Admin();
        admin.setCollageName("Updated College");
        admin.setAddress("456 Updated St");
        admin.setEmailId("updated@test.com");
        admin.setContactNumber("0987654321");
        admin.setWebsite("www.updated.com");
        admin.setPassword("updatedPassword");
        admin.setActiveStatus(true);

        int result = adminData.updateAdminDetails(admin);
        assertEquals(1, result);
    }

    @Test
    public void testIsActive() throws Exception {
        boolean isActive = adminData.isActive();
        assertTrue(isActive);
    }

    @Test
    public void testGetAdminData() throws Exception {
        Admin admin = adminData.getAdminData();
        assertNotNull(admin);
        assertEquals("Test College", admin.getCollageName());
        assertEquals("123 Test St", admin.getAddress());
    }

    @Test
    public void testCheckPassword() throws Exception {
        boolean isPasswordCorrect = adminData.checkPassword("Admin", "password123");
        assertTrue(isPasswordCorrect);

        boolean isPasswordIncorrect = adminData.checkPassword("Admin", "wrongpassword");
        assertFalse(isPasswordIncorrect);
    }

    @Test
    public void testSetActiveStatus() throws Exception {
        int result = adminData.setActiveStatus(false);
        assertEquals(1, result);

        boolean isActive = adminData.isActive();
        assertFalse(isActive);
    }

    @Test
    public void testGetProfilePic() throws Exception {
        Image profilePic = adminData.getProfilePic();
        assertNull(profilePic); // Assuming no profile pic was inserted
    }
}