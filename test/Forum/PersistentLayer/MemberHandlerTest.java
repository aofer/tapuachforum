/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.PersistentLayer;

import Forum.Exceptions.NoSuchUserException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        try {
            System.out.println("getPassword");
            String username = "nir";
            XMLMemberHandler instance = new XMLMemberHandler(xf);
            String expResult = "123456";
            String result = instance.getPassword(username);
            assertEquals(expResult, result);
        } catch (NoSuchUserException ex) {
            Logger.getLogger(MemberHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getEMail method, of class MemberHandler.
     */
    @Test
    public void testGetEMail() {
        try {
            System.out.println("getEMail");
            String username = "nir";
            XMLMemberHandler instance = new XMLMemberHandler(xf);
            String expResult = "a@a.com";
            String result = instance.getEMail(username);
            assertEquals(expResult, result);
            //     fail("The test case is a prototype.");
            //     fail("The test case is a prototype.");
        } catch (NoSuchUserException ex) {
            Logger.getLogger(MemberHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getDateJoined method, of class MemberHandler.
     */
    @Test
    public void testGetDateJoined() {
        try {
            System.out.println("getDateJoined");
            String username = "nir";
            XMLMemberHandler instance = new XMLMemberHandler(xf);
            Date result = instance.getDateJoined(username);
            assertNotNull(result);
        } catch (NoSuchUserException ex) {
            Logger.getLogger(MemberHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    /**
     * Test of getFirstName method, of class MemberHandler.
     */
    @Test
    public void testGetFirstName() {
        try {
            System.out.println("getFirstName");
            String username = "nir";
            XMLMemberHandler instance = new XMLMemberHandler(xf);
            String expResult = "a";
            String result = instance.getFirstName(username);
            assertEquals(expResult, result);
            //     fail("The test case is a prototype.");
            //     fail("The test case is a prototype.");
        } catch (NoSuchUserException ex) {
            Logger.getLogger(MemberHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getLastName method, of class MemberHandler.
     */
    @Test
    public void testGetLastName() {
        try {
            System.out.println("getLastName");
            String username = "nir";
            XMLMemberHandler instance = new XMLMemberHandler(xf);
            String expResult = "k";
            String result = instance.getLastName(username);
            assertEquals(expResult, result);
            //  fail("The test case is a prototype.");
            //  fail("The test case is a prototype.");
        } catch (NoSuchUserException ex) {
            Logger.getLogger(MemberHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getDateofBirth method, of class MemberHandler.
     */
    @Test
    public void testGetDateofBirth() {
        try {
            System.out.println("getDateofBirth");
            String username = "nir";
            XMLMemberHandler instance = new XMLMemberHandler(xf);
            Date result = instance.getDateofBirth(username);
            assertNotNull(result);
        } catch (NoSuchUserException ex) {
            Logger.getLogger(MemberHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * Test of getStatus method, of class MemberHandler.
     */
    @Test
    public void testGetStatus() {
        try {
            System.out.println("getStatus");
            String username = "nir";
            XMLMemberHandler instance = new XMLMemberHandler(xf);
            boolean expResult = false;
            boolean result = instance.getStatus(username);
            assertEquals(expResult, result);
            //fail("The test case is a prototype.");
            //fail("The test case is a prototype.");
        } catch (NoSuchUserException ex) {
            Logger.getLogger(MemberHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    /**
     * Test of setNickName method, of class MemberHandler.
     */
    @Test
    public void testSetNickName() {
        try {
            System.out.println("setNickName");
            String username = "nir";
            String nickName = "liron";
            XMLMemberHandler instance = new XMLMemberHandler(xf);
            instance.setNickName(username, nickName);
            String modf = instance.getNickName(username);
            assertEquals(modf, nickName);
            //  fail("The test case is a prototype.");
            //  fail("The test case is a prototype.");
        } catch (NoSuchUserException ex) {
            Logger.getLogger(MemberHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of setPassword method, of class MemberHandler.
     */
    @Test
    public void testSetPassword() {
        try {
            System.out.println("setPassword");
            String username = "nir";
            String password = "34r";
            XMLMemberHandler instance = new XMLMemberHandler(xf);
            instance.setPassword(username, password);
            String modf = instance.getPassword(username);
            assertEquals(modf, password);
        } catch (NoSuchUserException ex) {
            Logger.getLogger(MemberHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of setEMail method, of class MemberHandler.
     */
    @Test
    public void testSetEMail() {
        try {
            System.out.println("setEMail");
            String username = "nir";
            String eMail = "asdtew";
            XMLMemberHandler instance = new XMLMemberHandler(xf);
            instance.setEMail(username, eMail);
            String modf = instance.getEMail(username);
            assertEquals(modf, eMail);
            // TODO review the generated test code and remove the default call to fail.
            //fail("The test case is a prototype.");
        } catch (NoSuchUserException ex) {
            Logger.getLogger(MemberHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of setDateJoined method, of class MemberHandler.
     */
    @Test
    public void testSetDateJoined() {
        try {
            System.out.println("setDateJoined");
            String username = "nir";
            Date dateJoined = new Date();
            XMLMemberHandler instance = new XMLMemberHandler(xf);
            instance.setDateJoined(username, dateJoined);
            Date modf = instance.getDateJoined(username);
            assertNotNull(modf);
            // TODO review the generated test code and remove the default call to fail.
            //fail("The test case is a prototype.");
        } catch (NoSuchUserException ex) {
            Logger.getLogger(MemberHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of setFirstName method, of class MemberHandler.
     */
    @Test
    public void testSetFirstName() {
        try {
            System.out.println("setFirstName");
            String username = "nir";
            String firstName = "asdw";
            XMLMemberHandler instance = new XMLMemberHandler(xf);
            instance.setFirstName(username, firstName);
            String modf = instance.getFirstName(username);
            assertEquals(modf, firstName);
            // TODO review the generated test code and remove the default call to fail.
            // fail("The test case is a prototype.");
        } catch (NoSuchUserException ex) {
            Logger.getLogger(MemberHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of setLastName method, of class MemberHandler.
     */
    @Test
    public void testSetLastName() {
        try {
            System.out.println("setLastName");
            String username = "nir";
            String lastName = "dwdfs";
            XMLMemberHandler instance = new XMLMemberHandler(xf);
            instance.setLastName(username, lastName);
            String modf = instance.getLastName(username);
            assertEquals(modf, lastName);
            // TODO review the generated test code and remove the default call to fail.
            //fail("The test case is a prototype.");
        } catch (NoSuchUserException ex) {
            Logger.getLogger(MemberHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of setDateofBirth method, of class MemberHandler.
     */
    @Test
    public void testSetDateofBirth() {
        try {
            System.out.println("setDateofBirth");
            String username = "nir";
            Date dateOfBirth = new Date();
            XMLMemberHandler instance = new XMLMemberHandler(xf);
            instance.setDateofBirth(username, dateOfBirth);
            Date modf = instance.getDateofBirth(username);
            assertNotNull(modf);
            // TODO review the generated test code and remove the default call to fail.
            //fail("The test case is a prototype.");
        } catch (NoSuchUserException ex) {
            Logger.getLogger(MemberHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of setStatus method, of class MemberHandler.
     */
    @Test
    public void testSetStatus() {
        try {
            System.out.println("setStatus");
            String username = "nir";
            boolean status = false;
            XMLMemberHandler instance = new XMLMemberHandler(xf);
            instance.setStatus(username, status);
            boolean modf = instance.getStatus(username);
            assertEquals(modf, status);
            //fail("The test case is a prototype.");
            //fail("The test case is a prototype.");
        } catch (NoSuchUserException ex) {
            Logger.getLogger(MemberHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}