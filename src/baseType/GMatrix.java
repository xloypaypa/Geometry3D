package baseType;

import mathException.GMatrixSubscriptException;

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
	 * range from 0 to rows-1;
	 * the number of rows of the matrix;
	 * @param column
	 * range from 0 to columns-1;
	 * the number of columns of the matrix;
	 * @throws GMatrixSubscriptException 
	 */
	public GMatrix( int row, int column) throws GMatrixSubscriptException
	{
		if( row < 0 || column < 0 )
		{
			throw new GMatrixSubscriptException();
		}
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
	 * range from 0 to rows-1;
	 * the number of rows of the matrix;
	 * @param column
	 * range from 0 to columns-1;
	 * the number of columns of the matrix;
	 * @return
	 * the number at row rows and the column columns in the matrix;
	 * @throws GMatrixSubscriptException 
	 */
	public float get(int row,int column) throws GMatrixSubscriptException
	{
		if( row < 0 || row >= n || column < 0 ||column >= m )
		{
			throw new GMatrixSubscriptException();
		}
		else
		{
			return mat[row * m +column];
		}
	}
	
	
	/**
	 * set the number in the matrix;
	 * @param row
	 * range from 0 to rows-1;
	 * the number of rows of the matrix;
	 * @param column
	 * range from 0 to columns-1;
	 * the number of columns of the matrix;
	 * @param f
	 * the number need set in the matrix;
	 * @throws GMatrixSubscriptException 
	 */
	public void set(int row,int column,float f) throws GMatrixSubscriptException
	{
		if( row < 0 || row >= n || column < 0 ||column >= m )
		{
			throw new GMatrixSubscriptException();
		}
		else 
		{
			mat[row * m +column] = f;
		}
	}
	
	
	/**
	 * 
	 * @param mat
	 * @return
	 */
	public GMatrix multiplication ( GMatrix mat )
	{
		return null;
	}
	
	
	/**
	 * 
	 * @param mat
	 * @return
	 */
	public GMatrix addition ( GMatrix mat )
	{
		return null;
	}
	
	
	/**
	 * 
	 * @param mat
	 * @return
	 */
	public GMatrix subtraction ( GMatrix mat )
	{
		return null;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public GMatrix transpose ( )
	{
		return null;
	}

	
	/**
	 * 
	 * @return
	 */
	public boolean equals( )
	{
		return false;
	}
}
