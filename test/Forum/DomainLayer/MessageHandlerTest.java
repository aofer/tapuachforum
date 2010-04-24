/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer;


import Forum.PersistentLayer.ForumHandler;
import Forum.PersistentLayer.XMLFileHandler;

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
 * @author Nir
 */
public class MessageHandlerTest {

    public MessageHandlerTest() {
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
     * Test of getMessage method, of class MessageHandler.
     */
                  XMLFileHandler xf = new XMLFileHandler("tapuachforum.xml");
      ForumHandler fH = new ForumHandler(xf);
       XMLMessageHandler mesH = new XMLMessageHandler(xf);
         Date tDate = new Date();
       Forum  instanceForum = Forum.getInstance();
       MessageHandler instance = new MessageHandler(fH,mesH);

    @Test
    public void testGetMessage() throws Exception {
        System.out.println("getMessage");
        int messageId = 1;
        String expResult = "where is bob";
        String result = instance.getMessage(messageId).getSubject();
        assertEquals(expResult, result);
    }

    /**
     * Test of addMessage method, of class MessageHandler.
     */
    @Test
    public void testAddMessage() {
        System.out.println("addMessage");
        String _nickName = "userToCheckLogInandLogOut";
        String subject = "adding mwssage from domain layer";
        String body = "yeapy hi hoo!";
        int sizeFirst =xf.getForum().getMessages().size();
        instance.addMessage(_nickName, subject, body);
         int sizeAfter =xf.getForum().getMessages().size();
         assertTrue(sizeAfter- sizeFirst == 1);

    }

    /**
     * Test of addReply method, of class MessageHandler.
     */
    @Test
    public void testAddReply() throws Exception {
        System.out.println("addReply");
        int parentId = 1;
        String nickname = "userToCheckLogInandLogOut";
        String subject = "replay to where is Bob";
        String body = "Bob is WORKING all DAY!!!";
         int sizeFirst =xf.getForum().getMessages().get(0).getMessage().size();
       instance.addReply(parentId, nickname, subject, body);
      
       int sizeAfter =xf.getForum().getMessages().get(0).getMessage().size();
         assertTrue(sizeAfter- sizeFirst == 1); 
    }

    /**
     * Test of editMessage method, of class MessageHandler.
     */
    @Test
    public void testEditMessage() throws Exception {
        System.out.println("editMessage");
        String nickname = "alex";
        int messageId = 1;
        String subject = "CHang;eing";
        String body = "this ie Edit message";
       instance.editMessage(nickname, messageId, subject, body);
       String newSub = xf.getForum().getMessages().get(0).getSubject();
       assertEquals(newSub, "CHang;eing");
        }

    /**
     * Test of deleteMessage method, of class MessageHandler.
     */
    @Test
    public void testDeleteMessage() throws Exception {
        System.out.println("deleteMessage");
        int messageId = 3;
       int  sizeFirst=  instance.viewForum().size();
      instance.deleteMessage(messageId);
         int sizeAfter = instance.viewForum().size();
         assertTrue(sizeFirst- sizeAfter == 1);
     }

    /**
     * Test of viewForum method, of class MessageHandler.
     */
    @Test
    public void testViewForum() {
        System.out.println("viewForum");

        Vector result = instance.viewForum();
       for(  int i = 0; i < result.size(); i++ )         
        System.out.println(result.elementAt(i).toString());
           System.out.println("end view");
        assertTrue( result.size()>=1);

      }

}