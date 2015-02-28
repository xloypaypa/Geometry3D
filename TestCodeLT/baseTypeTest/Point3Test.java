package baseTypeTest;

import mathException.GMatrixSubscriptException;
import mathException.GTypeTransformException;

import org.junit.*;

import baseType.GEps;
import baseType.GMatrix;
import baseType.GPoint3;
import baseType.GVector3;

public class Point3Test {

	@Test
	public void matrixTest1() {
		try {
			GMatrix m=new GMatrix(1, 3);
			GPoint3 p=new GPoint3(1,2,3);
			m.set(0, 0, 1);  m.set(0, 1, 2); m.set(0, 2, 3);
			Assert.assertTrue(m.equals(p.getMatrix()));
			Assert.assertTrue(GEps.sign(p.getX()-1)==0);
			Assert.assertTrue(GEps.sign(p.getY()-2)==0);
			Assert.assertTrue(GEps.sign(p.getZ()-3)==0);
			
			p.setX(3); p.setY(1); p.setZ(2);
			m.set(0, 0, 3);  m.set(0, 1, 1); m.set(0, 2, 2);
			Assert.assertTrue(m.equals(p.getMatrix()));
			
			p.set(new GPoint3(1, 1, 1));
			m.set(0, 0, 1);  m.set(0, 1, 1); m.set(0, 2, 1);
			Assert.assertTrue(m.equals(p.getMatrix()));
			
			p=new GPoint3(new GPoint3(1, 1, 1));
			m.set(0, 0, 1);  m.set(0, 1, 1); m.set(0, 2, 1);
			Assert.assertTrue(m.equals(p.getMatrix()));
			
			p.set(1, 1, 1);
			m.set(0, 0, 1);  m.set(0, 1, 1); m.set(0, 2, 1);
			Assert.assertTrue(m.equals(p.getMatrix()));
		} catch (GMatrixSubscriptException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void matrixTest2() {
		try {
			GMatrix m=new GMatrix(1, 4);
			new GPoint3(m);
			Assert.fail();
		} catch (GMatrixSubscriptException e) {
			Assert.fail();
		} catch (GTypeTransformException e) {
			Assert.assertTrue(true);
		}
		
		try {
			GMatrix m2=new GMatrix(1, 4);
			GPoint3 p2=new GPoint3();
			p2.set(m2);
			Assert.fail();
		} catch (GMatrixSubscriptException e) {
			Assert.fail();
		} catch (GTypeTransformException e) {
			Assert.assertTrue(true);
		}
		
		try {
			GMatrix m=new GMatrix(1, 3);
			new GPoint3(m);
			Assert.assertTrue(true);
		} catch (GMatrixSubscriptException e) {
			Assert.fail();
		} catch (GTypeTransformException e) {
			Assert.fail();
		}
		
		try {
			GMatrix m2=new GMatrix(1, 3);
			GPoint3 p2=new GPoint3();
			p2.set(m2);
			Assert.assertTrue(true);
		} catch (GMatrixSubscriptException e) {
			Assert.fail();
		} catch (GTypeTransformException e) {
			Assert.fail();
			
		}
	}
	
	@Test
	public void addTest1(){
		GPoint3 p1,p2,p3;
		p1=new GPoint3(1,1,1); p2=new GPoint3(1,2,3);
		p3=new GPoint3(2, 3, 4);
		Assert.assertTrue(GEps.sign(p1.add(p2).getX()-p3.getX())==0);
		Assert.assertTrue(GEps.sign(p1.add(p2).getY()-p3.getY())==0);
		Assert.assertTrue(GEps.sign(p1.add(p2).getZ()-p3.getZ())==0);
		
		p1=new GPoint3(1,1,1); GVector3 v=new GVector3(1, 2, 3);
		p3=new GPoint3(2, 3, 4);
		Assert.assertTrue(GEps.sign(p1.add(v).getX()-p3.getX())==0);
		Assert.assertTrue(GEps.sign(p1.add(v).getY()-p3.getY())==0);
		Assert.assertTrue(GEps.sign(p1.add(v).getZ()-p3.getZ())==0);
	}
	
	@Test
	public void subTest1(){
		GPoint3 p1,p2,p3;
		p1=new GPoint3(1,1,1); p2=new GPoint3(1,2,3);
		p3=new GPoint3(0, -1, -2);
		Assert.assertTrue(GEps.sign(p1.sub(p2).getX()-p3.getX())==0);
		Assert.assertTrue(GEps.sign(p1.sub(p2).getY()-p3.getY())==0);
		Assert.assertTrue(GEps.sign(p1.sub(p2).getZ()-p3.getZ())==0);
		
		p1=new GPoint3(1,1,1); GVector3 v=new GVector3(1, 2, 3);
		p3=new GPoint3(0, -1, -2);
		Assert.assertTrue(GEps.sign(p1.sub(v).getX()-p3.getX())==0);
		Assert.assertTrue(GEps.sign(p1.sub(v).getY()-p3.getY())==0);
		Assert.assertTrue(GEps.sign(p1.sub(v).getZ()-p3.getZ())==0);
	}

}
