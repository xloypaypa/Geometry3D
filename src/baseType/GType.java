package baseType;

public interface GType {
	public boolean equal(GType obj);
	public float distance(GType obj);
	public boolean cross(GType obj);
	public GType[] crossResults(GType obj);
}
