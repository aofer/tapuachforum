/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forum.DomainLayer;

import Forum.DomainLayer.SearchEngine.SearchHit;
import Forum.PersistentLayer.Data.MemberData;
import Forum.PersistentLayer.ForumHandler;
import Forum.PersistentLayer.Interfaces.eMemberType;

import java.util.Date;
import java.util.Vector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nir
 */
public class ForumFascadeTest {

    public ForumFascadeTest() {
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
    Forum fInstance = Forum.getInstance();
    ForumFascade instance = new ForumFascade();

    /**
     * Test of register method, of class ForumFascade.
     */
    @Test
    public void testRegister() throws Exception {

        System.out.println("register");
        String username = "BobUser";
        String password = "bobbobbo";
        String nickname = "boby";
        String email = "b@b";
        String firstName = "Boooo";
        String lastName = "n";
        Date dateOfBirth = new Date();
        instance.register(username, password, nickname, email, firstName, lastName, dateOfBirth);
        assertTrue(instance.getUser() != null);

    }

    /**
     * Test of login method, of class ForumFascade.
     */
    @Test
    public void testLogin() throws Exception {
        System.out.println("login");
        String username = "BobUser";
        String password = "bobbobbo";
        assertEquals(fInstance.getOnlineMembers().size(), 0);
        instance.login(username, password);
        assertEquals(fInstance.getOnlineMembers().size(), 1);

    }

    /**
     * Test of addMessage method, of class ForumFascade.
     */
    @Test
    public void testAddMessage() throws Exception {
        Member tmem = new Member(new MemberData("mmUserName", "mmNickName", "12345678"));
        instance.setUser(tmem);
        System.out.println(instance.getUser());
        System.out.println("addMessage");
        String Subject = "hey man";
        String body = "hellow BOB hh";
        instance.addMessage(Subject, body);
        System.out.println(instance.readMessage(1));
        assertTrue(instance.readMessage(1) != null);
    }

    /**
     * Test of readMessage method, of class ForumFascade.
     */
    @Test
    public void testReadMessage() throws Exception {
        System.out.println("readMessage");
        int messageId = 1;
        String expResult = "";
        String result = instance.readMessage(messageId);
        assertTrue(result != null);
    }

    /**
     * Test of viewForum method, of class ForumFascade.
     */
    @Test
    public void testViewForum() {
        System.out.println("viewForum");
        Vector expResult = null;
        Vector result = instance.viewForum();
        assertEquals(1, result.size());
    }

    /**
     * Test of addReply method, of class ForumFascade.
     */
    @Test
    public void testAddReply() throws Exception {
        System.out.println("addReply");
        Member tmem = new Member(new MemberData("mmUserName", "mmNickName", "12345678"));
        instance.setUser(tmem);
        int parentId = 1;
        String Subject = "repp";
        String body = "llslk nasdfnk;l a;klnsdfm ";
        instance.addReply(parentId, Subject, body);
        assertTrue(fInstance.getMessage(1).getReplies() != null);
    }

    /**
     * Test of editMessage method, of class ForumFascade.
     */
    @Test
    public void testEditMessage() throws Exception {
        Moderator tmem = new Moderator(new MemberData("mmUserName", "mmNickName", "12345678"));
        instance.setUser(tmem);

        System.out.println("editMessage");
        int messageId = 2;
        String newSubject = "new is come!";
        String newBody = "no more old";
        assertEquals(fInstance.getMessage(1).getReplies().get(0).getBody().substring(0, 4), "llsl");
        instance.editMessage(messageId, newSubject, newBody);
        assertEquals(fInstance.getMessage(1).getReplies().get(0).getBody().substring(0, 5), "no mo");
    }

    /**
     * Test of deleteMessage method, of class ForumFascade.
     */
    @Test
    public void testDeleteMessage() throws Exception {
        System.out.println("deleteMessage");
        Moderator tmem = new Moderator(new MemberData("mmREMOVEName", "mmREMOVEName", "12345678"));
        instance.setUser(tmem);
        instance.addMessage("hellow", "world");
        System.out.println(fInstance.viewForum());
        assertEquals(fInstance.viewForum().size(), 2);
        SearchHit[] result = instance.searchByAuthor("mmREMOVEName", 0, 1);
        assertEquals("world", result[0].getMessage().getBody());
        int messageId = 3;
        instance.deleteMessage(messageId);
        System.out.println(" now... ");
        System.out.println(fInstance.viewForum());
        assertEquals(fInstance.viewForum().size(), 1);
    }

    /**
     * Test of upgradeUser method, of class ForumFascade.
     */
    @Test
    public void testUpgradeUser() throws Exception {
        System.out.println("addReply");
        Admin tmem = new Admin(new MemberData("mmadUserName", "mmadNickName", "12345678"));
        instance.setUser(tmem);
        System.out.println("upgradeUser");
        String username = "BobUser";
        instance.upgradeUser(username);
        assertEquals(fInstance.getMember("BobUser").getType(), eMemberType.Moderator);
    }

    /**
     * Test of setUser method, of class ForumFascade.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        Moderator tmem = new Moderator(new MemberData("mmUserName", "mmNickName", "12345678"));
        instance.setUser(tmem);

    }

    /**
     * Test of getUser method, of class ForumFascade.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        Admin tmem = new Admin(new MemberData("mmadUserName", "mmadNickName", "12345678"));
        instance.setUser(tmem);
        User expResult = tmem;
        User result = instance.getUser();
        assertEquals(expResult, result);
    }

    /**
     * Test of searchByAuthor method, of class ForumFascade.
     */
    @Test
    public void testSearchByAuthor() {
        System.out.println("searchByAuthor");
        String m_nickname = "mmNickName";
        int m_from = 0;
        int m_to = 2;
        String expResult = "hellow BOB hh";
        SearchHit[] result = instance.searchByAuthor(m_nickname, m_from, m_to);
        System.out.println(result[0]);
        assertEquals(expResult, result[0].getMessage().getBody());
  }

    /**
     * Test of searchByContent method, of class ForumFascade.
     */
    @Test
    public void testSearchByContent() {
        System.out.println("searchByContent");
        String m_phrase = "hh";
        int m_from = 0;
        int m_to = 2;
        String expResult = "hellow BOB hh";
        SearchHit[] result = instance.searchByContent(m_phrase, m_from, m_to);
        assertEquals(expResult, result[0].getMessage().getBody());
    }

    /**
     * Test of logout method, of class ForumFascade.
     */
    @Test
    public void testLogout() throws Exception {
        System.out.println("logout");
        Member tmem = new Member(new MemberData("mmUserName", "mmNickName", "12345678"));
        instance.setUser(tmem);
        instance.logout();
    }
}
