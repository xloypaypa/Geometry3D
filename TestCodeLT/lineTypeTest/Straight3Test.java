package lineTypeTest;

import java.util.Random;

import lineType.GStraight3;
import mathException.TypeBuildException;

import org.junit.*;

import baseType.GEps;
import baseType.GPoint3;
import baseType.GType;
import baseType.GVector3;

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
			Assert.assertTrue(ans[0].equals(new GPoint3(0, 0, 0)));
			
			s1=new GStraight3(new GPoint3(0, 0, 0), new GPoint3(0, 0, 1));
			s2=new GStraight3(new GPoint3(0, 0, 0), new GPoint3(0, 0, 1));
			ans=s1.crossResults(s2);
			Assert.assertTrue(ans!=null);
			Assert.assertTrue(ans[0].getClass().equals(GStraight3.class));
			Assert.assertTrue(ans[0].equals(s1));
			
			s1=new GStraight3(new GPoint3(0, 0, 0), new GPoint3(0, 0, 1));
			s2=new GStraight3(new GPoint3(0, 1, 0), new GPoint3(0, 1, 1));
			ans=s1.crossResults(s2);
			Assert.assertTrue(ans==null);
			
			s1=new GStraight3(new GPoint3(0, 0, 1), new GPoint3(0, 0, 0));
			s2=new GStraight3(new GPoint3(-12, 0, 0), new GPoint3(1, 0, 0));
			ans=s1.crossResults(s2);
			Assert.assertTrue(ans!=null);
			Assert.assertTrue(ans[0].getClass().equals(GPoint3.class));
			Assert.assertTrue(ans[0].equals(new GPoint3(0, 0, 0)));
			
			GPoint3 cross=new GPoint3();
			GVector3 v1,v2,v3,v4;
			
			v1=new GVector3(1, 2, 3); v2=v1.reverse();
			v3=new GVector3(3, 3, 3); v4=v3.reverse();
			
			s1=new GStraight3(cross.move(v1), cross.move(v2));
			s2=new GStraight3(cross.move(v3), cross.move(v4));
			ans=s1.crossResults(s2);
			
			Assert.assertTrue(ans!=null);
			Assert.assertTrue(ans[0].getClass().equals(GPoint3.class));
			Assert.assertTrue(ans[0].equals(cross));
			
			v1=new GVector3(-1, -1, -2); v2=v1.reverse();
			v3=new GVector3(-3, -3, -3); v4=v3.reverse();
			
			s1=new GStraight3(cross.move(v1), cross);
			s2=new GStraight3(cross.move(v3), cross);
			ans=s1.crossResults(s2);
			
			Assert.assertTrue(ans!=null);
			Assert.assertTrue(ans[0].getClass().equals(GPoint3.class));
			Assert.assertTrue(ans[0].equals(cross));
		} catch (TypeBuildException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void crossResultsTest2(){
		GStraight3 s1,s2;
		GType[] ans;
		GPoint3 cross;
		GVector3 v1,v2,v3,v4;
		int x,y,z;
		
		try {
			Random random=new Random();
			for (int i=0;i<100000;i++){
				x=random.nextInt()%1000; y=random.nextInt()%1000; z=random.nextInt()%1000;
				cross=new GPoint3(x,y,z);
				
				z=0;
				while (z==0) z=random.nextInt();
				v1=new GVector3(random.nextInt(), random.nextInt(), z); v2=v1.reverse();
				
				z=0;
				while (z==0) z=random.nextInt();
				v3=new GVector3(random.nextInt(), random.nextInt(), z); v4=v3.reverse();
				
				s1=new GStraight3(cross.move(v1), cross.move(v2));
				s2=new GStraight3(cross.move(v3), cross.move(v4));
				ans=s1.crossResults(s2);
				
				Assert.assertTrue(ans!=null);
				Assert.assertTrue(ans[0].getClass().equals(GPoint3.class));
				GEps.eps=1;
				Assert.assertTrue(ans[0].equals(cross));
				GEps.eps=1e-3;
			}
		} catch (TypeBuildException e) {
			Assert.fail();
		}
		
	}
	
	@Test
	public void distanceTest1(){
		GStraight3 s1,s2;
		try {
			s1=new GStraight3(new GPoint3(0, 0, 0), new GPoint3(0, 0, 1));
			s2=new GStraight3(new GPoint3(0, 1, 0), new GPoint3(0, 1, 1));
			Assert.assertEquals(1, s1.distance(s2), GEps.eps);
		} catch (TypeBuildException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void distanceTest2(){
		GStraight3 s1,s2;
		GPoint3 p,p2;
		GVector3 v1,v11,v2,v3,v31;
		double x,y,z,a,b,c;
		try{
			Random random=new Random();
			for (int i=0;i<100000;i++){
				p=new GPoint3(random.nextInt()%100,random.nextInt()%100,random.nextInt()%100);
				z=0;
				while (z==0) z=random.nextInt()%100;
				v1=new GVector3(random.nextInt()%100, random.nextInt()%100, z); v11=v1.reverse();
				s1=new GStraight3(p.move(v1), p.move(v11));
				
				x=0;
				while (x==0) x=random.nextInt()%100;
				y=random.nextInt()%100;
				a=v1.getX(); b=v1.getY(); c=v1.getZ();
				z=-(a*x+b*y)/c;
				v2=new GVector3(x, y, z);
				
				p2=p.move(v2);
				
				x=0;
				while (x==0) x=random.nextInt()%100;
				y=random.nextInt()%100;
				a=v2.getX(); b=v2.getY(); c=v2.getZ();
				if (GEps.sign(c)!=0){
					z=-(a*x+b*y)/c;
				}else{
					x=b; y=-a; z=0;
				}
				
				v3=new GVector3(x, y, z); v31=v3.reverse();
				s2=new GStraight3(p2.move(v3),p2.move(v31));
				
				Assert.assertEquals(v2.length(), s1.distance(s2), GEps.eps);
			}
		} catch (TypeBuildException e) {
			Assert.fail();
		}
	}

}
