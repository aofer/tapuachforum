/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer;

//import Forum.PersistentLayer.Data.MemberData;
import Forum.PersistentLayer.ForumHandler;
//import Forum.PersistentLayer.Interfaces.XMLMemberInterface;
import Forum.PersistentLayer.XMLFileHandler;
import Forum.PersistentLayer.XMLMemberHandler;
import Forum.PersistentLayer.XMLMessageHandler;
//import com.sun.xml.internal.ws.encoding.xml.XMLMessage;
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
public class UserTest {

    public UserTest() {
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
     * Test of readMessage method, of class User.
     */
    @Test
    public void testReadMessage() throws Exception {
        System.out.println("readMessage");
            XMLFileHandler xf = new XMLFileHandler("tapuachforum.xml");
        ForumHandler fH = new ForumHandler(xf);
       XMLMemberHandler memH = new XMLMemberHandler(xf);
       Forum  instanceForum = Forum.getInstance();
        XMLMessageHandler mseH = new XMLMessageHandler(xf);
        instanceForum.setDBHandlers(mseH, fH, memH);

        int messageId = 1;
        User instance = new Guest();
        String expResult = "Subject:CHang;ei";
        String result = instance.readMessage(messageId);
   //     System.out.println("****"+ expResult+ "****" +result.substring(1, 17)+"****");
        assertEquals(expResult , result.substring(13, 29));
     }

}