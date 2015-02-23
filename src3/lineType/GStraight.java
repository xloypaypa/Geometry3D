package lineType;

import baseType.GLineType;
import baseType.GPoint;
import baseType.GType;
import baseType.GVector;

public class GStraight extends GLineType {

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
	public boolean inside(GPoint point) {
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
	public GVector getVector() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GStraight buildParallelLine(GPoint point) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GStraight buildVerticalLine(GPoint point) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GPoint getPedal(GPoint point) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
