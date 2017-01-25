package queriesModule.tests;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;
import queriesModule.java.PMSemiHonestProtocol;
import queriesModule.java.Point;
import queriesModule.java.Polynomial;
import utilitiesModule.java.Paillier;
/**
 * 
 * @author Carmen Cojocaru
 *
 */
public class TestPMSemiHonestProtocol {
	
	@Test 
	public void testEvaluateEncPolynomial() {
		Paillier paillier = new Paillier();
		PMSemiHonestProtocol protocol = new PMSemiHonestProtocol();
		
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(BigInteger.ONE, BigInteger.ZERO));
		points.add(new Point(new BigInteger("2"), new BigInteger("2")));
		points.add(new Point(new BigInteger("4"), new BigInteger("12")));

		List<BigInteger> yValues = Arrays.asList(BigInteger.ZERO, new BigInteger("2"), new BigInteger("12"));
		List<BigInteger> xValues = Arrays.asList(BigInteger.ONE, new BigInteger("2"), new BigInteger("4"));
		
		Polynomial polynomial = protocol.computeCoefficients(points);
		Polynomial encryptedPol = protocol.encryptAndSend(polynomial, paillier);
		List<BigInteger> ciphertexts = protocol.evaluate(encryptedPol, yValues, paillier);
		protocol.decrypt(ciphertexts, paillier);
		List<BigInteger> intersection = protocol.findIntersection(xValues, yValues);
		
		Assert.assertEquals(intersection, Arrays.asList(new BigInteger("2")));
	}
}
