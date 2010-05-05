/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer.SearchEngine;

import Forum.DomainLayer.Interfaces.MessageInterface;
import Forum.DomainLayer.Message;
import Forum.PersistentLayer.Data.MessageData;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arseny
 */
public class CompassSearchHandlerTest {

    public CompassSearchHandlerTest() {
    }

    public CompassSearchHandler instance = new CompassSearchHandler();
    @BeforeClass
    public static void setUpClass() throws Exception {

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        Date tDate = new Date();
        Message msg = new Message(new MessageData("Arseny", "1", "hello hello", tDate, tDate,1));
        instance.addMessage(msg);
        msg = new Message(new MessageData("Arseny", "2", "hola hola", tDate, tDate,2));
        msg.addReply(new Message(new MessageData("Liron", "2.1", "aloha aloha", tDate, tDate,3)));
        instance.addMessage(msg);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addMessage method, of class CompassSearchHandler.
     */
    @Test
    public void testAddMessage() {
        System.out.println("addMessage");
        Date tDate = new Date();
        Message msg = new Message(new MessageData("Omri", "3", "marhaba marhaba", tDate, tDate,4));
        instance.addMessage(msg);
        SearchHit[] sh = instance.searchByAuthor("Omri", 0, 2);
        MessageInterface retMsg = sh[0].getMessage();
        assertEquals(msg.getIndex(), retMsg);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of updateMessage method, of class CompassSearchHandler.
     */
    @Test
    public void testUpdateMessage() {
        System.out.println("updateMessage");
        MessageInterface msg = null;
        
        instance.updateMessage(msg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeMessage method, of class CompassSearchHandler.
     */
    @Test
    public void testRemoveMessage() {
        System.out.println("removeMessage");
        MessageInterface msg = null;
        
        instance.removeMessage(msg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByAuthor method, of class CompassSearchHandler.
     */
    @Test
    public void testSearchByAuthor() {
        System.out.println("searchByAuthor");
        String username = "";
        int from = 0;
        int to = 0;
        SearchHit[] expResult = null;
        SearchHit[] result = instance.searchByAuthor(username, from, to);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByContent method, of class CompassSearchHandler.
     */
    @Test
    public void testSearchByContent() {
        System.out.println("searchByContent");
        String phrase = "";
        int from = 0;
        int to = 0;
        SearchHit[] expResult = null;
        SearchHit[] result = instance.searchByContent(phrase, from, to);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}