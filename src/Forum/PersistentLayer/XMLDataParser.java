/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.PersistentLayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Arseny
 */
public class XMLDataParser implements dataParser {

    private ObjectFactory of;
    private JAXBContext jc;
    private String fileName;

    public XMLDataParser(String fileName) {
        this.of = new ObjectFactory();
        try {
            this.jc = JAXBContext.newInstance("Forum.PersistentLayer");
        } catch (JAXBException ex) {
            Logger.getLogger(XMLDataParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.fileName = fileName;
    }



    public void addMember(MemberType m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addMessage(MessageType m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public MemberType getMember(String nick) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<MemberType> getMembers() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public MessageType getMessage(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<MessageType> getParentMessages() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<MessageType> getChildren(int id) throws NoSuchElementException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Forum ReadFromXML(){
        {
            Forum f = null;
            FileInputStream in = null;
            try {
                Unmarshaller u = jc.createUnmarshaller();
                in = new FileInputStream(this.fileName);
                f = (Forum) u.unmarshal(in);
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(XMLDataParser.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JAXBException ex) {
                Logger.getLogger(XMLDataParser.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    in.close();
                } catch (IOException ex) {
                    Logger.getLogger(XMLDataParser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
             return f;
        }

    }

    public void WriteToXML(Forum f){
        
    }

}
