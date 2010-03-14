/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer;

import Forum.DomainLayer.Interfaces.MemberInterface;
import java.util.Date;

/**
 *
 * @author Amit Ofer
 */
public class Member  extends Guest implements MemberInterface{
private String _userName;
private String _nickName;
private String _password;
private String _firstName;
private String _lastName;;
private String _email;
private Date _dateJoined;
private Date _dateOfBirth;

public Member(Forum forum,String userName,String nickName,String password,String firstName,String lastName,String email,
       Date dateOfBirth){
    super(forum);
    this._userName = userName;
    this._nickName = nickName;
    this._password = password;
    this._firstName = firstName;
    this._lastName = lastName;
    this._email = email;
    this._dateOfBirth = dateOfBirth;
    this._dateJoined = new Date();
}

    public void logOut() {
        this.getForum().logout(this._userName);
    }

    public void writeMessage(String subject, String body) {
        this.getForum().addMessage(this._nickName,subject,body);
    }

    public void editMessage(int messageId, String subject, String body) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
