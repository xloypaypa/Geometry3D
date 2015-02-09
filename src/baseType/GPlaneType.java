package baseType;

import planeType.*;

public abstract class GPlaneType implements GType {
	public abstract GVector getVector();
	public abstract GInfinitePlane buildParallelLine(GPoint point);
	public abstract GInfinitePlane buildVerticalLine(GPoint point);
	public abstract GPoint getPedal(GPoint point);
}
