package planeType;

import baseType.*;

public class GInfinitePlane extends GPlaneType {

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
	public GInfinitePlane buildParallelLine(GPoint point) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GInfinitePlane buildVerticalLine(GPoint point) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GPoint getPedal(GPoint point) {
		// TODO Auto-generated method stub
		return null;
	}

}
