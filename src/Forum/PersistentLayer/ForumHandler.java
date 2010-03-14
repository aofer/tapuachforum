/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.PersistentLayer;

import Forum.PersistentLayer.Interfaces.ForumInterface;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author Nir
 */
public class ForumHandler  implements ForumInterface{

    /**
     *
     * @return
     */
    public ForumType giveF() {
             ObjectFactory factory = new ObjectFactory();
             return       (factory.createForumType());
        }
        /**
         *
         * @param username
         * @param filedToUse
         * @return
         */
        public Object getObject(String username, int filedToUse){
            Object tempToSave;
            String usernameTemp;
            int index, size;
            boolean foundName;
            tempToSave = null;
            foundName = false;
            index = 0;
            List< MemberType>  membersList =  giveF().getMembers();
            size = membersList.size();
            while ((index < size) & !foundName){
                  usernameTemp  = membersList.get(index).getNickName();
                  foundName = usernameTemp.equals(username);
                  index = index +1;
            }
          if (! foundName)
               return null;
          else
               switch (filedToUse) {
                      case 1:  tempToSave = membersList.get(index-1).getNickName(); break;
                      case 2:  tempToSave = membersList.get(index-1).getPassword(); break;
                      case 3:  tempToSave = membersList.get(index-1).getEMail(); break;
                      case 4:  tempToSave = membersList.get(index-1).getDateJoined(); break;
                      case 5:  tempToSave = membersList.get(index-1).getFirstName(); break;
                      case 6:  tempToSave = membersList.get(index-1).getLastName(); break;
                      case 7:  tempToSave = membersList.get(index-1).getDateOfBirth(); break;
                      case 8:  tempToSave = membersList.get(index-1).isStatus(); break;
                   default:  tempToSave =  null; break;
        }
       System.out.println(tempToSave.toString());
     return (tempToSave);
      };

      /**
       *
       * @param username
       * @param tempToSave
       * @param filedToUse
       */
      public void setObject(String username, Object tempToSave, int filedToUse ){
            String usernameTemp;
            int index, size;
            boolean foundName;
            tempToSave = null;
            foundName = false;
            index = 0;
            List< MemberType>  membersList =  giveF().getMembers();
            size = membersList.size();
            while ((index < size) & !foundName){
                  usernameTemp  = membersList.get(index).getNickName();
                  foundName = usernameTemp.equals(username);
                  index = index +1;
                  if (foundName)
                    switch (filedToUse) {
                      case 1:   membersList.get(index-1).setNickName((String) tempToSave) ; break;
                      case 2:   membersList.get(index-1).setPassword((String) tempToSave); break;
                      case 3:   membersList.get(index-1).setEMail((String) tempToSave); break;
                      case 4:   membersList.get(index-1).setDateJoined((XMLGregorianCalendar) tempToSave); break;
                      case 5:   membersList.get(index-1).setFirstName((String) tempToSave); break;
                      case 6:   membersList.get(index-1).setLastName((String) tempToSave); break;
                      case 7:   membersList.get(index-1).setDateOfBirth((XMLGregorianCalendar) tempToSave); break;
                      case 8:   membersList.get(index-1).setStatus(tempToSave.equals(true)); break;
                   default:   System.out.println("user name is not here");; break;
        }
            }
}
      	/**
     * set the status of the user to be online
     * @param username, password */
    public void login(String username) {
       setObject(username, true, 8);
    }
	/**
     * set the status of the user to be offline
     * @param username a message id */
    public void logoff(String username) {
       setObject(username, false, 8);
    }

   	/**
     * check if the username already exist 
     * @param username 
     * @return username password if exists or NULL if not*/
    public String userExist(String username) {
       String nickName = null;
       nickName =(String)  getObject(username,  1);
     return nickName;
    }

    	/**
     * add a new member to the forum
     * @param username ,  nickName, password, eMail, firstName, lastName, dateOfBirth */
    public void register(String userName, String nickName, String password, String eMail, String firstName, String lastName, Date dateOfBirth) {
       	ObjectFactory factory = new ObjectFactory();
	// Create a new member
	MemberType  newMember = factory.createMemberType();
        newMember.setUserName(userName);
        newMember.setNickName(nickName);
        newMember.setPassword(password);
        newMember.setEMail(eMail);
        newMember.setFirstName(firstName);
        newMember.setLastName(lastName);

    //    newMember.setDateOfBirth(null);
         giveF().getMembers().add(newMember);
    }
    
	/**
     * add a new message to the forum
     * @param parentId, createdBy, subject,body */
    public void addMessage(int parentId, String createdBy, String subject, String body, Date DateAdded) {
         ObjectFactory factory = new ObjectFactory();
	// Create a new member
        MessageType  newMessage = factory.createMessageType();
        newMessage.setParentId(BigInteger.ONE);
        newMessage.setCreatedBy(createdBy);
        newMessage.setSubject(subject);
        newMessage.setBody(body);

        //newessage.setDateAdded(null);
        giveF().getMessages().add(newMessage);

    }

    public boolean checkNickname(String nickname) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean checkPassword(String password) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addMessage(int parentId, String createdBy, String subject, String body, Date DateAdded, Date modifyDate) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
