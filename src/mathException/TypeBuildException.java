package mathException;

/**
 * 
 * @author LT
 * 
 * The class TypeBuildException and its subclasses are a form of Exception that indicates conditions that a reasonable application might want to catch. 
 * Any type build Exception should be extends from this.  
 *
 */

public class TypeBuildException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new build exception with default message as its detail message.
	 */
	public TypeBuildException(){
		super();
	}
	
	/**
	 * Constructs a new build exception with the specified detail message.
	 * @param message
	 */
	public TypeBuildException(String message){
		super(message);
	}
	
}
