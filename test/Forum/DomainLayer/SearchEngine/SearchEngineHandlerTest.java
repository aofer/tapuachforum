/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer.SearchEngine;

import Forum.DomainLayer.Forum;
import Forum.DomainLayer.Interfaces.MessageInterface;
import Forum.DomainLayer.Message;
import Forum.PersistentLayer.Data.MessageData;
import Forum.PersistentLayer.ForumHandler;
import Forum.PersistentLayer.XMLFileHandler;
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

        Forum  fInstance = Forum.getInstance();



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
         MessageInterface msg1 = new Message(new MessageData("Arseny", "i just love aly and fila", "their latest future sound of egypt is great ", tDate, tDate,messageIndex));
        messageIndex = fH.addMessage(0, "Amit", "who cares about armin", "gareth emery is much better.. armin is so commercial now ", tDate, tDate);
         MessageInterface msg2 = new Message(new MessageData("Amit", "who cares about armin", "gareth emery is much better.. armin is so commercial now ", tDate, tDate, messageIndex));
       instance.addData(msg1);
        instance.addData(msg2);
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
         MessageInterface msg1 = new Message(new MessageData("Arseny2", "i just love aly and fila", "their latest future sound of egypt is great ", tDate, tDate,messageIndex));
        messageIndex = fH.addMessage(0, "Amit", "who cares about armin", "gareth emery is much better.. armin is so commercial now ", tDate, tDate);
         MessageInterface msg2 = new Message(new MessageData("Amit", "who cares about armin", "gareth emery is much better.. armin is so commercial now ", tDate, tDate, messageIndex));
       instance.addData(msg1);
        instance.addData(msg2);

        SearchHit[] result =instance.searchByAuthor(username, from, to);
             System.out.println("hey");
        assertTrue(result.length == 1);
        messageIndex = fH.addMessage(0, "Arseny2", "i just love aly and fila", "their latest future sound of egypt is great ", tDate, tDate);
          msg1 = new Message(new MessageData("Arseny2", "i just love aly and fila", "their latest future sound of egypt is great ", tDate, tDate,messageIndex));
            instance.addData(msg1);
        messageIndex = fH.addMessage(0, "Arseny2", "i just love aly and fila", "their latest future sound of egypt is great ", tDate, tDate);
          msg1 = new Message(new MessageData("Arseny2", "i just love aly and fila", "their latest future sound of egypt is great ", tDate, tDate,messageIndex));
            instance.addData(msg1);
            result =instance.searchByAuthor(username, from, 3);
        assertEquals(result.length , 3);

            messageIndex = fH.addMessage(0, "Arseny2", "i just love aly and fila", "their latest future sound of egypt is great ", tDate, tDate);
          msg1 = new Message(new MessageData("Arseny2", "i just love aly and fila", "their latest future sound of egypt is great ", tDate, tDate,messageIndex));
           instance.addData(msg1);
                 result =instance.searchByAuthor(username, from, 4);
        assertEquals(result.length , 4);



    }

    /**
     * Test of searchByContent method, of class SearchEngineHandler.
     */
    @Test
    public void testSearchByContent() {
        System.out.println("searchByContent");
        String phrase = "emmmmery";
        int from = 0;
        int to = 1;
              int messageIndex;
           SearchEngineHandler instance = new SearchEngineHandler();
           Date tDate = new Date();
       messageIndex = fH.addMessage(0, "Arseny3", "i just love aly and fila", "their latest future emmmmery sound of egypt is great ", tDate, tDate);
         MessageInterface msg1 = new Message(new MessageData("Arseny3", "i just love aly and fila", "their latest future emmmmery sound of egypt is great ", tDate, tDate,messageIndex));
        messageIndex = fH.addMessage(0, "Amit3", "who cares  armin", "gareth emmjmmery is much better.. armin is so commercial now ", tDate, tDate);
         MessageInterface msg2 = new Message(new MessageData("Amit", "who cares about armin", "gareth emmjmmery is much better.. armin is so commercial now ", tDate, tDate, messageIndex));
       instance.addData(msg1);
        instance.addData(msg2);

        SearchHit[] result = instance.searchByContent(phrase, from, to);
                assertEquals(result.length , 1);
      //       result = instance.searchByContent("aboutXttt", from, to);
     //           assertEquals(result.length , 0);


               
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


