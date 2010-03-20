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

          System.out.println("login");
           ForumHandler instance = new ForumHandler(xf);
      instance.initForum();
           String userName = "userToCheckLogInandLogOut";
        String nickName = "nowOut";
        String password = "PaSSword";
        String eMail = "3@sd";
        String firstName = "alex";
        String lastName = "iscoll";
        Date dateOfBirth = new Date();
         instance.register(userName, nickName, password, eMail, firstName, lastName, dateOfBirth);
       //XMLMemberHandler mh = new XMLMemberHandler(xf);
            boolean oldStatus = instance.getStatus(userName);
           assertFalse(oldStatus);
            instance.login(userName);
           boolean newStatus = instance.getStatus(userName);
           assertTrue(newStatus);



    }

    /**
     * Test of logoff method, of class ForumHandler.
     */
    @Test
    public void testLogoff() {
            System.out.println("logoff");
            String username = "userToCheckLogInandLogOut";
            ForumHandler instance = new ForumHandler(xf);
           boolean oldStatus = instance.getStatus(username);
           assertTrue(oldStatus);
            instance.logoff(username);
         boolean newStatus = instance.getStatus(username);
         assertFalse(newStatus);

    }

    /**
     * Test of userExist method, of class ForumHandler.
     */
    @Test
    public void testUserExists() {
        System.out.println("userExist");
        String username = "notSUchUser";
        ForumHandler instance = new ForumHandler(xf);
        String result = instance.userExist(username);
        assertNull(result);
         result = instance.userExist("userToCheckLogInandLogOut");
        assertEquals(result, "PaSSword");
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
  //        instance.initForum();
        String userName = "alexSup";
        String nickName = "superman";
        String password = "edfr";
        String eMail = "3@sd";
        String firstName = "alex";
        String lastName = "iscoll";
        Date dateOfBirth = new Date();
          instance.register(userName, nickName, password, eMail, firstName, lastName, dateOfBirth);
           String result = instance.userExist(userName);
        assertEquals(result,password);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of addMessage method, of class ForumHandler.
     */
    @Test
    public void testAddMessage_5args() {
        System.out.println("addMessage");
        int parentId = 0;
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
        boolean expResult = false;
        boolean result = instance.checkNickname(nickname);
        assertEquals(expResult, result);
        result = instance.checkNickname("nowOut");
        expResult = true;
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
        String password = "Neveruse123456";
        ForumHandler instance =  new ForumHandler(xf);;
        boolean expResult = false;
        boolean result = instance.checkPassword(password);
        assertEquals(expResult, result);
         expResult = true;
         result = instance.checkPassword("PaSSword");
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
        String createdBy = "someuser";
        String subject =" welcome prev mesage!!!";
        String body = "java is fun! ";
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
        int messageID = 2;
        ForumHandler instance =  new ForumHandler(xf);;
        String expResult = " welcome prev mesage!!!";
        String result = instance.getSubject(messageID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     //  fail("The test case is a prototype.");
    }



    /**
     * Test of checkUsername method, of class ForumHandler.
     */
    @Test
    public void testCheckUsername() {
        System.out.println("checkUsername");
        String username = "neverCallmeLikeThat";
        ForumHandler instance =  new ForumHandler(xf);
        boolean expResult = false;
        boolean result = instance.checkUsername(username);
        assertEquals(expResult, result);
          expResult = true;
         result = instance.checkUsername("userToCheckLogInandLogOut");
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
        int messageId = 2;
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

    /**
     * Test of deleteMessage method, of class ForumHandler.
     */
    @Test
    public void testDeleteMessage() throws Exception {
        System.out.println("deleteMessage");
      //  testAddMessage_6args();
       int messageId = 2;
        ForumHandler instance = new ForumHandler(xf);;;
    //    instance.deleteMessage(messageId);
        String newSubject = "it is new now";
        String subNow = instance.getSubject(messageId);
        assertEquals(newSubject, subNow);
        instance.deleteMessage(messageId);
        subNow = instance.getSubject(messageId);
        assertNotSame(newSubject, subNow);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


    /**
     * Test of upgradeUser method, of class ForumHandler.
     */
    @Test
    public void testUpgradeUser() throws Exception {
        System.out.println("upgradeUser");
        String username = "";
        ForumHandler instance = null;
        instance.upgradeUser(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initForum method, of class ForumHandler.
     */
    @Test
    public void testInitForum() {
        System.out.println("initForum");
        ForumHandler instance = new ForumHandler(xf);
   //     instance.initForum();
        // TODO review the generated test code and remove the default call to fail.
       fail("The test case is a prototype.");
    }



}