package queriesModule.java;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Carmen Cojocaru
 *	P(X) = a0 + a1 * X + a2 * X^2 + ... + an * X^n
 */
public class Polynomial {
	/**
	 * Refactorizare1: 
	 * Am vrut sa fac un constructor de tipul Polynomial(int degree, Integer... list). 
	 * Insa era confuz si se putea gresi foarte usor introducand doar lista de 
	 * coeficienti si uitand de grad.
	 * Astfel, am modificat in Polynomial(int degree, List<Integer> list);
	 * Intrucat new Polynomial(2) nu mai merge in cazul asta, a trebuit sa adaug un nou 
	 * constructor pentru cazul in care vreau sa initializez un polinom cu un anumit grad.
	 * Apoi am sters constructorul de tot ca tot era confuz si voiam sa initializez cu o valoare
	 * si cand colo initializam cu un anumit grad.
	 */
	private List<BigInteger> coeffs;
	
	public Polynomial() {
		this.coeffs = new ArrayList<BigInteger>();
	}
	
	public Polynomial(int degree, List<BigInteger> coeffs) {
		this.coeffs = new ArrayList<BigInteger>();
		this.coeffs.addAll(coeffs);
		
		int i = this.coeffs.size();
		while (i < degree) {
			this.coeffs.add(BigInteger.ZERO);
			i++;
		}
	}
	
	public Polynomial copy() {
		Polynomial cp = new Polynomial();
		for (int i = 0; i < this.getCoeffs().size(); i++) {
			cp.addCoeff(this.getCoeffs().get(i));
		}
		
		return cp;
	}
	
	public List<BigInteger> getCoeffs() {
		return coeffs;
	}

	public void setCoeffs(List<BigInteger> coeffs) {
		this.coeffs = coeffs;
	}

	public void addCoeff(BigInteger coeff) {
		this.coeffs.add(coeff);
	}
	
	public BigInteger get(int i) {
		return this.coeffs.get(i);
	}
	
	public void set(int i, BigInteger coeff) {
		this.coeffs.set(i, coeff);
	}
	
	public int size() {
		return this.coeffs.size();
	}
	
	public Polynomial multiplyByConstant(BigInteger c) {
		Polynomial result = this.copy();
		
		for (int i = 0; i < result.size(); i++) {
			result.set(i, result.get(i).multiply(c));
		}
		
		return result; 
	}
	
	public Polynomial multiplyByX() {
		Polynomial result = this.copy();
		
		for (int i = result.size() - 1; i > 0; i--) {
			result.set(i, result.get(i - 1));
		}
		
		result.set(0, BigInteger.ZERO);
		
		return result;
	}
	
	/**
	 * p1, p2 must have the same degree
	 * @param p1
	 * @param p2
	 * @return
	 */
	public Polynomial add(Polynomial p) {
		Polynomial result = new Polynomial();
		
		for (int i = 0; i < this.size(); i++) {
			result.getCoeffs().add(this.get(i).add(p.get(i)));
		}
		
		return result;
	}
	
	/**
	 * p1, p2 must have the same degree
	 * @param p1
	 * @param p2
	 * @return
	 */
	public Polynomial substract(Polynomial p) {
		Polynomial result = new Polynomial();
		
		for (int i = 0; i < this.size(); i++) {
			result.getCoeffs().add(this.get(i).subtract(p.get(i)));
		}
		
		return result;
	}
	
	public Polynomial divide(BigInteger c) {
		Polynomial result = new Polynomial();
		
		for (int i = 0; i < this.size(); i++) {
			result.getCoeffs().add(this.get(i).divide(c));
		}
		
		return result;
	}
	
}
