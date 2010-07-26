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
public class ModeratorTest {

    public ModeratorTest() {
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
     * Test of deleteMessage method, of class Moderator.
     */
    @Test
    public void testDeleteMessage() throws Exception {

        System.out.println("deleteMessage");
        int messageId = 1;
        Date tDate = new Date();
        MemberData memD = new MemberData("membUserName", "membNickName", "memiPass", "membFirstName", "membLastName", "memb@agr", tDate);
        Moderator instance = new Moderator(memD);
        fH.initForum();
        fH.addMessage(0, "TheTeser", "It should be delere", "no specital body", tDate, tDate);
        instance.deleteMessage(messageId);
        fH.addMessage(0, "TheTeser", "Now the message counter  should be 3 and Message Id 2 !!!", "no specital body", tDate, tDate);

        /** there is no ASSERT.
        if you want to see the TEST result, check that in the file
        named "testForum" , the first message is num 2!!!
         **/
    }

    /**
     * Test of getType method, of class Moderator.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Date tDate = new Date();
        MemberData memD = new MemberData("membUserName", "membNickName", "memiPass", "membFirstName", "membLastName", "memb@agr", tDate);
        Moderator instance = new Moderator(memD);
        eMemberType expResult = eMemberType.Moderator;
        eMemberType result = instance.getType();
        assertEquals(expResult, result);

    }
}
