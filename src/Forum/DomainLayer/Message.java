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
  *
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
  *
  * @return
  */
 public int getMessageId() {
        return _messageId;
    }

 /**
  * 
  * @return
  */
 public String getBody() {
        return _body;
    }

    /**
     *
     * @return
     */
    public String getNickname() {
        return _nickname;
    }

    /**
     *
     * @return
     */
    public String getSubject() {
        return _subject;
    }

    /**
     *
     * @return
     */
    public Vector<Message> getReplies() {
        return _replies;
    }

    /**
     *
     * @param _body
     */
    public void setBody(String _body) {
        this._body = _body;
    }

    /**
     *
     * @param _subject
     */
    public void setSubject(String _subject) {
        this._subject = _subject;
    }


 
    /**
     *
     * @param msg
     */
    public void addReply(Message msg){
     this._replies.add(msg);
 }
    @Override
 public String toString(){
     return "Message number:" + _messageId + "\nSubject:" + _subject + "\nWritten by:" + _nickname
             + "\n Number of replies:" + _replies.size() + "\nBody:" + _body + "\n";
 }

}
