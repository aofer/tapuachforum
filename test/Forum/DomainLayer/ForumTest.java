/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer;

import Forum.DomainLayer.Interfaces.MessageInterface;
import Forum.Exceptions.BadPasswordException;
import Forum.Exceptions.MessageNotFoundException;
import Forum.Exceptions.MessageOwnerException;
import Forum.Exceptions.NicknameExistsException;
import Forum.Exceptions.NoSuchUserException;
import Forum.Exceptions.UserExistsException;
import Forum.Exceptions.WrongPasswordException;
import Forum.PersistentLayer.Data.MemberData;
import Forum.PersistentLayer.ForumHandler;
import Forum.PersistentLayer.Interfaces.eMemberType;
import Forum.PersistentLayer.XMLMemberHandler;
import Forum.PersistentLayer.XMLFileHandler;
import Forum.PersistentLayer.XMLMessageHandler;
import java.util.Date;
import java.util.Vector;
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
 * @author Amit Ofer
 */
public class ForumTest {

    public ForumTest() {
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
     * Test of register method, of class Forum.
     */
    @Test
    public void testRegister() throws Exception {
        System.out.println("register");
        XMLFileHandler xf = new XMLFileHandler("testForum.xml");
       XMLMessageHandler msgH = new XMLMessageHandler(xf);
       ForumHandler fH = new ForumHandler(xf);
       XMLMemberHandler memH = new XMLMemberHandler(xf);
    //   Forum instance = new Forum(msgH,fH,memH);
         Forum  instance = Forum.getInstance();       
         instance.setDBHandlers(msgH, fH, memH);
         Date tDate = new Date();
         MemberData memberDetails = new MemberData("amitUserName", "amitNickName", "amiiPass","amitFirstName","amitLastName","amit@agr",tDate);
         Member newMember = new Member(memberDetails);
     fH.initForum();
         //   instance.getInstance().initForum();
         // assertNull (fH.checkUsername("amitTest") );
        instance.getInstance().register(memberDetails);
       assertTrue (fH.checkUsername("amitUserName") );
    }

   
    /**
     * Test of login method, of class Forum.
     */
    @Test
    public void testLogin() throws Exception {
         System.out.println("login");
        XMLFileHandler xf = new XMLFileHandler("testForum.xml");
       XMLMessageHandler msgH = new XMLMessageHandler(xf);
       ForumHandler fH = new ForumHandler(xf);
       XMLMemberHandler memH = new XMLMemberHandler(xf);
       Forum  instance = Forum.getInstance();
        Date tDate = new Date();
        String username = "amitUserName";
        String password = "amiiPass";
         assertFalse(instance.getOnlineMembers().size()== 1);
//!!!!!!!!!!  to do: handle with wrong password.
         //     instance.login(username,"wronPass");
//     assertFalse(instance.getOnlineMembers().size()== 1);
         instance.login(username, password);
        assertTrue(instance.getOnlineMembers().size()== 1);
    }

    /**
     * Test of addMessage method, of class Forum.
     */
   @Test
    public void testAddMessage() throws MessageOwnerException {
        try {
            System.out.println("addMessage");
            XMLFileHandler xf = new XMLFileHandler("testForum.xml");
            XMLMessageHandler msgH = new XMLMessageHandler(xf);
            ForumHandler fH = new ForumHandler(xf);
            XMLMemberHandler memH = new XMLMemberHandler(xf);
            Forum instance = Forum.getInstance();
             Date tDate = new Date();
           MemberData memberDetails = new MemberData("lironUserName", "lironNickName", "liroPass","lironFirstName","lironLastName","liron@agr",tDate);
          instance.register(memberDetails);
            String _nickName = "liron";
            String subject = "this is the subject";
            String body = "this is the body";
//!!!!!!!!!!!!!!!!!!! to fix null message!!!!!!!!!!!
            //           assertNull( instance.getMessage(1).getSubject());
            instance.addMessage(_nickName, subject, body);
             
            assertEquals(subject, instance.getMessage(1).getSubject());
        } catch (MessageNotFoundException ex) {
            Logger.getLogger(ForumTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UserExistsException ex) {
            Logger.getLogger(ForumTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NicknameExistsException ex) {
            Logger.getLogger(ForumTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPasswordException ex) {
            Logger.getLogger(ForumTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of logout method, of class Forum.
    */
    @Test
    public void testLogout() {
        try {
            System.out.println("login");
            XMLFileHandler xf = new XMLFileHandler("testForum.xml");
            XMLMessageHandler msgH = new XMLMessageHandler(xf);
            ForumHandler fH = new ForumHandler(xf);
            XMLMemberHandler memH = new XMLMemberHandler(xf);
            Forum instance = Forum.getInstance();
            //Date tDate = new Date();
            // Member newMember = new Member(instance, "liron", "lolo", "987654321", "liron", "katav","mail",tDate);
            // instance.register(newMember);
         
            String username = "amitUserName";
            String password = "amiiPass";
            instance.login(username, password);
             int pre = instance.getOnlineMembers().size();
              instance.logout(username);
            assertTrue(instance.getOnlineMembers().size() == pre - 1);
        } catch (NoSuchUserException ex) {
            Logger.getLogger(ForumTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WrongPasswordException ex) {
            Logger.getLogger(ForumTest.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
/***  do we need this test????
    /**
     * Test of checkPasswordPolicy method, of class Forum.
     */
    /*@Test
    public void testCheckPasswordPolicy() {
        System.out.println("checkPasswordPolicy");
          XMLFileHandler xf = new XMLFileHandler("testForum.xml");
            XMLMessageHandler msgH = new XMLMessageHandler(xf);
            ForumHandler fH = new ForumHandler(xf);
            XMLMemberHandler memH = new XMLMemberHandler(xf);
            Forum instance = Forum.getInstance();
        String password = "fhdsjkhfdjks";
        String badPassword = "1234";
        boolean result = instance.checkPasswordPolicy(password);
        assertTrue( result);
         boolean result2 = instance.checkPasswordPolicy(badPassword);
        assertFalse( result2);
        // TODO review the generated test code and remove the default call to fail.
   
    }
/***  do we need this test????
    /**
     * Test of addMember method, of class Forum.
     */
 /*   @Test
    public void testAddMember() {
       System.out.println("addMember");
        XMLFileHandler xf = new XMLFileHandler("testForum.xml");
       XMLMessageHandler msgH = new XMLMessageHandler(xf);
       ForumHandler fH = new ForumHandler(xf);
       XMLMemberHandler memH = new XMLMemberHandler(xf);
       Forum instance = Forum.getInstance();
        Date tDate = new Date();
        Member newMember = new Member(instance, "nir", "n", "987654321", "nir", "her","mail",tDate);
          int pre = instance.getOnlineMembers().size();
        instance.addMember(newMember);
        assertTrue(instance.getOnlineMembers().size()== pre + 1);
    }

  /***  do we need this test????
  /**
     * Test of editMessage method, of class Forum.
     */
   @Test
    public void testEditMessage() throws Exception {
       System.out.println("editMessage");
        String nickname = "liron";
        int messageId = 1;
        String subject = "try to change";
        String body = "if you read that you should smile,  the test pass.";
        Forum instance = Forum.getInstance();
       assertNotSame(subject, instance.getMessage(1).getSubject());

        instance.editMessage(nickname, messageId, subject, body);
        assertEquals(subject, instance.getMessage(1).getSubject());

        // TODO review the generated test code and remove the default call to fail.
 //       fail("The test case is a prototype.");*/
    }

    /**
     * Test of addReply method, of class Forum.
     */
  /*  @Test
    public void testAddReply() {
       System.out.println("addReply");
        int parentId = 0;
        String nickname = "";
        String subject = "";
        String body = "";
        Forum instance = null;
        instance..addReply(parentId, nickname, subject, body);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    //}

    /**
     * Test of getInstance method, of class Forum.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Forum expResult = null;
        Forum result = Forum.getInstance();
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
    //    fail("The test case is a prototype.");
    }

    /**
     * Test of setDBHandlers method, of class Forum.
     */
    @Test
    public void testSetDBHandlers() {
        try {
            System.out.println("setDBHandlers");
            XMLFileHandler xf = new XMLFileHandler("testForum.xml");
            XMLMessageHandler msgH = new XMLMessageHandler(xf);
            ForumHandler fH = new ForumHandler(xf);
            XMLMemberHandler memH = new XMLMemberHandler(xf);
            Forum instance = Forum.getInstance();
            instance.setDBHandlers(msgH, fH, memH);
            Date tDate = new Date();
            MemberData memberDetails = new MemberData("AnotherTestUserName", "AnotherTestNickName", "liroPass", "AnotherTestFirstName", "AnotherTestLastName", "AnotherTest@agr", tDate);
            instance.register(memberDetails);
            assertTrue(fH.checkUsername("AnotherTestUserName"));
            // TODO review the generated test code and remove the default call to fail.
       //     fail("The test case is a prototype.");
        } catch (UserExistsException ex) {
            Logger.getLogger(ForumTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NicknameExistsException ex) {
            Logger.getLogger(ForumTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPasswordException ex) {
            Logger.getLogger(ForumTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getOnlineMembers method, of class Forum.
     */
    @Test
    public void testGetOnlineMembers() {
        try {
            System.out.println("getOnlineMembers");
            Forum instance = Forum.getInstance();
            Vector expResult = null;
            Vector result = instance.getOnlineMembers();
            assertEquals(result.size(), 0);
            Date tDate = new Date();
            String username = "amitUserName";
            String password = "amiiPass";
            instance.login(username, password);
            assertEquals(result.size(), 1);
            //   fail("The test case is a prototype.");
            //   fail("The test case is a prototype.");
        } catch (NoSuchUserException ex) {
            Logger.getLogger(ForumTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WrongPasswordException ex) {
            Logger.getLogger(ForumTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getMessage method, of class Forum.
     */
    @Test
    public void testGetMessage() throws Exception {
        System.out.println("getMessage");
        int messageId = 1;
        Forum instance = Forum.getInstance();
        String expResult = null;
        MessageInterface result = instance.getMessage(messageId);
        assertEquals("try to change", result.getSubject());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addMessage method, of class Forum.
     */
    @Test
    public void testAddMessage_3args() throws Exception {
        System.out.println("addMessage");
        String nickname = "liron";
        String Subject = "3 args message";
        String body = "one two there";
        Forum instance = Forum.getInstance();
              instance.addMessage(nickname, Subject, body);
          assertEquals("3 args message", instance.getMessage(2).getSubject());
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of addMessage method, of class Forum.
     */
    @Test
    public void testAddMessage_4args() throws Exception {
        System.out.println("addMessage");
        int replyId = 0;
        String nickname = "amitWritesFOR";
        String Subject = "now we 4 args";
        String body = "4 3 2 one!";
        Forum instance = Forum.getInstance();
        instance.addMessage(replyId, nickname, Subject, body);
         assertEquals("now we 4 args", instance.getMessage(3).getSubject());
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of deleteMessage method, of class Forum.
     */
    @Test
    public void testDeleteMessage() throws Exception {
        System.out.println("deleteMessage");
        int messageId = 3;
        Forum instance = Forum.getInstance();
        assertEquals("now we 4 args", instance.getMessage(3).getSubject());
        instance.deleteMessage(messageId);
   // we need some how to check errors we get!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //      instance.deleteMessage(messageId);
        //assertNull(instance.getMessage(3));
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }


    //!!!!!!!!!!!!!!!!!! need to fix the test. the forum can update status, but not to check. it is in the member side.
    /**
     * Test of upgradeUser method, of class Forum.
     */
    @Test
    public void testUpgradeUser() throws Exception {
        System.out.println("upgradeUser");
        String username = "amitUserName";
         XMLFileHandler xf = new XMLFileHandler("testForum.xml");
       XMLMessageHandler msgH = new XMLMessageHandler(xf);
       ForumHandler fH = new ForumHandler(xf);
       XMLMemberHandler memH = new XMLMemberHandler(xf);
        Forum instance = Forum.getInstance();
        Date tDate = new Date();
        MemberData memberDetails = new MemberData("amitUserName", "amitNickName", "amiiPass","amitFirstName","amitLastName","amit@agr",tDate);
         Member bob = new Member(memberDetails);
      

        assertEquals(memH.getMemberType("amitUserName"), eMemberType.member);

        instance.upgradeUser(username);
   //    assertEquals(memH.getMemberType("amitUserName"),eMemberType.Moderator);
      //  instance.upgradeUser(username);
        // TODO review the generated test code and remove the default call to fail.
   //     fail("The test case is a prototype.");
    }
}