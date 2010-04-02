/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer;

import Forum.PersistentLayer.Data.MemberData;
import Forum.PersistentLayer.ForumHandler;
import Forum.PersistentLayer.Interfaces.eMemberType;
import Forum.PersistentLayer.XMLFileHandler;
import Forum.PersistentLayer.XMLMemberHandler;
import Forum.PersistentLayer.XMLMessageHandler;
import java.util.Date;
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
public class ModeratorTest {

    public ModeratorTest() {
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


            XMLFileHandler xf = new XMLFileHandler("testForum.xml");
        ForumHandler fH = new ForumHandler(xf);
       XMLMemberHandler memH = new XMLMemberHandler(xf);
       Forum  instanceForum = Forum.getInstance();
        XMLMessageHandler mseH = new XMLMessageHandler(xf);



    /**
     * Test of deleteMessage method, of class Moderator.
     */
    @Test
    public void testDeleteMessage() throws Exception {
          instanceForum.setDBHandlers(mseH, fH, memH);
        System.out.println("deleteMessage");
        int messageId = 1;
        Date tDate = new Date();
             MemberData memD = new MemberData("membUserName", "membNickName", "memiPass","membFirstName","membLastName","memb@agr",tDate);
        Moderator instance = new Moderator(memD);
        fH.initForum();
        fH.addMessage(0, "TheTeser", "It should be delere", "no specital body", tDate);
        instance.deleteMessage(messageId);
        fH.addMessage(0, "TheTeser", "Now the message counter  should be 3 and Message Id 2 !!!", "no specital body", tDate);

        /** there is no ASSERT.
         if you want to see the TEST result, check that in the file
         named "testForum" , the first message is num 2!!!
         **/

     }

    /**
     * Test of getType method, of class Moderator.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
       Date tDate = new Date();
        MemberData memD = new MemberData("membUserName", "membNickName", "memiPass","membFirstName","membLastName","memb@agr",tDate);
        Moderator instance = new Moderator(memD);
        eMemberType expResult = eMemberType.Moderator;
        eMemberType result = instance.getType();
        assertEquals(expResult, result);

    }

}