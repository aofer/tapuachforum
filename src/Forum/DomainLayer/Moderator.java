/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer;

import Forum.DomainLayer.Interfaces.ModeratorInterface;
import Forum.PersistentLayer.Data.MemberData;

/**
 *
 * @author amit
 */
public class Moderator extends Member implements ModeratorInterface {

    public Moderator(MemberData data){
        super(data);
    }
    public void deleteMessage(int messageId) {
        Forum.getInstance().deleteMessage(messageId);
    }

}