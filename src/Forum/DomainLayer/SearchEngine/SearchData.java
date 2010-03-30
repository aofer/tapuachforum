/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forum.DomainLayer.SearchEngine;

import Forum.DomainLayer.Interfaces.MessageInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Kipi
 */
public class SearchData implements SearchDataInterface {

    private HashMap<String, List<Integer>> _words;
    private HashMap<String, List<Integer>> _authors;

    public SearchData() {
        _words = new HashMap<String, List<Integer>>();
        _authors = new HashMap<String, List<Integer>>();
    }

    public void addMessage(MessageInterface msg) {
        String[] body = msg.getBody().split(" ");
        for (int i = 0; i < body.length; i++) {
            addWord(body[i], msg);
        }
        addAuthor(msg.getNickname(), msg);
    }

    public void removeMessage(MessageInterface msg) {
        removeValue(_words, msg.getIndex());
        removeValue(_authors, msg.getIndex());
    }

    public List<Integer> getByContent(String str) {
        return _words.get(str);
    }

    public List<Integer> getByAuthor(String author) {
        return _authors.get(author);
    }

    private void removeValue(HashMap<String, List<Integer>> hash, Integer value) {
        for (Iterator<String> it = hash.keySet().iterator(); it.hasNext();) { //for each word
            String key = it.next();
            List<Integer> msgIndexs = hash.get(key);
            if (msgIndexs.contains(value)) { //if the list of  indexs contian the given message index
                msgIndexs.remove(value);
            }
            if (msgIndexs.isEmpty()) {
                hash.remove(key);
            }
        }
    }

    private void addWord(String word, MessageInterface msg) {
        if (!_words.containsKey(word)) { //there is no such word
            _words.put(word, new ArrayList<Integer>()); //init the list of messages
        }
        _words.get(word).add(msg.getIndex()); //add the messgae index to the given word list
    }

    private void addAuthor(String author, MessageInterface msg) {
        if (!_authors.containsKey(author)) { //there is no such author
            _words.put(author, new ArrayList<Integer>()); //init the list of messages
        }
        _words.get(author).add(msg.getIndex()); //add the messgae index to the given authors list
    }
}