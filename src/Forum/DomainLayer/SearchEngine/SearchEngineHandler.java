/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer.SearchEngine;

import Forum.DomainLayer.Interfaces.MessageInterface;
import Forum.Exceptions.MessageNotFoundException;
import java.util.List;
import java.util.ListIterator;
import Forum.DomainLayer.Forum;
import Forum.DomainLayer.Logger.TapuachLogger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Arseny
 */
public class SearchEngineHandler implements SearchEngineInterface {

    private SearchDataInterface _searchData;

    public SearchEngineHandler() {
        _searchData = new SearchData();
    }


    //should init the search index
    /*public void init()
{
       //Vector<MessageInterface> entireForum = new Vector<MessageInterface>();
        //List<Integer> threadsIds =.getRepliesIds(0);
}*/

    public void addData(MessageInterface msg) {
       _searchData.addMessage(msg);
    }

    public SearchHit[] searchByAuthor(String username, int from, int to) {
        int n  = to-from-1; int i=0;
        SearchHit[] sh = new SearchHit[n];
        List<Integer> li =_searchData.getByAuthor(username);
        ListIterator<Integer> lit = li.listIterator();
        Forum f = Forum.getInstance();
        while(i<=n)
        {
            try {
                MessageInterface m = f.getMessage(lit.next());
                sh[i] = new SearchHit(m, 0);//@TODO by arseny.. how the score is determined??
                i++;
            } catch (MessageNotFoundException ex) {
                TapuachLogger tl = TapuachLogger.getInstance();
                tl.fine("message number" + ex.toString() + "not found");
            }

        }
        return sh;
    }

    public SearchHit[] searchByContent(String phrase, int from, int to) {
        int n  = to-from-1; int i=0;
        SearchHit[] sh = new SearchHit[n];
        //List<Integer> li =_searchData.getByContent(phrase);
        
        Set<Integer> li = new HashSet<Integer>();
        String[] body = phrase.split(" ");
        for(i = 0; i < body.length; i++) {
            List<Integer> l =_searchData.getByContent(body[i]);
            for(Integer it : l){
                li.add(it);
            }
        }
        Iterator<Integer> lit = li.iterator();
        Forum f = Forum.getInstance();
        while(i<=n)
        {
            try {
                MessageInterface m = f.getMessage(lit.next());
                sh[i] = new SearchHit(m, 0);//@TODO by arseny.. how the score is determined??
                i++;
            } catch (MessageNotFoundException ex) {
                TapuachLogger tl = TapuachLogger.getInstance();
                tl.fine("message number" + ex.toString() + "not found");
            }

        }
        return sh;
    }

public void RemoveMessage(MessageInterface m ){
    _searchData.removeMessage(m);
}
}
