/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.PersistentLayer;

import Forum.PersistentLayer.Interfaces.MemberInterface;
import java.util.Date;
import java.util.List;
//import javax.swing.text.StyledEditorKit.BoldAction;
import javax.xml.datatype.XMLGregorianCalendar;
//import sun.font.CreatedFontTracker;


/**
 *
 * @author Nir
 */
public class MemberHandler implements MemberInterface{


    /**
     *
     * @return
     */
    public ForumType giveF() {
             ObjectFactory factory = new ObjectFactory();
             return       (factory.createForumType());
        }
	//--------------------Getters------------------------------
      /**
        * get the getObject
       * @param username
       * @param filedToUse
       * @return the object of in the filed of userName.
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
     * get the nickname
         * @param username
         * @return
         */
	public String getNickName (String username){
            return ((String) getObject(username,1));
            /*      String usernameTemp;
            int index, size;
            boolean foundName;
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
                 return   membersList.get(index-1).getNickName();*/
      };

      /**
     * get the password
     * @param username */
    public String getPassword(String username) {
       return ((String) getObject(username,2));
    }

    	/**
     * get the email
     * @param username */
    public String getEMail(String username) {
          return ((String) getObject(username,3));
    }

    	/**
     * get the date when username joined the forum
     * @param username */
    public Date getDateJoined(String username) {
          return ((Date) getObject(username,4));
    }

    	
	/**
     * get the real first name of the username 
     * @param username */
    public String getFirstName(String username) {
        return ((String) getObject(username,5));
    }

    	/**
     * get the real last name of the username 
     * @param username */
    public String getLastName(String username) {
          return ((String) getObject(username,6));
    }

    	/**
     * get the date of birth of the username 
     * @param username */
    public Date getDateofBirth(String username) {
             return ((Date) getObject(username,7));
    }

   	/**
     * get the status of the username - online=true and offline= false 
     * @param username */
    public boolean getStatus(String username) {
          return ( getObject(username,8).equals(true));
    }

 
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

       System.out.println("i am in bad place!!!");

      };

    	/**
     * set the nickname
     * @param username, nickName */
      public void setNickName(String username, String nickName) {
      setObject(username, nickName,1 );
    }

    	/**
     * set the password
     * @param username, password */
      public void setPassword(String username, String password) {
        setObject(username, password,2 );
    }

    	/**
     * set the email
     * @param username, eMail */
      public void setEMail(String username, String eMail) {
      setObject(username, eMail,3 );
    }

    	/**
     * set the date when username joined the forum
     * @param username,dateJoined */
      public void setDateJoined(String username, Date dateJoined) {
       setObject(username, dateJoined,4 );
    }

    	/**
     * set the real first name of the username 
     * @param username,firstName */
      public void setFirstName(String username, String firstName) {
     setObject(username, firstName, 5 );
    }

    	/**
     * set the real last name of the username 
     * @param username,lastName*/
      public void setLastName(String username, String lastName) {
      setObject(username, lastName,6 );
    }

    	/**
     * set the date of birth of the username 
     * @param username, dateOfBirth */
      public void setDateofBirth(String username, Date dateOfBirth) {
       setObject(username, dateOfBirth,7 );
    }

    			
	/**
     * set the status of the username - online=true and offline= false 
     * @param username , status*/
      public void setStatus(String username, boolean status) {
     setObject(username, status,8 );
    }


}


