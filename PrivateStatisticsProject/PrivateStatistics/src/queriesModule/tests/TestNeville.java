package queriesModule.tests;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import queriesModule.java.Neville;
import queriesModule.java.Point;
import queriesModule.java.Polynomial;

/**
 * 
 * @author Carmen Cojocaru
 *
 */
public class TestNeville {
	
	@Test
	public void testComputeComponent_0_0() {
		Neville alg = new Neville();
		
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(BigInteger.ONE, BigInteger.ZERO));
		points.add(new Point(new BigInteger("2"), new BigInteger("2")));
		points.add(new Point(new BigInteger("4"), new BigInteger("12")));
		
		alg.setPoints(points);
		
		Polynomial result = alg.computeComponent(0, 0);
		
		Assert.assertEquals(result.getCoeffs(), Arrays.asList(BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO));
	}
	
	@Test
	public void testComputeComponent_1_1() {
		Neville alg = new Neville();
		
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(BigInteger.ONE, BigInteger.ZERO));
		points.add(new Point(new BigInteger("2"), new BigInteger("2")));
		points.add(new Point(new BigInteger("4"), new BigInteger("12")));
		
		alg.setPoints(points);
		
		Polynomial result = alg.computeComponent(1, 1);
		
		Assert.assertEquals(result.getCoeffs(), Arrays.asList(new BigInteger("2"), BigInteger.ZERO, BigInteger.ZERO));
	}
	
	@Test
	public void testComputeComponent_0_1() {
		Neville alg = new Neville();
		
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(BigInteger.ONE, BigInteger.ZERO));
		points.add(new Point(new BigInteger("2"), new BigInteger("2")));
		points.add(new Point(new BigInteger("4"), new BigInteger("12")));
		
		alg.setPoints(points);
		
		Polynomial result = alg.computeComponent(0, 1);
		
		Assert.assertEquals(result.getCoeffs(), Arrays.asList(new BigInteger("-2"), new BigInteger("2"), BigInteger.ZERO));
	}
	
	@Test
	public void testComputeComponent_1_2() {
		Neville alg = new Neville();
		
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(BigInteger.ONE, BigInteger.ZERO));
		points.add(new Point(new BigInteger("2"), new BigInteger("2")));
		points.add(new Point(new BigInteger("4"), new BigInteger("12")));
		
		alg.setPoints(points);
		
		Polynomial result = alg.computeComponent(1, 2);
		
		Assert.assertEquals(result.getCoeffs(), Arrays.asList(new BigInteger("-8"), new BigInteger("5"), BigInteger.ZERO));
	}
	
	@Test
	public void testComputeComponent_0_2() {
		Neville alg = new Neville();
		
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(BigInteger.ONE, BigInteger.ZERO));
		points.add(new Point(new BigInteger("2"), new BigInteger("2")));
		points.add(new Point(new BigInteger("4"), new BigInteger("12")));
		
		alg.setPoints(points);
		
		Polynomial result = alg.computeComponent(0, 2);
		
		Assert.assertEquals(result.getCoeffs(), Arrays.asList(BigInteger.ZERO, new BigInteger("-1"), BigInteger.ONE));
	}
	
	@Test
	public void testCompute() {
		Neville alg = new Neville();
		
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(BigInteger.ONE, BigInteger.ZERO));
		points.add(new Point(new BigInteger("2"), new BigInteger("2")));
		points.add(new Point(new BigInteger("4"), new BigInteger("12")));
		
		alg.setPoints(points);
		
		Polynomial result = alg.compute();
	
		Assert.assertEquals(result.getCoeffs(), Arrays.asList(BigInteger.ZERO, new BigInteger("-1"), BigInteger.ONE));
	}
}
