package baseType;

import planeType.*;

public abstract class GPlaneType3 implements GType {
	public abstract GVector3 getVector();
	public abstract GInfinitePlane buildParallelLine(GPoint3 point);
	public abstract GInfinitePlane buildVerticalLine(GPoint3 point);
	public abstract GPoint3 getPedal(GPoint3 point);
}
