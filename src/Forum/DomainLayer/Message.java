/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forum.DomainLayer;

import Forum.DomainLayer.Interfaces.MessageInterface;
import Forum.PersistentLayer.Data.MessageData;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;
import org.compass.annotations.Cascade;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableCascading;
import org.compass.annotations.SearchableComponent;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableIdComponent;

/**
 *
 * @author Amit Ofer
 */
@Searchable
public class Message implements MessageInterface {
    @SearchableIdComponent
    private MessageData _data;
    @SearchableCascading(cascade = {Cascade.ALL})
    private Vector<Message> _replies;

    public Message(){

    }

    public  MessageData getData() {
        return _data;
    }

    public void setData(MessageData _data) {
        this._data = _data;
    }

    public void setReplies(Vector<Message> _replies) {
        this._replies = _replies;
    }



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
    public void addReply(Vector<Message> msgs) {
        for (Iterator<Message> it = msgs.iterator(); it.hasNext();) {
            addReply(it.next());
        }
    }
    /**
     * toString method for a message
     * @return
     */
    public String toString() {
        String ans = "MessageId: " + _data.getId() + "\nSubject:" + _data.getSubject() + "\nWritten by:"
                + _data.getNickname() + "\nBody:" + _data.getBody() + "\n";
       if (_replies.size() > 0){
            ans = ans + "\nReplies:\n\n";
            for (int i = 0; i < _replies.size();i++){
                ans = ans + "Reply      " + (i+1)  + "\n";
                ans = ans + _replies.elementAt(i).toString() + "\n";
            }
       }
        return ans;
     //   return "\nSubject:" + _data.getSubject() + "\nWritten by:" + _data.getNickname()
      //          + "\n Number of replies:" + _replies.size() + "\nBody:" + _data.getBody() + "\n";
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

    public Date getWriteDate(){
        return this._data.getWriteDate();
    }
        public Date getModifiedDate(){
        return this._data.getModifiedDate();
    }

}
