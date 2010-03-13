/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.PersistentLayer;

import java.util.List;
import java.util.NoSuchElementException;

/**
 *
 * @author Arseny
 */
public class XMLDataParser implements dataParser {

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

    public Forum ReadFromXML(String file){
                throw new UnsupportedOperationException("Not supported yet.");

    }

    public void WriteToXML(Forum f){
        
    }

}
