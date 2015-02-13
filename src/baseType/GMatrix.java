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
			return ;
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
			return null;
		}
		return mat[row * m +column];
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
			return;
		}
		mat[row * m +column] = f;
	}
	
	
	/**
	 * get the multiplication of this matrix and mat;
	 * @param mat
	 * @return		
	 * the multiplication;
	 */
	public GMatrix multiplication ( GMatrix mat )
	{
		if( mat.getRowNumber() != m || mat.getColumnNumber() != n )
		{
			throw new GMatrixSubscriptException();
			return null;
		}
		GMatrix reMat = new GMatrix( n , mat.getColumnNumber() );
		for( int  i = 0 ; i < n ; i ++)
			for(int j = 0 ; j < mat.getColumnNumber() ; j ++)
			{
				float s = 0;
				for(int k = 0; k < m ; k ++)
				{
					s += get( i , k ) * mat.get( k , j );
				}
				reMat.set( i ,j ,s);
			}
		return reMat;
	}
	
	
	/**
	 * get the addition of this matrix and mat;
	 * @param mat
	 * @return
	 * the addition
	 */
	public GMatrix addition ( GMatrix mat )
	{
		if( mat.getRowNumber() != n || mat.getColumnNumber() != m )
		{
			throw new GMatrixSubscriptException();
			return null;
		}
		GMatrix reMat = new GMatrix( n , m );
		for( int i = 0; i < n; i ++)
			for( int j = 0; j < m; j ++)
			{
				reMat.set( i , j , mat.get( i , j ) + get( i , j ));
			}
		return reMat;
	}
	
	
	/**
	 * get the subtraction of this matrix and mat;
	 * @param mat
	 * @return
	 * the result of this matrix - mat;
	 */
	public GMatrix subtraction ( GMatrix mat )
	{
		if( mat.getRowNumber() != n || mat.getColumnNumber() != m )
		{
			throw new GMatrixSubscriptException();
			return null;
		}
		GMatrix reMat = new GMatrix( n , m );
		for( int i = 0; i < n; i ++)
			for( int j = 0; j < m; j ++)
			{
				reMat.set( i , j , mat.get( i , j ) - get( i , j ));
			}
		return reMat;
	}
	
	
	/**
	 * get the transpose of this matrix;
	 * @return
	 * the transpose
	 */
	public GMatrix transpose ( )
	{
		GMatrix reMat = new GMatrix( m , n );
		for(int i = 0; i < n; i ++)
			for(int j = 0;j < m; j ++)
			{
				reMat.set( i , j , get( j , i ));
			}
		return reMat;
	}

	
	/**
	 * get if this matrix equal to the mat;
	 * @param mat
	 * @return
	 * if equal return true else return false;
	 */
	public boolean equals( GMatrix mat )
	{
		if( mat.getRowNumber() != n || mat.getColumnNumber() != m )
		{
			return false;
		}
		for(int i = 0; i < n; i ++)
			for(int j = 0;j < m; j ++)
				if ( get( i , j ) ! = mat.get( i , j ))
				{
					return false;
				}
		return true;
	}
	/**
	 * get the inverse of this matrix
	 * @return
	 * the inverse of this matrix
 	 */
	public GMatrix inverse()
	{
		return null;
	}
	/**
	 * get the result of gauss elimination of this matrix
	 * @return
	 * the gauss elimination of this matrix
 	 */
	public GMatrix gaussElimination()
	{
		return null;
	}
}
