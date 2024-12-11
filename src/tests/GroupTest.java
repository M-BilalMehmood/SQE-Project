package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import collegeapplication.chat.Group;

import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * Test class for Group.java
 */
public class GroupTest {
    private Group group;

    @Before
    public void setUp() {
        group = new Group();
    }

    @Test
    public void testSetAndGetImage() {
        // Creating a dummy BufferedImage for testing
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        group.setImage(image);
        assertEquals(image, group.getImage());
    }

    @Test
    public void testSetAndGetGroupName() {
        String groupName = "Study Group";
        group.setGroupName(groupName);
        assertEquals(groupName, group.getGroupName());
    }

    @Test
    public void testSetAndGetCourceCode() {
        String courceCode = "CS101";
        group.setCourceCode(courceCode);
        assertEquals(courceCode, group.getCourceCode());
    }

    @Test
    public void testSetAndGetSemorYear() {
        int semOrYear = 2;
        group.setSem(semOrYear);
        assertEquals(semOrYear, group.getSemorYear());
    }

    @Test
    public void testSetAndGetMembers() {
        int members = 25;
        group.setMembers(members);
        assertEquals(members, group.getMembers());
    }

    @Test
    public void testDefaultValues() {
        assertNull(group.getImage());
        assertNull(group.getGroupName());
        assertNull(group.getCourceCode());
        assertEquals(0, group.getSemorYear());
        assertEquals(0, group.getMembers());
    }

    @Test
    public void testImageSetterGetterWithNull() {
        group.setImage(null);
        assertNull(group.getImage());
    }

    @Test
    public void testGroupNameSetterGetterWithEmptyString() {
        group.setGroupName("");
        assertEquals("", group.getGroupName());
    }

    @Test
    public void testCourceCodeSetterGetterWithCaseSensitivity() {
        String courceCode = "cs101";
        group.setCourceCode(courceCode);
        assertEquals(courceCode, group.getCourceCode());

        String anotherCourceCode = "CS102";
        group.setCourceCode(anotherCourceCode);
        assertEquals(anotherCourceCode, group.getCourceCode());
    }

    @Test
    public void testSemorYearSetterGetterWithNegativeValue() {
        int semOrYear = -1;
        group.setSem(semOrYear);
        assertEquals(semOrYear, group.getSemorYear());
    }

    @Test
    public void testMembersSetterGetterWithZero() {
        int members = 0;
        group.setMembers(members);
        assertEquals(members, group.getMembers());
    }

    @Test
    public void testMembersSetterGetterWithLargeNumber() {
        int members = 1000;
        group.setMembers(members);
        assertEquals(members, group.getMembers());
    }
}