/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.PersistentLayer;

import Forum.PersistentLayer.Data.MessageData;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author herschho
 */
public class SQLMessageHandlerTest {

    SQLMessageHandler instance = new SQLMessageHandler();

    public SQLMessageHandlerTest() {
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
     * Test of getMessage method, of class XMLMessageHandler.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        int messageID = 1;

        // *** AS YOU ALL PEOBLEBY KNOW, BOB IS NOT HERE. HE IS WORKIN!!!
        String expResult = "working";
        MessageData result = instance.getMessage(messageID);

        assertEquals(expResult,  result.getBody());

    }

    /**
     * Test of getRepliesIds method, of class XMLMessageHandler.
     */
    @Test
    public void testGetRepliesIds() {
        System.out.println("getRepliesIds");
        int messageID = 1;

        List expResult = null;
        List <Integer>result = instance.getRepliesIds(messageID);
        for (int i = 0; i<result.size();i++)
          System.out.println(result.get(i).intValue());
        assertNotNull(result);

    }

   

}