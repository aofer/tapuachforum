/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forum.PersistentLayer;

import Forum.Exceptions.MessageNotFoundException;
import Forum.PersistentLayer.Data.MessageData;
import Forum.PersistentLayer.Interfaces.MessageInterface;
import java.util.Date;

/**
 *
 * @author Arseny
 */
public class XMLMessageHandler implements MessageInterface {

    private XMLFileHandler xf;

    public XMLMessageHandler(XMLFileHandler xf) {
        this.xf = xf;
    }

    public MessageData getMessage(int messageID)
    {
           for(MessageType m : this.xf.getForum().getMessages()){
                if(m.getMessageId().intValue() == messageID){
                    String nick=m.getCreatedBy();
                    String sub=m.getSubject();
                    String body = m.getBody();
                    Date created=m.getDateAdded().toGregorianCalendar().getTime();
                    Date modified =m.getModifiedDate().toGregorianCalendar().getTime();

                    return new MessageData(nick, sub, body, created, modified);
                }
            }
           return null;
    }
}
