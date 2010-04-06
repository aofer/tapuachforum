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
import Forum.DomainLayer.Message;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

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
  public void init()
{
    Forum f = Forum.getInstance();
    Vector<MessageInterface> v = f.viewForum();
    for(MessageInterface m : v){
        addData(m);
   //    if(m.getReplies() != null){
   //     processReplies(m.getReplies());
   //     }
    }
 }

    private void processReplies(Vector<Message> v){
        if(v.isEmpty()){//no replies
            return;
        }
        else{
            for(Message m : v){
                addData(m);
                 if(m.getReplies() != null){
                processReplies(m.getReplies());
            }
            }
        }
    }

    public void addData(MessageInterface msg) {
       _searchData.addMessage(msg);
    }

    public SearchHit[] searchByAuthor(String username, int from, int to) {
        int n  = to-from-1; int i=0;
       // next line changed by Nir from "n" to "n+1"
        SearchHit[] sh = new SearchHit[n+1];
        List<Integer> li =_searchData.getByAuthor(username);
        // next line have been canceled by Nir. We  don't need it
        //       ListIterator<Integer> lit = li.listIterator();
        Forum f = Forum.getInstance();
        while(i<=n & (li != null))
        {
            try {
            //  old
                //            MessageInterface m = f.getMessage(lit.next());
                // new by Nir
                MessageInterface m = f.getMessage(li.get(i).intValue());
                sh[i] = new SearchHit(m, 0);//@TODO by arseny.. how the score is determined??
                i++;
            } catch (MessageNotFoundException ex) {
                TapuachLogger tl = TapuachLogger.getInstance();
                tl.fine("message number" + ex.toString() + "not found");
            }

        }
        return sh;
    }

 //* new version , made by Nir.
     public SearchHit[] searchByContent(String phrase, int from, int to) {
        int n  = to-from-1; int i=0;
        SearchHit[] sh = new SearchHit[n+1];
        String[] body = phrase.split(" ");
        List<Integer> li =_searchData.getByContent(body[0]);
        Forum f = Forum.getInstance();
       i =1;
       int runOnBody = body.length;
          while( (li != null) & (i < runOnBody))
        {
                  li.addAll(_searchData.getByContent(body[i]));
                  i = i+1;

          }
       i = 0;
        while(i<=n & (li != null) & (i < li.size()))
        {
            try {
                MessageInterface m = f.getMessage(li.get(i).intValue());
                sh[i] = new SearchHit(m, 0);//@TODO by arseny.. how the score is determined??
                i++;
            } catch (MessageNotFoundException ex) {
                TapuachLogger tl = TapuachLogger.getInstance();
                tl.fine("message number" + ex.toString() + "not found");
            }

        }
       return sh;
     }
        /* old version
  /*  public SearchHit[] searchByContent(String phrase, int from, int to) {
        int n  = to-from-1; int i=0;
       // next line changed by Nir from "n" to "n+1"
        SearchHit[] sh = new SearchHit[n+1];
    //    List<Integer> li =_searchData.getByContent(phrase);
      
        Set<Integer> li = new HashSet<Integer>();
        String[] body = phrase.split(" ");
        for(i = 0; i < body.length; i++) {
            List<Integer> l =_searchData.getByContent(body[i]);
           if (l != null)
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
    }*/

public void RemoveMessage(MessageInterface m ){
    _searchData.removeMessage(m);
}
}
