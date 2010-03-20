/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer;

import Forum.Exceptions.BadPasswordException;
import Forum.Exceptions.MessageNotFoundException;
import Forum.Exceptions.NicknameExistsException;
import Forum.Exceptions.NoSuchUserException;
import Forum.Exceptions.UserExistsException;
import Forum.Exceptions.WrongPasswordException;
import Forum.PersistentLayer.ForumHandler;
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
       Forum instance = new Forum(msgH,fH,memH);
       Date tDate = new Date();
         Member newMember = new Member(instance, "amit", "amit", "987654321", "liron", "katav","mail",tDate);
        instance.register(newMember);
       assertTrue (fH.checkUsername("amit") );
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
       Forum instance = new Forum(msgH,fH,memH);
        Date tDate = new Date();
        // Member newMember = new Member(instance, "liron", "lolo", "987654321", "liron", "katav","mail",tDate);
       // instance.register(newMember);
        String username = "liron";
        String password = "987654321";
        instance.login(username, password);
        assertTrue(instance.getOnlineMembers().size()== 1);
    }

    /**
     * Test of addMessage method, of class Forum.
     */
    @Test
    public void testAddMessage() {
        try {
            System.out.println("addMessage");
            XMLFileHandler xf = new XMLFileHandler("testForum.xml");
            XMLMessageHandler msgH = new XMLMessageHandler(xf);
            ForumHandler fH = new ForumHandler(xf);
            XMLMemberHandler memH = new XMLMemberHandler(xf);
            Forum instance = new Forum(msgH, fH, memH);
             Date tDate = new Date();
            Member newMember = new Member(instance, "liron", "lolo", "987654321", "liron", "katav","mail",tDate);
            instance.register(newMember);
            String _nickName = "liron";
            String subject = "this is the subject";
            String body = "this is the body";
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
            Forum instance = new Forum(msgH, fH, memH);
            //Date tDate = new Date();
            // Member newMember = new Member(instance, "liron", "lolo", "987654321", "liron", "katav","mail",tDate);
            // instance.register(newMember);
            String username = "amit2";
            String password = "12345678";
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

    /**
     * Test of checkPasswordPolicy method, of class Forum.
     */
    @Test
    public void testCheckPasswordPolicy() {
        System.out.println("checkPasswordPolicy");
          XMLFileHandler xf = new XMLFileHandler("testForum.xml");
            XMLMessageHandler msgH = new XMLMessageHandler(xf);
            ForumHandler fH = new ForumHandler(xf);
            XMLMemberHandler memH = new XMLMemberHandler(xf);
            Forum instance = new Forum(msgH, fH, memH);
        String password = "fhdsjkhfdjks";
        String badPassword = "1234";
        boolean result = instance.checkPasswordPolicy(password);
        assertTrue( result);
         boolean result2 = instance.checkPasswordPolicy(badPassword);
        assertFalse( result2);
        // TODO review the generated test code and remove the default call to fail.
   
    }

    /**
     * Test of addMember method, of class Forum.
     */
    @Test
    public void testAddMember() {
       System.out.println("addMember");
        XMLFileHandler xf = new XMLFileHandler("testForum.xml");
       XMLMessageHandler msgH = new XMLMessageHandler(xf);
       ForumHandler fH = new ForumHandler(xf);
       XMLMemberHandler memH = new XMLMemberHandler(xf);
       Forum instance = new Forum(msgH,fH,memH);
        Date tDate = new Date();
        Member newMember = new Member(instance, "nir", "n", "987654321", "nir", "her","mail",tDate);
          int pre = instance.getOnlineMembers().size();
        instance.addMember(newMember);
        assertTrue(instance.getOnlineMembers().size()== pre + 1);
    }

    /**
     * Test of editMessage method, of class Forum.
     */
    @Test
    public void testEditMessage() throws Exception {
       /* System.out.println("editMessage");
        String nickname = "";
        int messageId = 0;
        String subject = "";
        String body = "";
        Forum instance = null;
        instance.editMessage(nickname, messageId, subject, body);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of addReply method, of class Forum.
     */
    @Test
    public void testAddReply() {
      /*  System.out.println("addReply");
        int parentId = 0;
        String nickname = "";
        String subject = "";
        String body = "";
        Forum instance = null;
        instance.addReply(parentId, nickname, subject, body);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

}