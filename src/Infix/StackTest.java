package Infix;


import org.junit.Assert;
import org.junit.Test;

public class StackTest {

	@Test
	public void checkExpression1(){
		Assert.assertEquals((Integer)InfixExpression.evaluateString("3 * 4 + ( 5 * 2 )"),(Integer) 22);
	}
	
	@Test
	public void checkExpression2(){
		Assert.assertEquals((Integer)InfixExpression.evaluateString("3 * 4 + ( 5 * 2 ) > 23"),(Integer) 0);
	}
	
	@Test
	public void checkExpression3(){
		Assert.assertEquals((Integer)InfixExpression.evaluateString("3 * 4 < ( 5 * 2 ) && 23"),(Integer) 0);
	}
}

