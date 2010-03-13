/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer.Interfaces;

import java.util.Date;

/**
 *
 * @author amit
 */
public interface GuestInterface {

    public void readMessage(int messageId);
    public void register(String username,String password,String nickname,
            String email,String firstName,String lastName,Date dateOfBirth);
    public void logIn(String username,String password);
    

}
