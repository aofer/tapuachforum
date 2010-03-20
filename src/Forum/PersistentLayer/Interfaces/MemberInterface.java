package Forum.PersistentLayer.Interfaces;

import Forum.PersistentLayer.Data.MemberData;

/**
*
* @author Liron Katav
*/

public interface MemberInterface {
    MemberData getMember(String userName);
}
