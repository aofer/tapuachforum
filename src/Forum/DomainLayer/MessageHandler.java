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

    public MessageInterface getMessage(int messageId) throws MessageNotFoundException {
        MessageData data = this._XmlMessage.getMessage(messageId);
        Message msg = new Message(data);

        Vector<Message> tReplies = new Vector<Message>();

        //get children to be implemented later on!!

        return msg;
    }

    public void addMessage(String _nickName, String subject, String body) {
        Date tDate = new Date();
        this._XmlForum.addMessage(0, _nickName, subject, body, tDate, tDate);
    }

    public void addMessage(int replyId, String nickname, String subject, String body) throws MessageNotFoundException, MessageOwnerException {
        Date tDate = new Date();
        this._XmlForum.addMessage(replyId, body, subject, body, tDate, tDate);
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

    public void addReply(int parentId, String nickname, String subject, String body) {
    }

    public void deleteMessage(int messageId) throws MessageNotFoundException {
        this._XmlForum.deleteMessage(messageId);
    }
}
