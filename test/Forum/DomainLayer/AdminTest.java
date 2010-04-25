/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer;

import Forum.DomainLayer.Interfaces.ForumInterface;
import Forum.PersistentLayer.Data.MemberData;
import Forum.PersistentLayer.ForumHandler;
import Forum.PersistentLayer.Interfaces.eMemberType;
import Forum.PersistentLayer.MemberType;
import Forum.PersistentLayer.XMLFileHandler;
import Forum.PersistentLayer.XMLMemberHandler;
import Forum.PersistentLayer.XMLMessageHandler;
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

               XMLFileHandler xf = new XMLFileHandler("testForum.xml");
        ForumHandler fH = new ForumHandler(xf);
       XMLMemberHandler memH = new XMLMemberHandler(xf);
       Forum  instanceForum = Forum.getInstance();
        XMLMessageHandler mseH = new XMLMessageHandler(xf);



    /**
     * Test of upgradeUser method, of class Admin.
     */
    @Test
    public void testUpgradeUser() throws Exception {
        System.out.println("upgradeUser");
       instanceForum.setDBHandlers(mseH, fH, memH);
       fH.initForum();
       Date tDate = new Date();
        MemberData memD = new MemberData("membUserName", "membNickName", "memiPass","membFirstName","membLastName","memb@agr",tDate);
        Member memb = new Member(memD);
        fH.register("membUserName", "membNickName", "memiPass","membFirstName","membLastName","memb@agr",tDate);
      String username = "membUserName";
          MemberData adminD = new MemberData("AdminUserName", "AdNickName", "memiPass","AdembFirstName","membLastName","memb@agr",tDate);
           eMemberType expResult = eMemberType.member;
        eMemberType result = memb.getType();
        assertEquals(expResult, result);
      Admin instance = new Admin(adminD);
        instance.upgradeUser(username);
       result =memH.getMemberType(username);
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
              MemberData adminD = new MemberData("AdminUserName", "AdNickName", "memiPass","AdembFirstName","membLastName","memb@agr",tDate);
      Admin instance = new Admin(adminD);
        eMemberType expResult = eMemberType.Admin;
        eMemberType result = instance.getType();
        assertEquals(expResult, result);
    }

}