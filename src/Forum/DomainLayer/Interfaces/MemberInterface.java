/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer.Interfaces;

/**
 *
 * @author Amit Ofer
 */
public interface MemberInterface extends GuestInterface {

    public void logOut();
    public void writeMessage(String nickName,String subject,String body);
    public  void editMessage(int messageId,String subject,String body);
}
