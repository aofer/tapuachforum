/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forum.DomainLayer;

import Forum.DomainLayer.Interfaces.MemberInterface;
import Forum.PersistentLayer.Data.MemberData;
import Forum.PersistentLayer.Interfaces.ForumHandlerInterface;
import Forum.PersistentLayer.Interfaces.XMLMemberInterface;
import Forum.PersistentLayer.Interfaces.eMemberType;
import Forum.PersistentLayer.SQLForumHandler;
import Forum.PersistentLayer.SQLMemberHandler;
import java.util.Date;
import java.util.List;
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
public class UserHandlerTest {

    public UserHandlerTest() {
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
    ForumHandlerInterface fH = new SQLForumHandler();
    XMLMemberInterface memH = new SQLMemberHandler();
    Date tDate = new Date();
    Forum instanceForum = Forum.getInstance();
    MemberData newMemberData = new MemberData("membUserNameToRegister", "membNickName", "memiPass", "membFirstName", "membLastName", "memb@agr", tDate);
    UserHandler instance = new UserHandler(fH, memH);

    /**
     * Test of register method, of class UserHandler.
     */
    @Test
    public void testRegister() throws Exception {
        System.out.println("register");
        fH.initForum();
        String expResult = "membUserNameToRegister";
        // Should be by Omri way.
        instance.register("membUserNameToRegister", "memiPass", "membNickName", "membFirstName", "membLastName", "memb@agr", tDate);

        MemberInterface result = instance.getMember("membUserNameToRegister");
        assertEquals(expResult, result.getUserName());
    }

    /**
     * Test of login method, of class UserHandler.
     */
    @Test
    public void testLogin() throws Exception {
        System.out.println("login");
        String username = "membUserNameToRegister";
        String password = "memiPass";
        int def = (instance.getOnlineMembers().size());
        instance.login(username, password);
        def = instance.getOnlineMembers().size() - def;
        assertTrue(def == 1);
    }

    /**
     * Test of logout method, of class UserHandler.
     */
    @Test
    public void testLogout() throws Exception {
        System.out.println("logout");
        String username = "membUserNameToRegister";
        String password = "memiPass";
  //      instance.login(username, password);
        List <MemberInterface> memes = instance.getOnlineMembers();
        for (MemberInterface oneM : memes)
            System.out.println(oneM.getUserName());
        int before = (instance.getOnlineMembers().size());
        instance.logout(username);
        int after = instance.getOnlineMembers().size();
        int def = before - after;
        assertEquals(def , 0);
    }

    /**
     * Test of upgradeUser method, of class UserHandler.
     */
    @Test
    public void testUpgradeUser() throws Exception {
        System.out.println("upgradeUser");
        String username = "membUserNameToRegister";

        assertTrue(memH.getMemberType(username) == eMemberType.member);
        instance.upgradeUser(username);
        assertTrue(memH.getMemberType(username) == eMemberType.Moderator);

    }

    /**
     * Test of getOnlineMembers method, of class UserHandler.
     */
    @Test
    public void testGetOnlineMembers() throws Exception {
        System.out.println("getOnlineMembers");
        String username = "membUserNameToRegister";
        String password = "memiPass";
        int def = (instance.getOnlineMembers().size());
   //     instance.login(username, password);
        def = instance.getOnlineMembers().size() - def;
        assertEquals(0,def );
    }
}
