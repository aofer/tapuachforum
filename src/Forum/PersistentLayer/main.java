/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.PersistentLayer;

/**
 *
 * @author Arseny
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import java.util.GregorianCalendar;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileInputStream in = null;
		FileOutputStream out = null;

		try {

			JAXBContext jc = JAXBContext.newInstance("Forum.PersistentLayer");
			Unmarshaller u = jc.createUnmarshaller();

			in = new FileInputStream("tapuachforum.xml");

			// Obtain the data from the XML file.
	Forum f= (Forum)u.unmarshal(in);
			in.close();

			System.out.println(f.getForumName());
			

                        // Create a factory.
			ObjectFactory factory = new ObjectFactory();

			// Create a new member
			MemberType  m1 = factory.createMemberType();
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

                        
                        f.getMembers().add(m1);

			Marshaller m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			// Write all the data back to the XML file.
			out = new FileOutputStream("tapuachforum.xml");
			m.marshal(f,out);
			out.close();
			
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                catch (DatatypeConfigurationException ex) {
               //todo
            }
		finally {
			System.exit(0);
		}
	}

}
