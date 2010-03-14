/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer;

import java.util.Vector;
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
public class MessageTest {

    public MessageTest() {
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
     * Test of getMessageId method, of class Message.
     */
    @Test
    public void testGetMessageId() {
        System.out.println("getMessageId");
        Message instance = null;
        int expResult = 0;
        int result = instance.getMessageId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBody method, of class Message.
     */
    @Test
    public void testGetBody() {
        System.out.println("getBody");
        Message instance = null;
        String expResult = "";
        String result = instance.getBody();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNickname method, of class Message.
     */
    @Test
    public void testGetNickname() {
        System.out.println("getNickname");
        Message instance = null;
        String expResult = "";
        String result = instance.getNickname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubject method, of class Message.
     */
    @Test
    public void testGetSubject() {
        System.out.println("getSubject");
        Message instance = null;
        String expResult = "";
        String result = instance.getSubject();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReplies method, of class Message.
     */
    @Test
    public void testGetReplies() {
        System.out.println("getReplies");
        Message instance = null;
        Vector expResult = null;
        Vector result = instance.getReplies();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBody method, of class Message.
     */
    @Test
    public void testSetBody() {
        System.out.println("setBody");
        String _body = "";
        Message instance = null;
        instance.setBody(_body);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSubject method, of class Message.
     */
    @Test
    public void testSetSubject() {
        System.out.println("setSubject");
        String _subject = "";
        Message instance = null;
        instance.setSubject(_subject);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addReply method, of class Message.
     */
    @Test
    public void testAddReply() {
        System.out.println("addReply");
        Message msg = null;
        Message instance = null;
        instance.addReply(msg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Message.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Message instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}