/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forum.DomainLayer;

import Forum.DomainLayer.Interfaces.MessageInterface;
import Forum.PersistentLayer.Data.MessageData;
import java.util.Vector;

/**
 *
 * @author Amit Ofer
 */
public class Message implements MessageInterface {

    private MessageData _data;
    private Vector<Message> _replies;

    /**
     *constructor
     * @param nickname
     * @param subject
     * @param body
     */
    public Message(MessageData data) {
        this._data = data;
        this._replies = new Vector<Message>();
    }

    /**
     *another constructor
     * @param nickname
     * @param subject
     * @param body
     * @param replies
     * @param WriteDate
     * @param ModifiedDate
     */
    public Message(MessageData data, Vector<Message> replies) {
        this(data);
        this._replies = new Vector<Message>();
    }

    /**
     * getter for the body
     * @return
     */
    public String getBody() {
        return _data.getBody();
    }

    /**
     *getter for the nickname
     * @return
     */
    public String getNickname() {
        return _data.getNickname();
    }

    /**
     *getter for the subject
     * @return
     */
    public String getSubject() {
        return _data.getSubject();
    }

    /**
     *getter for the replies
     * @return
     */
    public Vector<Message> getReplies() {
        return _replies;
    }

    /**
     *setter for th e body
     * @param _body
     */
    public void setBody(String body) {
        _data.setBody(body);
    }

    /**
     *setter for the subject
     * @param _subject
     */
    public void setSubject(String subject) {
        _data.setSubject(subject);
    }

    /**
     *add a new reply
     * @param msg
     */
    public void addReply(Message msg) {
        this._replies.add(msg);
    }

    /**
     * toString method for a message
     * @return
     */
    @Override
    public String toString() {
        return "\nSubject:" + _data.getSubject() + "\nWritten by:" + _data.getNickname()
                + "\n Number of replies:" + _replies.size() + "\nBody:" + _data.getBody() + "\n";
    }

    /**
     * index getter
     * @return the index of the message
     */
    public int getIndex() {
        return this._data.getId();
    }
        

        /**
         * index setter - should not be used; used only for tests.
         * @param id - the index of the message
         */
        public void  setIndex(int id) {
        this._data.setId(id);
    }

}
