/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.PersistentLayer;

import Forum.DomainLayer.Forum;
import java.math.BigInteger;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
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
public class XMLFileHandlerTest {

    public XMLFileHandlerTest() {
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
     * Test of ReadFromXML method, of class XMLFileHandler.
     */
    @Test
    public void testReadFromXML() {
        System.out.println("ReadFromXML");
        XMLFileHandler instance = new XMLFileHandler("tapuachforum.xml");
        ForumType result = instance.ReadFromXML();
        assertNotNull(result);
    }

    /**
     * Test of WriteToXML method, of class XMLFileHandler.
     */
    @Test
    public void testWriteToXML() {
        try {
            System.out.println("WriteToXML");
            XMLFileHandler instance = new XMLFileHandler("tapuachforum.xml");
            ForumType f = instance.ReadFromXML();
            ObjectFactory factory = new ObjectFactory();
            MemberType m1 = factory.createMemberType();
            m1.setUserName("nir");
            m1.setNickName("arsenik");
            m1.setPassword("123456");
            m1.setFirstName("a");
            m1.setLastName("k");
            m1.setEMail("a@a.com");
            GregorianCalendar gcal = new GregorianCalendar();
            XMLGregorianCalendar xgcal;
            xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
            m1.setDateJoined(xgcal);
            m1.setDateOfBirth(xgcal);
            MessageType e = factory.createMessageType();
            e.setParentId(BigInteger.valueOf(0));
            e.setMessageId(BigInteger.valueOf(1));
            e.setCreatedBy("nir");
            e.setSubject("hello potatoheads..");
            e.setBody("hello everyone...");
            e.setDateAdded(xgcal);
            e.setModifiedDate(xgcal);
            f.getMembers().add(m1);
            instance.WriteToXML();
            assertTrue(true);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(XMLFileHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

}