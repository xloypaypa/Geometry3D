package baseTypeTest;

import mathException.GMatrixSubscriptException;
import mathException.GTypeTransformException;

import org.junit.*;

import baseType.GEps;
import baseType.GMatrix;
import baseType.GPoint3;
import baseType.GVector3;

public class Vector3Test {

	@Test
	public void matrixTest1() {
		try {
			GMatrix m=new GMatrix(1, 3);
			GVector3 p=new GVector3(1,2,3);
			m.set(0, 0, 1);  m.set(0, 1, 2); m.set(0, 2, 3);
			Assert.assertTrue(m.equals(p.getMatrix()));
			Assert.assertTrue(GEps.sign(p.getX()-1)==0);
			Assert.assertTrue(GEps.sign(p.getY()-2)==0);
			Assert.assertTrue(GEps.sign(p.getZ()-3)==0);
			
			p.setX(3); p.setY(1); p.setZ(2);
			m.set(0, 0, 3);  m.set(0, 1, 1); m.set(0, 2, 2);
			Assert.assertTrue(m.equals(p.getMatrix()));
			
			p.set(new GVector3(1, 1, 1));
			m.set(0, 0, 1);  m.set(0, 1, 1); m.set(0, 2, 1);
			Assert.assertTrue(m.equals(p.getMatrix()));
			
			p=new GVector3(new GVector3(1, 1, 1));
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
			new GVector3(m);
			Assert.fail();
		} catch (GMatrixSubscriptException e) {
			Assert.fail();
		} catch (GTypeTransformException e) {
			Assert.assertTrue(true);
		}
		
		try {
			GMatrix m2=new GMatrix(1, 4);
			GVector3 p2=new GVector3();
			p2.set(m2);
			Assert.fail();
		} catch (GMatrixSubscriptException e) {
			Assert.fail();
		} catch (GTypeTransformException e) {
			Assert.assertTrue(true);
		}
		
		try {
			GMatrix m=new GMatrix(1, 3);
			new GVector3(m);
			Assert.assertTrue(true);
		} catch (GMatrixSubscriptException e) {
			Assert.fail();
		} catch (GTypeTransformException e) {
			Assert.fail();
		}
		
		try {
			GMatrix m2=new GMatrix(1, 3);
			GVector3 p2=new GVector3();
			p2.set(m2);
			Assert.assertTrue(true);
		} catch (GMatrixSubscriptException e) {
			Assert.fail();
		} catch (GTypeTransformException e) {
			Assert.fail();
			
		}
	}
	
	@Test
	public void dotTest1(){
		GVector3 v1=new GVector3(2,3,4);
		GVector3 v2=new GVector3(3,2,1);
		Assert.assertTrue(GEps.sign(v1.dot(v2)-16)==0);
		Assert.assertTrue(GEps.sign(v1.dot(3,2,1)-16)==0);
	}
	
	@Test
	public void productTest1(){
		GVector3 v1=new GVector3(2,3,4);
		GVector3 v2=new GVector3(3,2,1);
		GVector3 v3=new GVector3(-5,10,-5);
		System.out.println(v1.product(v2).getX());
		Assert.assertTrue(GEps.sign(v1.product(v2).getX()-v3.getX())==0);
		Assert.assertTrue(GEps.sign(v1.product(v2).getY()-v3.getY())==0);
		Assert.assertTrue(GEps.sign(v1.product(v2).getZ()-v3.getZ())==0);
		
		Assert.assertTrue(GEps.sign(v1.product(3,2,1).getX()-v3.getX())==0);
		Assert.assertTrue(GEps.sign(v1.product(3,2,1).getY()-v3.getY())==0);
		Assert.assertTrue(GEps.sign(v1.product(3,2,1).getZ()-v3.getZ())==0);
	}
	
}
