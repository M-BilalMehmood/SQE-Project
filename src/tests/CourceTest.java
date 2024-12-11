package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import collegeapplication.cource.Cource;
import collegeapplication.cource.CourceData;

public class CourceTest {
    private Cource cource;

    @Before
    public void setUp() {
        cource = new Cource();
    }

    @Test
    public void testSetAndGetCourceName() {
        String courceName = "Computer Science";
        cource.setCourceName(courceName);
        assertEquals(courceName, cource.getCourceName());
    }

    @Test
    public void testGetCourceNameWhenNull() {
        // Assuming CourceData returns "Unknown" when courceName is null
        assertEquals("Unknown", cource.getCourceName());
    }

    @Test
    public void testSetAndGetCourceCode() {
        String courceCode = "CS101";
        cource.setCourceCode(courceCode);
        assertEquals(courceCode, cource.getCourceCode());
    }

    @Test
    public void testSetAndGetSemorYear() {
        int semorYear = 2;
        cource.setSemorYear(semorYear);
        assertEquals(semorYear, cource.getSemorYear());
    }

    @Test
    public void testSetAndGetIsDeclared() {
        boolean isDeclared = true;
        cource.setIsDeclared(isDeclared);
        assertEquals(isDeclared, cource.getIsDeclared());
    }
}