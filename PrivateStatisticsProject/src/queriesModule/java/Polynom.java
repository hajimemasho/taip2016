package queriesModule.java;

import java.util.List;
/**
 * 
 * @author Carmen Cojocaru
 * Class that defines a polynom by a list of coefficients.
 */
public class Polynom {
	List<Integer> coeff;

	public List<Integer> getCoeff() {
		return coeff;
	}

	public void setCoeff(List<Integer> coeff) {
		this.coeff = coeff;
	}
}
