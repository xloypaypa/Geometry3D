import lineType.GSegment3;
import lineType.GStraight3;
import baseType.GPoint3;
import mathException.GMatrixInverseException;
import mathException.GMatrixSubscriptException;
import mathException.TypeBuildException;
import baseType.GMatrix;


public class Main {
	public static void main(String[] args){
		try{
			GStraight3 s1,s2;
			s1 = new GStraight3(new GPoint3(3,4,5),new GPoint3(5,4,3));
			s2 = new GStraight3(new GPoint3(10.23,3.3,9.4),new GPoint3(9,10,11));
			if(s1.cross(s2)) System.out.printf("Yes");else System.out.printf("No");
			System.out.println(s1.distance(s2));
			GSegment3 s = s1.commonVerticalSegment(s2);
			if(s == null) System.out.println("false");
			else
			System.out.println(s.getPointOne().getX()+" "+s.getPointOne().getY()+" "+s.getPointOne().getZ()+"\n"+s.getPointTwo().getX()+" "+s.getPointTwo().getY()+" "+s.getPointTwo().getZ());
		}catch(TypeBuildException e){
			System.out.println(e.getMessage());
		}
	}
}
