package baseType;

public class GEps {
	public static double eps=1e-2;
	public static int sign(double value){
		if (value>eps) return 1;
		else if (value<-eps) return -1;
		else return 0;
	}
}
