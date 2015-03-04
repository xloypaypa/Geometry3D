package lineTypeTest;

import lineType.GStraight3;
import mathException.TypeBuildException;

import org.junit.*;

import baseType.GPoint3;
import baseType.GType;

public class Straight3Test {

	@Test
	public void crossTest1() {
		GStraight3 s1,s2;
		try {
			s1=new GStraight3(new GPoint3(0, 0, 0), new GPoint3(0, 0, 1));
			s2=new GStraight3(new GPoint3(0, 0, 0), new GPoint3(1, 0, 0));
			Assert.assertTrue(s1.cross(s2));
			
			s1=new GStraight3(new GPoint3(0, 0, 0), new GPoint3(0, 0, 1));
			s2=new GStraight3(new GPoint3(0, 1, 0), new GPoint3(1, 1, 0));
			Assert.assertFalse(s1.cross(s2));
			
			s1=new GStraight3(new GPoint3(3, 4, 5), new GPoint3(5, 4, 3));
			s2=new GStraight3(new GPoint3(10.23f, 3.3f, 9.4f), new GPoint3(9, 10, 11));
			Assert.assertFalse(s1.cross(s2));
			
			s1=new GStraight3(new GPoint3(3, 4, 5), new GPoint3(5, 4, 3));
			s2=new GStraight3(new GPoint3(10.23f, 3.3f, 9.4f), new GPoint3(9, 10, 11));
			Assert.assertFalse(s1.cross(s2));
			
			s1=new GStraight3(new GPoint3(3, 4, 5), new GPoint3(5, 4, 3));
			s2=new GStraight3(new GPoint3(3,4,5), new GPoint3(5,4,3));
			Assert.assertTrue(s1.cross(s2));
			
			s1=new GStraight3(new GPoint3(0, 0, 0), new GPoint3(0, 0, 1));
			s2=new GStraight3(new GPoint3(0,1,0), new GPoint3(0,1,1));
			Assert.assertFalse(s1.cross(s2));
		} catch (TypeBuildException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void crossResultsTest1(){
		GStraight3 s1,s2;
		try {
			s1=new GStraight3(new GPoint3(0, 0, 0), new GPoint3(0, 0, 1));
			s2=new GStraight3(new GPoint3(0, 0, 0), new GPoint3(1, 0, 0));
			GType[] ans=s1.crossResults(s2);
			Assert.assertTrue(ans!=null);
			Assert.assertTrue(ans[0].getClass().equals(GPoint3.class));
			Assert.assertTrue(ans[0].equal(new GPoint3(0, 0, 0)));
			
			s1=new GStraight3(new GPoint3(0, 0, 0), new GPoint3(0, 0, 1));
			s2=new GStraight3(new GPoint3(0, 0, 0), new GPoint3(0, 0, 1));
			ans=s1.crossResults(s2);
			Assert.assertTrue(ans!=null);
			Assert.assertTrue(ans[0].getClass().equals(GStraight3.class));
			Assert.assertTrue(ans[0].equal(s1));
			
			s1=new GStraight3(new GPoint3(0, 0, 0), new GPoint3(0, 0, 1));
			s2=new GStraight3(new GPoint3(0, 1, 0), new GPoint3(0, 1, 1));
			ans=s1.crossResults(s2);
			Assert.assertTrue(ans==null);
			
			s1=new GStraight3(new GPoint3(0, 0, 1), new GPoint3(0, 0, 0));
			s2=new GStraight3(new GPoint3(-12, 0, 0), new GPoint3(1, 0, 0));
			ans=s1.crossResults(s2);
			Assert.assertTrue(ans!=null);
			Assert.assertTrue(ans[0].getClass().equals(GPoint3.class));
			GPoint3 p=(GPoint3) ans[0];
			System.out.println(p.getX()+" "+p.getY()+" "+p.getZ());
			Assert.assertTrue(ans[0].equal(new GPoint3(0, 0, 0)));
		} catch (TypeBuildException e) {
			Assert.fail();
		}
	}

}
