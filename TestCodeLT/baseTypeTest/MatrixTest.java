package baseTypeTest;

import mathException.*;

import org.junit.*;

import baseType.GEps;
import baseType.GMatrix;

public class MatrixTest {

	@Test
	public void additionTest1() {
		GMatrix m1,m2,m3;
		try{
			m1=new GMatrix(2, 3);
			m2=new GMatrix(2, 3);
			m3=new GMatrix(2, 3);
			m1.set(0, 0, 1); m1.set(0, 1, 2); m1.set(0, 2, 3);
			m1.set(1, 0, 4); m1.set(1, 1, 5); m1.set(1, 2, 6);
			
			m2.set(0, 0, 1); m2.set(0, 1, 1); m2.set(0, 2, 1);
			m2.set(1, 0, 2); m2.set(1, 1, 2); m2.set(1, 2, 2);
			
			m3.set(0, 0, 2); m3.set(0, 1, 3); m3.set(0, 2, 4);
			m3.set(1, 0, 6); m3.set(1, 1, 7); m3.set(1, 2, 8);
		
			Assert.assertTrue(m1.addition(m2).equals(m3));
		}catch(GMatrixSubscriptException e){
			Assert.fail();
		}
	}
	
	@Test
	public void additionTest2() {
		GMatrix m1,m2;
		
		try{
			m1=new GMatrix(2, 3);
			m2=new GMatrix(3, 2);
			m1.addition(m2);
			Assert.fail();
		}catch(GMatrixSubscriptException e){
			Assert.assertTrue(true);
		}
		
		try {
			m1=new GMatrix(2, 3);
			m2=new GMatrix(2, 4);
			m1.addition(m2);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
		
		try {
			m1=new GMatrix(2, 3);
			m2=new GMatrix(3, 3);
			m1.addition(m2);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void subtractionTest1() {
		GMatrix m1,m2,m3;
		try{
			m1=new GMatrix(2, 3);
			m2=new GMatrix(2, 3);
			m3=new GMatrix(2, 3);
			m1.set(0, 0, 1); m1.set(0, 1, 2); m1.set(0, 2, 3);
			m1.set(1, 0, 4); m1.set(1, 1, 5); m1.set(1, 2, 6);
			
			m2.set(0, 0, 1); m2.set(0, 1, 1); m2.set(0, 2, 1);
			m2.set(1, 0, 2); m2.set(1, 1, 2); m2.set(1, 2, 2);
			
			m3.set(0, 0, 0); m3.set(0, 1, 1); m3.set(0, 2, 2);
			m3.set(1, 0, 2); m3.set(1, 1, 3); m3.set(1, 2, 4);
			
			Assert.assertTrue(m1.subtraction(m2).equals(m3));
		}catch(GMatrixSubscriptException e){
			Assert.fail();
		}
	}
	
	@Test
	public void subtractionTest2() {
		GMatrix m1,m2;
		try{
			m1=new GMatrix(2, 3);
			m2=new GMatrix(3, 2);
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
	public void subtractionTest3() {
		GMatrix m1,m2;
		try{
			m1=new GMatrix(2, 3);
			m2=new GMatrix(2, 4);
			m1.subtraction(m2);
			Assert.fail();
			
			m2=new GMatrix(3, 3);
			m1.subtraction(m2);
			Assert.fail();
		}catch(GMatrixSubscriptException e){
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void multiplicationTest1() {
		GMatrix m1,m2,m3;
		try{
			m1=new GMatrix(2, 3);
			m2=new GMatrix(3, 2);
			m3=new GMatrix(2, 2);
			m1.set(0, 0, 1); m1.set(0, 1, 2); m1.set(0, 2, 3);
			m1.set(1, 0, 4); m1.set(1, 1, 5); m1.set(1, 2, 6);
			
			m2.set(0, 0, 1); m2.set(1, 0, 1); m2.set(2, 0, 1);
			m2.set(0, 1, 2); m2.set(1, 1, 2); m2.set(2, 1, 2);
			
			m3.set(0, 0, 6); m3.set(0, 1, 12);
			m3.set(1, 0, 15); m3.set(1, 1, 30);
			
			Assert.assertTrue(m1.multiplication(m2).equals(m3));
			Assert.assertEquals(15, m3.get(1, 0), GEps.eps);
		}catch(GMatrixSubscriptException e){
			Assert.fail();
		}
	}
	
	@Test
	public void multiplicationTest2() {
		GMatrix m1,m2;
		try{
			m1=new GMatrix(2, 3);
			m2=new GMatrix(2, 3);
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
	
	@Test
	public void multiplicationTest3() {
		GMatrix m1,m2,m3;
		try{
			m1=new GMatrix(2, 3);
			m2=new GMatrix(3, 3);
			m3=new GMatrix(2, 3);
			m1.set(0, 0, 1); m1.set(0, 1, 2); m1.set(0, 2, 3);
			m1.set(1, 0, 4); m1.set(1, 1, 5); m1.set(1, 2, 6);
			
			m2.set(0, 0, 1); m2.set(0, 1, 2); m2.set(0, 2, 1);
			m2.set(1, 0, 2); m2.set(1, 1, 1); m2.set(1, 2, 2);
			m2.set(2, 0, 0); m2.set(2, 1, 0); m2.set(2, 2, 1);
			
			m3.set(0, 0, 5); m3.set(0, 1, 4); m3.set(0, 2, 8);
			m3.set(1, 0, 14); m3.set(1, 1, 13); m3.set(1, 2, 20);
			
			Assert.assertTrue(m1.multiplication(m2).equals(m3));
			Assert.assertEquals(14, m3.get(1, 0), GEps.eps);
		}catch(GMatrixSubscriptException e){
			Assert.fail();
		}
	}
	
	@Test
	public void multiplicationTest4() {
		GMatrix m1,m3;
		try{
			m1=new GMatrix(2, 3);
			m3=new GMatrix(2, 3);
			m1.set(0, 0, 1); m1.set(0, 1, 2); m1.set(0, 2, 3);
			m1.set(1, 0, 4); m1.set(1, 1, 5); m1.set(1, 2, 6);
			
			m3.set(0, 0, 5); m3.set(0, 1, 10); m3.set(0, 2, 15);
			m3.set(1, 0, 20); m3.set(1, 1, 25); m3.set(1, 2, 30);
			
			Assert.assertTrue(m1.multiplication(5).equals(m3));
			Assert.assertEquals(20, m3.get(1, 0), GEps.eps);
		}catch(GMatrixSubscriptException e){
			Assert.fail();
		}
	}
	
	@Test
	public void equalTest1(){
		GMatrix m1,m2;
		try{
			m1=new GMatrix(1, 2);
			m2=new GMatrix(2, 2);
			Assert.assertFalse(m1.equals(m2));
		}catch(GMatrixSubscriptException e){
			Assert.fail();
		}
		
		try{
			m1=new GMatrix(1, 2);
			m2=new GMatrix(1, 3);
			Assert.assertFalse(m1.equals(m2));
		}catch(GMatrixSubscriptException e){
			Assert.fail();
		}
		
		try{
			m1=new GMatrix(1, 2);
			m2=new GMatrix(3, 3);
			Assert.assertFalse(m1.equals(m2));
		}catch(GMatrixSubscriptException e){
			Assert.fail();
		}
		
		try{
			m1=new GMatrix(1, 2);
			m2=new GMatrix(1, 2);
			m2.set(0, 1, 10086);
			Assert.assertFalse(m1.equals(m2));
		}catch(GMatrixSubscriptException e){
			Assert.fail();
		}
	}
	
	@Test
	public void equalTest2(){
		GMatrix m1,m2;
		try{
			m1=new GMatrix(1, 2);
			m2=new GMatrix(m1);
			Assert.assertTrue(m1.equals(m2));
		}catch(GMatrixSubscriptException e){
			Assert.fail();
		}
	}
	
	@Test
	public void setTest1(){
		GMatrix m1;
		try{
			m1=new GMatrix(1, 2);
			m1.set(-1, 1, 3);
			Assert.fail();
		}catch(GMatrixSubscriptException e){
			Assert.assertTrue(true);
		}
		
		try{
			m1=new GMatrix(1, 2);
			m1.set(2, 1, 3);
			Assert.fail();
		}catch(GMatrixSubscriptException e){
			Assert.assertTrue(true);
		}
		
		try{
			m1=new GMatrix(1, 2);
			m1.set(0, -1, 3);
			Assert.fail();
		}catch(GMatrixSubscriptException e){
			Assert.assertTrue(true);
		}
		
		try{
			m1=new GMatrix(1, 2);
			m1.set(0, 2, 3);
			Assert.fail();
		}catch(GMatrixSubscriptException e){
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void getTest1(){
		GMatrix m1;
		try{
			m1=new GMatrix(1, 2);
			m1.get(-1, 1);
			Assert.fail();
		}catch(GMatrixSubscriptException e){
			Assert.assertTrue(true);
		}
		
		try{
			m1=new GMatrix(1, 2);
			m1.get(2, 1);
			Assert.fail();
		}catch(GMatrixSubscriptException e){
			Assert.assertTrue(true);
		}
		
		try{
			m1=new GMatrix(1, 2);
			m1.get(0, -1);
			Assert.fail();
		}catch(GMatrixSubscriptException e){
			Assert.assertTrue(true);
		}
		
		try{
			m1=new GMatrix(1, 2);
			m1.get(0, 2);
			Assert.fail();
		}catch(GMatrixSubscriptException e){
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void buildTest1(){
		try{
			new GMatrix(0, 2);
			Assert.fail();
		}catch(GMatrixSubscriptException e){
			Assert.assertTrue(true);
		}
		
		try{
			new GMatrix(1, 0);
			Assert.fail();
		}catch(GMatrixSubscriptException e){
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void transposeTest1(){
		GMatrix m1,m2;
		try{
			m1=new GMatrix(2, 3);
			m2=new GMatrix(3, 2);
			m1.set(0, 0, 1); m1.set(0, 1, 2); m1.set(0, 2, 3);
			m1.set(1, 0, 4); m1.set(1, 1, 5); m1.set(1, 2, 6);
			
			m2.set(0, 0, 1); m2.set(1, 0, 2); m2.set(2, 0, 3);
			m2.set(0, 1, 4); m2.set(1, 1, 5); m2.set(2, 1, 6);
			
			Assert.assertTrue(m1.transpose().equals(m2));
		}catch(GMatrixSubscriptException e){
			Assert.fail();
		}
	}
	
	@Test
	public void gaussEliminationTest1(){
		GMatrix m1,m2;
		try{
			m1=new GMatrix(2, 3);
			m2=new GMatrix(2, 3);
			m1.set(0, 0, 1); m1.set(0, 1, 2); m1.set(0, 2, 3);
			m1.set(1, 0, 4); m1.set(1, 1, 5); m1.set(1, 2, 6);
			
			m2.set(0, 0, 1); m2.set(0, 1, 0); m2.set(0, 2, -1);
			m2.set(1, 0, 0); m2.set(1, 1, 1); m2.set(1, 2, 2);
			
			Assert.assertTrue(m1.gaussElimination().equals(m2));
		}catch(GMatrixSubscriptException e){
			Assert.fail();
		}
	}
	
	@Test
	public void gaussEliminationTest2(){
		GMatrix m1,m2;
		try{
			m1=new GMatrix(2, 3);
			m2=new GMatrix(2, 3);
			m1.set(0, 0, 1); m1.set(0, 1, 2); m1.set(0, 2, 3);
			m1.set(1, 0, 4); m1.set(1, 1, 5); m1.set(1, 2, 6);
			m1=m1.transpose();
			
			m2.set(0, 0, 1); m2.set(0, 1, 0); m2.set(0, 2, 0);
			m2.set(1, 0, 0); m2.set(1, 1, 1); m2.set(1, 2, 0);
			m2=m2.transpose();
			
			Assert.assertTrue(m1.gaussElimination().equals(m2));
		}catch(GMatrixSubscriptException e){
			Assert.fail();
		}
	}
	
	@Test
	public void gaussEliminationTest3(){
		GMatrix m1,m2;
		try{
			m1=new GMatrix(2, 3);
			m2=new GMatrix(2, 3);
			m1.set(0, 0, 1); m1.set(0, 1, 2); m1.set(0, 2, 3);
			m1.set(1, 0, 1); m1.set(1, 1, 2); m1.set(1, 2, 3);
			
			m2.set(0, 0, 1); m2.set(0, 1, 2); m2.set(0, 2, 3);
			m2.set(1, 0, 0); m2.set(1, 1, 0); m2.set(1, 2, 0);
			
			Assert.assertTrue(m1.gaussElimination().equals(m2));
		}catch(GMatrixSubscriptException e){
			Assert.fail();
		}
	}
	
	@Test
	public void matrixTest1(){
		GMatrix m1;
		try{
			m1=new GMatrix(2, 3);
			m1.set(0, 0, 1); m1.set(0, 1, 2); m1.set(0, 2, 3);
			m1.set(1, 0, 4); m1.set(1, 1, 5); m1.set(1, 2, 6);
			
			double[] a={1,2,3,4,5,6};
			
			Assert.assertArrayEquals(a, m1.getMatrix(), GEps.eps);
		}catch(GMatrixSubscriptException e){
			Assert.fail();
		}
	}
	
	@Test
	public void inverseTest1(){
		GMatrix m1,I;
		try{
			m1=new GMatrix(3, 3);
			m1.set(0, 0, 1); m1.set(0, 1, 2); m1.set(0, 2, 3);
			m1.set(1, 0, 4); m1.set(1, 1, 5); m1.set(1, 2, 6);
			m1.set(2, 0, 5); m1.set(2, 1, 5); m1.set(2, 2, 6);
			
			I=new GMatrix(3, 3);
			for (int i=0;i<3;i++){
				I.set(i, i, 1);
			}
			
			Assert.assertTrue(m1.multiplication(m1.inverse()).equals(I));
		}catch(GMatrixException e){
			Assert.fail();
		}
		
		try{
			m1=new GMatrix(3, 3);
			m1.set(0, 0, 1); m1.set(0, 1, 2); m1.set(0, 2, 3);
			m1.set(1, 0, 4); m1.set(1, 1, 5); m1.set(1, 2, 6);
			m1.set(2, 0, 9); m1.set(2, 1, 9); m1.set(2, 2, 10);
			
			I=new GMatrix(3, 3);
			for (int i=0;i<3;i++){
				I.set(i, i, 1);
			}
			
			Assert.assertTrue(m1.multiplication(m1.inverse()).equals(I));
		}catch(GMatrixException e){
			Assert.fail();
		}
	}
	
	@Test
	public void inverseTest2(){
		GMatrix m1;
		
		try{
			m1=new GMatrix(3, 3);
			m1.set(0, 0, 1); m1.set(0, 1, 2); m1.set(0, 2, 3);
			m1.set(1, 0, 4); m1.set(1, 1, 5); m1.set(1, 2, 6);
			m1.set(2, 0, 9); m1.set(2, 1, 9); m1.set(2, 2, 9);
			
			m1.inverse();
			
			Assert.fail();
		}catch(GMatrixInverseException e){
			Assert.assertEquals("matrix cannot inverse.", e.getMessage());
		} catch (GMatrixSubscriptException e) {
			Assert.fail();
		}
		
		try{
			m1=new GMatrix(2, 3);
			m1.inverse();
			Assert.fail();
		}catch(GMatrixInverseException e){
			Assert.assertEquals("matrix not be square matrix.", e.getMessage());
		} catch (GMatrixSubscriptException e) {
			Assert.fail();
		}
	}

}
