/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer;

import Forum.DomainLayer.Interfaces.DomainGuestInterface;
import Forum.Exceptions.*;
import java.util.Date;

/**
 *
 * @author Amit Ofer
 */
public class Guest implements DomainGuestInterface {


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

    public String readMessage(int messageId) throws MessageNotFoundException{
        return  this._forum.getMessage(messageId).toString();
    }
    public void register(String username, String password, String nickname, String email, String firstName, String lastName, Date dateOfBirth)
            throws UserExistsException,NicknameExistsException,BadPasswordException{
        Member tMember = new Member(this._forum,username,nickname,email,password,firstName,lastName,dateOfBirth);
        this._forum.register(tMember) ;
    }

    public void logIn(String username, String password) throws NoSuchUserException,WrongPasswordException {
        this._forum.login(username,password);
    }

    
}
