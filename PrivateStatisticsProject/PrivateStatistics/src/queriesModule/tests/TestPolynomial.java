package queriesModule.tests;

import java.math.BigInteger;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import queriesModule.java.Polynomial;

public class TestPolynomial {
	
	@Test
	public void testPolynomialWithDegreeAndConstant() {
		int degree = 4;
		BigInteger constant = BigInteger.TEN;
		Polynomial p = new Polynomial(degree, Arrays.asList(constant));
		
		Assert.assertEquals(p.get(0), BigInteger.TEN);
	}
	
	@Test
	public void testCopy() {
		Polynomial p = new Polynomial(3, Arrays.asList(BigInteger.ONE, new BigInteger("2"), new BigInteger("3")));
		Polynomial cp = p.copy();
		
		Assert.assertEquals(p.getCoeffs(), cp.getCoeffs());
	}
	
	@Test
	public void testMultiplyByConstant() {
		BigInteger constant = new BigInteger("2");
		Polynomial p = new Polynomial(3, Arrays.asList(BigInteger.ONE, new BigInteger("2"), new BigInteger("3")));
		Polynomial result = p.multiplyByConstant(constant);
		
		Assert.assertEquals(result.getCoeffs(), Arrays.asList(new BigInteger("2"), new BigInteger("4"), new BigInteger("6")));
	}
	
	@Test
	public void testMultiplyByX() {
		Polynomial p = new Polynomial(3, Arrays.asList(BigInteger.ONE, new BigInteger("2"), new BigInteger("3")));
		Polynomial result = p.multiplyByX();
		
		Assert.assertEquals(result.getCoeffs(), Arrays.asList(BigInteger.ZERO, new BigInteger("1"), new BigInteger("2")));
	}
	
	@Test
	public void testAdd() {
		Polynomial result = new Polynomial();
		Polynomial p1 = new Polynomial(3, Arrays.asList(BigInteger.ONE, new BigInteger("2"), new BigInteger("3")));
		Polynomial p2 = new Polynomial(3, Arrays.asList(new BigInteger("4"), new BigInteger("5"), new BigInteger("6")));
		result = p1.add(p2);
		
		Assert.assertEquals(result.getCoeffs(), Arrays.asList(new BigInteger("5"), new BigInteger("7"), new BigInteger("9")));
	}
	
	@Test
	public void testSubstract() {
		Polynomial result = new Polynomial();
		Polynomial p1 = new Polynomial(3, Arrays.asList(new BigInteger("4"), new BigInteger("5"), new BigInteger("6")));
		Polynomial p2 = new Polynomial(3, Arrays.asList(new BigInteger("1"), new BigInteger("3"), new BigInteger("3")));
		result = p1.substract(p2);
		
		Assert.assertEquals(result.getCoeffs(), Arrays.asList(new BigInteger("3"), new BigInteger("2"), new BigInteger("3")));
	}
}
