package mathException;

/**
 * 
 * @author LT
 * The class GMatrixInverseException and its subclasses are a form of Exception that indicates conditions that a reasonable application might want to catch.
 * Inverse of GMatrix's exception should be extends from this.
 * This exception must construct with message.
 * 
 */
public class GMatrixInverseException extends GMatrixException {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructs a new matrix subscript exception with default message as its detail message.
	 * @param message message should be "not square matrix" or "can't be inverse".
	 */
	public GMatrixInverseException(String message){
		super(message);
	}
}
