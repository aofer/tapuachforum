package Forum.PersistentLayer;
// Generated 00:53:19 05/05/2010 by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Message generated by hbm2java
 */
public class Message  implements java.io.Serializable {


     private int number;
     private String title;
     private String body;
     private String author;
     private int idFather;
     private Date dateOfAdd;
     private Date dateOfEdit;

    public Message() {
    }

	
    public Message(int number, String author, int idFather, Date dateOfAdd, Date dateOfEdit) {
        this.number = number;
        this.author = author;
        this.idFather = idFather;
        this.dateOfAdd = dateOfAdd;
        this.dateOfEdit = dateOfEdit;
    }
    public Message(int number, String title, String body, String author, int idFather, Date dateOfAdd, Date dateOfEdit) {
       this.number = number;
       this.title = title;
       this.body = body;
       this.author = author;
       this.idFather = idFather;
       this.dateOfAdd = dateOfAdd;
       this.dateOfEdit = dateOfEdit;
    }
   
    public int getNumber() {
        return this.number;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getBody() {
        return this.body;
    }
    
    public void setBody(String body) {
        this.body = body;
    }
    public String getAuthor() {
        return this.author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getIdFather() {
        return this.idFather;
    }
    
    public void setIdFather(int idFather) {
        this.idFather = idFather;
    }
    public Date getDateOfAdd() {
        return this.dateOfAdd;
    }
    
    public void setDateOfAdd(Date dateOfAdd) {
        this.dateOfAdd = dateOfAdd;
    }
    public Date getDateOfEdit() {
        return this.dateOfEdit;
    }
    
    public void setDateOfEdit(Date dateOfEdit) {
        this.dateOfEdit = dateOfEdit;
    }




}

