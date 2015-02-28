package baseType;

import lineType.*;

public abstract class GLineType3 implements GType {
	public abstract GVector3 getVector();
	public GStraight buildParallelLine(GPoint3 point){
		return null;
	}
	
	public GStraight buildVerticalLine(GPoint3 point){
		return null;
	}
	
	public GPoint3 getPedal(GPoint3 point){
		return null;
	}
	public boolean isParallel(GLineType3 line){
		return GEps.sign(line.getVector().product(this.getVector()).length())==0;
	}
}
