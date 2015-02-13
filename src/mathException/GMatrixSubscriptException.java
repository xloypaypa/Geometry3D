package mathException;

/**
 * 
 * @author LT
 * The class GMatrixSubscriptException and its subclasses are a form of Exception that indicates conditions that a reasonable application might want to catch.
 * Any subscript of GMatrix's exception should be extends from this.
 * 
 */
public class GMatrixSubscriptException extends GMatrixException {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructs a new matrix subscript exception with default message as its detail message.
	 */
	public GMatrixSubscriptException(){
		super("Matrix Operator Exception");
	}
	/**
	 * Constructs a new matrix subscript exception with the specified detail message.
	 * @param message
	 */
	public GMatrixSubscriptException(String message){
		super(message);
	}
}
