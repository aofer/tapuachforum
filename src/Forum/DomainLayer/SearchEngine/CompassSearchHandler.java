/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer.SearchEngine;

import Forum.DomainLayer.Forum;
import Forum.DomainLayer.Interfaces.MessageInterface;
import Forum.DomainLayer.Logger.TapuachLogger;
import Forum.Exceptions.MessageNotFoundException;
import Forum.PersistentLayer.Data.MessageData;
import org.compass.core.CompassHit;
import org.compass.core.CompassHits;
import org.compass.core.CompassSession;

/**
 *
 * @author Arseny
 * 
 */
public class CompassSearchHandler implements SearchEngineInterface {

    public void addMessage(MessageInterface msg) {
        CompassSession cs = CompassInstance.getInstance().openSession();
        cs.beginTransaction();
               cs. save(msg);
          cs.commit();
          cs.close();
    }

    public void updateMessage(MessageInterface msg) {
        CompassInstance.getInstance().openSession().save(msg);
    }

    public void removeMessage(MessageInterface msg) {
                CompassInstance.getInstance().openSession().delete(msg);

    }

    public SearchHit[] searchByAuthor(String username, int from, int to) {
        CompassSession cs = CompassInstance.getInstance().openSession();
        cs.beginTransaction();
        CompassHits hits =  cs.find("author:\"" + username  + "\"");
      
        CompassHit[] detachedHits = hits.detach(from, to).getHits();
        SearchHit[] sh = new SearchHit[detachedHits.length];
        for(int i = 0; i<detachedHits.length;i++){
            try {
                sh[i] = new SearchHit((MessageInterface) Forum.getInstance().getMessage(((MessageData)(detachedHits[i])).getId()), detachedHits[i].score());
            } catch (MessageNotFoundException ex) {
                TapuachLogger.getInstance().severe("can't happen - no mesage found");
            }
        }
          cs.commit();
        cs.close();
        return sh;
    }

    
    public SearchHit[] searchByContent(String phrase, int from, int to) {
         CompassHits hits =  CompassInstance.getInstance().openSession().find("content:\"" + phrase  + "\"");
        CompassHit[] detachedHits = hits.detach(from, to).getHits();
        SearchHit[] sh = new SearchHit[detachedHits.length];
        for(int i = 0; i<detachedHits.length;i++){
      try {
                sh[i] = new SearchHit((MessageInterface) Forum.getInstance().getMessage(((MessageData)(detachedHits[i])).getId()), detachedHits[i].score());
            } catch (MessageNotFoundException ex) {
                TapuachLogger.getInstance().severe("can't happen - no mesage found");
            }
        }
        return sh;
    }


}
