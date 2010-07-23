
import Forum.DomainLayer.Forum;
import Forum.DomainLayer.Member;
import Forum.PersistentLayer.Data.MemberData;
import Forum.PersistentLayer.ForumHandler;
import Forum.PersistentLayer.Interfaces.ForumHandlerInterface;
import Forum.PersistentLayer.Interfaces.XMLMemberInterface;
import Forum.PersistentLayer.Interfaces.XMLMessageInterface;
import Forum.PersistentLayer.SQLForumHandler;
import Forum.PersistentLayer.SQLMemberHandler;
import Forum.PersistentLayer.SQLMessageHandler;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kipi
 */
public class ForumLogoff {

    public static void main(String[] args) {

        ForumHandlerInterface sqlForumHandler = new SQLForumHandler();
        XMLMemberInterface sqlMemberHandler = new SQLMemberHandler();
        List<MemberData> mmbrs = sqlMemberHandler.getMembers();
        for (MemberData memberData : mmbrs) {
            sqlForumHandler.logoff(memberData.getUserName());
        }
    }
}
