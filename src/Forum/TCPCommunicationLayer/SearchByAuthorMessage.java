/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.TCPCommunicationLayer;

import Forum.DomainLayer.Forum;
import Forum.DomainLayer.SearchEngine.SearchHit;

/**
 *
 * @author amit
 */
public class SearchByAuthorMessage extends ClientMessage{

     /**
     *The nickname of the author who wrote the message.
     */
    private String m_nickname;
    /**
     * hits from index from
     */
    private int m_from;
    /**
     * hits until index to
     */
    private int m_to;

    public SearchByAuthorMessage(String nickname,int from,int to){
        this.m_nickname = nickname;
        this.m_from = from;
        this.m_to = to;
    }

    public ServerResponse doOperation(Forum forum) {
        SearchHit[] tHits = Forum.getInstance().searchByAuthor(m_nickname, m_from, m_to);
        String tRes = "";
        for (int i = 0;i < tHits.length;i++){
            tRes = tRes + tHits[i].toString() + "\n";
        }
        ServerResponse tResponse = new ServerResponse(tRes, true);
        return tResponse;
    }

}
