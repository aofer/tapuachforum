/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forum.DomainLayer.SearchEngine;

import Forum.DomainLayer.Forum;
import Forum.DomainLayer.Interfaces.MessageInterface;
import Forum.DomainLayer.Message;
import Forum.Exceptions.MessageNotFoundException;
import Forum.PersistentLayer.Data.MessageData;
import Forum.PersistentLayer.ForumHandler;
import Forum.PersistentLayer.XMLFileHandler;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.crypto.Data;
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
    XMLFileHandler xf = new XMLFileHandler("testForum.xml");
    ForumHandler fH = new ForumHandler(xf);
    Forum fInstance = Forum.getInstance();

    /**
     * Test of addData method, of class SearchEngineHandler.
     */
    @Test
    public void testAddData() {
        fH.initForum();
        System.out.println("addData");
        int messageIndex;
        SearchEngineHandler instance = new SearchEngineHandler();
        Date tDate = new Date();
        messageIndex = fH.addMessage(0, "Arseny", "i just love aly and fila", "their latest future sound of egypt is great ", tDate, tDate);
        MessageInterface msg1 = new Message(new MessageData("Arseny", "i just love aly and fila", "their latest future sound of egypt is great ", tDate, tDate, messageIndex));
        messageIndex = fH.addMessage(0, "Amit", "who cares about armin", "gareth emery is much better.. armin is so commercial now ", tDate, tDate);
        MessageInterface msg2 = new Message(new MessageData("Amit", "who cares about armin", "gareth emery is much better.. armin is so commercial now ", tDate, tDate, messageIndex));
        instance.addMessage(msg1);
        instance.addMessage(msg2);
        assertTrue(true);

    }

    /**
     * Test of searchByAuthor method, of class SearchEngineHandler.
     */
    @Test
    public void testSearchByAuthor() {
        System.out.println("searchByAuthor");
        String username = "Arseny2";
        int from = 0;
        int to = 1;
        int messageIndex;
        SearchEngineHandler instance = new SearchEngineHandler();
        Date tDate = new Date();
        messageIndex = fH.addMessage(0, "Arseny2", "i just love aly and fila", "their latest future sound of egypt is great ", tDate, tDate);
        MessageInterface msg1 = new Message(new MessageData("Arseny2", "i just love aly and fila", "their latest future sound of egypt is great ", tDate, tDate, messageIndex));
        messageIndex = fH.addMessage(0, "Amit", "who cares about armin", "gareth emery is much better.. armin is so commercial now ", tDate, tDate);
        MessageInterface msg2 = new Message(new MessageData("Amit", "who cares about armin", "gareth emery is much better.. armin is so commercial now ", tDate, tDate, messageIndex));
        instance.addMessage(msg1);
        instance.addMessage(msg2);

        SearchHit[] result = instance.searchByAuthor(username, from, to);
        System.out.println("hey");
        assertTrue(result.length == 1);
        messageIndex = fH.addMessage(0, "Arseny2", "i just love aly and fila", "their latest future sound of egypt is great ", tDate, tDate);
        msg1 = new Message(new MessageData("Arseny2", "i just love aly and fila", "their latest future sound of egypt is great ", tDate, tDate, messageIndex));
        instance.addMessage(msg1);
        messageIndex = fH.addMessage(0, "Arseny2", "i just love aly and fila", "their latest future sound of egypt is great ", tDate, tDate);
        msg1 = new Message(new MessageData("Arseny2", "i just love aly and fila", "their latest future sound of egypt is great ", tDate, tDate, messageIndex));
        instance.addMessage(msg1);
        result = instance.searchByAuthor(username, from, 3);
        assertEquals(result.length, 3);

        messageIndex = fH.addMessage(0, "Arseny2", "i just love aly and fila", "their latest future sound of egypt is great ", tDate, tDate);
        msg1 = new Message(new MessageData("Arseny2", "i just love aly and fila", "their latest future sound of egypt is great ", tDate, tDate, messageIndex));
        instance.addMessage(msg1);
        result = instance.searchByAuthor(username, from, 4);
        assertEquals(result.length, 4);



    }

    /**
     * Test of searchByContent method, of class SearchEngineHandler.
     */
    @Test
    public void testSearchByContent() {
        System.out.println("searchByContent");
        String phrase = "emmmmery emmjmmery";
        int from = 0;
        int to = 2;
        int messageIndex;
        SearchEngineHandler instance = new SearchEngineHandler();
        Date tDate = new Date();
        messageIndex = fH.addMessage(0, "Arseny3", "i just love aly and fila", "their latest future emmmmery sound of egypt is great ", tDate, tDate);
        MessageInterface msg1 = new Message(new MessageData("Arseny3", "i just love aly and fila", "their latest future emmmmery sound of egypt is great ", tDate, tDate, messageIndex));
        messageIndex = fH.addMessage(0, "Amit3", "who cares  armin", "gareth emmjmmery is much better.. armin is so commercial now ", tDate, tDate);
        MessageInterface msg2 = new Message(new MessageData("Amit", "who cares about armin", "gareth emmjmmery is much better.. armin is so commercial now ", tDate, tDate, messageIndex));
        instance.addMessage(msg1);
        instance.addMessage(msg2);

        SearchHit[] result = instance.searchByContent(phrase, from, to);
        System.out.println(result[0].getMessage());
        System.out.println(result[1].getMessage());
        assertEquals(result.length, 2);
        //       result = instance.searchByContent("aboutXttt", from, to);
        //           assertEquals(result.length , 0);



    }

    /**
     * Test of RemoveMessage method, of class SearchEngineHandler.
     */
    @Test
    public void testRemoveMessage() {
        System.out.println("RemoveMessage");
        SearchEngineHandler instance = new SearchEngineHandler();
        int messageIndex;
        Date tDate = new Date();
        messageIndex = fH.addMessage(0, "REMMM", "i just love aly and fila", "their latest future emmmmery sound of egypt is great ", tDate, tDate);
        MessageInterface msg1 = new Message(new MessageData("REMMM", "i just love aly and fila", "their latest future emmmmery sound of egypt is great ", tDate, tDate, messageIndex));
        instance.addMessage(msg1);
        SearchHit[] result = instance.searchByAuthor("REMMM", 0, 1);
        assertNotSame(result[0], null);
        //  instance.RemoveMessage(msg1);
        instance.removeMessage(msg1);
        result = instance.searchByAuthor("REMMM", 0, 1);
        assertTrue(result.length==0);
    }

    /**
     * test from and to
     * @throws MessageNotFoundException
     */
    @Test
    public void testSearchByAuthor2() throws MessageNotFoundException {
        System.out.println("searchByAuthor2");
        int from = 1;
        int to =3;
        int length=5;
        SearchEngineHandler serach;
        SearchHit[] hits;
        int[] msgs=new int[length];

        serach= new SearchEngineHandler();
        for (int i=0;i<length;i++){
                msgs[i]=Forum.getInstance().addMessage("nick", "sub"+i, "body"+i);
        }
        hits=Forum.getInstance().searchByAuthor("nick", from, to);
        assertEquals(hits[0].getMessage().getBody(),"body1");
        assertEquals(hits[1].getMessage().getBody(),"body2");
        assertEquals(hits[2].getMessage().getBody(),"body3");
         assertTrue(hits.length==3);

        for (int i=0;i<length;i++){
            Forum.getInstance().deleteMessage(msgs[i]);
        }
    }
}


