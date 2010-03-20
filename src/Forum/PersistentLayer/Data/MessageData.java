/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.PersistentLayer.Data;

import java.util.Date;


/**
 * Contain all the data that a Domain class Message needed from the PersistentLayer
 */
public class MessageData {

 private String _nickname;
 private String _subject;
 private String _body;
 private Date _writeDate;
 private Date _modifiedDate;

 public MessageData(String nickname , String subject,String body,Date writeDate,Date modifedDate)
 {
     this._nickname=nickname;
     this._subject=subject;
     this._body=body;
     this._writeDate=writeDate;
     this._modifiedDate=modifedDate;
 }

    /**
     * @return the _nickname
     */
    public String getNickname() {
        return _nickname;
    }

    /**
     * @return the _subject
     */
    public String getSubject() {
        return _subject;
    }

    /**
     * @return the _body
     */
    public String getBody() {
        return _body;
    }
    /**
     * @return the _writeDate
     */
    public Date getWriteDate() {
        return _writeDate;
    }

    /**
     * @return the _modifiedDate
     */
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this._subject = subject;
    }

    /**
     * @param body the body to set
     */
    public void setBody(String body) {
        this._body = body;
    }
 
}