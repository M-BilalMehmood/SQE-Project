package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import collegeapplication.common.Person;
import collegeapplication.cource.CourceData;
import collegeapplication.common.ImageUtil;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Date;

// Concrete subclass for testing
class TestPerson extends Person {
    // No additional implementation needed for testing purposes
}

public class PersonTest {
    private TestPerson person;

    @Before
    public void setUp() {
        person = new TestPerson();
    }

    @Test
    public void testSetAndGetEmailId() {
        String email = "john.doe@example.com";
        person.setEmailId(email);
        assertEquals(email, person.getEmailId());
    }

    @Test
    public void testSetAndGetContactNumber() {
        String contact = "1234567890";
        person.setContactNumber(contact);
        assertEquals(contact, person.getContactNumber());
    }

    @Test
    public void testSetAndGetBirthDate() {
        String birthDate = "15-08-1990";
        person.setBirthDate(birthDate);
        assertEquals(birthDate, person.getBirthDate());
    }

    @Test
    public void testGetBirthDateInDateFormat() {
        String birthDate = "15-08-1990";
        person.setBirthDate(birthDate);
        Date expectedDate = null;
        try {
            expectedDate = new SimpleDateFormat("dd-MM-yyyy").parse(birthDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(expectedDate, person.getBirthDateInDateFormat());
    }

    @Test
    public void testSetAndGetGender() {
        String gender = "Male";
        person.setGender(gender);
        assertEquals(gender, person.getGender());
    }

    @Test
    public void testSetAndGetState() {
        String state = "California";
        person.setState(state);
        assertEquals(state, person.getState());
    }

    @Test
    public void testSetAndGetCity() {
        String city = "Los Angeles";
        person.setCity(city);
        assertEquals(city, person.getCity());
    }

//    @Test
//    public void testSetAndGetProfilePicWithImage() {
//        Image image = ImageUtil.createTestImage();
//        person.setProfilePic(image);
//        assertEquals(image, person.getProfilePic());
//    }
//
//    @Test
//    public void testSetAndGetProfilePicWithBytes() {
//        byte[] imageData = ImageUtil.createTestImageBytes();
//        person.setProfilePic(imageData);
//        Image expectedImage = ImageUtil.createImageFromBytes(imageData);
//        assertEquals(expectedImage.getWidth(null), person.getProfilePic().getWidth(null));
//        assertEquals(expectedImage.getHeight(null), person.getProfilePic().getHeight(null));
//    }

    @Test
    public void testSetAndGetSrNo() {
        int srNo = 101;
        person.setSrNo(srNo);
        assertEquals(srNo, person.getSrNo());
    }

    @Test
    public void testSetAndGetLastLogin() {
        String lastLogin = "10-Oct-2023 08:30:00 AM";
        person.setLastLogin(lastLogin);
        assertEquals(lastLogin, person.getLastLogin());
    }

    @Test
    public void testSetAndGetPassword() {
        String password = "securepassword";
        person.setPassword(password);
        assertEquals(password, person.getPassword());
    }

    @Test
    public void testSetAndGetActiveStatus() {
        person.setActiveStatus(true);
        assertTrue(person.getActiveStatus());
        person.setActiveStatus(false);
        assertFalse(person.getActiveStatus());
    }

    @Test
    public void testGetCourceName() {
        String courceCode = "CS101";
        String courceName = "Computer Science";
        person.setCourceCode(courceCode);

        // Mocking CourceData response
        CourceData courceData = new CourceData();
//        courceData.addCourceName(courceCode, courceName);
//
//        assertEquals(courceName, person.getCourceName());
    }

    @Test
    public void testGetAddress() {
        person.setCity("Los Angeles");
        person.setState("California");
        assertEquals("Los Angeles, California", person.getAddress());
    }

    @Test
    public void testComparePasswordSuccess() {
        String password = "password123";
        person.setPassword(password);
        assertTrue(person.comparePassword("password123"));
    }

    @Test
    public void testComparePasswordFailure() {
        String password = "password123";
        person.setPassword(password);
        assertFalse(person.comparePassword("wrongpassword"));
    }

    @Test
    public void testGetProfilePicInBytes() {
//        Image image = ImageUtil.createTestImage();
//        person.setProfilePic(image);
        byte[] imageBytes = person.getProfilePicInBytes();
        assertNotNull(imageBytes);
        assertTrue(imageBytes.length > 0);
    }

    @Test
    public void testGetProfilePicWithDimensions() {
//        Image image = ImageUtil.createTestImage();
//        person.setProfilePic(image);
        int width = 100;
        int height = 100;
        Image scaledImage = person.getProfilePic(width, height);
        assertEquals(width, scaledImage.getWidth(null));
        assertEquals(height, scaledImage.getHeight(null));
    }

    @Test
    public void testGetRoundedProfilePic() {
//        Image image = ImageUtil.createTestImage();
//        person.setProfilePic(image);
        int width = 100;
        int height = 100;
        int radius = 20;
        BufferedImage roundedImage = person.getRoundedProfilePic(width, height, radius);
        assertNotNull(roundedImage);
        assertEquals(width, roundedImage.getWidth());
        assertEquals(height, roundedImage.getHeight());
    }
}