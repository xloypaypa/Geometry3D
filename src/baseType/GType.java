package baseType;

public interface GType {
	public boolean equals(GType obj);
	public double distance(GType obj);
	public boolean cross(GType obj);
	public GType[] crossResults(GType obj);
}
