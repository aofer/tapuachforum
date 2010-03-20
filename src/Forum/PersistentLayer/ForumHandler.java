/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.PersistentLayer;

import Forum.PersistentLayer.Interfaces.ForumHandlerInterface;
import java.math.BigInteger;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author Nir
 */
public class ForumHandler  implements  ForumHandlerInterface{

    /**
     *
     * @return
     */


           private XMLFileHandler xf;

    public ForumHandler(XMLFileHandler xf) {
        this.xf = xf;
    }
      	/**
     * set the status of the user to be online
     * @param username, password */
    public void login(String username) {
        for (MemberType m : this.xf.getForum().getMembers()) {
            if (m.getUserName().equals(username)) {
                m.setStatus(true);
            }
       }
    }
	/**
     * set the status of the user to be offline
     * @param username a message id */
    public void logoff(String username) {
         for (MemberType m : this.xf.getForum().getMembers()) {
            if (m.getUserName().equals(username)) {
                m.setStatus(false);
            }
       }
    }

    private int getCounter(){
        int ans = this.xf.getForum().getMessageCounter().intValue();
        int tmp = ans +1;
        this.xf.getForum().setMessageCounter(BigInteger.valueOf(tmp));
        return ans;
    }
   	/**
     * check if the username already exist 
     * @param username 
     * @return username password if exists or NULL if not*/
    public String userExist(String username) {
                           for (MemberType m : this.xf.getForum().getMembers()) {
            if (m.getUserName().equals(username)) {
                return m.getUserName();
            }
        }
          return null;
        }

        private MemberType findMember(String username){
                         for (MemberType m : this.xf.getForum().getMembers()) {
            if (m.getUserName().equals(username)) {
                return m;
            }
        }
          return null;
        }

             private MessageType findMessage(int messageID) {
                         for (MessageType m : this.xf.getForum().getMessages()) {
              if(m.getMessageId().intValue() == messageID){
                return m;
            }
        }
          return null;
        }

             private MessageType findMessageOfUser(int messageID, String usernme) {
                  MemberType memb = findMember(usernme);
                 for (MessageType m :    memb.getMessage()) {
              if(m.getMessageId().intValue() == messageID){
                return m;
            }
        }
          return null;
        }
        /**
     * check if the username already exist 
     * @param username 
     * @return username password if exists or NULL if not*/
       
        public String getSubject(int messageID)  {
        for(MessageType m : this.xf.getForum().getMessages()){
            if(m.getMessageId().intValue() == messageID){

                return m.getSubject();
            }
        }
        return null;
        }
    	/**
     * add a new member to the forum
     * @param username ,  nickName, password, eMail, firstName, lastName, dateOfBirth */
    public void register(String userName, String nickName, String password, String eMail, String firstName, String lastName, Date dateOfBirth) {
        try {
            ObjectFactory factory = new ObjectFactory();
            // Create a new member
            MemberType newMember = factory.createMemberType();
            newMember.setUserName(userName);
            newMember.setNickName(nickName);
            newMember.setPassword(password);
            newMember.setEMail(eMail);
            newMember.setFirstName(firstName);
            newMember.setLastName(lastName);
            GregorianCalendar gcal = new GregorianCalendar();
            gcal.setTime(dateOfBirth);
            XMLGregorianCalendar xgcal, xgcal2;
            xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
            newMember.setDateOfBirth(xgcal);

            Date nowT = new Date();
            gcal.setTime(nowT);

            xgcal2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
            newMember.setDateJoined(xgcal2);
            //    newMember.setDateOfBirth(null);
            this.xf.getForum().getMembers().add(newMember);

        xf.WriteToXML();
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(ForumHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
	/**
     * add a new message to the forum
     * @param parentId, createdBy, subject,body */
    public void addMessage(int parentId, String createdBy, String subject, String body, Date DateAdded) {
        try {
            ObjectFactory factory = new ObjectFactory();
            // Create a new member
            MessageType newMessage = factory.createMessageType();
            newMessage.setParentId(BigInteger.valueOf(parentId));
            newMessage.setCreatedBy(createdBy);
            newMessage.setSubject(subject);
            newMessage.setBody(body);
            GregorianCalendar gcal = new GregorianCalendar();
            gcal.setTime(DateAdded);
            XMLGregorianCalendar xgcal;
            xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
            newMessage.setDateAdded(xgcal);
            newMessage.setModifiedDate(xgcal);
            newMessage.setMessageId(BigInteger.valueOf(getCounter()));
            this.xf.getForum().getMessages().add(newMessage);

            MemberType userWriter = findMember(createdBy);
            userWriter.getMessage().add(newMessage);

            xf.WriteToXML();
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(ForumHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean checkNickname(String nickname) {
                           for (MemberType m : this.xf.getForum().getMembers()) {
            if (m.getNickName().equals(nickname)) {
                return true;
            }
        }
          return false;
        };

    public boolean checkPassword(String password) {
                            for (MemberType m : this.xf.getForum().getMembers()) {
            if (m.getPassword().equals(password)) {
                return true;
            }
        }
          return false;
        };

    public void addMessage(int parentId, String createdBy, String subject, String body, Date DateAdded, Date modifyDate) {
        try {
            ObjectFactory factory = new ObjectFactory();
            // Create a new member
            MessageType newMessage = factory.createMessageType();
            newMessage.setParentId(BigInteger.valueOf(parentId));
            newMessage.setCreatedBy(createdBy);
            newMessage.setSubject(subject);
            newMessage.setBody(body);
            GregorianCalendar gcal = new GregorianCalendar();
            gcal.setTime(DateAdded);
            XMLGregorianCalendar xgcal, xgcal2;
            xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
            newMessage.setDateAdded(xgcal);

            gcal.setTime(modifyDate);
             xgcal2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
            newMessage.setModifiedDate(xgcal2);
               newMessage.setMessageId(BigInteger.valueOf(getCounter()));
               this.xf.getForum().getMessages().add(newMessage);

                 MemberType userWriter = findMember(createdBy);
            userWriter.getMessage().add(newMessage);
                   xf.WriteToXML();
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(ForumHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String userExists(String username) {
                               for (MemberType m : this.xf.getForum().getMembers()) {
            if (m.getUserName().equals(username)) {
                return m.getPassword();
            }
        }
          return null;
        };
   
    

    public boolean checkUsername(String username) {
                                  for (MemberType m : this.xf.getForum().getMembers()) {
            if (m.getUserName().equals(username)) {
                return true;
            }
        }
          return false;
        }

    public void editMessage(int messageId, String newSubject, String newBody, Date dateModified) {
        try {
            MessageType msg = findMessage(messageId);
            msg.setSubject(newSubject);
            msg.setBody(newBody);

            GregorianCalendar gcal = new GregorianCalendar();
            gcal.setTime(dateModified);
            XMLGregorianCalendar xgcal;
            xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
            msg.setModifiedDate(xgcal);


            MessageType msg2 = findMessageOfUser(messageId, msg.getCreatedBy());
            msg2.setSubject(newSubject);
            msg2.setBody(newBody);
              msg2.setModifiedDate(xgcal);

            xf.WriteToXML();
      
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(ForumHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
