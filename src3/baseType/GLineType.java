package baseType;

import lineType.*;

public abstract class GLineType implements GType {
	public abstract GVector getVector();
	public abstract GStraight buildParallelLine(GPoint point);
	public abstract GStraight buildVerticalLine(GPoint point);
	public abstract GPoint getPedal(GPoint point);
}
