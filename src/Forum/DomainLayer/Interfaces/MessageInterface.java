/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer.Interfaces;

import Forum.DomainLayer.Message;
import java.util.Vector;

/**
 *
 * @author Kipi
 */
public interface MessageInterface {

    /**
     * add a new reply
     * @param msg
     */
    void addReply(Message msg);

    /**
     * getter for the body
     * @return
     */
    String getBody();

    /**
     * getter for the nickname
     * @return
     */
    String getNickname();

    /**
     * getter for the replies
     * @return
     */
    Vector<Message> getReplies();

    /**
     * getter for the subject
     * @return
     */
    String getSubject();

    /**
     * setter for th e body
     * @param _body
     */
    void setBody(String body);

    /**
     * setter for the subject
     * @param _subject
     */
    void setSubject(String subject);

}
