package baseType;

import mathException.GMatrixSubscriptException;
import mathException.GTypeTransformException;

public class GVector3 {
	protected GMatrix vector;
	
	/**
	 * Construction method
	 * @throws GMatrixSubscriptException
	 */
	public GVector3 () {
		try {
			vector = new GMatrix( 1 , 3 );
		} catch (GMatrixSubscriptException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Construction method;
	 * Create GVector3 by a mat
	 * @param mat ,A GMatrix
	 * @throws GTypeTransformException 
	 * @throws GMatrixSubscriptException
	 */
	public GVector3 ( GMatrix mat ) throws GTypeTransformException{
		checkMatrixSize(mat);
		vector = new GMatrix ( mat );
	}
	
	/**
	 * Construction method;
	 * Create GVector3 by another GVector3
	 * @param v
	 * @throws GMatrixSubscriptException
	 */
	public GVector3 ( GVector3 v ){
		vector = new GMatrix ( v.vector );
	}
	
	/**
	 * Construction method;
	 * Create GVector3 by the Coordinate(x,y,z)
	 * @param x
	 * @param y
	 * @param z
	 * @throws GMatrixSubscriptException
	 */
	public GVector3 ( float x , float y , float z ) {
		try {
			vector = new GMatrix( 1 , 3 );
			vector.set( 0 , 0 , x );
			vector.set( 0 , 1 , y );
			vector.set( 0 , 2 , z );
		} catch (GMatrixSubscriptException e) {
			e.printStackTrace();
		}
	}
	
	public GVector3(GPoint3 from, GPoint3 to){
		try {
			vector=new GMatrix(to.getMatrix().subtraction(from.getMatrix()));
		} catch (GMatrixSubscriptException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Get the GMatrix of the GVector3
	 * @return the GMatrix
	 */
	public GMatrix getMatrix(){
		return vector;
	}
	
	public float getX() {
		try {
			return vector.get( 0 , 0 );
		} catch (GMatrixSubscriptException e) {
			return 0;
		}
	}
	
	public float getY() {
		try {
			return vector.get( 0 , 1 );
		} catch (GMatrixSubscriptException e) {
			return 0;
		}
	}
	
	public float getZ() {
		try {
			return vector.get( 0 , 2 );
		} catch (GMatrixSubscriptException e) {
			return 0;
		}
	}
	
	public void setX( float x ) {
		try {
			vector.set( 0 , 0 , x );
		} catch (GMatrixSubscriptException e) {
			e.printStackTrace();
		}
	}
	
	public void setY( float y ) {
		try {
			vector.set( 0 , 1 , y );
		} catch (GMatrixSubscriptException e) {
			e.printStackTrace();
		}
	}
	
	public void setZ( float z ) {
		try {
			vector.set( 0 , 2 , z );
		} catch (GMatrixSubscriptException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * set this GVector3 by another GVector3
	 * @param v
	 * @throws GMatrixSubscriptException
	 */
	public void set( GVector3 v) {
		this.vector = new GMatrix(v.vector);
	}
	
	/**
	 * set this GVector3 by a GMatrix
	 * @param mat
	 * @throws GTypeTransformException 
	 * @throws GMatrixSubscriptException
	 */
	public void set( GMatrix mat ) throws GTypeTransformException {
		checkMatrixSize(mat);
		this.vector = new GMatrix( mat );
	}
	
	public GVector3 reverse(){
		try {
			return new GVector3(vector.multiplication(-1));
		} catch (GTypeTransformException e) {
			return null;
		}
	}
	
	public boolean isReverse(GVector3 v){
		if (GEps.sign(this.length())==0||GEps.sign(v.length())==0) return true;
		else if (GEps.sign(this.product(v).length())!=0) return false;
		else if (GEps.sign(this.getX()*v.getX())==-1) return true;
		else if (GEps.sign(this.getY()*v.getY())==-1) return true;
		else if (GEps.sign(this.getZ()*v.getZ())==-1) return true;
		return false;
	}
	
	public boolean isSameDirection(GVector3 v){
		if (GEps.sign(this.length())==0||GEps.sign(v.length())==0) return true;
		else if (GEps.sign(this.product(v).length())!=0) return false;
		else if (GEps.sign(this.getX()*v.getX())==1) return true;
		else if (GEps.sign(this.getY()*v.getY())==1) return true;
		else if (GEps.sign(this.getZ()*v.getZ())==1) return true;
		return false;
	}
	
	/**
	 * set this GVector3 by the coordinate(x,y,z)
	 * @param x
	 * @param y
	 * @param z
	 * @throws GMatrixSubscriptException
	 */
	public void set( float x , float y , float z) {
		this.setX( x );
		this.setY( y );
		this.setZ( z );
	}
	
	public float length(){
		return (float) Math.sqrt(this.dot(this));
	}
	
	public float dot(GVector3 v) {
		return dot( v.getX() , v.getY() , v.getZ() );
	}
	
	public float dot(float x , float y , float z) {
		return x * getX() + y * getY() + z * getZ();
	}
	
	public GVector3 product(GVector3 v) {
		return product( v.getX() , v.getY() , v.getZ() );
	}
	
	public GVector3 product(float x , float y , float z) {
		float nx = getY() * z - getZ() * y;
		float ny = getZ() * x - getX() * z;
		float nz = getX() * y - getY() * x; 
		return new GVector3( nx , ny , nz );
	}
	
	public GVector3 mul(float value){
		try {
			return new GVector3(vector.multiplication(value));
		} catch (GTypeTransformException e) {
			return null;
		}
	}
	
	public GVector3 changeLength(float length){
		float now=this.length();
		return this.mul(length/now);
	}
	
	public boolean equal(GVector3 obj) {
		GVector3 p=(GVector3) obj;
		if (p.getMatrix().equals(this.getMatrix())) return true;
		else return false;
	}
	
	private void checkMatrixSize(GMatrix mat) throws GTypeTransformException {
		if (mat.getRowNumber()!=1||mat.getColumnNumber()!=3) throw new GTypeTransformException("matrix size error");
	}
}
