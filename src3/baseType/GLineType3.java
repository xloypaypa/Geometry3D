package baseType;

import lineType.*;
import mathException.TypeBuildException;

public abstract class GLineType3 implements GType {
	protected GPoint3 p1, p2;
	public GVector3 getVector(){
		return p2.sub( p1 );
	}
	public GStraight3 commonVerticalStraight( GLineType3 s ){
		
		GStraight3 s1 = new GStraight3();
		GStraight3 s2 = new GStraight3();
		try {
			s1 = new GStraight3( p1 , p2 );
			s2 = new GStraight3( s.p1 , s.p2 );
		} catch (TypeBuildException e) {
			e.printStackTrace();
			return null;
		}
		
		if (s1.equal( s2 )){
			return null;
		}
		
		GVector3 v1 = s1.getVector();
		GVector3 v2 = s2.getVector();
		GVector3 xv = v1.product( v2 );
		
 		if (s1.cross(s2)) {
 			GType[] crossRes = s1.crossResults(s2);
 			GPoint3 p = (GPoint3)crossRes[0];
			try {
				return new GStraight3(p,xv);
			} catch (TypeBuildException e) {
				e.printStackTrace();
				return null;
			}
		}
 		
 		GVector3 v3 = s1.p1.sub(s2.p1);
 		
		if (this.isParallel(s)) {
			GVector3 xv2 = v1.product( v1 );
			try {
				return new GStraight3(p1,xv2);
			} catch (TypeBuildException e) {
				e.printStackTrace();
				return null;
			}
		}
		
		float dis = s1.distance(s2);
		GPoint3 point1 = s1.p1;
		GPoint3 point2 = s2.p1;
		xv = xv.changeLength(dis);
		GPoint3 point3 = point2.move(xv);
		if( point3.cross(s1) ) {
			try {
				return new GStraight3(point2,point3);
			} catch (TypeBuildException e) {
				e.printStackTrace();
				return null;
			}
		}
		GVector3 v4 = s1.p2.sub( point3 );
		GVector3 _xv = v1.product(v4);
		if(! _xv.isReverse(xv)&& ! _xv.isSameDirection(xv) )
		{
			xv = xv.reverse();
			point3 = point2.move(xv);
			v4 = s1.p2.sub( point3 );
		}
		float theta = v4.getAngle(v1);
		float dis2 = point3.distance(point1);
		float dis3 = dis2 * (float)Math.tan(theta);
		v2 = v2.changeLength(dis3);
		GPoint3 point4 = point3.move(v2);
		if(!point3.cross(s1)){
			point4 = point3.move(v2.reverse());
		}
		try {
			return new GStraight3( point4 , point4.move(xv.reverse()) );
		} catch (TypeBuildException e) {
			e.printStackTrace();
			return null;
		}
	}
	public GSegment3 commonVerticalSegment( GLineType3 s ){
		if (this.cross(s)) return null;
		if (this.isParallel(s)) return null;
		GStraight3 res = commonVerticalStraight(s);
		if( res == null ) return null;
		try {
			return new GSegment3( res.p1 , res.p2 );
		} catch (TypeBuildException e) {
			e.printStackTrace();
			return null;
		}
	}
	public GStraight3 buildParallelLine(GPoint3 point){
		return null;
	}
	
	public GStraight3 buildVerticalLine(GPoint3 point){
		return null;
	}
	
	public GPoint3 getPedal(GPoint3 point){
		return null;
	}
	public boolean isParallel(GLineType3 line){
		return GEps.sign(line.getVector().product(this.getVector()).length())==0;
	}
}
