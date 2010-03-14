/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer;

import java.util.Date;
import java.util.Vector;

/**
 *
 * @author Amit Ofer
 */
public class Message {
 private int _messageId;
 private String _nickname;
 private String _subject;
 private String _body;
 private Vector<Message> _replies;
 private Date _writeDate;
 private Date _modifiedDate;

 /**
  *constructor
  * @param messageId
  * @param nickname
  * @param subject
  * @param body
  */
 public Message(int messageId,String nickname,String subject,String body){
     this._messageId = messageId;
     this._nickname = nickname;
     this._subject = subject;
     this._body = body;
     this._replies  = new Vector<Message>();
     this._writeDate = new Date();
     this._modifiedDate = new Date();
 }

 /**
  *getter for messageId
  * @return
  */
 public int getMessageId() {
        return _messageId;
    }

 /**
  * getter for the body
  * @return
  */
 public String getBody() {
        return _body;
    }

    /**
     *getter for the nickname
     * @return
     */
    public String getNickname() {
        return _nickname;
    }

    /**
     *getter for the subject
     * @return
     */
    public String getSubject() {
        return _subject;
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
    public void setBody(String _body) {
        this._body = _body;
    }

    /**
     *setter for the subject
     * @param _subject
     */
    public void setSubject(String _subject) {
        this._subject = _subject;
    }


 
    /**
     *add a new reply
     * @param msg
     */
    public void addReply(Message msg){
     this._replies.add(msg);
 }

    /**
     * toString method for a message
     * @return
     */
    @Override
 public String toString(){
     return "Message number:" + _messageId + "\nSubject:" + _subject + "\nWritten by:" + _nickname
             + "\n Number of replies:" + _replies.size() + "\nBody:" + _body + "\n";
 }

}
