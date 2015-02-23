package baseType;

public interface GType {
	public boolean equal(GType obj);
	public double distance(GType obj);
	public boolean inside(GMatrix point);
	public boolean cross(GType obj);
	public GType[] crossResults(GType obj);
}
