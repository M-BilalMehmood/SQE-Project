package tests;

import static org.junit.Assert.*;
import org.junit.*;

import collegeapplication.cource.Cource;
import collegeapplication.cource.CourceData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourceDataTest {
    private static CourceData courceData;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        courceData = new CourceData();
        // Initialize any required resources, e.g., establish a connection to a test database
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        CourceData.closeConnection();
    }

    @Test
    public void testAddCource() {
        String courceCode = "CS102";
        String courceName = "Data Structures";
        String semOrYear = "Sem";
        int totalSemOrYear = 6;

        int result = courceData.addCource(courceCode, courceName, semOrYear, totalSemOrYear);
        assertEquals(1, result);

        // Clean up
        // You might want to delete the added course after the test
    }

    @Test
    public void testGetcourcename() {
        String courceCode = "CS101";
        String expectedCourceName = "Computer Science";

        String courceName = courceData.getcourcename(courceCode);
        assertNotNull(courceName);
        assertEquals(expectedCourceName, courceName);
    }

    @Test
    public void testGetCourceinfo() throws SQLException {
        ResultSet rs = courceData.getCourceinfo();
        assertNotNull(rs);
        // Assuming there is at least one course in the test database
        assertTrue(rs.next());
        // Additional assertions based on expected data
        rs.close();
    }

    @Test
    public void testGetTotalCource() {
        int totalCources = courceData.getTotalCource();
        assertTrue(totalCources >= 0);
    }

    @Test
    public void testGetCourceNameArray() {
        String[] courceNames = courceData.getCourceName();
        assertNotNull(courceNames);
        assertTrue(courceNames.length > 0);
        assertEquals("---Select Cource---", courceNames[0]);
    }

    @Test
    public void testGetRollTotalCource() {
        int rollTotalCource = courceData.getRollTotalCource();
        assertTrue(rollTotalCource >= 0);
    }

    @Test
    public void testGetRollCourceName() {
        String[] rollCourceNames = courceData.getRollCourceName();
        assertNotNull(rollCourceNames);
        assertTrue(rollCourceNames.length > 0);
        assertEquals("---select---", rollCourceNames[0]);
    }

    @Test
    public void testGetSemorYear() {
        String courceName = "Computer Science";
        String[] semOrYear = courceData.getSemorYear(courceName);
        assertNotNull(semOrYear);
        assertTrue(semOrYear.length > 0);
        assertEquals("---Select Sem/Year---", semOrYear[0]);
    }

    @Test
    public void testGetCourcecodeByName() {
        String courceName = "Computer Science";
        String expectedCourceCode = "CS101";

        String courceCode = courceData.getCourcecode(courceName);
        assertNotNull(courceCode);
        assertEquals(expectedCourceCode, courceCode);
    }

    @Test
    public void testGetsemoryear() {
        String courceCode = "CS101";
        String expectedSemOrYear = "Sem";

        String semOrYear = courceData.getsemoryear(courceCode);
        assertNotNull(semOrYear);
        assertEquals(expectedSemOrYear, semOrYear);
    }

    @Test
    public void testGetCourcesForDeclareResult() {
        String courceName = "Computer Science";
        ArrayList<Cource> cources = courceData.getCourcesForDeclareResult(courceName);
        assertNotNull(cources);
        assertFalse(cources.isEmpty());

        for (Cource c : cources) {
            assertEquals(courceName, c.getCourceName());
            assertNotNull(c.getCourceCode());
            assertTrue(c.getSemorYear() > 0);
        }
    }

    @Test
    public void testIsCourceNameExist() {
        String existingCourceName = "Computer Science";
        String nonExistingCourceName = "Astrophysics";

        assertTrue(courceData.isCourceNameExist(existingCourceName));
        assertFalse(courceData.isCourceNameExist(nonExistingCourceName));
    }

    @After
    public void tearDown() throws Exception {
        // Clean up test data if necessary
    }
}