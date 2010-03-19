/*

 * Interface for the guest class
 */

package Forum.DomainLayer.Interfaces;

import Forum.Exceptions.*;
import java.util.Date;

/**
 *
 * @author Amit Ofer
 */
public interface GuestInterface extends UserInterface {
    /**
     * registers a new user to the forum
     * @param username
     * @param password
     * @param nickname
     * @param email
     * @param firstName
     * @param lastName
     * @param dateOfBirth
     */
    public void register(String username,String password,String nickname,
            String email,String firstName,String lastName,Date dateOfBirth) throws UserExistsException,NicknameExistsException,BadPasswordException;
    /**
     *login to the forum (turns the guest into a logged in member)
     * only works if the given username exists the the password matches
     * @param username
     * @param password
     */
    public void logIn(String username,String password) throws NoSuchUserException,WrongPasswordException;
    

}
