/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer.SearchEngine;

import Forum.DomainLayer.Interfaces.MessageInterface;
import org.compass.core.CompassHit;
import org.compass.core.CompassHits;

/**
 *
 * @author Arseny
 * 
 */
public class CompassSearchHandler implements SearchEngineInterface {

    public void addMessage(MessageInterface msg) {
        CompassInstance.getInstance().openSession().save(msg);
    }

    public void updateMessage(MessageInterface msg) {
        CompassInstance.getInstance().openSession().save(msg);
    }

    public void removeMessage(MessageInterface msg) {
                CompassInstance.getInstance().openSession().delete(msg);

    }

    public SearchHit[] searchByAuthor(String username, int from, int to) {
         CompassHits hits =  CompassInstance.getInstance().openSession().find("name:\"" + username  + "\"");
        CompassHit[] detachedHits = hits.detach(from, to).getHits();
        SearchHit[] sh = new SearchHit[detachedHits.length];
        for(int i = 0; i<detachedHits.length;i++){
            sh[i] = new SearchHit((MessageInterface) detachedHits[i].data(),detachedHits[i].score());
        }
        return sh;
    }

    
    public SearchHit[] searchByContent(String phrase, int from, int to) {
         CompassHits hits =  CompassInstance.getInstance().openSession().find("content:\"" + phrase  + "\"");
        CompassHit[] detachedHits = hits.detach(from, to).getHits();
        SearchHit[] sh = new SearchHit[detachedHits.length];
        for(int i = 0; i<detachedHits.length;i++){
            sh[i] = new SearchHit((MessageInterface) detachedHits[i].data(),detachedHits[i].score());
        }
        return sh;
    }


}
