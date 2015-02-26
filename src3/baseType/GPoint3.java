package baseType;

import mathException.GMatrixSubscriptException;

public class GPoint3 implements GType {

	protected GMatrix point;

	/**
	 * Construction method
	 * @throws GMatrixSubscriptException
	 */
	public GPoint3() throws GMatrixSubscriptException{
		point = new GMatrix( 1 , 3 );
	}
	
	/**
	 * Construction method;
	 * Create GPoint3 by another GPoint3
	 * @param p 
	 * @throws GMatrixSubscriptException
	 */
	public GPoint3( GPoint3 p ) throws GMatrixSubscriptException{
		point = new GMatrix( p.point );
	}
	
	/**
	 * Construction method;
	 * Create GPoint3 by a mat
	 * @param mat ,A GMatrix
	 * @throws GMatrixSubscriptException
	 */
	public GPoint3( GMatrix mat ) throws GMatrixSubscriptException{
		point = new GMatrix( mat );
	}
	
	/**
	 * Construction method;
	 * Create GPoint3 by the Coordinate(x,y,z)
	 * @param x
	 * @param y
	 * @param z
	 * @throws GMatrixSubscriptException
	 */
	public GPoint3( float x , float y , float z) throws GMatrixSubscriptException{
		point = new GMatrix( 1 , 3 );
		this.setX( x );
		this.setY( y );
		this.setZ( z );
	}
	
	/**
	 * Get the GMatrix of the GPoint3
	 * @return the GMatrix
	 */
	public GMatrix get(){
		return point;
	}
	
	public float getX() throws GMatrixSubscriptException{
		return point.get( 0 , 0 );
	}
	
	public float getY() throws GMatrixSubscriptException{
		return point.get( 0 , 1 );
	}
	
	public float getZ() throws GMatrixSubscriptException{
		return point.get( 0 , 2 );
	}
	
	public void setX( float x ) throws GMatrixSubscriptException{
		point.set( 0 , 0 , x );
	}
	
	public void setY( float y ) throws GMatrixSubscriptException{
		point.set( 0 , 1 , y );
	}
	
	public void setZ( float z ) throws GMatrixSubscriptException{
		point.set( 0 , 2 , z );
	}
	
	/**
	 * set this GPoint3 by another GPoint3
	 * @param p
	 * @throws GMatrixSubscriptException
	 */
	public void set( GPoint3 p) throws GMatrixSubscriptException{
		this.point = new GMatrix(p.point);
	}
	
	/**
	 * set this GPoint3 by a GMatrix
	 * @param mat
	 * @throws GMatrixSubscriptException
	 */
	public void set( GMatrix mat ) throws GMatrixSubscriptException{
		this.point = new GMatrix( mat );
	}
	
	/**
	 * set this GPoint3 by the coordinate(x,y,z)
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
	
	/**
	 * get the addition of this point and a vector;
	 * means move this point as the vector
	 * @param v
	 * @return the result of the addition
	 * @throws GMatrixSubscriptException
	 */
	public GPoint3 add( GVector3 v ) throws GMatrixSubscriptException{
		return new GPoint3( point.addition( v.get() ) );
	}
	
	/**
	 * get the subtraction of this point and a vector
	 * @param v
	 * @return the result of the subtraction
	 * @throws GMatrixSubscriptException
	 */
	public GPoint3 sub( GVector3 v ) throws GMatrixSubscriptException{
		return new GPoint3( point.subtraction( v.get() ) );
	}

	/**
	 * get the subtraction of this point and another point
	 * @param p
	 * @return the result of the subtraction
	 * @throws GMatrixSubscriptException
	 */
	public GVector3 sub( GPoint3 p ) throws GMatrixSubscriptException{
		return new GVector3( point.subtraction( p.get() ) );
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
