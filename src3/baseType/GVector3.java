package baseType;

import mathException.GMatrixSubscriptException;

public class GVector3 implements GType {
	protected GMatrix vector;
	
	/**
	 * Construction method
	 * @throws GMatrixSubscriptException
	 */
	public GVector3 () throws GMatrixSubscriptException{
		vector = new GMatrix( 1 , 3 );
	}
	
	/**
	 * Construction method;
	 * Create GVector3 by a mat
	 * @param mat ,A GMatrix
	 * @throws GMatrixSubscriptException
	 */
	public GVector3 ( GMatrix mat ){
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
	public GVector3 ( float x , float y , float z ) throws GMatrixSubscriptException{
		vector = new GMatrix( 1 , 3 );
		vector.set( 0 , 1 , x );
		vector.set( 0 , 2 , y );
		vector.set( 0 , 3 , z );
	}
	
	/**
	 * Get the GMatrix of the GVector3
	 * @return the GMatrix
	 */
	public GMatrix get(){
		return vector;
	}
	
	public float getX() throws GMatrixSubscriptException{
		return vector.get( 0 , 1 );
	}
	
	public float getY() throws GMatrixSubscriptException{
		return vector.get( 0 , 2 );
	}
	
	public float getZ() throws GMatrixSubscriptException{
		return vector.get( 0 , 3 );
	}
	
	public void setX( float x ) throws GMatrixSubscriptException{
		vector.set( 0 , 0 , x );
	}
	
	public void setY( float y ) throws GMatrixSubscriptException{
		vector.set( 0 , 1 , y );
	}
	
	public void setZ( float z ) throws GMatrixSubscriptException{
		vector.set( 0 , 2 , z );
	}
	
	/**
	 * set this GVector3 by another GVector3
	 * @param v
	 * @throws GMatrixSubscriptException
	 */
	public void set( GVector3 v) throws GMatrixSubscriptException{
		this.vector = new GMatrix(v.vector);
	}
	
	/**
	 * set this GVector3 by a GMatrix
	 * @param mat
	 * @throws GMatrixSubscriptException
	 */
	public void set( GMatrix mat ) throws GMatrixSubscriptException{
		this.vector = new GMatrix( mat );
	}
	
	/**
	 * set this GVector3 by the coordinate(x,y,z)
	 * @param x
	 * @param y
	 * @param z
	 * @throws GMatrixSubscriptException
	 */
	public void set( float x , float y , float z) throws GMatrixSubscriptException{
		this.setX( x );
		this.setY( y );
		this.setZ( z );
	}
	
	public float dot(GVector3 v) throws GMatrixSubscriptException{
		return dot( v.getX() , v.getY() , v.getZ() );
	}
	
	public float dot(float x , float y , float z) throws GMatrixSubscriptException{
		return x * getX() + y * getY() + z * getZ();
	}
	
	public GVector3 product(GVector3 v) throws GMatrixSubscriptException{
		return product( v.getX() , v.getY() , v.getZ() );
	}
	
	public GVector3 product(float x , float y , float z) throws GMatrixSubscriptException{
		float nx = getY() * z - getZ() * y;
		float ny = getZ() * x - getX() * z;
		float nz = getX() * y - getY() * x; 
		return new GVector3( nx , ny , nz );
	}
	
	@Override
	public boolean equal(GType obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double distance(GType obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean inside(GMatrix point) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cross(GType obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public GType[] crossResults(GType obj) {
		// TODO Auto-generated method stub
		return null;
	}
}
