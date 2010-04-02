/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer.SearchEngine;

import Forum.DomainLayer.Forum;
import Forum.DomainLayer.Interfaces.MessageInterface;
import Forum.DomainLayer.Message;
import Forum.PersistentLayer.Data.MessageData;
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
public class SearchEngineHandlerTest {

    public SearchEngineHandlerTest() {
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
     * Test of addData method, of class SearchEngineHandler.
     */
    @Test
    public void testAddData() {
        System.out.println("addData");
        MessageInterface msg1 = new Message(new MessageData("Arseny", "i just love aly and fila", "their latest future sound of egypt is great ", null, null));
        MessageInterface msg2 = new Message(new MessageData("Amit", "who cares about armin", "gareth emery is much better.. armin is so commercial now ", null, null));
        //SearchEngineHandler instance = new SearchEngineHandler();
        Forum f = Forum.getInstance();
        f.addMessageToIndex(msg1);
        f.addMessageToIndex(msg2);
        //instance.addData(msg1);
        //instance.addData(msg2);
        assertTrue(true);
        
        
    }

    /**
     * Test of searchByAuthor method, of class SearchEngineHandler.
     */
    @Test
    public void testSearchByAuthor() {
        System.out.println("searchByAuthor");
        String username = "";
        int from = 0;
        int to = 2;
        SearchEngineHandler instance = new SearchEngineHandler();
        MessageData m = new MessageData("Arseny", "i just love aly and fila", "their latest future sound of egypt is great ", null, null) ;
        m.setId(37);
        MessageInterface msg1 = new Message(m);
       m = new MessageData("Amit", "who cares about armin", "gareth emery is much better.. armin is so commercial now ", null, null)  ;
       m.setId(38);
        MessageInterface msg2 = new Message(m);
        Forum f = Forum.getInstance();
        f.addMessageToIndex(msg1);
        f.addMessageToIndex(msg2);
        SearchHit[] result =f.searchByAuthor("Arseny", from, to);
        assertTrue(result.length == 1);
        
    }

    /**
     * Test of searchByContent method, of class SearchEngineHandler.
     */
    @Test
    public void testSearchByContent() {
        System.out.println("searchByContent");
        String phrase = "";
        int from = 0;
        int to = 0;
        SearchEngineHandler instance = new SearchEngineHandler();
        SearchHit[] expResult = null;
        SearchHit[] result = instance.searchByContent(phrase, from, to);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RemoveMessage method, of class SearchEngineHandler.
     */
    @Test
    public void testRemoveMessage() {
        System.out.println("RemoveMessage");
        MessageInterface m = null;
        SearchEngineHandler instance = new SearchEngineHandler();
        instance.RemoveMessage(m);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}