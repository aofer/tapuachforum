/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.PersistentLayer;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arseny
 */
public class MemberHandlerTest {

    public MemberHandlerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    XMLFileHandler xf = new XMLFileHandler("tapuachforum.xml");
    
    /**
     * Test of getPassword method, of class MemberHandler.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        String username = "nir";
        MemberHandler instance = new MemberHandler(xf);
        String expResult = "123456";
        String result = instance.getPassword(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of getEMail method, of class MemberHandler.
     */
    @Test
    public void testGetEMail() {
        System.out.println("getEMail");
        String username = "nir";
        MemberHandler instance = new MemberHandler(xf);
        String expResult = "a@a.com";
        String result = instance.getEMail(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
   //     fail("The test case is a prototype.");
    }

    /**
     * Test of getDateJoined method, of class MemberHandler.
     */
    @Test
    public void testGetDateJoined() {
        System.out.println("getDateJoined");
        String username = "nir";
        MemberHandler instance = new MemberHandler(xf);
        Date result = instance.getDateJoined(username);
        assertNotNull(result);
       
    }

    /**
     * Test of getFirstName method, of class MemberHandler.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        String username = "nir";
        MemberHandler instance = new MemberHandler(xf);
        String expResult = "a";
        String result = instance.getFirstName(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
   //     fail("The test case is a prototype.");
    }

    /**
     * Test of getLastName method, of class MemberHandler.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        String username = "nir";
        MemberHandler instance = new MemberHandler(xf);
        String expResult = "k";
        String result = instance.getLastName(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of getDateofBirth method, of class MemberHandler.
     */
    @Test
    public void testGetDateofBirth() {
        System.out.println("getDateofBirth");
        String username = "nir";
        MemberHandler instance =  new MemberHandler(xf);
        Date result = instance.getDateofBirth(username);
        assertNotNull(result);
        
    }

    /**
     * Test of getStatus method, of class MemberHandler.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        String username = "nir";
        MemberHandler instance = new MemberHandler(xf);
        boolean expResult = false;
        boolean result = instance.getStatus(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
    /**
     * Test of setNickName method, of class MemberHandler.
     */
    @Test
    public void testSetNickName() {
        System.out.println("setNickName");
        String username = "nir";
        String nickName = "liron";
        MemberHandler instance = new MemberHandler(xf);
        instance.setNickName(username, nickName);
        String modf = instance.getNickName(username);
        assertEquals(modf, nickName);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class MemberHandler.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String username ="nir";
        String password = "34r";
        MemberHandler instance = new MemberHandler(xf);
        instance.setPassword(username, password);
    String modf = instance.getPassword(username);
        assertEquals(modf, password);
    }

    /**
     * Test of setEMail method, of class MemberHandler.
     */
    @Test
    public void testSetEMail() {
        System.out.println("setEMail");
        String username = "nir";
        String eMail = "asdtew";
        MemberHandler instance = new MemberHandler(xf);
        instance.setEMail(username, eMail);
            String modf = instance.getEMail(username);
        assertEquals(modf, eMail);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDateJoined method, of class MemberHandler.
     */
    @Test
    public void testSetDateJoined() {
        System.out.println("setDateJoined");


        String username = "nir";

        Date dateJoined =  new Date();
    MemberHandler instance = new MemberHandler(xf);
        instance.setDateJoined(username, dateJoined);
            Date modf = instance.getDateJoined(username);
        assertNotNull(modf);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFirstName method, of class MemberHandler.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String username = "nir";
        String firstName = "asdw";
        MemberHandler instance = new MemberHandler(xf);
        instance.setFirstName(username, firstName);
            String modf = instance.getFirstName(username);
        assertEquals(modf, firstName);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setLastName method, of class MemberHandler.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String username = "nir";
        String lastName = "dwdfs";
        MemberHandler instance = new MemberHandler(xf);
        instance.setLastName(username, lastName);
            String modf = instance.getLastName(username);
        assertEquals(modf, lastName);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDateofBirth method, of class MemberHandler.
     */
    @Test
    public void testSetDateofBirth() {
        System.out.println("setDateofBirth");
        String username = "nir";
        Date dateOfBirth = new Date();
        MemberHandler instance = new MemberHandler(xf);
        instance.setDateofBirth(username, dateOfBirth);
            Date modf = instance.getDateofBirth(username);
          assertNotNull(modf);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus method, of class MemberHandler.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        String username = "nir";
        boolean status = false;
        MemberHandler instance = new MemberHandler(xf);
        instance.setStatus(username, status);
            boolean  modf = instance.getStatus(username);
        assertEquals(modf, status);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}