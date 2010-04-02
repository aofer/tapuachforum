/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forum.DomainLayer;

import Forum.DomainLayer.Interfaces.MessageInterface;
import Forum.Exceptions.MessageNotFoundException;
import Forum.Exceptions.MessageOwnerException;
import Forum.PersistentLayer.Data.MessageData;
import Forum.PersistentLayer.Interfaces.ForumHandlerInterface;
import Forum.PersistentLayer.Interfaces.XMLMessageInterface;
import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Kipi
 */
public class MessageHandler {

    private ForumHandlerInterface _XmlForum;
    private XMLMessageInterface _XmlMessage;

    public MessageHandler(ForumHandlerInterface xmlForum, XMLMessageInterface xmlMessage) {
        this._XmlForum = xmlForum;
        this._XmlMessage = xmlMessage;
    }

    public Message getMessage(int messageId) throws MessageNotFoundException {
        MessageData data = this._XmlMessage.getMessage(messageId);
        Message msg = new Message(data);
        List<Integer> tReplyIds = this._XmlMessage.getRepliesIds(messageId);
        for (int i = 0;i<tReplyIds.size();i++){
            Message  tReply = getMessage(tReplyIds.get(i).intValue());
            msg.addReply(tReply);
        }

        return msg;
    }

    public void addMessage(String _nickName, String subject, String body) {
        Date tDate = new Date();
        this._XmlForum.addMessage(0, _nickName, subject, body, tDate, tDate);
    }

    public void addReply(int parentId, String nickname, String subject, String body) throws MessageNotFoundException {
        Date tDate = new Date();
        // NEXT LINE FIXED BY NIR . from "body" to "nickname"!!!!!!!!!
        this._XmlForum.addMessage(parentId, nickname, subject, body, tDate, tDate);
    }

    public void editMessage(String nickname, int messageId, String subject, String body) throws MessageNotFoundException, MessageOwnerException {
        Date tDate = new Date();
        String tNickname = this._XmlMessage.getMessage(messageId).getNickname();
        if (nickname.equals(tNickname)) {
            this._XmlForum.editMessage(messageId, subject, body, tDate);
        } else {
            throw new MessageOwnerException();
        }
    }

    // why was it here? ??!?@?!#$%
/*   public void addReply(int parentId, String nickname, String subject, String body) {
    }
*/
    public void deleteMessage(int messageId) throws MessageNotFoundException {
        this._XmlForum.deleteMessage(messageId);
    }

    Vector<Message> viewForum() {
        Vector<Message> entireForum = new Vector<Message>();
        List<Integer> threadsIds = this._XmlMessage.getRepliesIds(0);
        for (int i = 0;i< threadsIds.size();i++){
            int tId = threadsIds.get(i).intValue();
            MessageData tData = this._XmlMessage.getMessage(tId);
            Message tMessage = new Message(tData);
            entireForum.add(tMessage);
        }

        return entireForum;
    }
}
