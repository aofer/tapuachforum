
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
public class UseCasesAddMessageTest extends TestProject  {


    /**
     * Test Add Message Use Case
     * This test check add message to the system.
     * the case:(Member) wants to submit his message easily and effectively.
     * the expResult: Succes.the message is correctly saved and displayed in the forum in the right place.
        */
    @Test
    public void testAddMessageUseCase1() {
            String expResult = "the message is correctly saved";
            login("Bob","bobPasss");
            String result = addMessage ( "my message","this is my message");
            assertEquals(expResult, result);
            logout("Bob");
    }

    /**
     * Test Add Message Use Case
     * This test check add message to the system.
     * the case: (Guest)   wants to submit his message without login..
     * the expResult: Failure.The system shows a "User is not login" message.,
        */
    @Test
    public void testAddMessageUseCase2() {
            String expResult = "User is not login";
            String result = addMessage ( "my message", "this is my message");
            assertEquals(expResult, result);
    }
}