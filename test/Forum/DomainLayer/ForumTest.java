/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer;

import Forum.DomainLayer.Interfaces.MemberInterface;
import Forum.DomainLayer.Interfaces.MessageInterface;
import Forum.DomainLayer.SearchEngine.SearchHit;
import Forum.Exceptions.BadPasswordException;
import Forum.Exceptions.MessageNotFoundException;
import Forum.Exceptions.MessageOwnerException;
import Forum.Exceptions.NicknameExistsException;
import Forum.Exceptions.NoSuchUserException;
import Forum.Exceptions.UserExistsException;
import Forum.Exceptions.WrongPasswordException;
import Forum.PersistentLayer.Data.MemberData;
import Forum.PersistentLayer.Data.MessageData;
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
      fH.initForum();
         Date tDate = new Date();
         MemberData memberDetails = new MemberData("amitUserName", "amitNickName", "amiiPass","amitFirstName","amitLastName","amit@iteration.1",tDate);
         Member newMember = new Member(memberDetails);
  //   fH.initForum();
         //   instance.getInstance().initForum();
         // assertNull (fH.checkUsername("amitTest") );
        instance.getInstance().register("amitUserName", "amiiPass","amitNickName", "amitFirstName","amitLastName","amit@iteration.1",tDate);
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
//          instance.register(memberDetails);
            String _nickName = "liron";
            String subject = "this is the subject";
            String body = "this is the body";
