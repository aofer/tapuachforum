/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forum.PersistentLayer;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import Forum.Exceptions.MessageNotFoundException;
import Forum.Exceptions.UserNotExistException;
import Forum.PersistentLayer.Interfaces.ForumHandlerInterface;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Nir
 */
public class SQLForumHandler implements ForumHandlerInterface {

    public Session session = null;

    /**
     *
     * @param xf
     */
    public SQLForumHandler() {
        this.session = SessionFactoryUtil.getInstance().getCurrentSession();

    }

    private static void deleteMessage(Message msg) {
        Transaction tx = null;
        Session session = SessionFactoryUtil.getInstance().getCurrentSession();
        try {
            tx = session.beginTransaction();
            session.delete(msg);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                try {
                    // Second try catch as the rollback could fail as well
                    tx.rollback();
                } catch (HibernateException e1) {
                    // add logging
                }
                // throw again the first exception
                throw e;
            }
        }
    }

    private static void createMessage(Message msg) {
        Transaction tx = null;

        Session session = SessionFactoryUtil.getInstance().getCurrentSession();
        try {
            tx = session.beginTransaction();
            session.save(msg);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                try {
                    // Second try catch as the rollback could fail as well
                    tx.rollback();
                } catch (HibernateException e1) {
                    // add logging
                }
                // throw again the first exception
                throw e;
            }
        }
    }

    private static void updateMessage(Message msg) {
        Transaction tx = null;
        Session session = SessionFactoryUtil.getInstance().getCurrentSession();
        try {
            tx = session.beginTransaction();
            session.update(msg);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                try {
                    // Second try catch as the rollback could fail as well
                    tx.rollback();
                } catch (HibernateException e1) {
                    // add logging
                }
                // throw again the first exception
                throw e;
            }
        }
    }

    private static void deleteMember(Members oneMember) {
        Transaction tx = null;
        Session session = SessionFactoryUtil.getInstance().getCurrentSession();
        try {
            tx = session.beginTransaction();
            session.delete(oneMember);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                try {
                    // Second try catch as the rollback could fail as well
                    tx.rollback();
                } catch (HibernateException e1) {
                    // add logging
                }
                // throw again the first exception
                throw e;
            }
        }
    }

    private static void createMember(Members oneMember) {
        Transaction tx = null;

        Session session = SessionFactoryUtil.getInstance().getCurrentSession();
        try {
            tx = session.beginTransaction();
            session.save(oneMember);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                try {
                    // Second try catch as the rollback could fail as well
                    tx.rollback();
                } catch (HibernateException e1) {
                    // add logging
                }
                // throw again the first exception
                throw e;
            }
        }
    }

    private static void updateMember(Members oneMember) {
        Transaction tx = null;
        Session session = SessionFactoryUtil.getInstance().getCurrentSession();
        try {
            tx = session.beginTransaction();
            session.update(oneMember);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                try {
                    // Second try catch as the rollback could fail as well
                    tx.rollback();
                } catch (HibernateException e1) {
                    // add logging
                }
                // throw again the first exception
                throw e;
            }
        }
    }

    /**
     * set the status of the user to be online
     * @param username
     */
    public void login(String username) {
        Members oneOfMembers = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Members as members where members.UserName is '" + username + "'");
            oneOfMembers = (Members) q.uniqueResult();
            //TODO change Admin to statos login
            oneOfMembers.setIsAdmin(true);
            updateMember(oneOfMembers);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * set the status of the user to be offline
     * @param username a message id */
    public void logoff(String username) {
        Members oneOfMembers = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Members as members where members.UserName is '" + username + "'");
            oneOfMembers = (Members) q.uniqueResult();
            //TODO change Admin to statos login
            oneOfMembers.setIsAdmin(false);
            updateMember(oneOfMembers);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // this function is helping to add ONE to the number of messeages in the forum
    private int getCounter() {
        Message oneMessage = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            //TODO change to good query to get message with max
            Query q = session.createQuery("from Message as message where max");
            oneMessage = (Message) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (oneMessage == null)
            return 0;
        else
            return oneMessage.getNumber();
    }

    /**
     * check if the username already exist
     * @param username
     * @return username password if exists or NULL if not*/
    public String userExist(String username) {
        Members oneOfMembers = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Members as members where members.UserName is '" + username + "'");
            oneOfMembers = (Members) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (oneOfMembers != null) {
            return oneOfMembers.getPassword();
        } else {
            return null;
        }


    }

    // this function giving back member by his userName
    private Members findMember(String username) {
        Members oneOfMembers = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Members as members where members.UserName is '" + username + "'");
            oneOfMembers = (Members) q.uniqueResult();
            return oneOfMembers;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    // this function giving back   Message from the main level of the tree if exist. Null outher wise;
    // it is not in use!
    private Message findMessageAtMain(int messageID) {
        Message oneMessage = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Message as message where message.number is '" + messageID + "'");
            oneMessage = (Message) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return oneMessage;
    }
    ;

    // this function giving back   Message from the tree if exist. Null outher wise;
    // it is using the next helf-recorsivic function.
    private Message findMessage(int messageID) {
        Message oneMessage = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Message as message where message.number is '" + messageID + "'");
            oneMessage = (Message) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return oneMessage;
    }
    ;

    // recursivis function to find Messeage;
    // IN SQL we don't need this function!!
     /*   private MessageType findMessageRec(int messageID, MessageType messageAba) {
    if(messageAba.getMessageId().intValue() == messageID)
    return messageAba;
    else{
    MessageType tryMesaage = null;
    for (MessageType m : messageAba.getMessage()) {
    tryMesaage =  findMessageRec(messageID, m);
    if (tryMesaage != null)
    return tryMesaage;
    }
    }
    return null;
    }
     * /


    /**
     * check if the username already exist
     * @param messageID
     * @return username password if exists or NULL if not*/
    public String getSubject(int messageID) {
        Message Aba = findMessage(messageID);
        if (Aba != null) {
            return Aba.getTitle();
        } else {
            return ("not such messe");
        }
    }

    /**
     * add a new member to the forum
     * @param userName
     * @param nickName
     * @param password
     * @param eMail
     * @param firstName
     * @param lastName
     * @param dateOfBirth
     */
    public void register(String userName, String nickName, String password, String eMail, String firstName, String lastName, Date dateOfBirth) {
        Members newMember = new Members();
        // Create a new member
        newMember.setUserName(userName);
        newMember.setNickName(nickName);
        newMember.setPassword(password);
        newMember.setEmail(eMail);
        newMember.setFirstName(firstName);
        newMember.setLastName(lastName);
        newMember.setDataOfBirth(dateOfBirth);

        Date nowT = new Date();
        newMember.setDateOfJoin(nowT);
        createMember(newMember);
    }

    /**
     * add a new message to the forum
     * @param parentId
     * @param createdBy
     * @param DateAdded
     * @param subject
     * @param body
     */
    public void addMessage(int parentId, String createdBy, String subject, String body, Date DateAdded) throws MessageNotFoundException {
        // Create a new member
        Message newMessage = new Message();
        newMessage.setIdFather(parentId);
        newMessage.setAuthor(createdBy);
        newMessage.setTitle(subject);
        newMessage.setBody(body);
        newMessage.setDataOfAdd(DateAdded);
        Date tDate = new Date();
        newMessage.setDateOfEdit(tDate);
        newMessage.setNumber(getCounter() + 1);
        if (parentId == 0) {
            createMessage(newMessage);
        } else {
            Message Aba = findMessage(parentId);
            if (Aba != null) {
                createMessage(newMessage);
            } else {
                throw new MessageNotFoundException("there is not such parent" + parentId);
            }

        }

    }

    public boolean checkNickname(String nickname) {
        Members oneOfMembers = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Members as members where members.NickName is '" + nickname + "'");
            oneOfMembers = (Members) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (oneOfMembers != null) {
            return true;
        } else {
            return false;
        }
    }
    ;

    public boolean checkPassword(String password) {
        Members oneOfMembers = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Members as members where members.Password is '" + password + "'");
            oneOfMembers = (Members) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (oneOfMembers != null) {
            return true;
        } else {
            return false;
        }
    }
    ;

    public int addMessage(int parentId, String createdBy, String subject, String body, Date DateAdded, Date modifyDate) {
        // Create a new member
        Message newMessage = new Message();
        newMessage.setIdFather(parentId);
        newMessage.setAuthor(createdBy);
        newMessage.setAuthor(subject);
        newMessage.setBody(body);
        newMessage.setDataOfAdd(DateAdded);
        newMessage.setDateOfEdit(modifyDate);
        int id = getCounter() + 1;
        newMessage.setNumber(getCounter() + 1);

        // add messega to MAIN
        if (parentId == 0) {
            createMessage(newMessage);
        } // add messega in TREE
        else {
            Message Aba = findMessage(parentId);
            if (Aba != null) {
                createMessage(newMessage);
            } // didnt find perent, put in MAIN
            else {

                newMessage.setNumber(0);
                createMessage(newMessage);
            }
        }

        return id;

    }

    public String userExists(String username) {
        Members oneOfMembers = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Members as members where members.UserName is '" + username + "'");
            oneOfMembers = (Members) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (oneOfMembers != null) {
            return oneOfMembers.getPassword();
        } else {
            return null;
        }
    }
    ;

    public boolean checkUsername(String username) {
        Members oneOfMembers = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Members as members where members.UserName is '" + username + "'");
            oneOfMembers = (Members) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (oneOfMembers != null) {
            return true;

        } else {
            return false;

        }
    }

    public void editMessage(int messageId, String newSubject, String newBody, Date dateModified) {


        Message msg = findMessage(messageId);
        msg.setTitle(newSubject);
        msg.setBody(newBody);
        msg.setDateOfEdit(dateModified);
        updateMessage(msg);
    }

    /**
     *
     * @param messageId
     * @throws MessageNotFoundException
     */
    public void deleteMessage(int messageId) throws MessageNotFoundException {
        Message sonToRemove = findMessage(messageId);
        // find the messeage
        if (sonToRemove != null) {
            deleteMessage(sonToRemove);

        } else {
            throw new MessageNotFoundException("There is not son to delete. at no place!");

        }
    }

    /**
     *
     * @param username
     * @throws UserNotExistException
     */
    public void upgradeUser(String username) throws UserNotExistException {
        Members member = findMember(username);
        if (member == null) {
            throw new UserNotExistException();

        } else {
            member.setIsModerator(true);
            updateMember(member);
        }
    }

    /**
     *  this is just help funtion. It is taking at exsisting forum and clean it;
     */
    public void initForum() {
        List< Members>    MembersList = null;
    try {
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery ("from Members as members where * '");
        MembersList = (List<Members>) q.list();
    } catch (Exception e) {
        e.printStackTrace();
    }

        for (Members m : MembersList) {
            deleteMember(m);
        }
          List< Message>    MessagesList = null;
    try {
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery ("from Message as message where * '");
        MessagesList = (List<Message>) q.list();
    } catch (Exception e) {
        e.printStackTrace();
    }

        for (Message m : MessagesList) {
            deleteMessage(m);
        }
    }

    /*
     *    this function giving back member by his userName
     */

    public boolean getStatus(String username) {
        //  TODO change the admin check to status check
        return findMember(username).isIsAdmin();
    }

    /* add a Admin to the forum
     * @param userName
     * @param nickName
     * @param password
     * @param eMail
     * @param firstName
     * @param lastName
     * @param dateOfBirth
     */
    public void registerAdmin(String userName, String nickName, String password, String eMail, String firstName, String lastName, Date dateOfBirth) {
            // Create a new member
            Members newMember = new Members();
            newMember.setUserName(userName);
            newMember.setNickName(nickName);
            newMember.setPassword(password);
            newMember.setEmail(eMail);
            newMember.setFirstName(firstName);
            newMember.setLastName(lastName);
            newMember.setDataOfBirth(dateOfBirth);
            newMember.setIsAdmin(true);
            Date nowT = new Date();
            newMember.setDateOfJoin(nowT);
            //    newMember.setDateOfBirth(null);
            if (!checkUsername(userName)) {
               createMember(newMember);
            }
    }
    }
