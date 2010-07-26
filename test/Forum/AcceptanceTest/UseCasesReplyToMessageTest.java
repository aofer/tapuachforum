
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.AcceptanceTest;
import org.junit.Test;
/**
 *
 * @author Nir
 */
public class UseCasesReplyToMessageTest extends TestProject  {


    /**
     * Test Reply To Message Use Case
     * This test check  reply to message on the system.
     * the case: (Member) wants to add message and than to reply to it easily and effectively.
     * the expResult: Succes. The reply has been saved .
        */
    @Test
    public void testReplyToMessageUseCase1() {
            String expResult = "The reply as been saved.";
            login("Bob","bobPasss");
            addMessage( "my message","this is my message");
            String result = replyToMessage(2, "I want to reply to message", "I hope it will succed");
            assertEquals(expResult, result);
            logout("Bob");
    }

    /**
     * Test Reply To Message Use Case
     * This test check  reply to message on the system.
     * the case: (Guest)  wants to add message and then to reply to it  without login..
     * the expResult: Failure.The system shows a "User is not login" message.,
        */
    @Test
    public void testReplyToMessageUseCase2() {
            String expResult = "User is not login";
            login("Bob","bobPasss");
            addMessage ( "my message", "this is my message");
             logout("Bob");
              String result = replyToMessage(4, "Reply again", "I wnat to reply again.");
            assertEquals(expResult, result);
    }
}