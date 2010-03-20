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

     private MessageType findMessage(int messageID) {
                MessageType tryMesaage = null;
                 for (MessageType m : this.xf.getForum().getMessages()) {
                       tryMesaage  =  findMessageRec(messageID, m);
                       if (tryMesaage != null)
                           return tryMesaage;
                 }

                 return null;
        }

     // recursivis function to find Messeage;
        private MessageType findMessageRec(int messageID, MessageType messageAba) {
                 if(messageAba.getMessageId().intValue() == messageID)
                return messageAba;
                 else{
                MessageType tryMesaage = null;
                for (MessageType m : messageAba.getMessage()) {
                  tryMesaage =  findMessageRec(messageID, m);
                  if (tryMesaage != null)
                      return tryMesaage;
                }
                 }
             return null;
            }

    public MessageData getMessage(int messageID)    {
      MessageType m = findMessage(messageID);
      if  (m != null) {
      //  for(MessageType m : this.xf.getForum().getMessages()){
    //            if(m.getMessageId().intValue() == messageID){
                    String nick=m.getCreatedBy();
                    String sub=m.getSubject();
                    String body = m.getBody();
                    Date created=m.getDateAdded().toGregorianCalendar().getTime();
                    Date modified =m.getModifiedDate().toGregorianCalendar().getTime();

                    return new MessageData(nick, sub, body, created, modified);
   //             }
            }
           return null;
    }
}
//change XMLMemberHandler to do recursic searsh all over the hirracic tree of messages.