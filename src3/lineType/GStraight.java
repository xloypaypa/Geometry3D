package lineType;

import mathException.TypeBuildException;
import baseType.*;

public class GStraight extends GLineType3 {
	GPoint3 p1, p2;
	
	public GStraight(){
		p1=new GPoint3(0, 0, 0);
		p2=new GPoint3(0, 0, 1);
	}
	
	public GStraight(GPoint3 point1, GPoint3 point2) throws TypeBuildException {
		if (point1.equal(point2)) throw new TypeBuildException("not straight");
		p1=new GPoint3(point1);
		p2=new GPoint3(point2);
	}
	
	public GStraight(GPoint3 point, GVector3 vector) throws TypeBuildException {
		if (GEps.sign(vector.length())==0) throw new TypeBuildException("not straight");
		p1=new GPoint3(point);
		p2=new GPoint3(point.move(vector));
	}

	@Override
	public boolean equal(GType obj) {
		if (!obj.getClass().equals(this.getClass())) return false;
		GStraight s=(GStraight) obj;
		if (s.cross(p1)&&s.cross(p2)) return true;
		else return false;
	}

	@Override
	public float distance(GType obj) {
		if (obj.getClass().equals(GPoint3.class)) return this.distance((GPoint3)obj);
		if (obj.getClass().equals(GStraight.class)) return this.distance((GStraight)obj);
		else return obj.distance(this);
	}

	@Override
	public boolean cross(GType obj) {
		if (obj.getClass().equals(GPoint3.class)) return this.cross((GPoint3)obj);
		if (obj.getClass().equals(GStraight.class)) return this.cross((GStraight)obj);
		else return obj.cross(this);
	}

	@Override
	public GType[] crossResults(GType obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GVector3 getVector() {
		return new GVector3(p1, p2);
	}

	@Override
	public GStraight buildParallelLine(GPoint3 point) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GStraight buildVerticalLine(GPoint3 point) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GPoint3 getPedal(GPoint3 point) {
		// TODO Auto-generated method stub
		return null;
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
	
	protected float distance(GStraight s){
		// TODO Auto-generated method stub
		return 0;
	}
	
	protected boolean cross(GStraight s){
		if (this.equal(s)) return true;
		if (this.isParallel(s)) return false;
		
		return true;
	}
	
}
