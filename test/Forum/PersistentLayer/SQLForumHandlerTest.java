/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.PersistentLayer;

import Forum.Exceptions.MessageNotFoundException;
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
 * @author herschho
 */
public class SQLForumHandlerTest {
    public   SQLForumHandler instance= new SQLForumHandler();

    public SQLForumHandlerTest() {

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

        /**
     * Test of initForum method, of class SQLForumHandler.
     */
    @Test
    public void testInitForum() {
        
        System.out.println("initForum");
        //initFOrum2 use only to build in the first time Tapuach Forum;
        // Don't use if it is in the table
       instance.initForum();
     //instance.initForum();
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class SQLForumHandler.
     */
   @Test
    public void testLogin() {
        System.out.println("login");
         String userName = "userToCheck2";
        String nickName = "nowOut";
        String password = "PaSSword";
        String eMail = "3@sd";
        String firstName = "alex";
        String lastName = "iscoll";
        Date dateOfBirth = new Date();
     instance.register(userName, nickName, password, eMail, firstName, lastName, dateOfBirth);

        System.out.println("344");
           boolean oldStatus = instance.getStatus(userName);
           assertFalse(oldStatus);
            instance.login(userName);
          boolean newStatus = instance.getStatus(userName);
           assertTrue(newStatus);
    }

    /**
     * Test of logoff method, of class SQLForumHandler.
     */
    @Test
    public void testLogoff() {
        System.out.println("logoff");
                  System.out.println("logoff");
            String username = "userToCheck2";
           boolean oldStatus = instance.getStatus(username);
           assertTrue(oldStatus);
            instance.logoff(username);
         boolean newStatus = instance.getStatus(username);
         assertFalse(newStatus);
    }

    /**
     * Test of userExist method, of class SQLForumHandler.
     */
   @Test
     public void testUserExists() {
        System.out.println("userExist");
        String username = "notSUchUser";
       String result ;//= instance.findMember(username).getPassword();
  //      assertNull(result);
         result = instance.findMember("userToCheck2").getPassword();
        assertEquals(result, "PaSSword");

   }

      /**
     * Test of register method, of class SQLForumHandler.
     */
   @Test
    public void testRegister() {
         System.out.println("register");
        String userName = "alexSup";
        String nickName = "superman";
        String password = "edfr";
        String eMail = "3@sd";
        String firstName = "alex";
        String lastName = "iscoll";
        Date dateOfBirth = new Date();
          instance.register(userName, nickName,password, eMail, firstName, lastName, dateOfBirth);
           String result = instance.findMember(userName).getPassword();
        assertEquals(result,password);

    }
 



    /**
     * Test of addMessage method, of class SQLForumHandler.
     */
    @Test
    public void testAddMessage_5args() {
        System.out.println("addMessage");
        int parentId = 0;
        String createdBy = "alex";
        String subject = "where is bob";
        String body = "working";
        Date DateAdded = new Date();
        try {
            instance.addMessage(parentId, createdBy, subject, body, DateAdded);
        } catch (MessageNotFoundException ex) {
            Logger.getLogger(ForumHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
         String result = instance.getSubject(1);
        assertEquals(result, subject);

    }

    /**
     * Test of checkNickname method, of class SQLForumHandler.
     */
   @Test
    public void testCheckNickname() {
        System.out.println("checkNickname");
        String nickname = "arsenik";
        boolean expResult = false;
        boolean result = instance.checkNickname(nickname);
        assertEquals(expResult, result);
        result = instance.checkNickname("nowOut");
        expResult = true;
       assertEquals(expResult, result);
}

    /**
     * Test of checkPassword method, of class SQLForumHandler.
     */
    @Test
    public void testCheckPassword() {
        System.out.println("checkPassword");
        String password = "Neveruse123456";
        boolean expResult = false;
        boolean result = instance.checkPassword(password);
        assertEquals(expResult, result);
         expResult = true;
         result = instance.checkPassword("PaSSword");
        assertEquals(expResult, result);
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
       instance.addMessage(parentId, createdBy, subject, body, DateAdded, modifyDate);
        String resSub = instance.getSubject(2);
        assertEquals(subject, resSub);
    }

    /**
     * Test of getSubject method, of class ForumHandler.
     */
    @Test
    public void testGetSubject() {
        System.out.println("getSubject");
        int messageID = 2;
        String expResult = " welcome prev mesage!!!";
        String result = instance.getSubject(messageID);
        assertEquals(expResult, result);
    }



    /**
     * Test of checkUsername method, of class ForumHandler.
     */
   @Test
    public void testCheckUsername() {
        System.out.println("checkUsername");
        String username = "neverCallmeLikeThat";
        boolean expResult = false;
        boolean result = instance.checkUsername(username);
        assertEquals(expResult, result);
          expResult = true;
         result = instance.checkUsername("userToCheck2");
        assertEquals(expResult, result);
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
        instance.editMessage(messageId, newSubject, newBody, dateModified);
      String subNow = instance.getSubject(messageId);
        assertEquals(newSubject, subNow);
    }

    /**
     * Test of deleteMessage method, of class ForumHandler.
     */
    @Test
    public void testDeleteMessage() throws Exception {
        System.out.println("deleteMessage");
      //  testAddMessage_6args();
       int messageId = 2;
    //    instance.deleteMessage(messageId);
        String newSubject = "it is new now";
        String subNow = instance.getSubject(2);
        assertEquals(newSubject, subNow);
        instance.deleteMessage(messageId);
        subNow = instance.getSubject(messageId);
        assertNotSame(newSubject, subNow);
    }


    /**
     * Test of upgradeUser method, of class ForumHandler.
     */
    @Test
    public void testUpgradeUser() throws Exception {
        System.out.println("upgradeUser");
        String username = "alexSup";
       boolean result = instance.checkUsername(username);
         assertTrue(result);
        instance.upgradeUser(username);
        boolean result2= instance.checkUsername(username);
       assertEquals(result2, result);
    }

}