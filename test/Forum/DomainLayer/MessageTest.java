/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer;

import Forum.PersistentLayer.Data.MessageData;
import Forum.PersistentLayer.ForumHandler;
import Forum.PersistentLayer.XMLFileHandler;
import Forum.PersistentLayer.XMLMemberHandler;
import Forum.PersistentLayer.XMLMessageHandler;
import java.util.Date;
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

    
    
       Date tDate  = new Date();


       /**
     * Test of getBody method, of class Message.
     */
    @Test
    public void testGetBody() {
 
        System.out.println("getBody");
        MessageData mesData = new MessageData("mesWriter", "theMesSubject", "the Mes Body", tDate, tDate);
        Message instance = new Message(mesData);
        String expResult = "the Mes Body";
        String result = instance.getBody();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to // fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getNickname method, of class Message.
     */
    @Test
    public void testGetNickname() {
        System.out.println("getNickname");
              MessageData mesData = new MessageData("mesWriter", "theMesSubject", "the Mes Body", tDate, tDate);
        Message instance = new Message(mesData);
        String expResult = "mesWriter";
        String result = instance.getNickname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to // fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getSubject method, of class Message.
     */
    @Test
    public void testGetSubject() {
        System.out.println("getSubject");
             MessageData mesData = new MessageData("mesWriter", "theMesSubject", "the Mes Body", tDate, tDate);
        Message instance = new Message(mesData);
        String expResult = "theMesSubject";
        String result = instance.getSubject();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to // fail.
        // // fail("The test case is a prototype.");
    }

        /**
     * Test of addReply method, of class Message.
     */
    @Test
    public void testAddReply() {
        System.out.println("addReply");
               MessageData mesData = new MessageData("mesWriter", "theMesSubject", "the Mes Body", tDate, tDate);
        Message instance = new Message(mesData);
        MessageData mesData2 = new MessageData("mesWriter2222", "theMesSubject2222", "the Mes Body222222", tDate, tDate);
        Message instance2 = new Message(mesData2);
        int preSize = instance.getReplies().size();
        instance.addReply(instance2);
        assertEquals(instance.getReplies().size(), preSize + 1);
        Message tMessage = instance.getReplies().elementAt(0);
        assertEquals(instance.getReplies().elementAt(0).getSubject(),"theMesSubject2222");
        assertEquals(instance.getReplies().elementAt(0).getBody(),"the Mes Body222222");


    }
    /**
     * Test of getReplies method, of class Message.
     */
    @Test
    public void testGetReplies() {
        System.out.println("getReplies");
                MessageData mesData = new MessageData("mesWriter", "theMesSubject", "the Mes Body", tDate, tDate);
        Message instance = new Message(mesData);
        MessageData mesData2 = new MessageData("mesWriter2222", "theMesSubject2222", "the Mes Body222222", tDate, tDate);
        Message instance2 = new Message(mesData2);
        int preSize = instance.getReplies().size();
         assertNotSame(instance2, this);
       //  assertNotSame(instance.getReplies().elementAt(0).getBody(),"the Mes Body222222");
        instance.addReply(instance2);
        Vector result = instance.getReplies();
       assertEquals(instance.getReplies().elementAt(0).getBody(),"the Mes Body222222");
        // TODO review the generated test code and remove the default call to // // fail.
        // // fail("The test case is a prototype.");
    }

    /**
     * Test of setBody method, of class Message.
     */
    @Test
    public void testSetBody() {
        System.out.println("setBody");
        String body = "new Body";
              MessageData mesData = new MessageData("mesWriter", "theMesSubject", "the Mes Body", tDate, tDate);
        Message instance = new Message(mesData);
        instance.setBody(body);
        assertEquals(instance.getBody(), body);
        // TODO review the generated test code and remove the default call to // // fail.
        // // fail("The test case is a prototype.");
    }

    /**
     * Test of setSubject method, of class Message.
     */
    @Test
    public void testSetSubject() {
        System.out.println("setSubject");
        String subject = "New Subject";
              MessageData mesData = new MessageData("mesWriter", "theMesSubject", "the Mes Body", tDate, tDate);
        Message instance = new Message(mesData);
        instance.setSubject(subject);
         assertEquals(instance.getSubject(), subject);
        // TODO review the generated test code and remove the default call to // // fail.
        // // fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Message.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
               MessageData mesData = new MessageData("mesWriter", "theMesSubject", "the Mes Body", tDate, tDate);
        Message instance = new Message(mesData);
        String expResult = "ubject:theMesSubjec";
        String result = instance.toString();
        assertEquals(expResult, result.substring(2, 21));
        // TODO review the generated test code and remove the default call to // fail.
        // fail("The test case is a prototype.");
    }



}