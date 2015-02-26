package baseType;

import mathException.GMatrixInverseException;
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
	public GMatrix( int row, int column) throws GMatrixSubscriptException {
		if( row <= 0 || column <= 0 ) {
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
	public GMatrix( GMatrix mat ) {
		this.n = mat.getRowNumber();
		this.m = mat.getColumnNumber();
		this.mat = new float[n*m];
		for (int i=0;i<n;i++){
			for (int j=0;j<m;j++){
				safeSet(i, j, mat.safeGet(i, j));
			}
		}
	}
	
	
	/**
	 * get the number of rows of the matirx;
	 * @return
	 * the number of rows of the matirx;
	 */
	public int getRowNumber() {
		return n;
	}
	
	
	/**
	 * get the number of Columns of the matirx;
	 * @return
	 * the number of Columns of the matirx;
	 */
	public int getColumnNumber() {
		return m;
	}
	
	
	/**
	 * get the matirx;
	 * @return
	 * the matirx;
	 */
	public float[] getMatrix() {
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
	public float get(int row,int column) throws GMatrixSubscriptException {
		if( row < 0 || row >= n || column < 0 ||column >= m ) {
			throw new GMatrixSubscriptException();
		}
		return safeGet(row, column);
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
	public void set(int row,int column,float f) throws GMatrixSubscriptException {
		if( row < 0 || row >= n || column < 0 ||column >= m ) {
			throw new GMatrixSubscriptException();
		}
		safeSet(row, column, f);
	}
	
	
	/**
	 * get the multiplication of this matrix and mat;
	 * @param mat is a GMatrix
	 * @return		
	 * the multiplication;
	 * @throws GMatrixSubscriptException 
	 */
	public GMatrix multiplication ( GMatrix mat ) throws GMatrixSubscriptException {
		if( mat.getRowNumber() != m) {
			throw new GMatrixSubscriptException();
		}
		GMatrix reMat = new GMatrix( n , mat.getColumnNumber() );
		for( int  i = 0 ; i < n ; i ++) {
			for(int j = 0 ; j < mat.getColumnNumber() ; j ++) {
				float s = 0;
				for(int k = 0; k < m ; k ++) {
					s += safeGet( i , k ) * mat.safeGet( k , j );
				}
				reMat.safeSet( i ,j ,s);
			}
		}
			
		return reMat;
	}
	/**
	 * get the multiplication of this matrix and k;
	 * @param k is a float
	 * @return		
	 * the multiplication;
	 * @throws GMatrixSubscriptException 
	 */
	public GMatrix multiplication ( float k ) throws GMatrixSubscriptException {
		GMatrix reMat = new GMatrix( n , mat.getColumnNumber() );
		for( int  i = 0 ; i < n ; i ++) {
			for(int j = 0 ; j < m ; j ++) {
				reMat.safeSet( i ,j , safeGet( i , j ) * k );
			}
		}
		return reMat;
	}
	
	/**
	 * get the addition of this matrix and mat;
	 * @param mat
	 * @return
	 * the addition
	 * @throws GMatrixSubscriptException 
	 */
	public GMatrix addition ( GMatrix mat ) throws GMatrixSubscriptException {
		if( mat.getRowNumber() != n || mat.getColumnNumber() != m ) {
			throw new GMatrixSubscriptException();
		}
		GMatrix reMat = new GMatrix( n , m );
		for( int i = 0; i < n; i ++) {
			for( int j = 0; j < m; j ++) {
				reMat.safeSet( i , j , mat.safeGet( i , j ) + safeGet( i , j ));
			}
		}
			
		return reMat;
	}
	
	
	/**
	 * get the subtraction of this matrix and mat;
	 * @param mat
	 * @return
	 * the result of this matrix - mat;
	 * @throws GMatrixSubscriptException 
	 */
	public GMatrix subtraction ( GMatrix mat ) throws GMatrixSubscriptException {
		if( mat.getRowNumber() != n || mat.getColumnNumber() != m ) {
			throw new GMatrixSubscriptException();
		}
		GMatrix reMat = new GMatrix( n , m );
		for( int i = 0; i < n; i ++) {
			for( int j = 0; j < m; j ++) {
				reMat.safeSet( i , j , safeGet( i , j ) - mat.safeGet( i , j ));
			}
		}
		return reMat;
	}
	
	
	/**
	 * get the transpose of this matrix;
	 * @return
	 * the transpose
	 * @throws GMatrixSubscriptException 
	 */
	public GMatrix transpose () {
		GMatrix reMat = new GMatrix( this );
		int temp=reMat.n; reMat.n=reMat.m; reMat.m=temp;
		
		for(int i = 0; i < n; i ++) {
			for(int j = 0;j < m; j ++) {
				reMat.safeSet(j, i, safeGet(i, j));
			}
		}
		return reMat;
	}

	
	/**
	 * get if this matrix equal to the mat;
	 * @param mat
	 * @return
	 * if equal return true else return false;
	 * @throws GMatrixSubscriptException 
	 */
	public boolean equals( GMatrix mat ) {
		if( mat.getRowNumber() != n || mat.getColumnNumber() != m ) {
			return false;
		}
		for(int i = 0; i < n; i ++) {
			for(int j = 0;j < m; j ++) {
				if (GEps.sign(safeGet(i, j)-mat.safeGet(i, j))!=0){
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * get the inverse of this matrix
	 * @return
	 * the inverse of this matrix
	 * @throws GMatrixInverseException 
 	 */
	public GMatrix inverse() throws GMatrixInverseException {
		if ( n != m ){
			throw new GMatrixInverseException("matrix not be square matrix.");
		}
		
		GMatrix temp=new GMatrix(this);
		temp.m*=2; temp.mat=new float[n*2*m];
		for (int i=0;i<n;i++){
			for (int j=0;j<m;j++){
				temp.safeSet(i, j, this.safeGet(i, j));
			}
			temp.safeSet(i, m+i, 1);
		}
		temp=temp.gaussElimination();
		
		for (int i=0;i<n;i++){
			if (GEps.sign(temp.safeGet(i, i)-1)!=0){
				throw new GMatrixInverseException("matrix cannot inverse.");
			}
		}
		
		GMatrix ans=new GMatrix(this);
		for (int i=0;i<n;i++){
			for (int j=0;j<m;j++){
				ans.safeSet(i, j, temp.safeGet(i, m+j));
			}
		}
		return ans;
	}
	/**
	 * get the result of gauss elimination of this matrix
	 * @return
	 * the gauss elimination of this matrix
 	 */
	public GMatrix gaussElimination() {
		GMatrix ans=new GMatrix(this);
		for (int i=0;i<Math.min(n, m);i++){
			float max = findPivotElement(ans, i);
			if (GEps.sign(max)==0) continue;
			
			doElimination(ans, i);
		}
		
		eliminationBack(ans);
		return ans;
	}


	private void eliminationBack(GMatrix ans) {
		for (int i=Math.min(n, m)-1;i>=0;i--){
			if (GEps.sign(ans.safeGet(i, i))==0) continue;
			for (int j=i-1;j>=0;j--){
				float times=ans.safeGet(j, i)/ans.safeGet(i, i);
				for (int k=i;k<m;k++){
					ans.safeSet(j, k, ans.safeGet(j, k)-ans.safeGet(i, k)*times);
				}
			}
		}
	}


	private void doElimination(GMatrix ans, int i) {
		for (int j=i+1;j<m;j++){
			ans.safeSet(i, j, ans.safeGet(i, j)/ans.safeGet(i, i));
		}
		ans.safeSet(i, i, 1);
		
		for (int j=i+1;j<n;j++){
			float times=ans.safeGet(j, i);
			for (int k=i;k<m;k++){
				ans.safeSet(j, k, ans.safeGet(j, k)-ans.safeGet(i, k)*times);
			}
		}
	}


	private float findPivotElement(GMatrix ans, int i) {
		float max=ans.safeGet(i, i);
		int mainPos=i;
		for (int j=i+1;j<n;j++){
			max=Math.max(max, ans.safeGet(j, i));
			mainPos=j;
		}
		if (mainPos!=i){
			for (int j=i;j<m;j++){
				float temp=ans.safeGet(i, j);
				ans.safeSet(i, j, ans.safeGet(mainPos, j));
				ans.safeSet(mainPos, j, temp);
			}
		}
		return max;
	}
	
	private float safeGet(int row, int column){
		return mat[row * m +column];
	}
	private void safeSet(int row,int column, float value){
		mat[row * m +column] = value;
	}
}
