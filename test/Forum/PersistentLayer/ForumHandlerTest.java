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
        try {
            System.out.println("login");
            String username = "nir";
            ForumHandler instance = new ForumHandler(xf);
            XMLMemberHandler mh = new XMLMemberHandler(xf);
            boolean oldStatus = mh.getStatus(username);
            assertFalse(oldStatus);
            instance.login(username);
            boolean newStatus = mh.getStatus(username);
            assertTrue(newStatus);
        } catch (NoSuchUserException ex) {
            Logger.getLogger(ForumHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }

    /**
     * Test of logoff method, of class ForumHandler.
     */
    @Test
    public void testLogoff() {
        try {
            System.out.println("logoff");
            String username = "alex";
            ForumHandler instance = new ForumHandler(xf);
            XMLMemberHandler mh = new XMLMemberHandler(xf);
            boolean oldStatus = mh.getStatus(username);
            assertTrue(oldStatus);
            instance.logoff(username);
            boolean newStatus = mh.getStatus(username);
            assertFalse(newStatus);
        } catch (NoSuchUserException ex) {
            Logger.getLogger(ForumHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of userExist method, of class ForumHandler.
     */
    @Test
    public void testUserExist() {
        System.out.println("userExist");
        String username = "nir";
        ForumHandler instance = new ForumHandler(xf);
     
        String expResult = "";
        String result = instance.userExist(username);
        assertEquals(result, username);
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }

    /**
     * Test of register method, of class ForumHandler.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
           ForumHandler instance = new ForumHandler(xf);

        String userName = "alexSup";
        String nickName = "superman";
        String password = "edfr";
        String eMail = "3@sd";
        String firstName = "alex";
        String lastName = "iscoll";
        Date dateOfBirth = new Date();
          instance.register(userName, nickName, password, eMail, firstName, lastName, dateOfBirth);
            String result = instance.userExist(userName);
        assertEquals(result, userName);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of addMessage method, of class ForumHandler.
     */
    @Test
    public void testAddMessage_5args() {
        System.out.println("addMessage");
        int parentId = 76;
        String createdBy = "alex";
        String subject = "where is bob";
        String body = "working";
        Date DateAdded = new Date();
        ForumHandler instance =  new ForumHandler(xf);;
        instance.addMessage(parentId, createdBy, subject, body, DateAdded);
             String result = instance.getSubject(1);
        assertEquals(result, subject);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of checkNickname method, of class ForumHandler.
     */
    @Test
    public void testCheckNickname() {
        System.out.println("checkNickname");
        String nickname = "arsenik";
        ForumHandler instance =  new ForumHandler(xf);;
        boolean expResult = true;
        boolean result = instance.checkNickname(nickname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
  //      fail("The test case is a prototype.");
    }

    /**
     * Test of checkPassword method, of class ForumHandler.
     */
    @Test
    public void testCheckPassword() {
        System.out.println("checkPassword");
        String password = "123456";
        ForumHandler instance =  new ForumHandler(xf);;
        boolean expResult = true;
        boolean result = instance.checkPassword(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addMessage method, of class ForumHandler.
     */
    @Test
    public void testAddMessage_6args() {
        System.out.println("addMessage");
        int parentId = 1;
        String createdBy = "nir";
        String subject = "asd";
        String body = "asdd ";
        Date DateAdded = new Date();
        Date modifyDate =  new Date();
        ForumHandler instance =  new ForumHandler(xf);
        instance.addMessage(parentId, createdBy, subject, body, DateAdded, modifyDate);
        String resSub = instance.getSubject(2);
        assertEquals(subject, resSub);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getSubject method, of class ForumHandler.
     */
    @Test
    public void testGetSubject() {
        System.out.println("getSubject");
        int messageID = 3;
        ForumHandler instance =  new ForumHandler(xf);;
        String expResult = "where is bob";
        String result = instance.getSubject(messageID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     //  fail("The test case is a prototype.");
    }

    /**
     * Test of userExists method, of class ForumHandler.
     */
    @Test
    public void testUserExists() {
        System.out.println("userExists");
        String username = "nir";
        ForumHandler instance =  new ForumHandler(xf);;
        String expResult = "123456";
        String result = instance.userExists(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of checkUsername method, of class ForumHandler.
     */
    @Test
    public void testCheckUsername() {
        System.out.println("checkUsername");
        String username = "nir";
        ForumHandler instance =  new ForumHandler(xf);
        boolean expResult = true;
        boolean result = instance.checkUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of editMessage method, of class ForumHandler.
     */
    @Test
    public void testEditMessage() {
        System.out.println("editMessage");
        int messageId = 4;
        String newSubject = "it is new now";
        String newBody = "we are trrrrrrrying to do bstst est ever";
        Date dateModified = new Date();
        ForumHandler instance = new ForumHandler(xf);
        instance.editMessage(messageId, newSubject, newBody, dateModified);
      String subNow = instance.getSubject(messageId);
        assertEquals(newSubject, subNow);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }



}