package baseType;

public abstract class GVector3 implements GType {
	protected GMatrix vector;
	public GVector3 (){
		vector = new GMatrix( 1 , 3 );
	}
	public GVector3 ( GMatrix mat ){
		vector = new GMatrix ( mat );
	}
	public GVector3 ( GVector3 v ){
		vector = new GMatrix ( v.vector );
	}
	public GVector3 ( float x , float y , float z ){
		vector = new GMatrix( 1 , 3 );
		vector.set( 0 , 1 , x );
		vector.set( 0 , 2 , y );
		vector.set( 0 , 3 , z );
	}
	public GMatrix get(){
		return vector;
	}
	public GMatrix getX(){
		return vector.get( 0 , 1 );
	}
	public GMatrix getY(){
		return vector.get( 0 , 2 );
	}
	public GMatrix getZ(){
		return vector.get( 0 , 3 );
	}
	public float dot(GVector3 v){
		return dot( v.getX() , v.getY() , v.getZ() );
	}
	public float dot(float x , float y , float z){
		return x * getX() + y * getY() + z * getZ();
	}
	public GVector3 product(GVector3 v){
		return product( v.getX() , v.getY() , v.getZ() );
	}
	public GVector3 product(float x , float y , float z){
		float nx = getY() * z - getZ() * y;
		float ny = getZ() * x - getX() * z;
		float nz = getX() * y - getY() * x; 
		return new GVector3( nx , ny , nz );
	}
}
