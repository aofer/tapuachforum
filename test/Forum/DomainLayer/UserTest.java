/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forum.DomainLayer;

//import Forum.PersistentLayer.Data.MemberData;
import Forum.PersistentLayer.Interfaces.ForumHandlerInterface;
import Forum.PersistentLayer.SQLForumHandler;
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
public class UserTest {

    public UserTest() {
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
     * Test of readMessage method, of class User.
     */
    @Test
    public void testReadMessage() throws Exception {
        System.out.println("readMessage");
        Forum instanceForum = Forum.getInstance();
        ForumHandlerInterface fork = new SQLForumHandler();
        //fork.initForum();
        String _nickName = "userToCheckLo";
        String subject = "adding mwssage from domain layer";
        String body = "yeapy hi hoo!";
        instanceForum.addMessage(_nickName, subject, body);
        int messageId = instanceForum.viewForum().size();
         System.out.println(messageId);
        User instance = new Guest();
        String expResult = "Subject:adding m";
        String result = instance.readMessage(messageId);
        assertEquals(expResult, result.substring(13, 29));
    }
}
