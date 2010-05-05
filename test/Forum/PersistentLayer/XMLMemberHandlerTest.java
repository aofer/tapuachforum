/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.PersistentLayer;

import Forum.PersistentLayer.Data.MemberData;
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
public class XMLMemberHandlerTest {

    public XMLMemberHandlerTest() {
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
     * Test of giveF method, of class XMLMemberHandler.
     */


    /**
     * Test of getMember method, of class XMLMemberHandler.
     */
    @Test
    public void testGetMember() {
        System.out.println("getMember");
        String userName = "userToCheckLogInandLogOut";
        XMLMemberHandler instance = new XMLMemberHandler(xf);
        String expResult = "nowOut";
        MemberData result = instance.getMember(userName);
        assertEquals(expResult, result.getNickName());
           expResult = "not good name";
      
        assertNotSame(expResult, result.getNickName());
    }

}