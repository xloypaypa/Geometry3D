import mathException.GMatrixInverseException;
import mathException.GMatrixSubscriptException;
import baseType.GMatrix;


public class Main {
	public static void main(String[] args){
		GMatrix m1,m2,m3;
		try{
			m1=new GMatrix(3, 3);
			m1.set(0, 0, 1); m1.set(0, 1, 2); m1.set(0, 2, 3);
			m1.set(1, 0, 4); m1.set(1, 1, 5); m1.set(1, 2, 6);
			m1.set(2, 0, 9); m1.set(2, 1, 9); m1.set(2, 2, 10);
			
			m2=m1.inverse();
			m3=m1.multiplication(m2);
			
			for (int i=0;i<3;i++){
				for (int j=0;j<3;j++){
					System.out.print(m3.get(i, j)+" ");
				}
				System.out.println();
			}
		}catch(GMatrixInverseException e){
			System.out.println(e.getMessage());
		} catch (GMatrixSubscriptException e) {
			e.printStackTrace();
		}
	}
}
