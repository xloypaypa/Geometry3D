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
	public GVector3 ( double x , double y , double z ) {
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
	
	public double getX() {
		try {
			return vector.get( 0 , 0 );
		} catch (GMatrixSubscriptException e) {
			return 0;
		}
	}
	
	public double getY() {
		try {
			return vector.get( 0 , 1 );
		} catch (GMatrixSubscriptException e) {
			return 0;
		}
	}
	
	public double getZ() {
		try {
			return vector.get( 0 , 2 );
		} catch (GMatrixSubscriptException e) {
			return 0;
		}
	}
	
	public void setX( double x ) {
		try {
			vector.set( 0 , 0 , x );
		} catch (GMatrixSubscriptException e) {
			e.printStackTrace();
		}
	}
	
	public void setY( double y ) {
		try {
			vector.set( 0 , 1 , y );
		} catch (GMatrixSubscriptException e) {
			e.printStackTrace();
		}
	}
	
	public void setZ( double z ) {
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
	public void set( double x , double y , double z) {
		this.setX( x );
		this.setY( y );
		this.setZ( z );
	}
	
	public double length(){
		return (double) Math.sqrt(this.dot(this));
	}
	
	public double dot(GVector3 v) {
		return dot( v.getX() , v.getY() , v.getZ() );
	}
	
	public double dot(double x , double y , double z) {
		return x * getX() + y * getY() + z * getZ();
	}
	
	public GVector3 product(GVector3 v) {
		return product( v.getX() , v.getY() , v.getZ() );
	}
	
	public GVector3 product(double x , double y , double z) {
		double nx = getY() * z - getZ() * y;
		double ny = getZ() * x - getX() * z;
		double nz = getX() * y - getY() * x; 
		return new GVector3( nx , ny , nz );
	}
	
	public GVector3 mul(double value){
		try {
			return new GVector3(vector.multiplication(value));
		} catch (GTypeTransformException e) {
			return null;
		}
	}
	
	public GVector3 sub(double value){
			try {
				return new GVector3(vector.subtraction(value));
			} catch (GTypeTransformException e) {
				e.printStackTrace();
				return null;
			}
	}
	
	public GVector3 add(double value){
		try {
			return new GVector3(vector.addition(value));
		} catch (GTypeTransformException e) {
			e.printStackTrace();
			return null;
		}
}
	
	public GVector3 changeLength(double length){
		if( this.isEmpty() ) return new GVector3(this);
		double now=this.length();
		return this.mul(length/now);
	}
	
	public boolean isEmpty()
	{
		if( this.getX() == 0f && this.getY() == 0f && this.getZ() == 0f) return true;
		return false;
	}
	
	public double getAngle(GVector3 v)
    {
     if(this.isEmpty()) return 0f;
     if(v.isEmpty()) return 0f;
     return (double)Math.acos(this.dot(v)/(v.length()*this.length()));
    }
	
	/**
	 * project this vector on another vector
	 * @param v ,it is the "another vector";
	 * @return the projection
	 */
	public double getProjection(GVector3 v)
	{
		if( v.isEmpty() ) return 0f;
		return Math.abs(v.normalize().dot(this));
	}
	
	public GVector3 normalize(){
		return changeLength( 1.0f );
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
