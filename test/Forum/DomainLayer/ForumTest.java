/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer;

import Forum.Exceptions.BadPasswordException;
import Forum.Exceptions.MessageNotFoundException;
import Forum.Exceptions.NicknameExistsException;
import Forum.Exceptions.UserExistsException;
import Forum.PersistentLayer.ForumHandler;
import Forum.PersistentLayer.MemberHandler;
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
 * @author amit
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
        XMLFileHandler xf = new XMLFileHandler("tapuachforum.xml");
       XMLMessageHandler msgH = new XMLMessageHandler(xf);
       ForumHandler fH = new ForumHandler(xf);
       MemberHandler memH = new MemberHandler(xf);
       Forum instance = new Forum(msgH,fH,memH);
       Date tDate = new Date();
         Member newMember = new Member(instance, "liron", "lolo", "987654321", "liron", "katav","mail",tDate);
        instance.register(newMember);
       assertTrue (fH.checkUsername("liron") );
    }

   
    /**
     * Test of login method, of class Forum.
     */
    @Test
    public void testLogin() throws Exception {
         System.out.println("login");
        XMLFileHandler xf = new XMLFileHandler("tapuachforum.xml");
       XMLMessageHandler msgH = new XMLMessageHandler(xf);
       ForumHandler fH = new ForumHandler(xf);
       MemberHandler memH = new MemberHandler(xf);
       Forum instance = new Forum(msgH,fH,memH);
        Date tDate = new Date();
         Member newMember = new Member(instance, "liron", "lolo", "987654321", "liron", "katav","mail",tDate);
        instance.register(newMember);
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
            XMLFileHandler xf = new XMLFileHandler("tapuachforum.xml");
            XMLMessageHandler msgH = new XMLMessageHandler(xf);
            ForumHandler fH = new ForumHandler(xf);
            MemberHandler memH = new MemberHandler(xf);
            Forum instance = new Forum(msgH, fH, memH);
             Date tDate = new Date();
            Member newMember = new Member(instance, "liron", "lolo", "987654321", "liron", "katav","mail",tDate);
            instance.register(newMember);
            String _nickName = "liron";
            String subject = "this is the subject";
            String body = "this is the body";
            instance.addMessage(_nickName, subject, body);
            assertEquals(subject, instance.getMessage(1).getSubject());
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
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
        System.out.println("logout");
        String username = "";
        Forum instance = null;
        instance.logout(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPasswordPolicy method, of class Forum.
     */
    @Test
    public void testCheckPasswordPolicy() {
        System.out.println("checkPasswordPolicy");
        String password = "";
        Forum instance = null;
        boolean expResult = false;
        boolean result = instance.checkPasswordPolicy(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMember method, of class Forum.
     */
    @Test
    public void testAddMember() {
        System.out.println("addMember");
        Member member = null;
        Forum instance = null;
        instance.addMember(member);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editMessage method, of class Forum.
     */
    @Test
    public void testEditMessage() throws Exception {
        System.out.println("editMessage");
        String nickname = "";
        int messageId = 0;
        String subject = "";
        String body = "";
        Forum instance = null;
        instance.editMessage(nickname, messageId, subject, body);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addReply method, of class Forum.
     */
    @Test
    public void testAddReply() {
        System.out.println("addReply");
        int parentId = 0;
        String nickname = "";
        String subject = "";
        String body = "";
        Forum instance = null;
        instance.addReply(parentId, nickname, subject, body);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}