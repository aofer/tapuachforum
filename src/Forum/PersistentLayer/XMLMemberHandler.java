/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forum.PersistentLayer;

import Forum.Exceptions.NoSuchUserException;
import Forum.PersistentLayer.Data.MemberData;
import Forum.PersistentLayer.Interfaces.MemberInterface;
import java.util.Date;
import java.util.GregorianCalendar;
//import javax.swing.text.StyledEditorKit.BoldAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
//import sun.font.CreatedFontTracker;

/**
 *
 * @author Nir
 */
public class XMLMemberHandler implements MemberInterface {

    /**
     *
     * @return
     */
    public ForumType giveF() {
        ObjectFactory factory = new ObjectFactory();
        return (factory.createForumType());
    }
    private XMLFileHandler xf;

    public XMLMemberHandler(XMLFileHandler xf) {
        this.xf = xf;
    }

    public MemberData getMember(String userName)
    {
        for (MemberType m : this.xf.getForum().getMembers()) {
            if (m.getUserName().equals(userName)) {
                Date joined =m.getDateJoined().toGregorianCalendar().getTime();
                Date birth =  m.getDateOfBirth().toGregorianCalendar().getTime();
                return new MemberData(m.getUserName(), m.getNickName(), m.getPassword(),
                       m.getFirstName(), m.getLastName(), m.getEMail(), joined, birth);
            }
        }
        return null;
    }
}


