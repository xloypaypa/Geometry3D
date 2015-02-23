package lineType;

import baseType.*;

public class GStraight extends GLineType3 {

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

	@Override
	public GVector3 getVector() {
		// TODO Auto-generated method stub
		return null;
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
	
}
