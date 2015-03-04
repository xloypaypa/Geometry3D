package baseType;

import mathException.GMatrixException;
import mathException.GMatrixSubscriptException;
import mathException.GTypeTransformException;

public class GPoint3 implements GType {

	protected GMatrix point;

	/**
	 * Construction method
	 */
	public GPoint3(){
		try {
			point = new GMatrix( 1 , 3 );
		} catch (GMatrixSubscriptException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Construction method;
	 * Create GPoint3 by another GPoint3
	 * @param p 
	 */
	public GPoint3( GPoint3 p ){
		point = new GMatrix( p.point );
	}
	
	/**
	 * Construction method;
	 * Create GPoint3 by a mat
	 * @param mat ,A GMatrix
	 * @throws GMatrixSubscriptException
	 */
	public GPoint3( GMatrix mat ) throws GTypeTransformException{
		checkMatrixSize(mat);
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
	public GPoint3( float x , float y , float z) {
		try {
			point = new GMatrix( 1 , 3 );
			this.setX( x );
			this.setY( y );
			this.setZ( z );
		} catch (GMatrixException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Get the GMatrix of the GPoint3
	 * @return the GMatrix
	 */
	public GMatrix getMatrix(){
		return point;
	}
	
	public float getX() {
		try {
			return point.get( 0 , 0 );
		} catch (GMatrixSubscriptException e) {
			return 0;
		}
	}
	
	public float getY() {
		try {
			return point.get( 0 , 1 );
		} catch (GMatrixSubscriptException e) {
			return 0;
		}
	}
	
	public float getZ() {
		try {
			return point.get( 0 , 2 );
		} catch (GMatrixSubscriptException e) {
			return 0;
		}
	}
	
	public void setX( float x ) {
		try {
			point.set( 0 , 0 , x );
		} catch (GMatrixSubscriptException e) {
			e.printStackTrace();
		}
	}
	
	public void setY( float y ) {
		try {
			point.set( 0 , 1 , y );
		} catch (GMatrixSubscriptException e) {
			e.printStackTrace();
		}
	}
	
	public void setZ( float z ) {
		try {
			point.set( 0 , 2 , z );
		} catch (GMatrixSubscriptException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * set this GPoint3 by another GPoint3
	 * @param p
	 * @throws GMatrixSubscriptException
	 */
	public void set( GPoint3 p) {
		this.point=new GMatrix(p.point);
	}
	
	/**
	 * set this GPoint3 by a GMatrix
	 * @param mat
	 * @throws GMatrixSubscriptException
	 */
	public void set( GMatrix mat ) throws GTypeTransformException{
		checkMatrixSize(mat);
		this.point = new GMatrix( mat );
	}
	
	/**
	 * set this GPoint3 by the coordinate(x,y,z)
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
	
	/**
	 * get the move of this point and a vector;
	 * means move this point as the vector
	 * @param v
	 * @return the result of the addition
	 * @throws GMatrixSubscriptException
	 */
	public GPoint3 move( GVector3 v ) {
		try {
			return new GPoint3( point.addition( v.getMatrix() ) );
		} catch (GMatrixSubscriptException | GTypeTransformException e) {
			return null;
		}
	}
	
	public GPoint3 add(GPoint3 p){
		try {
			return new GPoint3(point.addition(p.point));
		} catch (GMatrixSubscriptException | GTypeTransformException e) {
			return null;
		}
	}

	/**
	 * get the subtraction of this point and another point
	 * @param p
	 * @return the result of the subtraction
	 * @throws GMatrixSubscriptException
	 */
	public GVector3 sub( GPoint3 p ) {
		try {
			return new GVector3( point.subtraction( p.getMatrix() ) );
		} catch (GMatrixSubscriptException | GTypeTransformException e) {
			return null;
		}
	}

	@Override
	public boolean equals(GType obj) {
		if (!obj.getClass().equals(this.getClass())) return false;
		GPoint3 p=(GPoint3) obj;
		if (p.getMatrix().equals(this.getMatrix())) return true;
		else return false;
	}

	@Override
	public float distance(GType obj) {
		if (obj.getClass().equals(GPoint3.class)) return this.distance((GPoint3)obj);
		return obj.distance(this);
	}

	@Override
	public boolean cross(GType obj) {
		if (obj.getClass().equals(GPoint3.class)) return this.equals(obj);
		return obj.cross(this);
	}

	@Override
	public GType[] crossResults(GType obj) {
		if (obj.getClass().equals(GPoint3.class)) return this.crossResults((GPoint3)obj);
		return obj.crossResults(this);
	}
	
	protected float distance(GPoint3 p){
		try {
			GPoint3 temp=new GPoint3(this.sub(p).getMatrix());
			return (float) Math.sqrt(temp.getMatrix().multiplication(temp.getMatrix().transpose()).get(0, 0));
		} catch (GMatrixSubscriptException | GTypeTransformException e) {
			return 0;
		}
	}
	
	protected GType[] crossResults(GPoint3 p){
		if (this.cross(p)){
			GType[] ans=new GType[1];
			ans[0]=new GPoint3(this);
			return ans;
		}else{
			return null;
		}
	}
	
	private void checkMatrixSize(GMatrix mat) throws GTypeTransformException {
		if (mat.getRowNumber()!=1||mat.getColumnNumber()!=3) throw new GTypeTransformException("matrix size error");
	}

}
