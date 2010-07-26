/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forum.TCPCommunicationLayer;

import Forum.DomainLayer.Interfaces.MessageInterface;
import Forum.DomainLayer.Message;
import Forum.PersistentLayer.Data.MessageData;
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
    public void testEncode1() {
        MessageInterface msg1 = new Message(new MessageData("arseny", "", "what the fuck", new Date(), new Date()));
        String result = MessagesParser.Encode(msg1);
        Vector<Message> rmsg1 = MessagesParser.Decode(result);
        Message msgFromStr = rmsg1.firstElement();
        assertEquals(msg1.getIndex(), msgFromStr.getIndex());
        assertEquals(msg1.getBody(), msgFromStr.getBody());
    }

    @Test
    public void testEncode2() {
        Message msg1 = new Message(new MessageData("arseny", "", "what the fuck", new Date(), new Date()));
        Message msg2 = new Message(new MessageData("amit", "blah blah", "hello friends", new Date(), new Date()));
        Message msg3 = new Message(new MessageData("liron3", "ha ha ha", "she said ha ha..", new Date(), new Date()));
        Message msg4 = new Message(new MessageData("liron4", "haa", "1234", new Date(), new Date()));
        Message msg5 = new Message(new MessageData("liron5", "hhha", "dkfndf", new Date(), new Date()));
        Message msg6 = new Message(new MessageData("liron6", "ROFL", "felknfwe", new Date(), new Date()));
        Message msg7 = new Message(new MessageData("liron7", "volcano", "Eyjafjallajökull", new Date(), new Date()));
        Message msg8 = new Message(new MessageData("liron8", "ROFL", "felknfwe", new Date(), new Date()));
        
        msg5.addReply(msg7);
        msg4.addReply(msg5);
        msg4.addReply(msg6);
        msg3.addReply(msg4);
        msg1.addReply(msg2);
        msg1.addReply(msg3);
        msg1.addReply(msg8);

        String result = MessagesParser.Encode(msg1);
        Vector<Message> rmsg1 = MessagesParser.Decode(result);
        Message msgFromStr = rmsg1.firstElement();//1
        assertEquals("arseny", msgFromStr.getNickname());

        Message msgFromStr1 = msgFromStr.getReplies().get(0);//2
        assertEquals(msg2.getNickname(), msgFromStr1.getNickname());

        msgFromStr1 = msgFromStr.getReplies().get(2);//8
        assertEquals(msg8.getNickname(), msgFromStr1.getNickname());

        msgFromStr1 = msgFromStr.getReplies().get(1);//3
        assertEquals(msg3.getNickname(), msgFromStr1.getNickname());

        msgFromStr = msgFromStr1.getReplies().get(0);//4
        assertEquals(msg4.getNickname(), msgFromStr.getNickname());

        msgFromStr1 = msgFromStr.getReplies().get(1);//6
        assertEquals(msg6.getNickname(), msgFromStr1.getNickname());

        msgFromStr1 = msgFromStr.getReplies().get(0);//5
        assertEquals(msg5.getNickname(), msgFromStr1.getNickname());

        msgFromStr1 = msgFromStr1.getReplies().get(0);//7
        assertEquals(msg7.getNickname(), msgFromStr1.getNickname());


    }
}
