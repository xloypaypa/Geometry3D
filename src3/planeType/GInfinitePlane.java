package planeType;

import baseType.*;

public class GInfinitePlane extends GPlaneType3 {

	@Override
	public boolean equal(GType obj) {
		// TODO Auto-generated method stub
		return false;
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

	@Override
	public GInfinitePlane buildParallelLine(GPoint3 point) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GInfinitePlane buildVerticalLine(GPoint3 point) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GPoint3 getPedal(GPoint3 point) {
		// TODO Auto-generated method stub
		return null;
	}

}
