package baseType;
/**
 * this is a base class of N Dimension Point && Vector;
 * @author jyk
 * 2015/02/12
 */
public class GMatrix {
	
	protected float[] mat;		//matrix

	protected int n;			//row			
	
	protected int m;			//column
	
	
	/**
	 * Create a Matrix by the row and Column;
	 * @param row
	 * the number of rows of the matrix;
	 * @param column
	 * the number of columns of the matrix;
	 */
	public GMatrix( int row, int column)
	{
		this.n = row;
		this.m = column;
		this.mat = new float[row*column];
	}
	
	
	/**
	 * Create a Matrix by a Matrix;
	 * @param mat
	 * the matrix need to be copied;
	 */
	public GMatrix( GMatrix mat )
	{
		this.n = mat.getRowNumber();
		this.m = mat.getColumnNumber();
		this.mat = mat.getMatrix();
	}
	
	
	/**
	 * get the number of rows of the matirx;
	 * @return
	 * the number of rows of the matirx;
	 */
	public int getRowNumber()
	{
		return n;
	}
	
	
	/**
	 * get the number of Columns of the matirx;
	 * @return
	 * the number of Columns of the matirx;
	 */
	public int getColumnNumber()
	{
		return m;
	}
	
	
	/**
	 * get the matirx;
	 * @return
	 * the matirx;
	 */
	public float[] getMatrix()
	{
		return mat;
	}
	
	
	/**
	 * get the number in the matrix;
	 * @param row
	 * the number of rows of the matrix;
	 * @param column
	 * the number of columns of the matrix;
	 * @return
	 * the number at row rows and the column columns in the matrix;
	 */
	public float get(int row,int column)
	{
		return mat[row * m +column];
	}
	
	
	/**
	 * set the number in the matrix;
	 * @param row
	 * the number of rows of the matrix;
	 * @param column
	 * the number of columns of the matrix;
	 * @param f
	 * the number need set in the matrix;
	 */
	public void set(int row,int column,float f)
	{
		mat[row * m +column] = f;
	}
	
	
	/**
	 * 
	 * @param mat
	 */
	public GMatrix multiplication ( GMatrix mat )
	{
		
	}
	
	
	public GMatrix addition ( GMatrix mat )
	{
		
	}
	
	
	public GMatrix subtraction ( GMatrix mat )
	{
	}
	
	

}
