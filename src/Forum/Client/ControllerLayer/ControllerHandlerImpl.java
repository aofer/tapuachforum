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
import Forum.TCPCommunicationLayer.LogoffMessage;
import Forum.TCPCommunicationLayer.MembersMessage;
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
        handleTreeEvents(new ModifyMessageMessage(id, subject, body), comp);
    }

    @Override
    public void addReplyToMessage(long id, String subject, String body, Component comp) {
        handleTreeEvents(new AddReplyMessage(id, subject, body), comp);
    }

    @Override
    public void deleteMessage(long id, Component comp) {
        handleTreeEvents(new DeleteMessageMessage(id), comp);
    }

    @Override
    public void addNewMessage(String subject, String body, Component comp) {
        handleTreeEvents(new AddMessageMessage(subject, body), comp);
    }

    @Override
    public void searchByAuthor(String nickname, int from, int to, Component comp) {
        handleSearchEvents(new SearchByAuthorMessage(nickname, from, to), comp);
    }

    @Override
    public void searchByContent(String phrase, int from, int to, Component comp) {
        handleSearchEvents(new SearchByContentMessage(phrase, from, to), comp);
    }

    @Override
    public void login(String username, String password, Component comp) {
        _connectionController.send(new LoginMessage(username, password));
        ServerResponse res = _connectionController.listen();
        if (res.hasExecuted()) {
            notifyObservers(new LoginEvent(comp, username));
        } else {
            notifyObservers(new ForumTreeErrorEvent(res.getResponse()));
        }
    }

    @Override
    public void register(String firstName, String lastName, String nickname, String email, String username, String password, Component comp) {
        _connectionController.send(new RegisterMessage(firstName, lastName, nickname, email, username, password));
        ServerResponse res = _connectionController.listen();
        if (res.hasExecuted()) {
            notifyObservers(new RegisterEvent(comp));
        } else {
            notifyObservers(new ForumTreeErrorEvent(res.getResponse()));
        }
    }

    @Override
    public void modifyMessage(long id, String content, Component comp) {
        handleTreeEvents(new ModifyMessageMessage(id, "", content), comp);
    }

    private void handleMemberEvents(ClientMessage msg, Component comp) {
        ServerResponse res;
        _connectionController.send(msg);
        res = _connectionController.listen();
        if (res.hasExecuted()) {
            notifyObservers(new ForumTreeRefreshEvent(comp, getForumView()));
        } else {
            notifyObservers(new ForumTreeErrorEvent(res.getResponse()));
        }
    }

    private void handleTreeEvents(ClientMessage msg, Component comp) {
        ServerResponse res;
        _connectionController.send(msg);
        res = _connectionController.listen();
        if (res.hasExecuted()) {
            notifyObservers(new ForumTreeRefreshEvent(comp, getForumView()));
        } else {
            notifyObservers(new ForumTreeErrorEvent(res.getResponse()));
        }
    }

    private void handleSearchEvents(ClientMessage msg, Component comp) {
        ServerResponse res;
        _connectionController.send(msg);
        res = _connectionController.listen();
        if (res.hasExecuted()) {
            notifyObservers(new ForumTreeRefreshEvent(comp, res.getResponse()));
        } else {
            notifyObservers(new ForumTreeErrorEvent(res.getResponse()));
        }
    }

    @Override
    public void getMembers(Component comp) {
        ServerResponse res;
        _connectionController.send(new MembersMessage());
        res = _connectionController.listen();
        if (res.hasExecuted()) {
            notifyObservers(new ForumTreeRefreshEvent(comp, res.getResponse()));
        } else {
            notifyObservers(new ForumTreeErrorEvent(res.getResponse()));
        }
    }

    @Override
    public void logoff(Component comp) {
        handleMemberEvents(new LogoffMessage(), comp);
    }
}
