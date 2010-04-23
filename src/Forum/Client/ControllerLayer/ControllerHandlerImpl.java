package forum.client.controllerlayer;

import Forum.Client.ControllerLayer.ClientConnectionController;
import Forum.TCPCommunicationLayer.AddMessageMessage;
import Forum.TCPCommunicationLayer.AddReplyMessage;
import Forum.TCPCommunicationLayer.ClientMessage;
import Forum.TCPCommunicationLayer.DeleteMessageMessage;
import Forum.TCPCommunicationLayer.ModifyMessageMessage;
import Forum.TCPCommunicationLayer.ServerResponse;
import java.awt.Component;

import forum.client.ui.events.*;

/**
 * You need to delete all the code in here and implement it yourself.<br>
 * This code is just for you to understand how to work with the Observer/Observed and GUI.
 * 
 * @author Tomer Heber
 */
public class ControllerHandlerImpl extends ControllerHandler {

    private ClientConnectionController _connectionController;

    @Override
    public String getForumView() {
        return "";
    }

    @Override
    public void modifyMessage(long id, String  subject,String body, Component comp) {
        hanndleEvent(new ModifyMessageMessage(id, subject, body),comp);
    }

    @Override
    public void addReplyToMessage(long id, String subject,String body, Component comp) {
        hanndleEvent(new AddReplyMessage(id, subject, body),comp);
    }

    @Override
    public void deleteMessage(long id, Component comp) {
        hanndleEvent(new DeleteMessageMessage(id),comp);
    }

    @Override
    public void addNewMessage(String subject,String body, Component comp) {
        hanndleEvent(new AddMessageMessage(subject, body),comp);
    }

    private void hanndleEvent(ClientMessage msg, Component comp) {
        ServerResponse res;
        _connectionController.send(msg);
        res = _connectionController.listen();
        if (res.hasExecuted()) {
            notifyObservers(new ForumTreeRefreshEvent(comp, getForumView()));
        } else {
            notifyObservers(new ForumTreeErrorEvent(res.getResponse()));
        }
    }
}
