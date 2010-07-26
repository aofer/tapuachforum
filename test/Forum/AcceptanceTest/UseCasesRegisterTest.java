
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
public class UseCasesRegisterTest extends TestProject  {


    /**
     * Test Register Use Case
     * This test check register of user to the system.
     * the case:(Guest) Wants to register to the system easily and comfortably. 
        * the format is : first name, last name, nick name , user name, password, e-mail.
   * the expResult: Succes. The user registers the system, the user's details are saved in the system.
        */
    @Test
    public void testRegisterUseCase1() {
            String expResult = "user was add and data was saved";
            String result = register("Bob", "Spong", "boby", "Bob", "bobPasss", "bob@animation.com");
            assertEquals(expResult, result);

    }

    /**
     * Test Register Use Case
     * This test check register of user to the system.
     * the case: the user chooses a user name that already exists- "Bob".
      * the format is : first name, last name, nick name , user name, password, e-mail.
      * the expResult: Failure.The system shows a "username already exists" message,
     * and the user is required to choose a different username.
        */
    @Test
    public void testRegisterUseCase2() {
            String expResult = "username already exists";
            String result = register("Bob", "Builder", "TheBuilder", "Bob", "buiLderR", "builder@animation.com");
            assertEquals(expResult, result);
    }

    /**
     * Test Register Use Case
     * This test check register of user to the system.
     * the case:  the user chooses a nickname that already exists- "boby".
     * the format is : first name, last name, nick name , user name, password, e-mail.
     * the expResult: Failure.The system shows a "nickname already exists" message,
     * and the user is required to choose a different nickname.
     */
  
    @Test
    public void testRegisterUseCase3() {
            String expResult = "nickname already exists";
            String result = register("Bob", "Marly", "boby", "bobM", "reagyYYY", "bob@singers.com");
            assertEquals(expResult, result);
    }

    /**
     * Test Register Use Case
     * This test check register of user to the system.
     * the case:  the user chooses a password that does not meet the required policy- "a".
     * the format is : first name, last name, nick name , user name, password, e-mail.
     * the expResult: Failure. The system shows a "password does not meet the policy" message
      *   and the user may choose to view the password policy.
     */
    @Test
    public void testRegisterUseCase4() {
            String expResult = "password does not meet the policy";
            String result = register("Bob", "Alise", "BA", "AB", "a", "bob@codes.com");
            assertEquals(expResult, result);
    }
}
