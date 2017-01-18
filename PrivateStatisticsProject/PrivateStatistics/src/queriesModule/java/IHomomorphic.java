package queriesModule.java;
/**
 * 
 * @author Carmen Cojocaru
 * Interface that defines the homomorphic operations.
 */
public interface IHomomorphic {
	
	Polynom add(Polynom c1, Polynom c2);
	
	Polynom multiply(Polynom c1, Polynom c2);
}
