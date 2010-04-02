/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.TCPCommunicationLayer;

import Forum.DomainLayer.Forum;
import Forum.Exceptions.MessageNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amit
 */
public class DeleteMessageMessage extends ClientMessage{
    
    private long m_messageId;

    public DeleteMessageMessage(long messageId){
        this.m_messageId = messageId;
    }


    public ServerResponse doOperation(Forum forum) {
        ServerResponse tResponse;
        try {
            Forum.getInstance().deleteMessage((int) m_messageId);
            String tAns = "Message was deleted successfully.";
            tResponse = new ServerResponse(tAns, true);
        } catch (MessageNotFoundException ex) {
            //Logger.getLogger(DeleteMessageMessage.class.getName()).log(Level.SEVERE, null, ex);
            tResponse = new ServerResponse("Message does not exist.", false);
        }
        return tResponse;
    }
}
