/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forum.DomainLayer;

import Forum.PersistentLayer.Data.MemberData;
import Forum.PersistentLayer.Interfaces.ForumHandlerInterface;
import Forum.PersistentLayer.Interfaces.eMemberType;
import Forum.PersistentLayer.SQLForumHandler;
import java.util.Date;
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
public class AdminTest {

    public AdminTest() {
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
    Forum instanceForum = Forum.getInstance();

    /**
     * Test of upgradeUser method, of class Admin.
     */
    @Test
    public void testUpgradeUser() throws Exception {
        System.out.println("upgradeUser");

        fH.initForum();
        Date tDate = new Date();
        MemberData memD = new MemberData("membUserName", "membNickName", "memiPass", "membFirstName", "membLastName", "memb@agr", tDate);
        Member memb = new Member(memD);
        fH.register("membUserName", "membNickName", "memiPass", "membFirstName", "membLastName", "memb@agr", tDate);
        String username = "membUserName";
        MemberData adminD = new MemberData("AdminUserName", "AdNickName", "memiPass", "AdembFirstName", "membLastName", "memb@agr", tDate);
        eMemberType expResult = eMemberType.member;
        eMemberType result = memb.getType();
        assertEquals(expResult, result);
        Admin instance = new Admin(adminD);
        instance.upgradeUser(username);
        result = Forum.getInstance().getMember(username).getType();
        expResult = eMemberType.Moderator;
        assertEquals(expResult, result);
    }

    /**
     * Test of getType method, of class Admin.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Date tDate = new Date();
        MemberData adminD = new MemberData("AdminUserName", "AdNickName", "memiPass", "AdembFirstName", "membLastName", "memb@agr", tDate);
        Admin instance = new Admin(adminD);
        eMemberType expResult = eMemberType.Admin;
        eMemberType result = instance.getType();
        assertEquals(expResult, result);
    }
}
