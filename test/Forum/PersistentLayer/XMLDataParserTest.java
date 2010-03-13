/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.PersistentLayer;

import java.util.List;
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
public class XMLDataParserTest {

    public XMLDataParserTest() {
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
     * Test of addMember method, of class XMLDataParser.
     */
    @Test
    public void testAddMember() {
        System.out.println("addMember");
        MemberType m = null;
        XMLDataParser instance = null;
        instance.addMember(m);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMessage method, of class XMLDataParser.
     */
    @Test
    public void testAddMessage() {
        System.out.println("addMessage");
        MessageType m = null;
        XMLDataParser instance = null;
        instance.addMessage(m);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMember method, of class XMLDataParser.
     */
    @Test
    public void testGetMember() {
        System.out.println("getMember");
        String nick = "";
        XMLDataParser instance = null;
        MemberType expResult = null;
        MemberType result = instance.getMember(nick);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMembers method, of class XMLDataParser.
     */
    @Test
    public void testGetMembers() {
        System.out.println("getMembers");
        XMLDataParser instance = null;
        List expResult = null;
        List result = instance.getMembers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessage method, of class XMLDataParser.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        int id = 0;
        XMLDataParser instance = null;
        MessageType expResult = null;
        MessageType result = instance.getMessage(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParentMessages method, of class XMLDataParser.
     */
    @Test
    public void testGetParentMessages() {
        System.out.println("getParentMessages");
        XMLDataParser instance = null;
        List expResult = null;
        List result = instance.getParentMessages();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getChildren method, of class XMLDataParser.
     */
    @Test
    public void testGetChildren() {
        System.out.println("getChildren");
        int id = 0;
        XMLDataParser instance = null;
        List expResult = null;
        List result = instance.getChildren(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ReadFromXML method, of class XMLDataParser.
     */
    @Test
    public void testReadFromXML() {
        System.out.println("ReadFromXML");
        XMLDataParser instance = new XMLDataParser("tapuachforum.xml");
        Forum result = instance.ReadFromXML();
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail
    }

    /**
     * Test of WriteToXML method, of class XMLDataParser.
     */
    @Test
    public void testWriteToXML() {
        System.out.println("WriteToXML");
        Forum f = null;
        XMLDataParser instance = null;
        instance.WriteToXML(f);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}