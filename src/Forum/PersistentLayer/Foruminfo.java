package Forum.PersistentLayer;
// Generated 00:53:19 05/05/2010 by Hibernate Tools 3.2.1.GA



/**
 * Foruminfo generated by hbm2java
 */
public class Foruminfo  implements java.io.Serializable {


     private String name;
     private int numOfMessages;

    public Foruminfo() {
    }

    public Foruminfo(String name, int numOfMessages) {
       this.name = name;
       this.numOfMessages = numOfMessages;
    }
   
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public int getNumOfMessages() {
        return this.numOfMessages;
    }
    
    public void setNumOfMessages(int numOfMessages) {
        this.numOfMessages = numOfMessages;
    }




}


