/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer;

import Forum.DomainLayer.Interfaces.GuestInterface;
import java.util.Date;

/**
 *
 * @author Amit Ofer
 */
public class Guest implements GuestInterface {


    private Forum _forum;

    /**
     *
     * @param forum
     */
    public Guest(Forum forum){
        this._forum = forum;

    }

    /**
     * 
     * @return
     */
    public Forum getForum() {
        return _forum;
    }

    public String readMessage(int messageId) {
        return  this._forum.getMessage(messageId).toString();
    }
    public void register(String username, String password, String nickname, String email, String firstName, String lastName, Date dateOfBirth) {
        Member tMember = new Member(this._forum,username,nickname,email,password,firstName,lastName,dateOfBirth);
        this._forum.register(tMember);
    }

    public void logIn(String username, String password) {
        this._forum.login(username,password);
    }

    
}
