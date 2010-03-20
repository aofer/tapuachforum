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
     * Test of addReply method, of class Message.
     */
    @Test
    public void testAddReply() {
        System.out.println("addReply");
        Message msg = new Message("amit","a test","this is a test");
        Message instance = new Message("amit","main message","this is the main message");
        int preSize = instance.getReplies().size();
        instance.addReply(msg);
        assertEquals(instance.getReplies().size(), preSize + 1);
        Message tMessage = instance.getReplies().elementAt(0);
        assertEquals(instance.getReplies().elementAt(0).getSubject(),"a test");
        assertEquals(instance.getReplies().elementAt(0).getBody(),"this is a test");


    }



}