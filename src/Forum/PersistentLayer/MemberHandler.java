/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forum.PersistentLayer;

import Forum.Exceptions.NoSuchUserException;
import Forum.PersistentLayer.Interfaces.MemberInterface;
import java.util.Date;
import java.util.GregorianCalendar;
//import javax.swing.text.StyledEditorKit.BoldAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
//import sun.font.CreatedFontTracker;

/**
 *
 * @author Nir
 */
public class MemberHandler implements MemberInterface {

    /**
     *
     * @return
     */
    public ForumType giveF() {
        ObjectFactory factory = new ObjectFactory();
        return (factory.createForumType());
    }
    private XMLFileHandler xf;

    public MemberHandler(XMLFileHandler xf) {
        this.xf = xf;
    }
    //--------------------Getters------------------------------

    /**
     * get the nickname
     * @param username
     * @return
     */
    public String getNickName(String username) throws NoSuchUserException {
        for (MemberType m : this.xf.getForum().getMembers()) {
            if (m.getUserName().equals(username)) {
                return m.getNickName();
            }
        }
        throw new NoSuchUserException(("no such user exists, go away!!!"));
    }

    /**
     * get the password
     * @param usernam */
    public String getPassword(String username) throws NoSuchUserException {
        for (MemberType m : this.xf.getForum().getMembers()) {
            if (m.getUserName().equals(username)) {
                return m.getPassword();
            }
        }
        throw new NoSuchUserException(("no such user exists, go away!!!"));
    }

    /**
     * get the email
     * @param username */
    public String getEMail(String username) throws NoSuchUserException {
        for (MemberType m : this.xf.getForum().getMembers()) {
            if (m.getUserName().equals(username)) {
                return m.getEMail();
            }
        }
        throw new NoSuchUserException(("no such user exists, go away!!!"));
    }

    /**
     * get the date when username joined the forum
     * @param username */
    public Date getDateJoined(String username) throws NoSuchUserException {
        for (MemberType m : this.xf.getForum().getMembers()) {
            if (m.getUserName().equals(username)) {
                return m.getDateJoined().toGregorianCalendar().getTime();
            }
        }
        throw new NoSuchUserException(("no such user exists, go away!!!"));
    }

    /**
     * get the real first name of the username 
     * @param username */
    public String getFirstName(String username) throws NoSuchUserException {
        for (MemberType m : this.xf.getForum().getMembers()) {
            if (m.getUserName().equals(username)) {
                return m.getFirstName();
            }
        }
        throw new NoSuchUserException(("no such user exists, go away!!!"));
    }

    /**
     * get the real last name of the username 
     * @param username */
    public String getLastName(String username) throws NoSuchUserException {
        for (MemberType m : this.xf.getForum().getMembers()) {
            if (m.getUserName().equals(username)) {
                return m.getLastName();
            }
        }
        throw new NoSuchUserException(("no such user exists, go away!!!"));
    }

    /**
     * get the date of birth of the username 
     * @param username */
    public Date getDateofBirth(String username) throws NoSuchUserException {
        for (MemberType m : this.xf.getForum().getMembers()) {
            if (m.getUserName().equals(username)) {
                return m.getDateOfBirth().toGregorianCalendar().getTime();

            }
        }
        throw new NoSuchUserException(("no such user exists, go away!!!"));
    }

    /**
     * get the status of the username - online=true and offline= false 
     * @param username */
    public boolean getStatus(String username) throws NoSuchUserException {
        for (MemberType m : this.xf.getForum().getMembers()) {
            if (m.getUserName().equals(username)) {
                return m.isStatus();
            }
        }
        throw new NoSuchUserException(("no such user exists, go away!!!"));
    }

    /**
     * set the nickname
     * @param username, nickName */
    public void setNickName(String username, String nickName) throws NoSuchUserException {

        for (MemberType m : this.xf.getForum().getMembers()) {
            if (m.getUserName().equals(username)) {
                m.setNickName(nickName);
            }
        }
        throw new NoSuchUserException(("no such user exists, go away!!!"));
    }

    /**
     * set the password
     * @param username, password */
    public void setPassword(String username, String password) throws NoSuchUserException {
        for (MemberType m : this.xf.getForum().getMembers()) {
            if (m.getUserName().equals(username)) {
                m.setPassword(password);
            }
        }
        throw new NoSuchUserException(("no such user exists, go away!!!"));
    }

    /**
     * set the email
     * @param username, eMail */
    public void setEMail(String username, String eMail) throws NoSuchUserException {
        for (MemberType m : this.xf.getForum().getMembers()) {
            if (m.getUserName().equals(username)) {
                m.setEMail(eMail);
            }
        }
        throw new NoSuchUserException(("no such user exists, go away!!!"));
    }

    /**
     * set the date when username joined the forum
     * @param username,dateJoined */
    public void setDateJoined(String username, Date dateJoined) throws NoSuchUserException {
        for (MemberType m : this.xf.getForum().getMembers()) {
            if (m.getUserName().equals(username)) {
                try {
                    GregorianCalendar gcal = new GregorianCalendar();
                    gcal.setTime(dateJoined);
                    XMLGregorianCalendar xgcal;

                    xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);

                    m.setDateJoined(xgcal);
                } catch (DatatypeConfigurationException ex) {
                    Logger.getLogger(MemberHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        throw new NoSuchUserException(("no such user exists, go away!!!"));
    }

    /**
     * set the real first name of the username 
     * @param username,firstName */
    public void setFirstName(String username, String firstName) throws NoSuchUserException {
        for (MemberType m : this.xf.getForum().getMembers()) {
            if (m.getUserName().equals(username)) {
                m.setFirstName(firstName);
            }
        }
        throw new NoSuchUserException(("no such user exists, go away!!!"));
    }

    /**
     * set the real last name of the username 
     * @param username,lastName*/
    public void setLastName(String username, String lastName) throws NoSuchUserException {
        for (MemberType m : this.xf.getForum().getMembers()) {
            if (m.getUserName().equals(username)) {
                m.setLastName(lastName);
            }
        }
        throw new NoSuchUserException(("no such user exists, go away!!!"));
    }

    /**
     * set the date of birth of the username 
     * @param username, dateOfBirth */
    public void setDateofBirth(String username, Date dateOfBirth) throws NoSuchUserException {
        for (MemberType m : this.xf.getForum().getMembers()) {
            if (m.getUserName().equals(username)) {
                try {
                    GregorianCalendar gcal = new GregorianCalendar();
                    gcal.setTime(dateOfBirth);
                    XMLGregorianCalendar xgcal;

                    xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);

                    m.setDateOfBirth(xgcal);
                } catch (DatatypeConfigurationException ex) {
                    Logger.getLogger(MemberHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        throw new NoSuchUserException(("no such user exists, go away!!!"));
    }

    /**
     * set the status of the username - online=true and offline= false 
     * @param username , status*/
    public void setStatus(String username, boolean status) throws NoSuchUserException {
        for (MemberType m : this.xf.getForum().getMembers()) {
            if (m.getUserName().equals(username)) {
                m.setStatus(status);
            }
        }
        throw new NoSuchUserException(("no such user exists, go away!!!"));
    }
}


