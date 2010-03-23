/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer;

import Forum.DomainLayer.Interfaces.MemberInterface;
import Forum.PersistentLayer.Data.MemberData;
import Forum.PersistentLayer.ForumHandler;
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
 * @author amit
 */
public class GuestTest {

    public GuestTest() {
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
     * Test of register method, of class Guest.
     */
    @Test
    public void testRegister() throws Exception {
          instanceForum.setDBHandlers(msgH, fH, memH);
         fH.initForum();
        System.out.println("register");
        String username = "guestUser";
        String password = "guestPass";
        String nickname = "guestNick";
        String email = "blahblah@gmail.com";
        String firstName = "guestFirst";
        String lastName = "guestLast";

          Date dateOfBirth = new Date();
        Guest instance2 = new Guest();
        MemberData newMem = new MemberData(username, nickname, password, firstName, lastName, email, dateOfBirth);
           MemberInterface memInter = instanceForum.register(newMem);
        assertEquals(memInter.getFirstName(), firstName);
       // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");*/
    }

    /**
     * Test of logIn method, of class Guest.
     */
    @Test
    public void testLogIn() throws Exception {
        System.out.println("logIn");
        String tUsername = "guestUser";
        String tPassword = "guestPass";
       Guest instance = new Guest();
       assertEquals(instanceForum.getOnlineMembers().size(), 1);
       instance.logIn(tUsername, tPassword);
      assertEquals(instanceForum.getOnlineMembers().size(), 2);
        //needs to add wrongs paramentes and checks*/
    }

}