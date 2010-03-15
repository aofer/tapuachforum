/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer;

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

   
    /**
     * Test of register method, of class Guest.
     */
    @Test
    public void testRegister() throws Exception {
        System.out.println("register");
        String username = "lironka";
        String password = "12345";
        String nickname = "liron";
        String email = "blahblah@gmail.com";
        String firstName = "liron";
        String lastName = "katav";
        Date dateOfBirth = null;;
        Guest instance = null;
        instance.register(username, password, nickname, email, firstName, lastName, dateOfBirth);
       // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of logIn method, of class Guest.
     */
    @Test
    public void testLogIn() throws Exception {
        System.out.println("logIn");
        String tUsername = "liron";
        String tPassword = "12345678";
        Forum tForum = new Forum(null, null,null);
        Member tMember = new Member (tForum, tUsername, null, tPassword, null, null,null, null);
        tForum.addMember(tMember);
        Guest instance = new Guest(tForum);
        instance.logIn(tUsername, tPassword);
        assertEquals(tMember, tForum.getOnlineMembers().elementAt(0));
        //needs to add wrongs paramentes and checks
    }

}