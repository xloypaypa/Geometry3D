package baseType;

import mathException.GMatrixSubscriptException;

public class GPoint3 implements GType {

	protected GMatrix point;


	public GPoint3() throws GMatrixSubscriptException{
		point = new GMatrix( 1 , 3 );
	}

	public GPoint3( GPoint3 p ) throws GMatrixSubscriptException{
		point = new GMatrix( p.point );
	}

	public GPoint3( GMatrix mat ) throws GMatrixSubscriptException{
		point = new GMatrix( mat );
	}

	public GPoint3( float x , float y , float z) throws GMatrixSubscriptException{
		point = new GMatrix( 1 , 3 );
		this.setX( x );
		this.setY( y );
		this.setZ( z );
	}

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

	public void set( GPoint3 p) throws GMatrixSubscriptException{
		this.point = new GMatrix(p.point);
	}

	public void set( GMatrix p) throws GMatrixSubscriptException{
		this.point = new GMatrix(p);
	}

	public void set( float x , float y , float z) throws GMatrixSubscriptException{
		this.setX( x );
		this.setY( y );
		this.setZ( z );
	}

	public GPoint3 add( GVector3 v ){
		return new GPoint3( point.addition( v.get() ) );
	}

	public GPoint3 sub( GVector3 v ){
		return new GPoint3( point.subtraction( v.get() ) );
	}

	public GVector3 sub( GPoint3 p ){
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
