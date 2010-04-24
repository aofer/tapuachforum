/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.TCPCommunicationLayer;

import Forum.DomainLayer.Interfaces.MessageInterface;
import Forum.DomainLayer.Message;
import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author Kipi
 */
 public  class MessagesParser {

    public static String Encode(MessageInterface msg){
        String str;
        str = " <message> ";
        str+="id: " + msg.getIndex() + "  user: " + msg.getNickname() ;
        str+= "subject: " +  msg.getSubject() ;
        str+= "body:  " + msg.getBody();

        for (Iterator<Message> it = msg.getReplies().iterator(); it.hasNext();) {
            Message message = it.next();
            str+=Encode(message);
        }
        str+=" </message>";
        return str;
    }
    public static Vector<Message> Decode(String str){
        return null;
    }
}
