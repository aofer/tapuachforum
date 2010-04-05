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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class SearchDataTest {

    public SearchDataTest() {
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
   //    Forum instance = new Forum(msgH,fH,memH);

        Forum  fInstance = Forum.getInstance();


    /**
     * Test of addMessage method, of class SearchData.
     */

    @Test
    public void testAddMessage() {
        System.out.println("addMessage");
        SearchData instance = new SearchData();
        int messageIndex;
             Date tDate = new Date();
       messageIndex = fH.addMessage(0, "TestAdd", "i just love aly and fila", "their3 latest  kk future sound of egypt is great ", tDate, tDate);
            MessageInterface msg1 = new Message(new MessageData("TestAdd", "i just love aly and fila", "their3 latest  kk future sound of egypt is great ", tDate, tDate, messageIndex));
      assertTrue (instance.getByAuthor("TestAdd") == null);
            instance.addMessage(msg1);
      assertTrue (instance.getByAuthor("TestAdd") != null);
    }

    /**
     * Test of removeMessage method, of class SearchData.
     */
    @Test
    public void testRemoveMessage() {
        System.out.println("removeMessage");
        SearchData instance = new SearchData();
             Date tDate = new Date();

             MessageInterface msg1 = new Message(new MessageData("TestRem", "i just love aly and fila", "their3 latest  kk future sound of egypt is great ", tDate, tDate));
          instance.addMessage(msg1);
       //     assertTrue (instance.getByAuthor("TestRem").size() == 1);
              System.out.println("removeMessage2");
      instance.removeMessage(msg1);
     //  assertTrue (instance.getByAuthor("TestRem").size() == 0);
   //   TODO
    }

    /**
     * Test of getByContent method, of class SearchData.
     */
    @Test
    public void testGetByContent() {
            System.out.println("getByContent");
            fH.initForum();
            SearchData instance = new SearchData();
            Date tDate = new Date();
            int messageIndex;
            messageIndex = fH.addMessage(0, "Arseny", "i just love aly and fila", "their3 latest future sound of egypt is great ", tDate, tDate);
             MessageInterface msg1 = new Message(new MessageData("Arseny", "i just love aly and fila", "their3 latest  kk future sound of egypt is great ", tDate, tDate,messageIndex));
             messageIndex =fH.addMessage(0, "Amit", "whto cares about armin", "gareth3 emery is much better.. armin is so commercial now ", tDate, tDate);
             MessageInterface msg2 = new Message(new MessageData("Amit", "who cares about armin", "gareth3 emery kk  is muchONE better.. armin is so commercial now ", tDate, tDate,messageIndex));
             messageIndex =fH.addMessage(0, "Amitt", "whto cares about armin", "garetht3 emery is much better.. armin is so commercial now ", tDate, tDate);
            MessageInterface msg3 = new Message(new MessageData("Amitt", "wtho cares about armin", "garetht3  kk emery is much better.. armin is so commercial now ", tDate, tDate,messageIndex));
            instance.addMessage(msg1);
            instance.addMessage(msg2);
            instance.addMessage(msg3);
            String str = "muchONE";
            List<Integer> result = instance.getByContent(str);
            if (result != null) {
                for (int i = 0; i < result.size(); i++) {
                    System.out.println(result.get(i).intValue());
                }
            }
            if (result != null) {
                assertTrue(result.size() == 1);
            }
            str = "kk";
            result = instance.getByContent(str);
            if (result != null) {
                for (int i = 0; i < result.size(); i++) {
                    System.out.println(result.get(i).intValue());
                }
            }
            if (result != null) {
                assertTrue(result.size() == 3);
            }
    }
        /**
         * Test of getByAuthor method, of class SearchData.
         */
          @Test
        public void testGetByAuthor() {
        System.out.println("getByAuthor");
            SearchData instance = new SearchData();
            Date tDate = new Date();
           int messageIndex;
          messageIndex = fH.addMessage(0, "Arseny", "i just love aly and fila", "their3 latest  kk future sound of egypt is great ", tDate, tDate);
                 MessageInterface msg1 = new Message(new MessageData("Arseny", "i just love aly and fila", "their3 latest  kk future sound of egypt is great ", tDate, tDate,messageIndex));
          messageIndex = fH.addMessage(0, "Amit", "who cares about armin", "gareth3 emery kk  is muchONE better.. armin is so commercial now ", tDate, tDate);
            MessageInterface msg2 = new Message(new MessageData("Amit", "who cares about armin", "gareth3 emery kk  is muchONE better.. armin is so commercial now ", tDate, tDate,messageIndex));
          messageIndex = fH.addMessage(0, "Amitt", "wtho cares about armin", "garetht3  kk emery is much better.. armin is so commercial now " , tDate, tDate);
            MessageInterface msg3 = new Message(new MessageData("Amitt", "wtho cares about armin", "garetht3  kk emery is much better.. armin is so commercial now ", tDate, tDate,messageIndex));

            instance.addMessage(msg1);
              instance.addMessage(msg2);
              instance.addMessage(msg3);


        String author = "Amit";
       List<Integer> result = instance.getByAuthor(author);
             if (result != null){
            for (int i = 0; i<result.size();i++)
                    System.out.println(result.get(i).intValue());
             }
        if (result != null)
       assertTrue(result.size() == 1 );
        // TODO review the generated test code and remove the default call to fail.
         }
     //   catch (MessageNotFoundException ex) {
   //         Logger.getLogger(SearchDataTest.class.getName()).log(Level.SEVERE, null, ex);
   //    }
  //  }



}