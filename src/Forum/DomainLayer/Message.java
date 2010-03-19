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

 private String _nickname;
 private String _subject;
 private String _body;
 private Vector<Message> _replies;
 private Date _writeDate;
 private Date _modifiedDate;


 /**
  *constructor
  * @param nickname
  * @param subject
  * @param body
  */
 public Message(String nickname,String subject,String body){
     this._nickname = nickname;
     this._subject = subject;
     this._body = body;
     this._replies  = new Vector<Message>();
     this._writeDate = new Date();
     this._modifiedDate = new Date();
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
 public Message(String nickname,String subject,String body,Vector<Message> replies,Date WriteDate,Date ModifiedDate){
     this._nickname = nickname;
     this._subject = subject;
     this._body = body;
     this._replies  = new Vector<Message>();
     this._writeDate = new Date();
     this._modifiedDate = new Date();
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
     return  "\nSubject:" + _subject + "\nWritten by:" + _nickname
             + "\n Number of replies:" + _replies.size() + "\nBody:" + _body + "\n";
 }

}
