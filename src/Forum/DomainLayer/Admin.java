/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer;

import Forum.DomainLayer.Interfaces.AdminInterface;
import Forum.PersistentLayer.Data.MemberData;

/**
 *
 * @author amit
 */
public class Admin extends Moderator implements AdminInterface {

        public Admin(MemberData data){
        super(data);
    }
    public void upgradeUser(String username) {
        Forum.getInstance().upgradeUser(username);
    }

}