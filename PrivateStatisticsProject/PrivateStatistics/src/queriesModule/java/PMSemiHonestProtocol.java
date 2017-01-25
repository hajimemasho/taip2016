package queriesModule.java;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import utilitiesModule.java.Paillier;


/**
 * 
 * @author Carmen Cojocaru
 *
 */

public class PMSemiHonestProtocol {
	
	/**
	 * Client uses Neville algorithm to compute the coefficients of the polynomial 
	 * @param points
	 * @return
	 */
	public Polynomial computeCoefficients(List<Point> points) {
		Neville alg = new Neville();
		alg.setPoints(points);
		return alg.compute();
	}
	
	/**
	 * Client returns a list of the coefficients of the polynomial encrypted.
	 * @param polynomial
	 * @param paillier
	 * @return
	 */
	public Polynomial encryptAndSend(Polynomial polynomial, Paillier paillier) {
		List<BigInteger> encryptedCoeff = new ArrayList<>();
		for (BigInteger coeff : polynomial.getCoeffs()) {
			BigInteger c = paillier.Encryption(new BigInteger(String.valueOf(coeff)));
			encryptedCoeff.add(c);
		}
		
		return new Polynomial(polynomial.size(), encryptedCoeff);
	}
	
	/**
	 * Server evaluates the encrypted polynomial in all of its values.
	 * @param encryptedPol
	 * @param y
	 * @return
	 */
	public BigInteger evaluateEncPolynomial(Polynomial encryptedPol, BigInteger y) {
		BigInteger value = BigInteger.ZERO;
		for (int i = 0; i < encryptedPol.size(); i++) {
			BigInteger yPow = y.pow(i);
			value.add(encryptedPol.get(i).multiply(yPow));
		}
		
		return value;
	}
	
	/**
	 * The server multiplies each of the value obtained by evaluating the polynomial 
	 * with a random value and then adds its y value encrypted.
	 * At final, he shuffles the array to preserve the order of the values.
	 * @param encryptedPol
	 * @param yValues
	 * @param paillier
	 * @return
	 */
	public List<BigInteger> evaluate(Polynomial encryptedPol, List<BigInteger> yValues, Paillier paillier) {
		Random random = new Random();
		List<BigInteger> ciphertexts = new ArrayList<>();
		
		for (BigInteger y : yValues) {
			int randomNr = random.nextInt(100);
			BigInteger evaluatedPol = evaluateEncPolynomial(encryptedPol, y);
			BigInteger product = evaluatedPol.multiply(new BigInteger(String.valueOf(randomNr)));
			BigInteger sum = product.add(paillier.Encryption(y));
			ciphertexts.add(sum);
		}
		long seed = System.nanoTime();
		Collections.shuffle(ciphertexts, new Random(seed));
		return ciphertexts;
	}
	
	/**
	 * Client receives a list of cipher texts, decrypts them and chooses only 
	 * those values that are common.
	 * @param ciphertexts
	 * @param paillier
	 * @return
	 */
	public List<BigInteger> decrypt(List<BigInteger> ciphertexts, Paillier paillier) {
		List<BigInteger> decryptedValues = new ArrayList<BigInteger>();
		int i = 0;
		for (BigInteger c : ciphertexts) {
			BigInteger decrypted = paillier.Decryption(c);
			System.out.println("decrypted: " + i + " - " + decrypted);
			decryptedValues.add(decrypted);
			i++;
		}
		return decryptedValues;
	}
	
	public List<BigInteger> findIntersection(List<BigInteger> xValues, List<BigInteger> ciphertexts) {
		List<BigInteger> intersect = new ArrayList<BigInteger>();
		for (BigInteger c : ciphertexts) {
			if (xValues.contains(c)) {
				System.out.println("c = " + c);
				intersect.add(c);
			}
		}
		
		return intersect;
	}
}

