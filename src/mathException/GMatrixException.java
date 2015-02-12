package mathException;

/**
 * 
 * @author LT
 * 
 * The class GMatrixException and its subclasses are a form of Exception that indicates conditions that a reasonable application might want to catch. 
 * Any operator of GMatrix's Exception should be extends from this.  
 *
 */
public class GMatrixException extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructs a new matrix exception with default message as its detail message.
	 */
	public GMatrixException(){
		super("Matrix exception.");
	}
	/**
	 * Constructs a new matrix exception with the specified detail message. 
	 * @param message
	 */
	public GMatrixException(String message){
		super(message);
	}
}
