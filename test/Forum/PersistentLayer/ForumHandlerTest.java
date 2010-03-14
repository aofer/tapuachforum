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
public class ForumHandlerTest {

    public ForumHandlerTest() {
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
     * Test of login method, of class ForumHandler.
     */
    @Test
    public void testLogin() {
        System.out.println("login");

        String username = "nir";
        ForumHandler instance = new ForumHandler(xf);
        MemberHandler mh  = new MemberHandler(xf);
        boolean oldStatus=  mh.getStatus(username);
        assertFalse(oldStatus);
        instance.login(username);
        boolean newStatus=  mh.getStatus(username);
        assertTrue(newStatus);
     
    }

    /**
     * Test of logoff method, of class ForumHandler.
     */
    @Test
    public void testLogoff() {
        System.out.println("logoff");
        String username = "nirfr";
   ForumHandler instance = new ForumHandler(xf);
        MemberHandler mh  = new MemberHandler(xf);
        boolean oldStatus=  mh.getStatus(username);
        assertTrue(oldStatus);
        instance.logoff(username);
        boolean newStatus=  mh.getStatus(username);
        assertFalse(oldStatus);
    }

    /**
     * Test of userExist method, of class ForumHandler.
     */
    @Test
    public void testUserExist() {
        System.out.println("userExist");
        String username = "";
        ForumHandler instance = null;
        String expResult = "";
        String result = instance.userExist(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of register method, of class ForumHandler.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        String userName = "";
        String nickName = "";
        String password = "";
        String eMail = "";
        String firstName = "";
        String lastName = "";
        Date dateOfBirth = null;
        ForumHandler instance = null;
        instance.register(userName, nickName, password, eMail, firstName, lastName, dateOfBirth);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMessage method, of class ForumHandler.
     */
    @Test
    public void testAddMessage_5args() {
        System.out.println("addMessage");
        int parentId = 0;
        String createdBy = "";
        String subject = "";
        String body = "";
        Date DateAdded = null;
        ForumHandler instance = null;
        instance.addMessage(parentId, createdBy, subject, body, DateAdded);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkNickname method, of class ForumHandler.
     */
    @Test
    public void testCheckNickname() {
        System.out.println("checkNickname");
        String nickname = "";
        ForumHandler instance = null;
        boolean expResult = false;
        boolean result = instance.checkNickname(nickname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPassword method, of class ForumHandler.
     */
    @Test
    public void testCheckPassword() {
        System.out.println("checkPassword");
        String password = "";
        ForumHandler instance = null;
        boolean expResult = false;
        boolean result = instance.checkPassword(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMessage method, of class ForumHandler.
     */
    @Test
    public void testAddMessage_6args() {
        System.out.println("addMessage");
        int parentId = 0;
        String createdBy = "";
        String subject = "";
        String body = "";
        Date DateAdded = null;
        Date modifyDate = null;
        ForumHandler instance = null;
        instance.addMessage(parentId, createdBy, subject, body, DateAdded, modifyDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}