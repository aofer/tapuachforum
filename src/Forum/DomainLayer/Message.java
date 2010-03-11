/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer;

import java.util.Vector;

/**
 *
 * @author Arseny
 */
public class Message {
 private String nick;
 private String title;
 private String body;
 private Vector<Message> comments;
}
