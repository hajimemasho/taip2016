package queriesModule.java;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
 * @author Carmen Cojocaru
 * Implements the Neville algorithm for a set of points.
 */
public class Neville {
	
	private int degree;
	private List<Point> points;
	
	public Neville() {
		points = new ArrayList<Point>();
		degree = 0;
	}
	
	public Neville(List<Point> points) {
		this.points = points;
		degree = points.size();
	}
	
	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
		this.degree = points.size();
	}
	
	public Polynomial compute() {
		return computeComponent(0, degree - 1);
	}
	
	public Polynomial computeComponent(int i, int j) {
		Polynomial result = new Polynomial();
		if (i == j) {
			return new Polynomial(degree, Arrays.asList(this.getPoints().get(i).getY()));
		} else {
			BigInteger nominator = this.getPoints().get(j).getX().subtract(this.getPoints().get(i).getX());
			
			if (!nominator.equals(BigInteger.ZERO)) {
				Polynomial polynom1 = computeComponent(i, j - 1);
				Polynomial member1 = polynom1.multiplyByConstant(this.getPoints().get(j).getX());
				Polynomial member2 = polynom1.multiplyByX();
				
				Polynomial polynom2 = computeComponent(i + 1, j);
				Polynomial member3 = polynom2.multiplyByX();
				Polynomial member4 = polynom2.multiplyByConstant(this.getPoints().get(i).getX());
				
				Polynomial denominator = member1.substract(member2).add(member3.substract(member4));
				
				result = denominator.divide(nominator);
			}
		}
		return result;
	}
	
	
}
