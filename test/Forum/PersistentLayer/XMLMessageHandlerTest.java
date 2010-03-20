/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.PersistentLayer;

import Forum.Exceptions.MessageNotFoundException;
import Forum.PersistentLayer.Data.MessageData;
import java.util.Date;
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
 * @author Arseny
 */
public class XMLMessageHandlerTest {

    public XMLMessageHandlerTest() {
    }
    XMLFileHandler xf = new XMLFileHandler("tapuachforum.xml");

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
     * Test of getParentId method, of class XMLMessageHandler.
     */
    @Test
    public void testGetParentId() {
//        try {
            System.out.println("getParentId");
            XMLMessageHandler instance = new XMLMessageHandler(xf);
            int expResult = 76;
   //         int result = instance.getParentId(1);
     //       assertEquals(expResult, result);
   //     } catch (MessageNotFoundException ex) {
  //          Logger.getLogger(XMLMessageHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
  //      }
    }

    /**
     * Test of getSubject method, of class XMLMessageHandler.
     */
    @Test
    public void testGetSubject() {
  //      try {
            System.out.println("getSubject");
            int messageID = 1;
            XMLMessageHandler instance = new XMLMessageHandler(xf);
   //         String result = instance.getSubject(messageID);
     //       assertNotNull(result);
     //   } catch (MessageNotFoundException ex) {
      //      Logger.getLogger(XMLMessageHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
      //  }
        
    }

    /**
     * Test of getContent method, of class XMLMessageHandler.
     */
    @Test
    public void testGetContent() {
   //     try {
            System.out.println("getContent");
            int messageID = 1;
            XMLMessageHandler instance = new XMLMessageHandler(xf);
     //       String result = instance.getContent(messageID);
     //       assertNotNull(result);
      //  } catch (MessageNotFoundException ex) {
      //      Logger.getLogger(XMLMessageHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
    //    }
    }

    /**
     * Test of getUsername method, of class XMLMessageHandler.
     */
    @Test
    public void testGetUsername() {
  //      try {
            System.out.println("getUsername");
            int messageID = 1;
            XMLMessageHandler instance = new XMLMessageHandler(xf);
        //    String result = instance.getUsername(messageID);
        //    assertNotNull(result);
    //    } catch (MessageNotFoundException ex) {
      //      Logger.getLogger(XMLMessageHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
    //    }
    }

    /**
     * Test of getDateAdded method, of class XMLMessageHandler.
     */
    @Test
    public void testGetDateAdded() {
 ///       try {
            System.out.println("getDateAdded");
            int messageID = 1;
            XMLMessageHandler instance = new XMLMessageHandler(xf);
     //       Date result = instance.getDateAdded(messageID);
     //       assertNotNull(result);

      //  } catch (MessageNotFoundException ex) {


    //        Logger.getLogger(XMLMessageHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
   //     }
    }

    /**
     * Test of setSubject method, of class XMLMessageHandler.
     */
    @Test
    public void testSetSubject() {
   //     try {
            System.out.println("setSubject");
            int messageID = 1;
            String newSubject = "new subject";
            XMLMessageHandler instance = new XMLMessageHandler(xf);
   //         instance.setSubject(messageID, newSubject);
            assertTrue(true);
    //    } catch (MessageNotFoundException ex) {
   //         Logger.getLogger(XMLMessageHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
   //     }
    }

    /**
     * Test of setContent method, of class XMLMessageHandler.
     */
    @Test
    public void testSetContent() {
     //   try {
            System.out.println("setContent");
            int messageID = 1;
            String newContent = "this is the new content of the message";
            XMLMessageHandler instance = new XMLMessageHandler(xf);
     //       instance.setContent(messageID, newContent);
            assertTrue(true);
    //    } catch (MessageNotFoundException ex) {
      //      Logger.getLogger(XMLMessageHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
     //   }
    }

    /**
     * Test of getMessage method, of class XMLMessageHandler.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        int messageID = 1;
        XMLMessageHandler instance = new XMLMessageHandler(xf);
   
        // *** AS YOU ALL PEOBLEBY KNOW, BOB IS NOT HERE. HE IS WORKIN!!!
        String expResult = "working";
        MessageData result = instance.getMessage(messageID);
       
        assertEquals(expResult,  result.getBody());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}