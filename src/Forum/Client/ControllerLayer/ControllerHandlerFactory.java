package Forum.Client.ControllerLayer;


/**
 * @author Tomer Heber
 *
 */
public class ControllerHandlerFactory {
	
	/**
	 * 
	 * @return An implementation of the ControllerHandler pipe.
	 */
	public static ControllerHandler getPipe() {
		return new ControllerHandlerImpl();
	}

}
