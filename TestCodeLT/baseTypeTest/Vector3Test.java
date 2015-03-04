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
			
			p=new GVector3(new GPoint3(2, 3, 4), new GPoint3(3, 4, 5));
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
		Assert.assertTrue(GEps.sign(v1.product(v2).getX()-v3.getX())==0);
		Assert.assertTrue(GEps.sign(v1.product(v2).getY()-v3.getY())==0);
		Assert.assertTrue(GEps.sign(v1.product(v2).getZ()-v3.getZ())==0);
		
		Assert.assertTrue(GEps.sign(v1.product(3,2,1).getX()-v3.getX())==0);
		Assert.assertTrue(GEps.sign(v1.product(3,2,1).getY()-v3.getY())==0);
		Assert.assertTrue(GEps.sign(v1.product(3,2,1).getZ()-v3.getZ())==0);
	}
	
	@Test
	public void lengthTest1(){
		GVector3 v=new GVector3(1,2,3);
		Assert.assertTrue(GEps.sign(v.length()-Math.sqrt(14))==0);
	}
	
	@Test
	public void lengthTest2(){
		GVector3 v1=new GVector3(1,1,0);
		GVector3 v2=new GVector3((float)Math.sqrt(2),(float)Math.sqrt(2),0);
		v1=v1.changeLength(2);
		Assert.assertTrue(v1.equal(v2));
		
		v1=new GVector3(0, 0, 0);
		Assert.assertTrue(v1.isEmpty());
		
		v1=new GVector3(1,1,0);
		v2=new GVector3((float)Math.sqrt(2)/2,(float)Math.sqrt(2)/2,0);
		v1=v1.normalize();
		Assert.assertTrue(v1.equal(v2));
		v1=v1.changeLength(2);
		Assert.assertFalse(v1.equal(v2));
	}
	
	@Test
	public void directionTest1(){
		GVector3 v1=new GVector3(1,2,3);
		GVector3 v2=new GVector3(2,4,6);
		Assert.assertTrue(v1.isSameDirection(v2));
		Assert.assertTrue(v1.isReverse(v2.reverse()));
		Assert.assertFalse(v1.isReverse(v2));
		Assert.assertFalse(v1.isSameDirection(v2.reverse()));
		v2=new GVector3(1,1,1);
		Assert.assertFalse(v1.isReverse(v2));
	}
	
	@Test
	public void directionTest2(){
		GVector3 v1=new GVector3(1,2,3);
		GVector3 v2=new GVector3(2,4,7);
		Assert.assertFalse(v1.isSameDirection(v2));
		Assert.assertFalse(v1.isReverse(v2.reverse()));
	}
	
	@Test
	public void floatTest1(){
		GVector3 v1=new GVector3(1,2,3);
		GVector3 v2=new GVector3(2,3,4);
		v1=v1.add(1);
		Assert.assertTrue(v1.equal(v2));
		
		v1=new GVector3(1,2,3);
		v2=new GVector3(2,3,4);
		v2=v2.sub(1);
		Assert.assertTrue(v1.equal(v2));
		
		v1=new GVector3(1,2,3);
		v2=new GVector3(2,4,6);
		v1=v1.mul(2);
		Assert.assertTrue(v1.equal(v2));
	}
	
	@Test
	public void angleTest1(){
		GVector3 v1=new GVector3(1,0,0);
		GVector3 v2=new GVector3(1,1,0);
		Assert.assertEquals(Math.acos(-1)/4, v1.getAngle(v2), GEps.eps);
	}
	
	@Test
	public void projectionTest1(){
		GVector3 v1=new GVector3(1,0,0);
		GVector3 v2=new GVector3(1,1,0);
		Assert.assertEquals(1, v2.getProjection(v1), GEps.eps);
	}
	
}
