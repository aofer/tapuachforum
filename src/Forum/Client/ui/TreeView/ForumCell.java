package Forum.Client.ui.TreeView;

import Forum.DomainLayer.Message;
import java.util.Vector;

/**
 * A forum cell is the an object that is attached to each node in the tree (JTree).
 * 
 * @author Tomer Heber
 */
public class ForumCell {
	
	/**
	 * A unique identifier of a message. 
	 */
	private long _id;
	
	private String _userName;
	private String _subject;
    private String _body;
	
	/**
	 * The sons of this ForumCell.
	 */
	private Vector<ForumCell> m_sons;

    public ForumCell(Message msg){
        this(msg.getIndex(), msg.getNickname(), msg.getSubject(), msg.getBody());
        for (Message m : msg.getReplies()) {
            add(new ForumCell(m));
        }
    }
	public ForumCell(long id, String userName, String subject,String body) {
		_id = id;
		_userName = userName;
		_subject = subject;
        _body=body;
		m_sons = new Vector<ForumCell>();
	}

	public Vector<ForumCell> getSons() {
		return m_sons;
	}
	/**
	 * Add a ForumCell cell to the the sons vector of this cell.
	 * 
	 * @param cell The cell to be added as a son to this cell.
	 */
	public void add(ForumCell cell) {
		m_sons.add(cell);
	}

    /**
     * @return the _subject
     */
    public String getSubject() {
        return _subject;
    }

    /**
     * @param subject the _subject to set
     */
    public void setSubject(String subject) {
        this._subject = subject;
    }

    /**
     * @return the _body
     */
    public String getBody() {
        return _body;
    }

    /**
     * @param body the _body to set
     */
    public void setBody(String body) {
        this._body = body;
    }

    /**
     * @return the _userName
     */
    public String getUserName() {
        return _userName;
    }

    /**
     * @return the m_id
     */
    public long getId() {
        return _id;
    }
    @Override
    public String toString(){
        return "abc";
    }

}
