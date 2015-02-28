package mathException;

/**
 * 
 * @author LT
 * 
 * The class GTypeTransformException and its subclasses are a form of Exception that indicates conditions that a reasonable application might want to catch. 
 * Any operator of type transform Exception should be extends from this.  
 *
 */
public class GTypeTransformException extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructs a new type transform exception with default message as its detail message.
	 */
	public GTypeTransformException(){
		super();
	}
	
	/**
	 * Constructs a new type transform exception with the specified detail message. 
	 * @param message
	 */
	public GTypeTransformException(String message){
		super(message);
	}

}
