/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.PersistentLayer;

import Forum.PersistentLayer.Data.MemberData;
import Forum.PersistentLayer.Interfaces.eMemberType;
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
public class SQLMemberHandlerTest {
    public   SQLMemberHandler instance= new SQLMemberHandler();


    public SQLMemberHandlerTest() {
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
     * Test of getMember method, of class SQLMemberHandler.
     */
    @Test
    public void testGetMember_0args() {
        System.out.println("getMember");
        List<MemberData> expResult = null;
        List<MemberData> result = instance.getMember();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMember method, of class SQLMemberHandler.
     */
    @Test
    public void testGetMember_String() {
        System.out.println("getMember");
        String userName = "userToCheckLogInandLogOut";
        String expResult = "nowOut";
        MemberData result = instance.getMember(userName);
        assertEquals(expResult, result.getNickName());
           expResult = "not good name";

        assertNotSame(expResult, result.getNickName());
    }

    /**
     * Test of getMemberType method, of class SQLMemberHandler.
     */
    @Test
    public void testGetMemberType() {
        System.out.println("getMemberType");
        String userName = "";
        eMemberType expResult = null;
        eMemberType result = instance.getMemberType(userName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}