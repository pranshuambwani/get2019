package assignment6_2;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Ignore;
import org.junit.Test;

import assignment6_2.Polynomial.Terms;


public class PolyTest {

	@Test
	public void EvaluateTest(){
		Polynomial poly=new Polynomial(new Integer[]{1,2,1,1,4,0});
		float value=(float)2;
		Assert.assertEquals((Integer)10,poly.Evaluate(value));
		Assert.assertNotEquals((Integer)2,poly.Evaluate(value));
		
	}
	
	@Test
	public void DegreeTest(){
		Polynomial poly=new Polynomial(new Integer[]{1,4,2,5,1,2,1,0});
		Assert.assertEquals((Integer)5,poly.getPolynomialDegree());
		Assert.assertNotEquals((Integer)2,poly.getPolynomialDegree());
		}
	
	@Test
	public void AddTest(){
		Polynomial poly1=new Polynomial(new Integer[]{1,2,1,1,4,0});
		Polynomial poly2=new Polynomial(new Integer[]{1,2,1,1,4,0});
		Polynomial poly=new Polynomial();
		poly=poly.addPoly(poly1,poly2);
		Integer[]result={2,2,2,1,8,0};
		Integer loop=0;
		for(Terms t1:poly.lst){
			Assert.assertEquals(result[loop], t1.coefficient);
			Assert.assertEquals(result[loop+1], t1.exponent);
			loop=loop+2;
		}
	}
	
	@Test
	public void MulTest(){
		Polynomial poly1=new Polynomial(new Integer[]{1,1,2,0});
		Polynomial poly2=new Polynomial(new Integer[]{1,1,2,0});
		Polynomial poly=new Polynomial();
		poly=poly.mulPoly(poly1,poly2);
		Integer[]result={1,2,2,1,2,1,4,0};
		Integer loop=0;
		for(Terms t1:poly.lst){
			Assert.assertEquals(result[loop], t1.coefficient);
			Assert.assertEquals(result[loop+1], t1.exponent);
			loop=loop+2;
		}
	}
}
