/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.TCPCommunicationLayer;

import Forum.DomainLayer.Interfaces.MessageInterface;
import Forum.DomainLayer.Message;
import Forum.PersistentLayer.Data.MessageData;
import java.util.Vector;
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
public class MessagesParserTest {

    public MessagesParserTest() {
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
     * Test of Encode method, of class MessagesParser.
     */
    @Test
    public void testEncode() {
        System.out.println("Encode");
        MessageInterface msg1 = new Message(new MessageData("arseny", "", "what the fuck", null, null), null);
        MessagesParser instance = new MessagesParser();
        
        String result = instance.Encode(msg1);

        Vector<Message> rmsg1 = instance.Decode(result);

        assertEquals(msg1, rmsg1.firstElement());

        Message msg2 = new Message(new MessageData("amit", "blah blah", "hello friends", null, null), null);
        Message msg3 = new Message(new MessageData("liron", "ha ha ha", "she said ha ha..", null, null), null);
        msg1.addReply( msg3);

        result = instance.Encode(msg1);
        Vector<Message> rmsg2 = instance.Decode(result);
        assertEquals(msg1,rmsg2.firstElement());


        msg1.getReplies().firstElement().addReply(msg2);
        msg1.getReplies().firstElement().getReplies().firstElement().addReply(msg3);

        result = instance.Encode(msg1) ;
        rmsg2 = instance.Decode(result);
        assertEquals(msg1,rmsg2.firstElement());





      
        
    }


}