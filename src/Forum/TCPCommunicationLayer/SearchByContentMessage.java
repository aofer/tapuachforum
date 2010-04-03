/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.TCPCommunicationLayer;

import Forum.DomainLayer.Forum;
import Forum.DomainLayer.SearchEngine.SearchHit;

/**
 *
 * @author amit ofer
 */
public class SearchByContentMessage extends ClientMessage {

    /**
     * the phrase that the user would like to search
     */
    private String m_phrase;
    /**
     * hits from index from
     */
    private int m_from;
    /**
     * hits until index to
     */
    private int m_to;

    public SearchByContentMessage(String phrase,int from,int to){
        this.m_phrase = phrase;
        this.m_from = from;
        this.m_to = to;
    }

    public ServerResponse doOperation() {
        SearchHit[] tHits = Forum.getInstance().searchByContent(m_phrase, m_from, m_to);
        String tRes = "";
        for (int i = 0;i< tHits.length;i++){
            tRes = tRes + tHits[i].toString() + "\n";
        }
        ServerResponse tResponse = new ServerResponse(tRes,true);
        return tResponse;

    }

}
