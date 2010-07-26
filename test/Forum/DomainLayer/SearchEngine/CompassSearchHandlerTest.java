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
        msg = new Message(new MessageData("Arseny", "", "", tDate, tDate,2));
        Message Msg2 = new Message(new MessageData("Liron", "2.1", "aloha aloha", tDate, tDate,3));
        Message Msg3 = new Message(new MessageData("Amit", "2.1.1", "bom dia", tDate, tDate,10));
        Msg2.addReply(Msg3);
        msg.addReply(Msg2);
        instance.addMessage(msg);
        msg = new Message(new MessageData("Tal", "", "", tDate, tDate,111));
        instance.addMessage(msg);
        msg.setBody("foo boo goo");
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
        
        msg.addReply( new Message(new MessageData("Nir", "3", "bonjour bonjour", tDate, tDate,5)));

        instance.addMessage(msg);
        SearchHit[] sh = instance.searchByAuthor("Omri", 0, 1);
        MessageInterface retMsg = sh[0].getMessage();
        assertEquals(msg.getIndex(), retMsg.getIndex());
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of updateMessage method, of class CompassSearchHandler.
     */
    @Test
    public void testUpdateMessage() {
        System.out.println("updateMessage");
         SearchHit[] sh = instance.searchByAuthor("Nir", 0, 1);
         MessageInterface retMsg = sh[0].getMessage();
         retMsg.setBody("ni hao");
         instance.updateMessage(retMsg);
         sh = instance.searchByAuthor("Nir", 0, 1);
         retMsg = sh[0].getMessage();
         assertEquals("ni hao",retMsg.getBody() );

        
        
  
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of removeMessage method, of class CompassSearchHandler.
     */
    @Test
    public void testRemoveMessage() {
        System.out.println("removeMessage");
        SearchHit[] sh = instance.searchByAuthor("Omri", 0, 1);
        MessageInterface retMsg = sh[0].getMessage();
        instance.removeMessage(retMsg);
        sh = instance.searchByAuthor("Omri", 0, 1);
        assertEquals(0, sh.length);
        sh = instance.searchByAuthor("Nir", 0, 1);
        assertEquals(0, sh.length);

        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of searchByAuthor method, of class CompassSearchHandler.
     */
    @Test
    public void testSearchByAuthor() {
        System.out.println("searchByAuthor");
        String username = "Tal";
        int from = 0;
        int to = 1;
        SearchHit[] result = instance.searchByAuthor(username, from, to);
        MessageInterface retMsg = result[0].getMessage();
        assertEquals(111, retMsg.getIndex());
        username = "Arseny";
        from = 0; to =  2 ;
        result = instance.searchByAuthor(username, from, to);
        assertEquals(1, result.length);


    }

    /**
     * Test of searchByContent method, of class CompassSearchHandler.
     */
    @Test
    public void testSearchByContent() {
        System.out.println("searchByContent");
        Date tDate = new Date();
        Message msg = new Message(new MessageData("Alex", "Black Mirror 2", "Angelina also catches the eye of Darren’s despotic, unpopular boss", tDate, tDate,7));
        instance.addMessage(msg);
        String phrase = "also";
        int from = 0;
        int to = 1;
        SearchHit[] result = instance.searchByContent(phrase, from, to);
        MessageInterface retMsg = result[0].getMessage();
        assertEquals(7, retMsg.getIndex());

         phrase = "also";
         from = 0;
         to = 1;
        result = instance.searchByContent(phrase, from, to);
         retMsg = result[0].getMessage();
        assertEquals(7, retMsg.getIndex());
  
        
    }

}