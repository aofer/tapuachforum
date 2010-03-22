package Forum.PersistentLayer.Interfaces;

import Forum.PersistentLayer.Data.MemberData;

/**
*
* @author Liron Katav
*/

public interface XMLMemberInterface {
    /**
     * get the member data of the member
     * @param userName - the username of the member we need to get
     * @return - a MemberData object containing all the member's data
     */
    MemberData getMember(String userName);
}
