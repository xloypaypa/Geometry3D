package lineType;

import mathException.TypeBuildException;
import baseType.GLineType3;
import baseType.GPoint3;
import baseType.GType;
import baseType.GVector3;

public class GRay3 extends GLineType3{
	
	GPoint3 p1,p2;
	
	public GRay3(){
		p1=new GPoint3(0, 0, 0);
		p2=new GPoint3(0, 0, 1);
	}
	
	public GRay3(GPoint3 from, GPoint3 to){
		p1=new GPoint3(from);
		p2=new GPoint3(to);
	}
	
	public GRay3(GPoint3 point, GVector3 vector){
		p1=new GPoint3(point);
		p2=new GPoint3(point.move(vector));
	}
	
	public GRay3(GRay3 ray){
		this.p1=new GPoint3(ray.p1);
		this.p2=new GPoint3(ray.p2);
	}
	
	@Override
	public boolean equals(GType obj) {
		if (!obj.getClass().equals(this.getClass())) return false;
		GRay3 ray=(GRay3) obj;
		if (!ray.p1.equals(p1)) return false;
		if (ray.getVector().isSameDirection(this.getVector())) return true;
		else return false;
	}

	@Override
	public float distance(GType obj) {
		// TODO Auto-generated method stub
		return 0;
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

	@Override
	public GVector3 getVector() {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected float distance(GPoint3 p){
		GVector3 v1,v2;
		v1=this.getVector();
		v2=new GVector3(p1, p);
		v1.changeLength(v2.length());
		GSegment3 s=null;
		try {
			s=new GSegment3(p1, p1.move(v1));
		} catch (TypeBuildException e) {
			return 0;
		}
		return s.distance(p);
	}
	
	protected boolean cross(GPoint3 p){
		GVector3 v1,v2;
		v1=this.getVector();
		v2=new GVector3(p1, p);
		if (v1.isSameDirection(v2)) return true;
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
		// TODO
		return 0;
	}
	
	protected boolean cross(GSegment3 s){
		GStraight3 s1=null,s2=null;
		try {
			s1=new GStraight3(p1, p1);
			s2=new GStraight3(s.getPointOne(), s.getPointTwo());
		} catch (TypeBuildException e) {
			e.printStackTrace();
		}
		
		GType[] ans=s1.crossResults(s2);
		if (ans==null) return false;
		else if (ans[0].getClass().equals(GPoint3.class)){
			if (ans[0].cross(this)&&ans[0].cross(s)) return true;
			else return false;
		}else{
			if (s.getPointOne().cross(this)) return true;
			else if (s.getPointTwo().cross(this)) return true;
			else return false;
		}
	}
	
	protected GType[] crossResults(GSegment3 s){
		GStraight3 s1=null,s2=null;
		try {
			s1=new GStraight3(p1, p1);
			s2=new GStraight3(s.getPointOne(), s.getPointTwo());
		} catch (TypeBuildException e) {
			e.printStackTrace();
		}
		
		GType[] ans=s1.crossResults(s2);
		if (ans==null) return null;
		else if (ans[0].getClass().equals(GPoint3.class)){
			if (ans[0].cross(this)&&ans[0].cross(s)) return ans;
			else return null;
		}else{
			boolean f1,f2;
			f1=s.getPointOne().cross(this);
			f2=s.getPointTwo().cross(this);
			
			if (!f1&&!f2) return null;
			
			if (f1&&f2){
				ans[0]=new GSegment3(s);
			}else if (f1&&!f2){
				try {
					ans[0]=new GSegment3(p1,s.getPointOne());
				} catch (TypeBuildException e) {
					ans[0]=new GPoint3(p1);
				}
			}else if (!f1&&f2){
				try {
					ans[0]=new GSegment3(p1,s.getPointTwo());
				} catch (TypeBuildException e) {
					ans[0]=new GPoint3(p1);
				}
			}
			return ans;
			
		}
	}
	
	protected float distance(GStraight3 s){
		// TODO
		return 0;
	}
	
	protected boolean cross(GStraight3 s){
		GStraight3 s1=null;
		try {
			s1=new GStraight3(p1, p2);
		} catch (TypeBuildException e) {
			e.printStackTrace();
		}
		
		GType[] ans=s1.crossResults(s);
		if (ans==null) return false;
		else if (ans[0].getClass().equals(GPoint3.class)) {
			if (ans[0].cross(this)) return true;
			else return false;
		}else{
			return true;
		}
	}
	
	protected GType[] crossResults(GStraight3 s){
		GStraight3 s1=null;
		try {
			s1=new GStraight3(p1, p2);
		} catch (TypeBuildException e) {
			e.printStackTrace();
		}
		
		GType[] ans=s1.crossResults(s);
		if (ans==null) return null;
		else if (ans[0].getClass().equals(GPoint3.class)) {
			if (ans[0].cross(this)) return ans;
			else return null;
		}else{
			ans[0]=new GRay3(this);
			return ans;
		}
	}
	
	protected float distance(GRay3 r){
		// TODO
		return 0;
	}
	
	protected boolean cross(GRay3 r){
		GStraight3 s1=null,s2=null;
		try {
			s1=new GStraight3(p1, p2);
			s2=new GStraight3(r.p1, r.p2);
		} catch (TypeBuildException e) {
			e.printStackTrace();
		}
		
		GType[] ans=s1.crossResults(s2);
		if (ans==null) return false;
		else if (ans[0].getClass().equals(GPoint3.class)){
			if (ans[0].cross(this)&&ans[0].cross(r)) return true;
			else return false;
		}else{
			if (r.p1.cross(this)) return true;
			else if (p1.cross(r)) return true;
			else return false;
		}
	}
	
	protected GType[] crossResults(GRay3 r){
		GStraight3 s1=null,s2=null;
		try {
			s1=new GStraight3(p1, p2);
			s2=new GStraight3(r.p1, r.p2);
		} catch (TypeBuildException e) {
			e.printStackTrace();
		}
		
		GType[] ans=s1.crossResults(s2);
		if (ans==null) return null;
		else if (ans[0].getClass().equals(GPoint3.class)){
			if (ans[0].cross(this)&&ans[0].cross(r)) return ans;
			else return null;
		}else{
			GVector3 v1,v2;
			v1=this.getVector();
			v2=r.getVector();
			if (v1.isSameDirection(v2)){
				if (p1.cross(r)){
					ans[0]=new GRay3(this);
					return ans;
				}else{
					ans[0]=new GRay3(r);
					return ans;
				}
			}else{
				try {
					ans[0]=new GSegment3(p1, r.p1);
				} catch (TypeBuildException e) {
					ans[0]=new GPoint3(p1);
				}
				return ans;
			}
		}
	}

}
