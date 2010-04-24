package Forum.Client.ControllerLayer;

import Forum.TCPCommunicationLayer.AddMessageMessage;
import Forum.TCPCommunicationLayer.AddReplyMessage;
import Forum.TCPCommunicationLayer.ClientMessage;
import Forum.TCPCommunicationLayer.DeleteMessageMessage;
import Forum.TCPCommunicationLayer.ModifyMessageMessage;
import Forum.TCPCommunicationLayer.ServerResponse;
import java.awt.Component;

import Forum.Client.ui.events.*;
import Forum.TCPCommunicationLayer.LoginMessage;
import Forum.TCPCommunicationLayer.RegisterMessage;
import Forum.TCPCommunicationLayer.SearchByAuthorMessage;
import Forum.TCPCommunicationLayer.SearchByContentMessage;
import Forum.TCPCommunicationLayer.ViewForumMessage;

/**
 * You need to delete all the code in here and implement it yourself.<br>
 * This code is just for you to understand how to work with the Observer/Observed and GUI.
 * 
 * @author Tomer Heber
 */
public class ControllerHandlerImpl extends ControllerHandler {

    public ControllerHandlerImpl() {
        super();

    }

    @Override
    public String getForumView() {
        ServerResponse res;
        _connectionController.send(new ViewForumMessage());
        res = _connectionController.listen();
        return res.getResponse();
    }

    @Override
    public void modifyMessage(long id, String subject, String body, Component comp) {
        handleEvent(new ModifyMessageMessage(id, subject, body), comp);
    }

    @Override
    public void addReplyToMessage(long id, String subject, String body, Component comp) {
        handleEvent(new AddReplyMessage(id, subject, body), comp);
    }

    @Override
    public void deleteMessage(long id, Component comp) {
        handleEvent(new DeleteMessageMessage(id), comp);
    }

    @Override
    public void addNewMessage(String subject, String body, Component comp) {
        handleEvent(new AddMessageMessage(subject, body), comp);
    }

    @Override
    public void searchByAuthor(String nickname, int from, int to, Component comp) {
        handleEvent(new SearchByAuthorMessage(nickname, from, to), comp);
    }

    @Override
    public void searchByContent(String phrase, int from, int to, Component comp) {
        handleEvent(new SearchByContentMessage(phrase, from, to), comp);
    }

    @Override
    public void login(String username, String password, Component comp) {
        handleEvent(new LoginMessage(username, password), comp);
    }

    @Override
    public void register(String firstName, String lastName, String nickname, String email, String username, String password, Component comp) {
        handleEvent(new RegisterMessage(firstName, lastName, nickname, email, username, password), comp);
    }

    @Override
    public void modifyMessage(long id, String content, Component comp) {
        handleEvent(new ModifyMessageMessage(id, "", content), comp);
    }

    private void handleEvent(ClientMessage msg, Component comp) {
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
