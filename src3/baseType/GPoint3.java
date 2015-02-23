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
	public GPoint3( GMatrix p ) throws GMatrixSubscriptException{
		point = new GMatrix( p );
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
	public void set( float x , float y , float z) throws GMatrixSubscriptException
	{
		this.setX( x );
		this.setY( y );
		this.setZ( z );
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
