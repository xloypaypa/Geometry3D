package baseTypeTest;

import mathException.GMatrixSubscriptException;

import org.junit.*;

import baseType.GEps;
import baseType.GMatrix;

public class MatrixTest {

	@Test
	public void additionTest1() {
		GMatrix m1,m2,m3;
		m1=new GMatrix(2, 3);
		m2=new GMatrix(2, 3);
		m3=new GMatrix(2, 3);
		try{
			m1.set(0, 0, 1); m1.set(0, 1, 2); m1.set(0, 2, 3);
			m1.set(1, 0, 4); m1.set(1, 1, 5); m1.set(1, 2, 6);
			
			m2.set(0, 0, 1); m2.set(0, 1, 1); m2.set(0, 2, 1);
			m2.set(1, 0, 2); m2.set(1, 1, 2); m2.set(1, 2, 2);
			
			m3.set(0, 0, 2); m3.set(0, 1, 3); m3.set(0, 2, 4);
			m3.set(1, 0, 6); m3.set(1, 1, 7); m3.set(1, 2, 8);
		
			Assert.assertTrue(m1.addition(m2).equal(m3));
		}catch(GMatrixSubscriptException e){
			Assert.fail();
		}
	}
	
	@Test
	public void additionTest2() {
		GMatrix m1,m2;
		m1=new GMatrix(2, 3);
		m2=new GMatrix(3, 2);
		try{
			m1.set(0, 0, 1); m1.set(0, 1, 2); m1.set(0, 2, 3);
			m1.set(1, 0, 4); m1.set(1, 1, 5); m1.set(1, 2, 6);
		
			m2.set(0, 0, 1); m2.set(1, 0, 1); m2.set(2, 0, 1);
			m2.set(0, 1, 2); m2.set(1, 1, 2); m2.set(2, 1, 2);
		
			m1.addition(m2);
			Assert.fail();
		}catch(GMatrixSubscriptException e){
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void subtractionTest1() {
		GMatrix m1,m2,m3;
		m1=new GMatrix(2, 3);
		m2=new GMatrix(2, 3);
		m3=new GMatrix(2, 3);
		try{
			m1.set(0, 0, 1); m1.set(0, 1, 2); m1.set(0, 2, 3);
			m1.set(1, 0, 4); m1.set(1, 1, 5); m1.set(1, 2, 6);
			
			m2.set(0, 0, 1); m2.set(0, 1, 1); m2.set(0, 2, 1);
			m2.set(1, 0, 2); m2.set(1, 1, 2); m2.set(1, 2, 2);
			
			m3.set(0, 0, 0); m3.set(0, 1, 1); m3.set(0, 2, 2);
			m3.set(1, 0, 2); m3.set(1, 1, 3); m3.set(1, 2, 4);
			
			Assert.assertTrue(m1.subtraction(m2).equal(m3));
		}catch(GMatrixSubscriptException e){
			Assert.fail();
		}
	}
	
	@Test
	public void subtractionTest2() {
		GMatrix m1,m2;
		m1=new GMatrix(2, 3);
		m2=new GMatrix(3, 2);
		try{
			m1.set(0, 0, 1); m1.set(0, 1, 2); m1.set(0, 2, 3);
			m1.set(1, 0, 4); m1.set(1, 1, 5); m1.set(1, 2, 6);
			
			m2.set(0, 0, 1); m2.set(1, 0, 1); m2.set(2, 0, 1);
			m2.set(0, 1, 2); m2.set(1, 1, 2); m2.set(2, 1, 2);
		
			m1.subtraction(m2);
			Assert.fail();
		}catch(GMatrixSubscriptException e){
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void multiplicationTest1() {
		GMatrix m1,m2,m3;
		m1=new GMatrix(2, 3);
		m2=new GMatrix(3, 2);
		m3=new GMatrix(2, 2);
		try{
			m1.set(0, 0, 1); m1.set(0, 1, 2); m1.set(0, 2, 3);
			m1.set(1, 0, 4); m1.set(1, 1, 5); m1.set(1, 2, 6);
			
			m2.set(0, 0, 1); m2.set(1, 0, 1); m2.set(2, 0, 1);
			m2.set(0, 1, 2); m2.set(1, 1, 2); m2.set(2, 1, 2);
			
			m3.set(0, 0, 6); m3.set(0, 1, 12);
			m3.set(1, 0, 15); m3.set(1, 1, 30);
			
			Assert.assertTrue(m1.subtraction(m2).equal(m3));
			Assert.assertEquals(15, m3.get(1, 0), GEps.eps);
		}catch(GMatrixSubscriptException e){
			Assert.fail();
		}
	}
	
	@Test
	public void multiplicationTest2() {
		GMatrix m1,m2;
		m1=new GMatrix(2, 3);
		m2=new GMatrix(2, 3);
		try{
			m1.set(0, 0, 1); m1.set(0, 1, 2); m1.set(0, 2, 3);
			m1.set(1, 0, 4); m1.set(1, 1, 5); m1.set(1, 2, 6);
			
			m2.set(0, 0, 1); m2.set(0, 1, 1); m2.set(0, 2, 1);
			m2.set(1, 0, 2); m2.set(1, 1, 2); m2.set(1, 2, 2);
			
			m1.multiplication(m2);
			Assert.fail();
		}catch(GMatrixSubscriptException e){
			Assert.assertTrue(true);
		}
	}
	
	

}
