/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forum.PersistentLayer;

import Forum.PersistentLayer.Data.MemberData;
import Forum.PersistentLayer.Interfaces.XMLMemberInterface;
import Forum.PersistentLayer.Interfaces.eMemberType;
import java.util.Date;
//import javax.swing.text.StyledEditorKit.BoldAction;
//import sun.font.CreatedFontTracker;

/**
 *
 * @author Nir
 */
public class XMLMemberHandler implements XMLMemberInterface {

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

    public eMemberType getMemberType(String userName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}


