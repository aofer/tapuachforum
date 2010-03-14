/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.PersistentLayer;

import Forum.Exceptions.MessageNotFoundException;
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
    
    
    
    public int getParentId(int messageID) throws MessageNotFoundException {
        for(MessageType m : this.xf.getForum().getMessages()){
            if(m.getMessageId().intValue() == messageID){
                return m.getParentId().intValue();
            }
        }
      MessageNotFoundException  e = new MessageNotFoundException("message not exists");
        throw e;

    }

    public String getSubject(int messageID) throws MessageNotFoundException {
        for(MessageType m : this.xf.getForum().getMessages()){
            if(m.getMessageId().intValue() == messageID){
                return m.getSubject();
            }
        }
        
      MessageNotFoundException  e = new MessageNotFoundException("message not exists");
        throw e;
    }

    public String getContent(int messageID) throws MessageNotFoundException {
       for(MessageType m : this.xf.getForum().getMessages()){
            if(m.getMessageId().intValue() == messageID){
                return m.getBody();
            }
        }

      MessageNotFoundException  e = new MessageNotFoundException("message not exists");
        throw e;
    }

    public String getUsername(int messageID) throws MessageNotFoundException {
       for(MessageType m : this.xf.getForum().getMessages()){
            if(m.getMessageId().intValue() == messageID){
                return m.getCreatedBy();
            }
        }

      MessageNotFoundException  e = new MessageNotFoundException("message not exists");
        throw e;
    }

    public Date getDateAdded(int messageID) throws MessageNotFoundException {
        for(MessageType m : this.xf.getForum().getMessages()){
            if(m.getMessageId().intValue() == messageID){
                return m.getDateAdded().toGregorianCalendar().getTime();
            }
        }

      MessageNotFoundException  e = new MessageNotFoundException("message not exists");
        throw e;
    }

    public void setSubject(int messageID, String newSubject) throws MessageNotFoundException {
        for(MessageType m : this.xf.getForum().getMessages()){
            if(m.getMessageId().intValue() == messageID){
                m.setSubject(newSubject);
            }
        }

      MessageNotFoundException  e = new MessageNotFoundException("message not exists, can't edit");
        throw e;
    }

    public void setContent(int messageID, String newContent) throws MessageNotFoundException {
         for(MessageType m : this.xf.getForum().getMessages()){
            if(m.getMessageId().intValue() == messageID){
                m.setBody(newContent);
            }
        }

      MessageNotFoundException  e = new MessageNotFoundException("message not exists, can't edit");
        throw e;
    }

}
