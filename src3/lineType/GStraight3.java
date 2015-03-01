package lineType;

import mathException.TypeBuildException;
import baseType.*;

public class GStraight3 extends GLineType3 {
	GPoint3 p1, p2;
	
	public GStraight3(){
		p1=new GPoint3(0, 0, 0);
		p2=new GPoint3(0, 0, 1);
	}
	
	public GStraight3(GPoint3 point1, GPoint3 point2) throws TypeBuildException {
		if (point1.equal(point2)) throw new TypeBuildException("not straight");
		p1=new GPoint3(point1);
		p2=new GPoint3(point2);
	}
	
	public GStraight3(GPoint3 point, GVector3 vector) throws TypeBuildException {
		if (GEps.sign(vector.length())==0) throw new TypeBuildException("not straight");
		p1=new GPoint3(point);
		p2=new GPoint3(point.move(vector));
	}
	
	public GStraight3(GStraight3 s){
		this.p1=new GPoint3(s.p1);
		this.p2=new GPoint3(s.p2);
	}

	@Override
	public boolean equal(GType obj) {
		if (!obj.getClass().equals(this.getClass())) return false;
		GStraight3 s=(GStraight3) obj;
		if (s.cross(p1)&&s.cross(p2)) return true;
		else return false;
	}

	@Override
	public float distance(GType obj) {
		if (obj.getClass().equals(GPoint3.class)) return this.distance((GPoint3)obj);
		if (obj.getClass().equals(GStraight3.class)) return this.distance((GStraight3)obj);
		else return obj.distance(this);
	}

	@Override
	public boolean cross(GType obj) {
		if (obj.getClass().equals(GPoint3.class)) return this.cross((GPoint3)obj);
		if (obj.getClass().equals(GStraight3.class)) return this.cross((GStraight3)obj);
		else return obj.cross(this);
	}

	@Override
	public GType[] crossResults(GType obj) {
		if (obj.getClass().equals(GPoint3.class)) return this.crossResults((GPoint3)obj);
		if (obj.getClass().equals(GStraight3.class)) return this.crossResults((GStraight3)obj);
		else return obj.crossResults(this);
	}
	
	protected float distance(GPoint3 p){
		GVector3 v1,v2;
		v1=new GVector3(p, p1);
		v2=new GVector3(p, p2);
		return v1.product(v2).length()/(2*p1.distance(p2));
	}
	
	protected boolean cross(GPoint3 p){
		GVector3 v1,v2,v3;
		v1=new GVector3(p1, p);
		v2=this.getVector();
		v3=v1.product(v2);
		if (GEps.sign(v3.length())==0) return true;
		return false;
	}
	
	protected GType[] crossResults(GPoint3 p){
		if (this.cross(p)){
			GType[] ans=new GType[1];
			ans[0]=new GPoint3(p);
			return ans;
		}else{
			return null;
		}
	}
	
	protected float distance(GStraight3 s){
		if (this.cross(s)) return 0f;
		if (this.isParallel(s)) return s.distance(p1);
		GVector3 v1 = p1.sub( p2 );
		GVector3 v2 = s.p1.sub( s.p2 );
		GVector3 v3 = p1.sub( s.p1 );
		GVector3 xv = v1.product( v2 );
		return v3.getProjection(xv);
	}
	
	protected boolean cross(GStraight3 s){
		if (this.equal(s)) return true;
		if (this.isParallel(s)) return false;
		
		GVector3 v11,v12,v21,v22,a1,a2;
		v11=new GVector3(p1, s.p1);
		v12=new GVector3(p1, s.p2);
		v21=new GVector3(p2, s.p1);
		v22=new GVector3(p2, s.p2);
		a1=v11.product(v12); a2=v21.product(v22);
		return GEps.sign(a1.product(a2).length())==0;
	}
	
	protected GType[] crossResults(GStraight3 s){
		if (this.equal(s)){
			GType[] ans=new GType[1];
			ans[0]=new GStraight3(s);
			return ans;
		}else if (!this.cross(s)) {
			return null;
		}else{
			float dis=p1.distance(s);
			GType[] ans=new GType[1];
			ans[0]=p1.move(this.getVector().changeLength(dis));
			if (ans[0].cross(s)&&ans[0].cross(this)){
				return ans;
			}else{
				ans[0]=p1.move(this.getVector().reverse().changeLength(dis));
				return ans;
			}
		}
	}

	@Override
	public GVector3 getVector() {
		return new GVector3(p1, p2);
	}
	
}