//!!!!!!!!!!!!!!!!!!! to fix null message!!!!!!!!!!!
            //           assertNull( instance.getMessage(1).getSubject());
            instance.addMessage(_nickName, subject, body);
             
            assertEquals(subject, instance.getMessage(1).getSubject());
        } catch (MessageNotFoundException ex) {
            Logger.getLogger(ForumTest.class.getName()).log(Level.SEVERE, null, ex);
        //} catch (UserExistsException ex) {
           // Logger.getLogger(ForumTest.class.getName()).log(Level.SEVERE, null, ex);
        //} catch (NicknameExistsException ex) {
            Logger.getLogger(ForumTest.class.getName()).log(Level.SEVERE, null, ex);
        //} catch (BadPasswordException ex) {
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
    }

    /**
     * Test of setDBHandlers method, of class Forum.
     */
    @Test
    public void testSetDBHandlers() {
        try {
            //        try {
            System.out.println("setDBHandlers");
            XMLFileHandler xf = new XMLFileHandler("testForum.xml");
            XMLMessageHandler msgH = new XMLMessageHandler(xf);
            ForumHandler fH = new ForumHandler(xf);
            XMLMemberHandler memH = new XMLMemberHandler(xf);
            Forum instance = Forum.getInstance();
            instance.setDBHandlers(msgH, fH, memH);
            Date tDate = new Date();
            MemberData memberDetails = new MemberData("AnotherTestUserName", "AnotherTestNickName", "liroPass", "AnotherTestFirstName", "AnotherTestLastName", "AnotherTest@agr", tDate);
            instance.register("AnotherTestUserName", "AnotherTestNickName", "liroPass", "AnotherTestFirstName", "AnotherTestLastName", "AnotherTest@agr", tDate);
            assertTrue(fH.checkUsername("AnotherTestUserName"));
            //} catch (UserExistsException ex) {
            //            Logger.getLogger(ForumTest.class.getName()).log(Level.SEVERE, null, ex);//
            //} catch (NicknameExistsException ex) {
            //         Logger.getLogger(ForumTest.class.getName()).log(Level.SEVERE, null, ex);
            //} catch (BadPasswordException ex) {
            //      Logger.getLogger(ForumTest.class.getName()).log(Level.SEVERE, null, ex);
            //}
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
    }

    /**
     * Test of addMessage method, of class Forum.
     */
    @Test
    public void testAddMessage_4args() throws Exception {
        System.out.println("addMessage");
        int parentId = 0;
        String nickname = "amitWritesFOR";
        String Subject = "now we 4 args";
        String body = "4 3 2 one!";
        Forum instance = Forum.getInstance();
        instance.addReply(parentId, nickname, Subject, body);
         assertEquals("now we 4 args", instance.getMessage(3).getSubject());
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
    }

    /**
     * Test of addReply method, of class Forum.
     */
    @Test
    public void testAddReply() throws Exception {
        System.out.println("addReply");
        int parentId = 2;
        String nickname = "liroPass";
        String Subject = "replay COOL";
        String body = "i want to try it";
        Forum instance = Forum.getInstance();
        assertTrue(instance.getMessage(2).getReplies().size() == 0);
        instance.addReply(parentId, nickname, Subject, body);

         assertTrue(instance.getMessage(2).getReplies().size() != 0l);
    }

    /**
     * Test of viewForum method, of class Forum.
     */
    @Test
    public void testViewForum() {
        System.out.println("viewForum");
        Forum instance =  Forum.getInstance();;
        Vector expResult = null;
        Vector result = instance.viewForum();
        assertTrue(result.size() == 2);
    }

    /**
     * Test of addMessageToIndex method, of class Forum.
     */
    @Test
    public void testAddMessageToIndex() {
        System.out.println("addMessageToIndex");
        Date tDate = new Date();
                  XMLFileHandler xf = new XMLFileHandler("testForum.xml");
            XMLMessageHandler msgH = new XMLMessageHandler(xf);
            ForumHandler fH = new ForumHandler(xf);
            XMLMemberHandler memH = new XMLMemberHandler(xf);
        Forum instance = Forum.getInstance();

        int indexMes   = fH.addMessage(0,"liroPass", "subject to index", "body to index IkkkkkkkS  COOL ", tDate, tDate);
        MessageInterface m = new Message( new MessageData("liroPass", "subject to index", "body to index IS COOL", tDate, tDate,indexMes));
//           assertTrue(instance.searchByAuthor("liroPass", 0, 1)[0] == null);
        instance.addMessage("liroPass", "subject to index", "body to index IkkkkkkkS  COOL");
       //    System.out.println(instance.searchByAuthor("liroPass", 0, 1)[0].getMessage());
          assertTrue(instance.searchByAuthor("liroPass", 0, 1)[0] != null);
    }

    /**
     * Test of searchByContent method, of class Forum.
     */
    @Test
    public void testSearchByContent() {
        System.out.println("searchByContent");
        String phrase = "COOjL";
        int from = 0;
        int to =2;
      Date tDate = new Date();
        Forum instance = Forum.getInstance();
                 XMLFileHandler xf = new XMLFileHandler("testForum.xml");
            XMLMessageHandler msgH = new XMLMessageHandler(xf);
            ForumHandler fH = new ForumHandler(xf);
            XMLMemberHandler memH = new XMLMemberHandler(xf);
     int indexMes   = fH.addMessage(0,"liroPass", "subject to index", "body to index IS  COOjL ", tDate, tDate);
        MessageInterface m = new Message( new MessageData("liroPass", "subject to index", "body to index IS  COOjL ", tDate, tDate,indexMes));
        instance.addMessage("liroPass", "subject to index", "body to index IS  COOjL ");
        SearchHit[] result =  instance.searchByContent(phrase, from, to);
       //   System.out.println(result[0].getMessage());
        assertTrue( result[0] != null);
         assertTrue( result.length == 1);
    }

    /**
     * Test of searchByAuthor method, of class Forum.
     */
    @Test
    public void testsearchByAuthor() {
        System.out.println("searchByAuthor");
        Date tDate = new Date();
                  XMLFileHandler xf = new XMLFileHandler("testForum.xml");
            XMLMessageHandler msgH = new XMLMessageHandler(xf);
            ForumHandler fH = new ForumHandler(xf);
            XMLMemberHandler memH = new XMLMemberHandler(xf);
        Forum instance = Forum.getInstance();

        int indexMes   = fH.addMessage(0,"liroPassp", "subject to indexp", "body to index IkkkkkkkS  COOL ", tDate, tDate);
        MessageInterface m = new Message( new MessageData("liroPassp", "subject tpo index", "bpody to index IS COOL", tDate, tDate,indexMes));
//           assertTrue(instance.searchByAuthor("liroPassp", 0, 1)[0] == null);
        instance.addMessage("liroPassp", "subject to indexp", "body to index IkkkkkkkS  COOL ");
       //    System.out.println(instance.searchByAuthor("liroPass", 0, 1)[0].getMessage());
          assertTrue(instance.searchByAuthor("liroPassp", 0, 1)[0] != null);
    }

    /**
     * Test of getMember method, of class Forum.
     */
    @Test
    public void testGetMember() {
        System.out.println("getMember");
        String username = "amitUserName";
        Forum instance = Forum.getInstance();
        MemberInterface expResult = null;
        MemberInterface result = instance.getMember(username);
        assertEquals("amitLastName", result.getFirstName());
    }
}