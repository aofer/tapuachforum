/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forum.PersistentLayer;

import Forum.PersistentLayer.Data.MemberData;
import Forum.PersistentLayer.Interfaces.XMLMemberInterface;
import Forum.PersistentLayer.Interfaces.eMemberType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


/**
 *
 * @author Nir
 */
public class SQLMemberHandler implements XMLMemberInterface {

    /**
     *
     * @return
     */

    Session session = null;



    public SQLMemberHandler() {
         this.session = SessionFactoryUtil.getInstance().getCurrentSession();
    }

    public List<MemberData> getMember() {
        List<MemberData> members = new ArrayList<MemberData>();
    List< Members>    MembersList = null;
    try {
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery ("from Members as members where * '");
        MembersList = (List<Members>) q.list();
    } catch (Exception e) {
        e.printStackTrace();
    }

        for (Members m : MembersList) {
            Date joined = m.getDateOfJoin();
            Date birth = m.getDateOfJoin();
            members.add(new MemberData(m.getUserName(), m.getNickName(), m.getPassword(),
                    m.getFirstName(), m.getLastName(), m.getEmail(), joined, birth));
        }
        return members;
    }

    public MemberData getMember(String userName) {
           Members   oneOfMembers = null;
    try {
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery ("from Members as members where members.UserName is '"+userName+"'");
        oneOfMembers = (Members) q.uniqueResult();
    } catch (Exception e) {
        e.printStackTrace();
    }
   
            if (oneOfMembers != null ) {
                Date joined = oneOfMembers.getDateOfJoin();
                Date birth = oneOfMembers.getDataOfBirth();
                return new MemberData(oneOfMembers.getUserName(), oneOfMembers.getNickName(), oneOfMembers.getPassword(),
                        oneOfMembers.getFirstName(), oneOfMembers.getLastName(), oneOfMembers.getEmail(), joined, birth);
            }
        
        return null;
    }

    public eMemberType getMemberType(String userName) {
                 Members   oneOfMembers = null;
    try {
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery ("from Members as members where members.UserName is '"+userName+"'");
        oneOfMembers = (Members) q.uniqueResult();
    } catch (Exception e) {
        e.printStackTrace();
    }
               if (oneOfMembers != null ) {
                if (oneOfMembers.isIsAdmin()) {
                    return (eMemberType.Admin);
                } else if (oneOfMembers.isIsModerator()) {
                    return (eMemberType.Moderator);
                } else {
                    return eMemberType.member;
                }
            
        }
        return (null);
    }
}


