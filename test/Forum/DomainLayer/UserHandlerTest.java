/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer;

import Forum.Exceptions.NoSuchUserException;
import Forum.Exceptions.WrongPasswordException;
import Forum.PersistentLayer.Data.MemberData;
import Forum.PersistentLayer.ForumHandler;
import Forum.PersistentLayer.Interfaces.XMLMemberInterface;
import Forum.PersistentLayer.Interfaces.eMemberType;
import Forum.PersistentLayer.XMLFileHandler;
import Forum.PersistentLayer.XMLMemberHandler;
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

              XMLFileHandler xf = new XMLFileHandler("testForum.xml");
        ForumHandler fH = new ForumHandler(xf);
       XMLMemberHandler memH = new XMLMemberHandler(xf);
         Date tDate = new Date();
       Forum  instanceForum = Forum.getInstance();
          MemberData newMemberData = new MemberData("membUserNameToRegister", "membNickName", "memiPass","membFirstName","membLastName","memb@agr",tDate);
   //       XMLMemberInterface memHXml = new XMLMemberInterface();

        UserHandler instance = new UserHandler (fH,memH);


    /**
     * Test of register method, of class UserHandler.
     */
    @Test
    public void testRegister() throws Exception {
        System.out.println("register");
        fH.initForum();
        String expResult = "membUserNameToRegister";
      // Should be by Omri way.
        // Member result = instance.register(newMemberData);
       String result = "this is stub string!!!";
        assertEquals(expResult, result);//result.getUserName());
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
         def = instance.getOnlineMembers().size() -def;
         assertTrue(def == 1);
    }

    /**
     * Test of logout method, of class UserHandler.
     */
    @Test
    public void testLogout()  throws Exception{
        System.out.println("logout");
     String username = "membUserNameToRegister";
     String password = "memiPass";
     instance.login(username, password);
     int def = (instance.getOnlineMembers().size());
     instance.logout(username);
     def = instance.getOnlineMembers().size() -def;
     assertTrue(def == -1);
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
              instance.login(username, password);
         def = instance.getOnlineMembers().size() -def;
         assertTrue(def == 1);
    xf.WriteToXML();
    }

  
}
