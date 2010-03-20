/*

 * Interface for the guest class
 */

package Forum.DomainLayer.Interfaces;

import Forum.Exceptions.*;
import Forum.PersistentLayer.Data.MemberData;

/**
 *
 * @author Amit Ofer
 */
public interface GuestInterface extends UserInterface {
    /**
     * registers a new user to the forum
     */
    public MemberInterface register(MemberData data) throws UserExistsException,NicknameExistsException,BadPasswordException;
    /**
     *login to the forum (turns the guest into a logged in member)
     * only works if the given username exists the the password matches
     * @param username
     * @param password
     */
    public void logIn(String username,String password) throws NoSuchUserException,WrongPasswordException;
    

}
