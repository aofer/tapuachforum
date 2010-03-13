/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer;

import Forum.DomainLayer.Interfaces.GuestInterface;
import java.util.Date;

/**
 *
 * @author amit
 */
public class Guest implements GuestInterface {


    private Forum _forum;

    public Guest(Forum forum){
        this._forum = forum;

    }

    public void readMessage(int messageId) {
        Message tMsg = this._forum.getMessage(messageId);
        System.out.println(tMsg.toString());
    }

    public void register(String username, String password, String nickname, String email, String firstName, String lastName, Date dateOfBirth) {
        Member tMember = new Member(this._forum,username,nickname,email,password,firstName,lastName,dateOfBirth);
        this._forum.register(tMember);
    }

    public void logIn(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
