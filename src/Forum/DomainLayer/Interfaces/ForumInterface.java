/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer.Interfaces;

import Forum.DomainLayer.Message;

/**
 *
 * @author Amit Ofer
 */
public interface ForumInterface {
    public Message getMessage(int messageId);
    
}
