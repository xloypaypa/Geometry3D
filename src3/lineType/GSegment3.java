package lineType;

import mathException.TypeBuildException;
import baseType.GEps;
import baseType.GLineType3;
import baseType.GPoint3;
import baseType.GType;
import baseType.GVector3;
import lineType.GStraight3;

public class GSegment3 extends GLineType3 {
	
	public GSegment3(){
		p1=new GPoint3(0, 0, 0);
		p2=new GPoint3(0, 0, 1);
	}
	
	public GSegment3(GPoint3 point1, GPoint3 point2) throws TypeBuildException{
		if (point1.equal(point2)) throw new TypeBuildException("not segment");
		p1=new GPoint3(point1);
		p2=new GPoint3(point2);
	}
	
	public GSegment3(GPoint3 point, GVector3 vector) throws TypeBuildException{
		if (GEps.sign(vector.length())==0) throw new TypeBuildException("not segment");
		p1=new GPoint3(point);
		p2=new GPoint3(point.move(vector));
	}
	
	public GSegment3(GSegment3 s){
		p1=new GPoint3(s.p1);
		p2=new GPoint3(s.p2);
	}
	
	public float length(){
		return p1.distance(p2);
	}
	
	public GPoint3 getMidpoint(){
		return new GPoint3((p1.getX()+p2.getX())/2, (p1.getY()+p2.getY())/2, (p1.getZ()+p2.getZ())/2);
	}

	@Override
	public boolean equal(GType obj) {
		if (!obj.getClass().equals(this.getClass())) return false;
		GSegment3 s=(GSegment3) obj;
		if (p1.equal(s.p1)&&p2.equal(s.p2)) return true;
		if (p1.equal(s.p2)&&p2.equal(s.p1)) return true;
		return false;
	}

	@Override
	public float distance(GType obj) {
		if (obj.getClass().equals(GPoint3.class)) return this.distance((GPoint3)obj);
		if (obj.getClass().equals(GStraight3.class)) return this.distance((GStraight3)obj);
		if (obj.getClass().equals(GSegment3.class)) return this.distance((GSegment3)obj);
		else return obj.distance(this);
	}

	@Override
	public boolean cross(GType obj) {
		if (obj.getClass().equals(GPoint3.class)) return this.cross((GPoint3)obj);
		if (obj.getClass().equals(GStraight3.class)) return this.cross((GStraight3)obj);
		if (obj.getClass().equals(GSegment3.class)) return this.cross((GSegment3)obj);
		else return obj.cross(this);
	}

	@Override
	public GType[] crossResults(GType obj) {
		if (obj.getClass().equals(GPoint3.class)) return this.crossResults((GPoint3)obj);
		if (obj.getClass().equals(GStraight3.class)) return this.crossResults((GStraight3)obj);
		if (obj.getClass().equals(GSegment3.class)) return this.crossResults((GSegment3)obj);
		else return obj.crossResults(this);
	}
	
	protected float distance(GPoint3 p){
		float d1,d2,d3,h,len1,len2;
		d1=p.distance(this);
		d2=p.distance(this);
		d3=this.length();
		GStraight3 s=null;
		try {
			s=new GStraight3(p1, p2);
		} catch (TypeBuildException e) {
			e.printStackTrace();
		}
		h=p.distance(s);
		len1=(float) Math.sqrt(d1*d1-h*h);
		len2=(float) Math.sqrt(d2*d2-h*h);
		if (GEps.sign(d3-len1-len2)==-1){
			return Math.min(d1, d2);
		}
		return h;
	}
	
	protected boolean cross(GPoint3 p){
		GVector3 v1,v2;
		v1=new GVector3(p, p1);
		v2=new GVector3(p, p2);
		if (v1.isReverse(v2)) return true;
		else return false;
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
	
	protected float distance(GSegment3 s){
		return 0;
	}
	
	protected boolean cross(GSegment3 s){
		GStraight3 s1=null,s2=null;
		try {
			s1=new GStraight3(p1, p2);
			s2=new GStraight3(s.p1, s.p2);
		} catch (TypeBuildException e) {
			e.printStackTrace();
		}
		GType[] ans=s1.crossResults(s2);
		if (ans==null) return false;
		if (ans[0].getClass().equals(GPoint3.class)){
			if (s.cross(ans[0])&&this.cross(ans[0])) return true;
			else return false;
		}else{
			if (s.cross(p1)||s.cross(p2)) return true;
			else return false;
		}
	}
	
	protected GType[] crossResults(GSegment3 s){
		GStraight3 s1=null,s2=null;
		try {
			s1=new GStraight3(p1, p2);
			s2=new GStraight3(s.p1, s.p2);
		} catch (TypeBuildException e) {
			e.printStackTrace();
		}
		GType[] ans=s1.crossResults(s2);
		if (ans==null) return ans;
		else if (ans[0].getClass().equals(GPoint3.class)){
			if (s.cross(ans[0])&&this.cross(ans[0])) return ans;
			else return null;
		}else{
			GPoint3 ans1,ans2;
			if (s.cross(p1)) ans1=p1;
			else if (s.cross(p2)) ans1=p2;
			else return null;
			
			if (this.cross(s.p1)) ans2=s.p1;
			else if (this.cross(s.p2)) ans2=s.p2;
			else return null;
			
			GType[] ret=new GType[1];
			try {
				ret[0]=new GSegment3(new GPoint3(ans1),new GPoint3(ans2));
			} catch (TypeBuildException e) {
				ret[0]=new GPoint3(ans1);
			}
			return ret;
		}
	}
	
	protected float distance(GStraight3 s){
		return 0;
	}
	
	protected boolean cross(GStraight3 s){
		GStraight3 s2=null;
		try {
			s2=new GStraight3(p1, p2);
		} catch (TypeBuildException e) {
			e.printStackTrace();
		}
		GType[] ret=s.crossResults(s2);
		if (ret==null) return false;
		else if (ret[0].getClass().equals(GPoint3.class)){
			if (ret[0].cross(this)) return true;
			else return false;
		}else{
			return true;
		}
	}
	
	protected GType[] crossResults(GStraight3 s){
		GStraight3 s2=null;
		try {
			s2=new GStraight3(p1, p2);
		} catch (TypeBuildException e) {
			e.printStackTrace();
		}
		GType[] ret=s.crossResults(s2);
		if (ret==null) return null;
		else if (ret[0].getClass().equals(GPoint3.class)){
			if (ret[0].cross(this)) return ret;
			else return null;
		}else{
			GType[] ans=new GType[1];
			ans[0]=new GSegment3(this);
			return ans;
		}
	}

	@Override
	public GVector3 getVector() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
