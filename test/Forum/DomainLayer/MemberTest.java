/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer;

import java.util.Date;
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
public class MemberTest {

    public MemberTest() {
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
     * Test of logOut method, of class Member.
     */
    @Test
    public void testLogOut() {
        System.out.println("logOut");
        Forum tForum = new Forum(null,null,null);
        Member instance = new Member(tForum,"liron", "blah","87654321", "liron", "katav",null,null);
        tForum.addMember(instance);
        instance.logOut();
        assertTrue(tForum.getOnlineMembers().size() == 0);
    }
   
}