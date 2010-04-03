/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.TCPCommunicationLayer;

import Forum.DomainLayer.Forum;
import Forum.Exceptions.UserNotExistException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amit ofer
 */
public class UpgradeUserMessage extends ClientMessage {

    private String m_username;

    public UpgradeUserMessage(String username){
        this.m_username = username;
    }

    public ServerResponse doOperation() {
        ServerResponse tResponse;
        try {
            Forum.getInstance().upgradeUser(m_username); //maybe change to username later
            String tAns = "The user " + m_username + " was upgraded successfully.";
            tResponse = new ServerResponse(tAns, true);
        } catch (UserNotExistException ex) {
            tResponse = new ServerResponse("User does not exist.", false);
            //Logger.getLogger(UpgradeUserMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tResponse;
    }

}
