/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer;

import Forum.Exceptions.BadPasswordException;
import Forum.Exceptions.NicknameExistsException;
import Forum.Exceptions.UserExistsException;
import Forum.PersistentLayer.Data.MemberData;
import Forum.PersistentLayer.ForumHandler;
import Forum.PersistentLayer.Interfaces.eMemberType;
import Forum.PersistentLayer.XMLFileHandler;
import Forum.PersistentLayer.XMLMemberHandler;
import Forum.PersistentLayer.XMLMessageHandler;
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
 * @author amit
 */
public class MemberTest {

    public MemberTest() {
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

          XMLFileHandler xf = new XMLFileHandler("testForum.xml");
       XMLMessageHandler msgH = new XMLMessageHandler(xf);
       ForumHandler fH = new ForumHandler(xf);
       XMLMemberHandler memH = new XMLMemberHandler(xf);
       Forum  instanceForum = Forum.getInstance();





    /**
     * Test of getUserName method, of class Member.
     */
    @Test
    public void testGetUserName() {
        instanceForum.setDBHandlers(msgH, fH, memH);
        fH.initForum();
        System.out.println("getUserName");
        Date tDate = new Date();
        MemberData memD = new MemberData("membUserName", "membNickName", "memiPass","membFirstName","membLastName","memb@agr",tDate);
        Member instance = new Member(memD);
        String expResult = "membUserName";
        String result = instance.getUserName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword method, of class Member.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
           Date tDate = new Date();
        MemberData memD = new MemberData("membUserName", "membNickName", "memiPass","membFirstName","membLastName","memb@agr",tDate);
        Member instance = new Member(memD);
        String expResult = "memiPass";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNickName method, of class Member.
     */
    @Test
    public void testGetNickName() {
        System.out.println("getNickName");
             Date tDate = new Date();
        MemberData memD = new MemberData("membUserName", "membNickName", "memiPass","membFirstName","membLastName","memb@agr",tDate);
        Member instance = new Member(memD);
        String expResult = "membNickName";
        String result = instance.getNickName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastName method, of class Member.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
          Date tDate = new Date();
        MemberData memD = new MemberData("membUserName", "membNickName", "memiPass","membFirstName","membLastName","memb@agr",tDate);
        Member instance = new Member(memD);
        String expResult = "membLastName";
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFirstName method, of class Member.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
      Date tDate = new Date();
        MemberData memD = new MemberData("membUserName", "membNickName", "memiPass","membFirstName","membLastName","memb@agr",tDate);
        Member instance = new Member(memD);
        String expResult = "membFirstName";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class Member.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
           Date tDate = new Date();
        MemberData memD = new MemberData("membUserName", "membNickName", "memiPass","membFirstName","membLastName","memb@agr",tDate);
        Member instance = new Member(memD);
        String expResult = "memb@agr";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateOfBirth method, of class Member.
     */
    @Test
    public void testGetDateOfBirth() {
        System.out.println("getDateOfBirth");
       Date tDate = new Date();
        MemberData memD = new MemberData("membUserName", "membNickName", "memiPass","membFirstName","membLastName","memb@agr",tDate);
        Member instance = new Member(memD);
        Date expResult = tDate;
        Date result = instance.getDateOfBirth();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateJoined method, of class Member.
     */
    @Test
    public void testGetDateJoined() {
        System.out.println("getDateJoined");
          Date tDate = new Date();
        MemberData memD = new MemberData("membUserName", "membNickName", "memiPass","membFirstName","membLastName","memb@agr",tDate);
        Member instance = new Member(memD);
        Date result = instance.getDateJoined();
        assertNotNull(result);
    }

    /**
     * Test of writeMessage method, of class Member.
     */
    @Test
    public void testWriteMessage() throws Exception {
        System.out.println("writeMessage");
        String subject = "member try";
        String body = "this is a test. Specipiuc memebr write the message";
          Date tDate = new Date();
        MemberData memD = new MemberData("membUserName", "membNickName", "memiPass","membFirstName","membLastName","memb@agr",tDate);
        Member instance = new Member(memD);
        instance.writeMessage(subject, body);
        assertEquals(instanceForum.getMessage(1).getSubject(),subject);
       System.out.print(instanceForum.getMessage(1));
    }

    /**
     * Test of writeReply method, of class Member.
     */
    @Test
    public void testWriteReply() throws Exception {
        System.out.println("writeReply");
        int parentId = 1;

        String subject = "replay to 1";
        String body = "this is 2nd test on message";
             Date tDate = new Date();
        MemberData memD = new MemberData("membUserName", "membNickName", "memiPass","membFirstName","membLastName","memb@agr",tDate);
        Member instance = new Member(memD);
        instance.writeReply(parentId, subject, body);
        assertEquals(instanceForum.getMessage(2).getSubject(),subject);
    }

    /**
     * Test of editMessage method, of class Member.
     */
    @Test
    public void testEditMessage() throws Exception {
        System.out.println("editMessage");
        int messageId = 2;
        String subject = "NEW SUBJECT";
        String body = "here it is edited message.";
               Date tDate = new Date();
        MemberData memD = new MemberData("membUserName", "membNickName", "memiPass","membFirstName","membLastName","memb@agr",tDate);
        Member instance = new Member(memD);
        assertNotSame(instanceForum.getMessage(2).getSubject(),subject);
        instance.editMessage(messageId, subject, body);
      assertEquals(instanceForum.getMessage(2).getSubject(),subject);
    }

    /**
     * Test of getType method, of class Member.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
              Date tDate = new Date();
        MemberData memD = new MemberData("membUserName", "membNickName", "memiPass","membFirstName","membLastName","memb@agr",tDate);
        Member instance = new Member(memD);
        eMemberType expResult = eMemberType.member;
        eMemberType result = instance.getType();
        assertEquals(expResult, result);
    }

        /**
     * Test of logOut method, of class Member.
     */
    @Test
    public void testLogOut() {
       try {

            System.out.println("logOut");
            Date tDate = new Date();
            MemberData instance = new MemberData("liron", "blah", "87654321", "liron", "katav", "lirrr@l.c", tDate);
            Member memb = new Member(instance);
            instanceForum.register("liron", "blah", "87654321", "liron", "katav", "lirrr@l.c", tDate);
             assertEquals(instanceForum.getOnlineMembers().size() , 1);
            memb.logOut();
            assertEquals(instanceForum.getOnlineMembers().size() , 0);
        } catch (UserExistsException ex) {
            Logger.getLogger(MemberTest.class.getName()).log(Level.SEVERE, null, ex);
       } catch (NicknameExistsException ex) {
            Logger.getLogger(MemberTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPasswordException ex) {
           Logger.getLogger(MemberTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}