/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forum.TCPCommunicationLayer;

import Forum.DomainLayer.Interfaces.MessageInterface;
import Forum.DomainLayer.Message;
import Forum.PersistentLayer.Data.MessageData;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author Kipi
 */
public class MessagesParser {

    static DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static String Encode(MessageInterface msg) {
        String str;
        //DateFormat  formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        str = " <message>";
        str += "id:" + msg.getIndex();
        str += "user:" + msg.getNickname();
        str += "subject:" + msg.getSubject();
        str += "body:" + msg.getBody();
        str += "WriteDate:" + formatter.format(msg.getWriteDate());
        str += "ModifiedDate:" + formatter.format(msg.getModifiedDate());

        for (Iterator<Message> it = msg.getReplies().iterator(); it.hasNext();) {
            Message message = it.next();
            str += Encode(message);
        }
        str += " </message>";
        return str;
    }

    public static Vector<Message> Decode(String str) {
        int len = str.length();
        int pos = 1;
        int msgStart;
        int msgEnd;
        Vector<Message> msgVec = new Vector<Message>();
        Message msg;

        while (pos < len) {
            msgStart = str.indexOf("<message>", pos + 1);
            msgEnd = str.indexOf("</message>", pos);
            if (msgStart == -1 | msgEnd < msgStart) {
                msg = getMessage(str.substring(pos + 9, msgEnd));
                msgVec.add(msg);
                pos = msgEnd + 11;
            } else {
                msg = getMessage(str.substring(pos + 9, msgStart));
                msgEnd=getClosed(msgStart,str);
                msg.addReply(Decode(str.substring(msgStart - 1,msgEnd)));
                msgVec.add(msg);
                pos =msgEnd+11;
            }
        }
        return msgVec;
    }

    private static int getClosed(int index, String str) {
        int count = 0;
        int msgStart;
        int msgEnd;
        while (index < str.length()) {
            msgStart = str.indexOf("<message>", index);
            msgEnd = str.indexOf("</message>", index);

            if (msgStart!=-1 & msgStart < msgEnd) {
                count++;
                index = msgStart + 1;
            } else {
                if (count == 0) {
                    return msgEnd;
                } else {
                    count--;
                    index = msgEnd + 1;
                }
            }
        }
        return 0;
    }

    private static Message getMessage(String str) {
        int tmpIndex1 = str.indexOf("user:");
        int tmpIndex2 = str.indexOf("subject:");

        int id = Integer.parseInt(str.substring(3, tmpIndex1));
        String user = str.substring(tmpIndex1 + 5, tmpIndex2);
        tmpIndex1 = str.indexOf("body:");
        String sub = str.substring(tmpIndex2 + 8, tmpIndex1);
        tmpIndex2 = str.indexOf("WriteDate:");
        String body = str.substring(tmpIndex1 + 5, tmpIndex2);
        tmpIndex1 = str.indexOf("ModifiedDate:");
        Date d1 = null;
        Date d2 = null;
        try {
            System.out.println(str.substring(tmpIndex2 + 10, tmpIndex1));
            System.out.println(str.substring(tmpIndex1 + 13));
            d1 = formatter.parse(str.substring(tmpIndex2 + 10, tmpIndex1));
            d2 = formatter.parse(str.substring(tmpIndex1 + 13));
        } catch (ParseException ex) {
        }
        return new Message(new MessageData(user, sub, body, d1, d2, id));
    }
}
