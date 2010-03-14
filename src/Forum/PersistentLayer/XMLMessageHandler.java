/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forum.PersistentLayer;

import Exceptions.RequiredMessageWasntFoundException;
import Forum.PersistentLayer.Interfaces.MessageInterface;
import java.util.Date;

/**
 *
 * @author Arseny
 */
public class XMLMessageHandler implements MessageInterface {

    private XMLFileHandler xf;

    public XMLMessageHandler(XMLFileHandler xf) {
        this.xf = xf;
    }

    public int getParentId(int messageID) throws RequiredMessageWasntFoundException {
        for (MessageType m : this.xf.getForum().getMessages()) {
            if (m.getMessageId().intValue() == messageID) {
                return m.getParentId().intValue();
            }
        }
        RequiredMessageWasntFoundException e = new RequiredMessageWasntFoundException("message not exists");
        throw e;

    }

    public String getSubject(int messageID) throws RequiredMessageWasntFoundException {
        for (MessageType m : this.xf.getForum().getMessages()) {
            if (m.getMessageId().intValue() == messageID) {
                return m.getSubject();
            }
        }

        RequiredMessageWasntFoundException e = new RequiredMessageWasntFoundException("message not exists");
        throw e;
    }

    public String getContent(int messageID) throws RequiredMessageWasntFoundException {
        for (MessageType m : this.xf.getForum().getMessages()) {
            if (m.getMessageId().intValue() == messageID) {
                return m.getBody();
            }
        }

        RequiredMessageWasntFoundException e = new RequiredMessageWasntFoundException("message not exists");
        throw e;
    }

    public String getUsername(int messageID) throws RequiredMessageWasntFoundException {
        for (MessageType m : this.xf.getForum().getMessages()) {
            if (m.getMessageId().intValue() == messageID) {
                return m.getCreatedBy();
            }
        }

        RequiredMessageWasntFoundException e = new RequiredMessageWasntFoundException("message not exists");
        throw e;
    }

    public Date getDateAdded(int messageID) throws RequiredMessageWasntFoundException {
        for (MessageType m : this.xf.getForum().getMessages()) {
            if (m.getMessageId().intValue() == messageID) {
                return m.getDateAdded().toGregorianCalendar().getTime();
            }
        }

        RequiredMessageWasntFoundException e = new RequiredMessageWasntFoundException("message not exists");
        throw e;
    }

    public void setSubject(int messageID, String newSubject) throws RequiredMessageWasntFoundException {
        boolean success = false;
        for (MessageType m : this.xf.getForum().getMessages()) {
            if (m.getMessageId().intValue() == messageID) {
                m.setSubject(newSubject);
                success = true;
                break;
            }

        }
        if (!success) {
            RequiredMessageWasntFoundException e = new RequiredMessageWasntFoundException("message not exists, can't edit");
            throw e;
        }


    }

    public void setContent(int messageID, String newContent) throws RequiredMessageWasntFoundException {
        boolean success = false;
        for (MessageType m : this.xf.getForum().getMessages()) {
            if (m.getMessageId().intValue() == messageID) {
                m.setBody(newContent);
                success = true;
                break;
            }

        }
        if (!success) {
            RequiredMessageWasntFoundException e = new RequiredMessageWasntFoundException("message not exists, can't edit");
            throw e;
        }


    }
}
